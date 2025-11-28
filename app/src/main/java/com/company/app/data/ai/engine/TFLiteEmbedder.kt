package com.company.app.data.ai.engine

import android.content.Context
import android.util.Log
import com.company.app.core.util.AssetExtractor
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.tasks.text.textembedder.TextEmbedder
import com.google.mediapipe.tasks.text.textembedder.TextEmbedder.TextEmbedderOptions
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TFLiteEmbedder @Inject constructor(
    @ApplicationContext private val context: Context,
    private val assetExtractor: AssetExtractor
) {
    private var embedder: TextEmbedder? = null
    private val modelName = "mobilebert_embedding.tflite"

    private suspend fun ensureInitialized() {
        if (embedder != null) return
        withContext(Dispatchers.IO) {
            try {
                val modelFile = assetExtractor.extract("models/$modelName")

                val baseOptions = BaseOptions.builder()
                    .setModelAssetPath(modelFile.absolutePath)
                    .build()

                val options = TextEmbedderOptions.builder()
                    .setBaseOptions(baseOptions)
                    .build()

                embedder = TextEmbedder.createFromOptions(context, options)
            } catch (e: Exception) {
                Log.e("TFLiteEmbedder", "Failed to init embedder", e)
            }
        }
    }

    suspend fun embed(text: String): FloatArray {
        ensureInitialized()
        return withContext(Dispatchers.Default) {
            val currentEmbedder = embedder ?: return@withContext FloatArray(0)

            val result = currentEmbedder.embed(text)
            val embedding = result.embeddingResult().embeddings().firstOrNull()

            embedding?.floatEmbedding() ?: FloatArray(0)
        }
    }
}
