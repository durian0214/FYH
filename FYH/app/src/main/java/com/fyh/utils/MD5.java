package com.fyh.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Cbt on 2016/12/22.
 */
public class MD5 {
    //加密
    public static  String getMD5 (String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());
        byte[] m = md5.digest();//加密
        return getStr(m);
    }
    private static String getStr( byte[] b){
        StringBuffer sb = new StringBuffer();
        for (byte q:b
             ) {
            sb.append(q);
        }

        return sb.toString();
    }


}
