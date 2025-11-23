#pragma once

#include "whisper.h"
#include <string>
#include <vector>

namespace whisper_bridge {
bool read_pcm_f32(const std::string &path, std::vector<float> &out);
std::string run_inference(struct whisper_context *ctx, const std::vector<float> &pcm);
} // namespace whisper_bridge
