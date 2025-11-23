cmake_minimum_required(VERSION 3.22.1)
project(whisper_wrapper)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

include(FetchContent)
set(WHISPER_BUILD_EXAMPLES OFF CACHE BOOL "" FORCE)
set(WHISPER_BUILD_TESTS OFF CACHE BOOL "" FORCE)
set(WHISPER_BUILD_SHARED_LIB ON CACHE BOOL "" FORCE)
set(WHISPER_SUPPORT_SDL OFF CACHE BOOL "" FORCE)

FetchContent_Declare(
    whispercpp
    GIT_REPOSITORY https://github.com/ggerganov/whisper.cpp.git
    GIT_TAG master
)

FetchContent_MakeAvailable(whispercpp)

add_library(
    whisper_wrapper
    SHARED
    whisper_jni.cpp
    whisper_wrapper.cpp
    native-lib.cpp
)

find_library(log-lib log)

target_include_directories(
    whisper_wrapper
    PRIVATE
    ${whispercpp_SOURCE_DIR}
    ${whispercpp_SOURCE_DIR}/include
)

target_link_libraries(
    whisper_wrapper
    whisper
    ${log-lib}
    android
)
