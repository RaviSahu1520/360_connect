package com.company.app.data.ai.manager

import com.company.app.core.util.AssetExtractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModelDownloadManager @Inject constructor(
    private val assetExtractor: AssetExtractor
) {
    private val _state = MutableStateFlow(false)
    val state: StateFlow<Boolean> = _state

    suspend fun ensureModelDownloaded(modelName: String) {
        withContext(Dispatchers.IO) {
            assetExtractor.extract("models/whisper-tiny.bin")
            assetExtractor.extract("models/all-mpnet-base-v2.tflite")
            _state.emit(true)
        }
    }
}
