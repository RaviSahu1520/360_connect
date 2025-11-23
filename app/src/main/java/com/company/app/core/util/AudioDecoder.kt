package com.company.app.core.util

import android.media.MediaCodec
import android.media.MediaExtractor
import android.media.MediaFormat
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.floor
import kotlin.math.roundToInt

@Singleton
class AudioDecoder @Inject constructor() {

    suspend fun decodeToFloatFile(inputFile: File, outputFile: File, targetSampleRate: Int = 16_000): Int =
        withContext(Dispatchers.IO) {
            outputFile.parentFile?.mkdirs()
            val extractor = MediaExtractor()
            extractor.setDataSource(inputFile.absolutePath)
            val trackIndex = selectAudioTrack(extractor)
            require(trackIndex >= 0) { "No audio track in ${inputFile.name}" }
            extractor.selectTrack(trackIndex)
            val format = extractor.getTrackFormat(trackIndex)
            val mime = format.getString(MediaFormat.KEY_MIME) ?: error("Missing mime type")
            var sampleRate = format.getInteger(MediaFormat.KEY_SAMPLE_RATE)
            val channelCount = if (format.containsKey(MediaFormat.KEY_CHANNEL_COUNT)) {
                format.getInteger(MediaFormat.KEY_CHANNEL_COUNT)
            } else 1

            val decoder = MediaCodec.createDecoderByType(mime)
            decoder.configure(format, null, null, 0)
            decoder.start()

            val bufferInfo = MediaCodec.BufferInfo()
            val rawPcm = ByteArrayOutputStream()
            var inputDone = false
            var outputDone = false

            try {
                while (!outputDone) {
                    if (!inputDone) {
                        val inputIndex = decoder.dequeueInputBuffer(TIMEOUT_US)
                        if (inputIndex >= 0) {
                            val buffer = decoder.getInputBuffer(inputIndex) ?: continue
                            val size = extractor.readSampleData(buffer, 0)
                            if (size < 0) {
                                decoder.queueInputBuffer(
                                    inputIndex,
                                    0,
                                    0,
                                    0,
                                    MediaCodec.BUFFER_FLAG_END_OF_STREAM
                                )
                                inputDone = true
                            } else {
                                decoder.queueInputBuffer(
                                    inputIndex,
                                    0,
                                    size,
                                    extractor.sampleTime,
                                    0
                                )
                                extractor.advance()
                            }
                        }
                    }

                    val outputIndex = decoder.dequeueOutputBuffer(bufferInfo, TIMEOUT_US)
                    when {
                        outputIndex >= 0 -> {
                            val outBuffer = decoder.getOutputBuffer(outputIndex) ?: continue
                            val bytes = ByteArray(bufferInfo.size)
                            outBuffer.get(bytes)
                            rawPcm.write(bytes)
                            outBuffer.clear()
                            decoder.releaseOutputBuffer(outputIndex, false)
                            if (bufferInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM != 0) {
                                outputDone = true
                            }
                        }
                        outputIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED -> {
                            val newFormat = decoder.outputFormat
                            sampleRate = newFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE)
                            Log.d(TAG, "Output format changed, sampleRate=$sampleRate")
                        }
                    }
                }
            } finally {
                decoder.stop()
                decoder.release()
                extractor.release()
            }

            val pcmBytes = rawPcm.toByteArray()
            val shortBuffer = ByteBuffer.wrap(pcmBytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer()
            val shorts = ShortArray(shortBuffer.remaining())
            shortBuffer.get(shorts)
            val mono = if (channelCount > 1) downmix(shorts, channelCount) else shorts

            val floatPcm = toFloat(mono)
            val finalPcm = if (sampleRate != targetSampleRate && sampleRate > 0) {
                resample(floatPcm, sampleRate, targetSampleRate)
            } else floatPcm

            val byteBuffer = ByteBuffer.allocate(finalPcm.size * 4).order(ByteOrder.LITTLE_ENDIAN)
            finalPcm.forEach { byteBuffer.putFloat(it) }
            FileOutputStream(outputFile).use { fos ->
                fos.write(byteBuffer.array())
            }
            Log.d(TAG, "Decoded ${inputFile.name} to ${outputFile.name} samples=${finalPcm.size}")
            targetSampleRate
        }

    private fun selectAudioTrack(extractor: MediaExtractor): Int {
        for (index in 0 until extractor.trackCount) {
            val format = extractor.getTrackFormat(index)
            val mime = format.getString(MediaFormat.KEY_MIME) ?: continue
            if (mime.startsWith("audio/")) return index
        }
        return -1
    }

    private fun toFloat(shorts: ShortArray): FloatArray {
        val floats = FloatArray(shorts.size)
        for (i in shorts.indices) {
            floats[i] = shorts[i] / 32768f
        }
        return floats
    }

    private fun downmix(data: ShortArray, channels: Int): ShortArray {
        if (channels <= 1) return data
        val frameCount = data.size / channels
        val output = ShortArray(frameCount)
        for (i in 0 until frameCount) {
            var sum = 0
            for (ch in 0 until channels) {
                sum += data[i * channels + ch].toInt()
            }
            output[i] = (sum / channels).toShort()
        }
        return output
    }

    private fun resample(data: FloatArray, sourceRate: Int, targetRate: Int): FloatArray {
        if (sourceRate == targetRate) return data
        val ratio = sourceRate.toDouble() / targetRate.toDouble()
        val outSize = (data.size / ratio).roundToInt().coerceAtLeast(1)
        val result = FloatArray(outSize)
        for (i in 0 until outSize) {
            val srcPosition = i * ratio
            val index = floor(srcPosition).toInt().coerceIn(0, data.lastIndex)
            val nextIndex = (index + 1).coerceAtMost(data.lastIndex)
            val fraction = (srcPosition - index).toFloat()
            val sample = data[index] * (1 - fraction) + data[nextIndex] * fraction
            result[i] = sample
        }
        return result
    }

    companion object {
        private const val TAG = "AudioDecoder"
        private const val TIMEOUT_US = 10_000L
    }
}
