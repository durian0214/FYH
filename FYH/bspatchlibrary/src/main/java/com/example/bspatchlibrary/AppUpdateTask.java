package com.example.bspatchlibrary;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.lang.ref.SoftReference;

/**
 * 版本升级AsyncTask
 * Created by Aramis on 2017/3/6.
 */

public class AppUpdateTask extends AsyncTask<String, Void, VersionEnum> {
    private static final String TAG = "===AppUpdateTask===";
    private SoftReference<Context> contextSoftReference;
    private String oldApkPath, newApkPath, patchPath;

    public AppUpdateTask(Context context) {
        contextSoftReference = new SoftReference<>(context);
        oldApkPath = ApkUtils.getSourceApkPath(context);
        newApkPath = ApkUtils.newApkPath;
        patchPath = ApkUtils.patchPath;
    }

    @Override
    protected VersionEnum doInBackground(String... params) {
        Log.e(TAG, "开始处理");
        //先下载
        String url = params[0];
        //模拟
        File newApkFile = new File(newApkPath);
        if (newApkFile.exists()) {
            Log.e(TAG, "最新apk文件已经存在");
            return VersionEnum.SUCCESS;
        }
        File patchFile = new File(patchPath);
        if (patchFile.exists()) {
            Log.e(TAG, "patch文件已经存在");
            int ret = PatchUtils.patch(oldApkPath, newApkPath, patchPath);
            Log.e(TAG, "合并成功 ret=" + ret);
            return VersionEnum.SUCCESS;
        }
        return VersionEnum.FAIL;
    }

    @Override
    protected void onPostExecute(VersionEnum aVersionEnum) {
        super.onPostExecute(aVersionEnum);
        Log.e(TAG, "VersionEnum:" + aVersionEnum.toString());
        Context context = contextSoftReference.get();
        if (context == null) {
            return;
        }
        if (aVersionEnum != VersionEnum.SUCCESS) {
            Toast.makeText(context, "更新失败", Toast.LENGTH_SHORT).show();
            return;
        }
//        String newAppSign = SignatureUtils.getApkSign(newApkPath);
//        String oldAppSign = SignatureUtils.getAppSign(context, oldApkPath);
        if (new File(newApkPath).exists()) {
            ApkUtils.installApk(context, newApkPath);
        } else {
            Toast.makeText(context, "新apk不存在", Toast.LENGTH_SHORT).show();
        }
//        if (!TextUtils.isEmpty(oldAppSign) && !TextUtils.isEmpty(newAppSign) && oldAppSign.equals(newAppSign)) {
//            ApkUtils.installApk(context, newApkPath);
//        } else {
//            Toast.makeText(context, "更新失败", Toast.LENGTH_SHORT).show();
//        }
    }
}
