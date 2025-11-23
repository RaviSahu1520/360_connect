package com.company.app.platform.recording

import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioPlaybackCaptureConfiguration
import android.media.AudioRecord
import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import android.media.MediaMuxer
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.io.File
import java.nio.ByteBuffer
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@RequiresApi(Build.VERSION_CODES.Q)
class AudioCaptureManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val capturing = AtomicBoolean(false)
    private var mediaProjection: MediaProjection? = null
    private var audioRecord: AudioRecord? = null
    private var codec: MediaCodec? = null
    private var muxer: MediaMuxer? = null
    private var trackIndex: Int = -1
    private var recordingJob: Job? = null

    fun requestProjectionIntent(): Intent {
        val manager = context.getSystemService<MediaProjectionManager>()
            ?: throw IllegalStateException("MediaProjectionManager not available")
        return manager.createScreenCaptureIntent()
    }

    fun setMediaProjection(projection: MediaProjection) {
        mediaProjection?.unregisterCallback(projectionCallback)
        mediaProjection?.stop()
        mediaProjection = projection.also { proj ->
            proj.registerCallback(projectionCallback, null)
        }
    }

    fun hasProjection(): Boolean = mediaProjection != null

    fun startCapture(outputFile: File) {
        if (!capturing.compareAndSet(false, true)) return
        recordingJob?.cancel()
        recordingJob = scope.launch { captureInternal(outputFile) }
    }

    fun stopCapture() {
        capturing.set(false)
        recordingJob?.cancel()
        releaseResources()
    }

    fun isCapturing(): Boolean = capturing.get()

    private suspend fun captureInternal(outputFile: File) {
        runCatching {
            outputFile.parentFile?.mkdirs()
            if (outputFile.exists()) outputFile.delete()

            val projection = mediaProjection ?: throw IllegalStateException("MediaProjection not granted")
            val captureConfig = AudioPlaybackCaptureConfiguration.Builder(projection)
                .addMatchingUsage(AudioAttributes.USAGE_VOICE_COMMUNICATION)
                .addMatchingUsage(AudioAttributes.USAGE_MEDIA)
                .build()

            val minBuffer = AudioRecord.getMinBufferSize(
                SAMPLE_RATE,
                AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_PCM_16BIT
            )
            audioRecord = AudioRecord.Builder()
                .setBufferSizeInBytes(minBuffer * 2)
                .setAudioPlaybackCaptureConfig(captureConfig)
                .setAudioFormat(
                    AudioFormat.Builder()
                        .setSampleRate(SAMPLE_RATE)
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
                        .build()
                )
                .build()

            val format = MediaFormat.createAudioFormat(MediaFormat.MIMETYPE_AUDIO_AAC, SAMPLE_RATE, 1).apply {
                setInteger(MediaFormat.KEY_AAC_PROFILE, MediaCodecInfo.CodecProfileLevel.AACObjectLC)
                setInteger(MediaFormat.KEY_BIT_RATE, BIT_RATE)
            }
            codec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_AUDIO_AAC).apply {
                configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
                start()
            }
            muxer = MediaMuxer(outputFile.absolutePath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4)
            trackIndex = -1

            val record = audioRecord ?: return
            val encoder = codec ?: return
            val bufferInfo = MediaCodec.BufferInfo()
            record.startRecording()

            while (capturing.get() && scope.isActive) {
                queueAudio(record, encoder)
                drainEncoder(encoder, bufferInfo)
            }

            // send end of stream
            val endIndex = encoder.dequeueInputBuffer(DEQUEUE_TIMEOUT_US)
            if (endIndex >= 0) {
                encoder.queueInputBuffer(
                    endIndex,
                    0,
                    0,
                    System.nanoTime() / 1000,
                    MediaCodec.BUFFER_FLAG_END_OF_STREAM
                )
                drainEncoder(encoder, bufferInfo)
            }
        }.onFailure {
            // swallow errors after cleanup; log could be added
        }.also {
            releaseResources()
            capturing.set(false)
        }
    }

    private fun queueAudio(
        record: AudioRecord,
        encoder: MediaCodec
    ) {
        val inputIndex = encoder.dequeueInputBuffer(DEQUEUE_TIMEOUT_US)
        if (inputIndex >= 0) {
            val inputBuffer: ByteBuffer = encoder.getInputBuffer(inputIndex) ?: return
            inputBuffer.clear()
            val read = record.read(inputBuffer, inputBuffer.capacity(), AudioRecord.READ_BLOCKING)
            val pts = System.nanoTime() / 1000
            if (read > 0) {
                encoder.queueInputBuffer(inputIndex, 0, read, pts, 0)
            }
        }
    }

    private fun drainEncoder(
        encoder: MediaCodec,
        bufferInfo: MediaCodec.BufferInfo
    ) {
        var outputIndex = encoder.dequeueOutputBuffer(bufferInfo, DEQUEUE_TIMEOUT_US)
        while (outputIndex >= 0 || outputIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
            if (outputIndex == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                trackIndex = muxer?.addTrack(encoder.outputFormat) ?: -1
                if (trackIndex >= 0) {
                    muxer?.start()
                }
            } else if (outputIndex >= 0) {
                if (bufferInfo.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG != 0) {
                    bufferInfo.size = 0
                }
                if (bufferInfo.size > 0 && trackIndex >= 0) {
                    val outBuffer = encoder.getOutputBuffer(outputIndex) ?: return
                    outBuffer.position(bufferInfo.offset)
                    outBuffer.limit(bufferInfo.offset + bufferInfo.size)
                    muxer?.writeSampleData(trackIndex, outBuffer, bufferInfo)
                }
                encoder.releaseOutputBuffer(outputIndex, false)
            }
            outputIndex = encoder.dequeueOutputBuffer(bufferInfo, DEQUEUE_TIMEOUT_US)
        }
    }

    private fun releaseResources() {
        runCatching { audioRecord?.stop() }
        runCatching { audioRecord?.release() }
        runCatching {
            codec?.stop()
            codec?.release()
        }
        runCatching {
            if (trackIndex >= 0) muxer?.stop()
            muxer?.release()
        }
        trackIndex = -1
        audioRecord = null
        codec = null
        muxer = null
    }

    private val projectionCallback = object : MediaProjection.Callback() {
        override fun onStop() {
            stopCapture()
            mediaProjection = null
        }
    }

    companion object {
        private const val SAMPLE_RATE = 44100
        private const val BIT_RATE = 128_000
        private const val DEQUEUE_TIMEOUT_US = 10_000L
    }
}
