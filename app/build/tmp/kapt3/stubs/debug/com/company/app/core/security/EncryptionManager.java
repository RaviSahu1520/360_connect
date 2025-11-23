package com.company.app.core.security;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/company/app/core/security/EncryptionManager;", "", "keyStoreHelper", "Lcom/company/app/core/security/KeyStoreHelper;", "(Lcom/company/app/core/security/KeyStoreHelper;)V", "secretKey", "Ljavax/crypto/SecretKey;", "getSecretKey", "()Ljavax/crypto/SecretKey;", "secretKey$delegate", "Lkotlin/Lazy;", "decrypt", "", "encrypted", "encrypt", "raw", "Companion", "app_debug"})
public final class EncryptionManager {
    @org.jetbrains.annotations.NotNull()
    private final com.company.app.core.security.KeyStoreHelper keyStoreHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy secretKey$delegate = null;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String TRANSFORMATION = "AES/GCM/NoPadding";
    @org.jetbrains.annotations.NotNull()
    private static final com.company.app.core.security.EncryptionManager.Companion Companion = null;
    
    public EncryptionManager(@org.jetbrains.annotations.NotNull()
    com.company.app.core.security.KeyStoreHelper keyStoreHelper) {
        super();
    }
    
    private final javax.crypto.SecretKey getSecretKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String encrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String raw) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String decrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String encrypted) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/company/app/core/security/EncryptionManager$Companion;", "", "()V", "TRANSFORMATION", "", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}