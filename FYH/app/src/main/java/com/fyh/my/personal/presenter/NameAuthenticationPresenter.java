package com.fyh.my.personal.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.my.personal.view.NameAuthenticationView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * a
 * 2017-2017/1/12
 */
public class NameAuthenticationPresenter extends BasePresenter<NameAuthenticationView>{
    public NameAuthenticationPresenter(NameAuthenticationView myView){
        attachView(myView);
    }
    public void authentication(){
        Map<String,Object> params = new HashMap<>( );
        HttpUtils.getInstance().jsonPost(HttpConstant.UPDATE_SEX, params, new DefaultObjectHttpListener() {
            @Override
            public void onSuccessParsed(Object result) {

            }
        });
    }
}
