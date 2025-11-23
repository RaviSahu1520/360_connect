package com.company.app.core.security

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

private const val KEYSTORE_NAME = "AndroidKeyStore"

class KeyStoreHelper(private val alias: String) {
    private val keyStore: KeyStore = KeyStore.getInstance(KEYSTORE_NAME).apply { load(null) }

    fun getOrCreateKey(): SecretKey {
        return (keyStore.getEntry(alias, null) as? KeyStore.SecretKeyEntry)?.secretKey ?: run {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, KEYSTORE_NAME)
            val parameterSpec = KeyGenParameterSpec.Builder(
                alias,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()
            keyGenerator.init(parameterSpec)
            keyGenerator.generateKey()
        }
    }
}
