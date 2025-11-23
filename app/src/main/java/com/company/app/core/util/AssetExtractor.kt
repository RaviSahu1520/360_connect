package com.company.app.core.util

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetExtractor @Inject constructor(
    @ApplicationContext private val context: Context
) {

    suspend fun extract(assetPath: String, outputName: String = File(assetPath).name, expectedSize: Long? = null): File {
        return withContext(Dispatchers.IO) {
            val destinationDir = File(context.filesDir, "models").apply { if (!exists()) mkdirs() }
            val destination = File(destinationDir, outputName)
            val shouldCopy = !destination.exists() || (expectedSize != null && destination.length() != expectedSize)
            if (shouldCopy) {
                context.assets.open(assetPath).use { input ->
                    destination.outputStream().use { output ->
                        input.copyTo(output)
                    }
                }
                Log.d(TAG, "Extracted asset $assetPath to ${destination.absolutePath}")
            }
            destination
        }
    }

    companion object {
        private const val TAG = "AssetExtractor"
    }
}
