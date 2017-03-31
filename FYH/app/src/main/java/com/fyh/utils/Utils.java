package com.fyh.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.fyh.enums.NetWorkStatus;

/**
 * Created by Cbt on 2016/12/23.
 */
public class Utils {

    /**
     * 获取网络错误码
     * @param status
     * @return
     */
    public static String getNetMSG (int status){
        String  msg = "";
        switch (status ){
            case 404:
                msg = NetWorkStatus.S_404;
                break;
            case 500:
                msg = NetWorkStatus.S_500;
                break;
            case 405:
                msg = NetWorkStatus.S_405;
                break;
            case 501:
                msg = NetWorkStatus.S_501;
                break;
            case 200:
                msg = NetWorkStatus.S_200;
                break;
            case 300:
                msg = NetWorkStatus.S_300;
                break;
            case 301:
                msg = NetWorkStatus.S_301;
                break;
            case 502:
                msg = NetWorkStatus.S_502;
                break;
            case 310:
                msg = NetWorkStatus.S_310;
                break;
        }
        return msg;
    }

    /**
     * RV水平管理
     * @param mContext
     * @return
     */
    public static LinearLayoutManager getHManager(Context mContext){
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return manager;
    }

    /**
     * RV垂直管理
     * @param mContext
     * @return
     */

    public static LinearLayoutManager getVManager(Context mContext){
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    /**
     * 表格佈局
     * @param mContext
     * @param size 数量
     * @return
     */
    public static GridLayoutManager getTableManager (Context mContext,int size){
        GridLayoutManager glm =   new GridLayoutManager(mContext,size);
        return glm;
    }
    /**
     * StaggeredGridLayoutManager时，查找position最大的列
     *
     * @param lastVisiblePositions
     * @return
     */
    public static int findMax(int[] lastVisiblePositions) {
        int max = lastVisiblePositions[0];
        for (int value : lastVisiblePositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static View inflate(Context context, int layoutId) {
        if (layoutId <= 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(layoutId, null);
    }
}
