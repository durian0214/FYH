package com.fyh.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.fyh.listen.MyLocationListener;
import com.fyh.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Durian
 * 2017-2017/3/8
 */
public class BaiDuMapServer extends Service {
    private LocationClient mclient = null;
    private MyLocationListener myLocationListener;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
        mclient = new LocationClient(this);
        myLocationListener = new MyLocationListener();
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        int span = 10000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);  //可选，默认false,设置是否使用gps
        option.setIgnoreKillProcess(true); //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        mclient.setLocOption(option);
        mclient.registerLocationListener(myLocationListener);
        start();
    }

    public void start() {
        mclient.start();
    }

    public void stopClient() {
        mclient.stop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void EventBus(BDLocation location) {
        if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
            LogUtil.i("Log", location.getCity());
            stopClient();
        }

    }
}
