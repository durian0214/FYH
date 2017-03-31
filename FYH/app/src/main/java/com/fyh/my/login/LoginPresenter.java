package com.fyh.my.login;


import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cbt on 2016/12/20.
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view){
        attachView(view);
    }

    public void login(String account , String passWord){
        Map<String,Object> params = new HashMap();
        params.put("mobile",account);
        params.put("password",passWord);
        LogUtil . i("Login", HttpConstant.LOGIN);
        HttpUtils.getInstance().jsonPost(HttpConstant.LOGIN, params, new DefaultObjectHttpListener<LoginModel>() {
            @Override
            public void onSuccessParsed(LoginModel result) {
                myView.doLoginSuccess(result);
            }
        });
    }
}
