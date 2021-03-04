#include <jni.h>
#include <string>
#include "temp_lib.h"



float celsius2fahrenheit(float celsius){
    return (celsius * 1.8) + 32;
}
float celsius2kelvin(float celsius){
    return celsius + 273.15;
}

float fahrenheit2celsius(float fahrenheit){
    return (fahrenheit - 32)*5556;
}
float fahrenheit2kelvin(float fahrenheit){
    return (fahrenheit + 459.67)*5/9;
}

float kelvin2celsius(float kelvin){
    return kelvin - 273.15;
}
float kelvin2fahrenheit(float kelvin){
    return kelvin * 9/5 - 459.67;
}


extern "C"
JNIEXPORT jfloat JNICALL
Java_orbianta_github_basic_tempconverter_native_1interface_celsius2fahrenheit(JNIEnv *env, jobject thiz, jfloat value) {

    return celsius2fahrenheit(value);
}


extern "C"
JNIEXPORT jfloat JNICALL
Java_orbianta_github_basic_tempconverter_native_1interface_celsius2kelvin(JNIEnv *env, jobject thiz, jfloat value) {
    return celsius2kelvin(value);
}

extern "C"
JNIEXPORT jfloat JNICALL
Java_orbianta_github_basic_tempconverter_native_1interface_fahrenheit2celsius(JNIEnv *env, jobject thiz, jfloat value) {
    return fahrenheit2celsius(value);
}


extern "C"
JNIEXPORT jfloat JNICALL
Java_orbianta_github_basic_tempconverter_native_1interface_fahrenheit2kelvin(JNIEnv *env, jobject thiz, jfloat value) {
    return fahrenheit2kelvin(value);
}

extern "C"
JNIEXPORT jfloat JNICALL
Java_orbianta_github_basic_tempconverter_native_1interface_kelvin2celsius(JNIEnv *env, jobject thiz, jfloat value) {
    return kelvin2celsius(value);
}


extern "C"
JNIEXPORT jfloat JNICALL
Java_orbianta_github_basic_tempconverter_native_1interface_kelvin2fahrenheit(JNIEnv *env, jobject thiz, jfloat value) {
    return kelvin2fahrenheit(value);
}