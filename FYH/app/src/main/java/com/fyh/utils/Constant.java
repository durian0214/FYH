package com.fyh.utils;

import com.fyh.home.AreaModel;
import com.fyh.home.CityModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cbt on 2016/12/22.
 */
public class Constant {
    public static int  width = 0;
    public static int hight = 0;
    //日志
    public static boolean isLog = true;
    //城市Id
    public static int REGISON_ID = 1;
    //區域ID
    public static List<AreaModel> areaList = new ArrayList<>();
    //身份
    public  static int IDENTITY =0;
    //是否登录状态
    public static boolean isLogin = false;
    //账号
    public static String ACCOUNT = "";
    //手机号
    public static String MOBILE = "";
    //性别
    public static int GENDER = 0;
    //头像地址
    public static String ICON_URL = "";
    //sessionId
    public static String sessionId = "";
    //出租类型
    public static String[] rentType = {"不限", "整租", "合租"};
    //租金排序
    public static String[] rentSort = {"不限", "升序", "降序"};
    //城市ID
    public static int cityId = 1;
    //城市列表
    public static List<CityModel> cityList;

}
