package com.company.app.core.security

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey

class EncryptionManager(private val keyStoreHelper: KeyStoreHelper) {

    private val secretKey: SecretKey by lazy { keyStoreHelper.getOrCreateKey() }

    fun encrypt(raw: String): String {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedBytes = cipher.doFinal(raw.encodeToByteArray())
        val iv = cipher.iv
        return Base64.encodeToString(iv + encryptedBytes, Base64.DEFAULT)
    }

    fun decrypt(encrypted: String): String {
        val data = Base64.decode(encrypted, Base64.DEFAULT)
        val iv = data.copyOfRange(0, 12)
        val payload = data.copyOfRange(12, data.size)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, javax.crypto.spec.GCMParameterSpec(128, iv))
        return cipher.doFinal(payload).decodeToString()
    }

    private companion object {
        const val TRANSFORMATION = "AES/GCM/NoPadding"
    }
}
