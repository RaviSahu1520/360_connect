#include "whisper_wrapper.h"
#include <android/log.h>
#include <fstream>
#include <vector>
#include <thread>

namespace whisper_bridge {

static const char *TAG = "WhisperWrapper";

bool read_pcm_f32(const std::string &path, std::vector<float> &out) {
    std::ifstream file(path, std::ios::binary);
    if (!file.is_open()) {
        __android_log_print(ANDROID_LOG_ERROR, TAG, "Failed to open PCM file: %s", path.c_str());
        return false;
    }
    file.seekg(0, std::ios::end);
    const auto size = static_cast<size_t>(file.tellg());
    file.seekg(0, std::ios::beg);
    if (size % sizeof(float) != 0) {
        __android_log_print(ANDROID_LOG_ERROR, TAG, "PCM file size is not multiple of float: %zu", size);
        return false;
    }
    out.resize(size / sizeof(float));
    file.read(reinterpret_cast<char *>(out.data()), static_cast<std::streamsize>(size));
    return !out.empty();
}

std::string run_inference(struct whisper_context *ctx, const std::vector<float> &pcm) {
    whisper_full_params params = whisper_full_default_params(WHISPER_SAMPLING_GREEDY);
    params.print_realtime = false;
    params.print_progress = false;
    params.print_timestamps = false;
    params.print_special = false;
    params.translate = false;
    params.language = "en";
    params.n_threads = std::max(1u, std::thread::hardware_concurrency());

    if (whisper_full(ctx, params, pcm.data(), pcm.size()) != 0) {
        __android_log_print(ANDROID_LOG_ERROR, TAG, "whisper_full failed");
        return "";
    }

    std::string result;
    const int nSegments = whisper_full_n_segments(ctx);
    for (int i = 0; i < nSegments; ++i) {
        const char *segment = whisper_full_get_segment_text(ctx, i);
        if (segment) {
            result += segment;
            result += " ";
        }
    }
    return result;
}

} // namespace whisper_bridge
