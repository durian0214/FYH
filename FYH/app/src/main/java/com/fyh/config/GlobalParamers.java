package com.fyh.config;

import android.os.Environment;

import java.io.File;

/**
 * 全局参数
 * Created by Aramis on 2017/3/8.
 */

public class GlobalParamers {
    public final static String basePath = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "FYH" + File.separator;
    public final static String apkFolder = basePath + "apk";
    public final static String crashFolder = basePath + "crash";

    public final static String packageName = "com.example.asus.myndktest2";
    public final static String newApkPath = apkFolder + File.separator + "new.apk";
    public final static String patchPath = apkFolder + File.separator + "apk.patch";
}
