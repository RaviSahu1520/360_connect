package com.company.app.data.ai.engine

import android.util.Log
import com.company.app.core.common.DispatcherProvider
import com.company.app.core.util.AssetExtractor
import com.company.app.core.util.AudioDecoder
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Singleton
class WhisperEngine @Inject constructor(
    @ApplicationContext private val context: android.content.Context,
    private val dispatchers: DispatcherProvider,
    private val assetExtractor: AssetExtractor,
    private val audioDecoder: AudioDecoder
) {

    private val handle = AtomicLong(0L)
    private val mutex = Mutex()

    suspend fun transcribe(audioFile: File): String = withContext(dispatchers.io) {
        ensureInitialized()
        val floatFile = File(context.cacheDir, "pcm/${audioFile.nameWithoutExtension}.f32").apply {
            parentFile?.mkdirs()
        }
        val startDecode = System.currentTimeMillis()
        audioDecoder.decodeToFloatFile(audioFile, floatFile)
        Log.d(TAG, "Decoded audio in ${System.currentTimeMillis() - startDecode} ms")
        val start = System.currentTimeMillis()
        val transcript = transcribeNative(handle.get(), floatFile.absolutePath)
        Log.d(TAG, "Whisper inference in ${System.currentTimeMillis() - start} ms for ${audioFile.name}")
        runCatching { floatFile.delete() }
        transcript
    }

    suspend fun benchmark(audioFile: File): Long = withContext(dispatchers.io) {
        val start = System.currentTimeMillis()
        transcribe(audioFile)
        System.currentTimeMillis() - start
    }

    private suspend fun ensureInitialized() {
        if (handle.get() != 0L) return
        mutex.withLock {
            if (handle.get() != 0L) return
            val modelFile = assetExtractor.extract("models/whisper-tiny.bin")
            val nativeHandle = initWhisper(modelFile.absolutePath)
            require(nativeHandle != 0L) { "Unable to initialize whisper.cpp" }
            handle.set(nativeHandle)
            Runtime.getRuntime().addShutdownHook(Thread { freeNative() })
        }
    }

    private fun freeNative() {
        val current = handle.getAndSet(0L)
        if (current != 0L) {
            freeWhisper(current)
        }
    }

    private external fun initWhisper(modelPath: String): Long
    private external fun transcribe(handle: Long, audioPath: String): String
    private external fun freeWhisper(handle: Long)

    private fun transcribeNative(handle: Long, audioPath: String): String {
        return transcribe(handle, audioPath)
    }

    companion object {
        init {
            runCatching { System.loadLibrary("whisper_wrapper") }
                .onFailure { Log.e(TAG, "Failed loading whisper_wrapper", it) }
        }
        private const val TAG = "WhisperEngine"
    }
}
