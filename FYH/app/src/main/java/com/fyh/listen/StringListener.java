package com.fyh.listen;

import java.io.IOException;

import okhttp3.Request;


/**
 * Created by Cbt on 2016/12/18.
 */
public interface StringListener {
    public abstract  void onSusseccData(String msg);
    public abstract  void onError(Request request, IOException e);
}
