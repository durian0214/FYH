package com.fyh.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.fyh.R;


/**
 * Created by Cbt on 2016/12/18.
 */
public class GlideUtil {
    private static final  int IMG_WAIT = R.drawable.house_icon;
      volatile   private static GlideUtil intance= null;
    private GlideUtil(){}
    public static GlideUtil getIntance (){
        synchronized (GlideUtil.class) {
            if (intance == null) {
                intance = new GlideUtil();
            }
        }
        return intance;
    }

    /**
     * 加载图片
     * @param mContext
     * @param v
     * @param url
     */
    public void loaderImg(Context mContext, ImageView v, String url){

        Glide.with(mContext).load(HttpConstant.IMG_URL+url).placeholder(IMG_WAIT).error(IMG_WAIT).into(v);
    }
    public void loaderImg(Context mContext, ImageView v, String url,int myImg){
        Glide.with(mContext).load(HttpConstant.IMG_URL+url).placeholder(IMG_WAIT).error(IMG_WAIT).into(v);
    }

    public void loaderCornersImg(Context mContext, ImageView v, String url){
        Glide.with(mContext)
                .load(HttpConstant.IMG_URL+url) //URI to image from local addressbook
                .asBitmap()
                .placeholder(IMG_WAIT) //without this line everything works fine
                .error(IMG_WAIT)
                .into(v);
    }

    //清理磁盘缓存
    public static void GuideClearDiskCache(Context mContext) {
        //理磁盘缓存 需要在子线程中执行
        Glide.get(mContext).clearDiskCache();
    }

    //清理内存缓存
    public static void GuideClearMemory(Context mContext) {
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(mContext).clearMemory();
    }



}
