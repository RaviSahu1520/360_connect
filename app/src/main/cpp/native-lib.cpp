#include <jni.h>
#include <android/log.h>

static const char *TAG = "WhisperNative";

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *) {
    __android_log_print(ANDROID_LOG_INFO, TAG, "JNI_OnLoad whisper_wrapper");
    return JNI_VERSION_1_6;
}
