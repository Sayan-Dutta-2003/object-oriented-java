#include <jni.h>
#include <stdio.h>
#include "NativeExample.h"

JNIEXPORT void JNICALL Java_NativeExample_printMessage(JNIEnv *env, jobject obj) {
    printf("Hello from native C code!\n");
}