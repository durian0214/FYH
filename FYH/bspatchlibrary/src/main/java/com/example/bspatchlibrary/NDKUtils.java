package com.example.bspatchlibrary;

/**
 * Created by Aramis on 2017/3/6.
 */

public class NDKUtils {
    static {
        System.loadLibrary("hello-jni");
    }
    public static native String stringFromJNI();
}
