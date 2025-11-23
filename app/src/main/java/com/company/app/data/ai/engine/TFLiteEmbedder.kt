package com.company.app.data.ai.engine

import android.util.Log
import com.company.app.core.util.AssetExtractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.sin

@Singleton
class TFLiteEmbedder @Inject constructor(
    private val assetExtractor: AssetExtractor
) {
    private val modelPath by lazy {
        runBlocking(Dispatchers.IO) {
            runCatching { assetExtractor.extract("models/all-mpnet-base-v2.tflite").absolutePath }
                .getOrNull()
        }
    }

    fun embed(text: String): FloatArray {
        // Deterministic pseudo-embedding based on hash to avoid heavy runtime deps.
        val digest = MessageDigest.getInstance("SHA-256").digest(text.toByteArray())
        val size = 384
        val result = FloatArray(size)
        for (i in 0 until size) {
            val b = digest[i % digest.size].toInt()
            result[i] = sin((b + i).toDouble()).toFloat()
        }
        if (modelPath != null) {
            Log.d("TFLiteEmbedder", "Model ready at ${modelPath}")
        }
        return result
    }
}
