package com.fyh.my.forgetPw;

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
 * Created by Cbt on 2016/12/28.
 */
public class ForgetPasswordPresenter extends BasePresenter<ForgetPasswordView> {
    public ForgetPasswordPresenter(ForgetPasswordView myView){
        attachView(myView);
    }
    public void getCode(String mobile) {
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", mobile);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_FORGET_PASSWORD_CODE, params, new DefaultObjectHttpListener<String>() {
            @Override
            public void onSuccessParsed(String result) {
                LogUtil.i("忘记密码验证码==",result);
                myView.getCodeSuccess(result);
            }
        });
    }

    public void setPassword(String account, String password, String affirmPassword, String code) {
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", account);
        params.put("password", password);
        params.put("againPwd", affirmPassword);
        params.put("picCaptcha", code);
        HttpUtils.getInstance().jsonPost(HttpConstant.FORGET_PASSWORD, params, new DefaultObjectHttpListener<ForgetPasswordModel>() {
            @Override
            public void onSuccessParsed(ForgetPasswordModel result) {
                myView.setPasswordSuccess(result);
            }
        });
    }
}
