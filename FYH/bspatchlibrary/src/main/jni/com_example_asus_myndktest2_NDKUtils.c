#include <string.h>
#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_example_asus_myndktest2_NDKUtils_stringFromJNI(JNIEnv *env, jobject instance) {

    return (*env)->NewStringUTF(env, "Hello NDK!");
}
