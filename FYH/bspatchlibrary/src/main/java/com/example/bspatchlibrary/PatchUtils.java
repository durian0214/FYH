package com.example.bspatchlibrary;

/**
 * Created by Aramis on 2017/3/6.
 */

public class PatchUtils {
    static {
        System.loadLibrary("bspatch");
    }
    public static native int patch(String oldVersionPath,String newVersionPath,String patchPath);
}
