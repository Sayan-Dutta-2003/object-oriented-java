#include <stdio.h>
#include <jni.h>
#include "NativeMethod_NativeExample.h"  // Generated header

// JNI function name MUST match: Java_[Package]_[Class]_[Method]
JNIEXPORT void JNICALL Java_NativeMethod_NativeExample_printMessage(JNIEnv *env, jobject obj) {
    printf("Hello from native code!\n");
}