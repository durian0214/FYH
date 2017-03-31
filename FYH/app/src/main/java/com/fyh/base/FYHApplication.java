package com.fyh.base;

import android.app.Application;

import com.fyh.aramis.crash.CrashHandler;
import com.fyh.guide.main.MainActivity;
import com.fyh.utils.HttpConstant;

/**
 * 房营行application
 * Created by Aramis on 2017/3/7.
 */

public class FYHApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

//        CrashHandler.getInstance().init(this, BuildConfig.DEBUG, true, 0, MainActivity.class);
        CrashHandler.getInstance().init(this, true, true, 0, MainActivity.class, HttpConstant.BUG_COLLECTION);
    }
}
