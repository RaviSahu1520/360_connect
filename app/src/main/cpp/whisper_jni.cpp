#include <jni.h>
#include <android/log.h>
#include <mutex>
#include <vector>
#include "whisper.h"
#include "whisper_wrapper.h"

static const char *JNI_TAG = "WhisperJNI";
static std::mutex g_mutex;

extern "C"
JNIEXPORT jlong JNICALL
Java_com_company_app_data_ai_engine_WhisperEngine_initWhisper(
        JNIEnv *env,
        jobject /* this */,
        jstring modelPath_) {
    const char *modelPath = env->GetStringUTFChars(modelPath_, nullptr);
    auto *ctx = whisper_init_from_file(modelPath);
    env->ReleaseStringUTFChars(modelPath_, modelPath);
    return reinterpret_cast<jlong>(ctx);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_company_app_data_ai_engine_WhisperEngine_transcribe(
        JNIEnv *env,
        jobject /* this */,
        jlong handle,
        jstring audioPath_) {
    const char *audioPath = env->GetStringUTFChars(audioPath_, nullptr);
    __android_log_print(ANDROID_LOG_INFO, JNI_TAG, "Starting transcription for %s", audioPath);
    std::vector<float> pcm;
    if (!whisper_bridge::read_pcm_f32(audioPath, pcm)) {
        env->ReleaseStringUTFChars(audioPath_, audioPath);
        return env->NewStringUTF("");
    }
    auto *ctx = reinterpret_cast<whisper_context *>(handle);
    if (ctx == nullptr) {
        env->ReleaseStringUTFChars(audioPath_, audioPath);
        __android_log_print(ANDROID_LOG_ERROR, JNI_TAG, "Whisper context is null");
        return env->NewStringUTF("");
    }
    std::string result;
    {
        std::lock_guard<std::mutex> lock(g_mutex);
        result = whisper_bridge::run_inference(ctx, pcm);
    }
    env->ReleaseStringUTFChars(audioPath_, audioPath);
    __android_log_print(ANDROID_LOG_INFO, JNI_TAG, "Transcription finished, length=%zu", result.size());
    return env->NewStringUTF(result.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_company_app_data_ai_engine_WhisperEngine_freeWhisper(
        JNIEnv * /* env */,
        jobject /* this */,
        jlong handle) {
    auto *ctx = reinterpret_cast<whisper_context *>(handle);
    if (ctx != nullptr) {
        whisper_free(ctx);
    }
}
