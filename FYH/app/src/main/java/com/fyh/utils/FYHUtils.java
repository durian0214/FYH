package com.fyh.utils;

import com.fyh.config.GlobalParamers;

import java.io.File;

/**
 * 房营行自有工具类
 * Created by Aramis on 2017/3/8.
 */

public class FYHUtils {
    private static volatile FYHUtils fyhUtils;

    private FYHUtils() {
    }

    public static FYHUtils getInstence() {
        if (fyhUtils == null) {
            synchronized (FYHUtils.class) {
                if (fyhUtils == null) {
                    fyhUtils = new FYHUtils();
                }
            }
        }
        return fyhUtils;
    }

    /**
     * 创建房营行文件夹
     */
    public void createFYHFolder() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] floder = {GlobalParamers.apkFolder, GlobalParamers.crashFolder};
                for (String path : floder) {
                    File f = new File(path);
                    if (!f.exists()) f.mkdirs();
                }
            }
        }).start();
    }
}
