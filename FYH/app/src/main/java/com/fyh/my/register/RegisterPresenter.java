package com.fyh.my.register;

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
 * Created by Cbt on 2016/12/23.
 */
public class RegisterPresenter extends BasePresenter<RegisterView>{
    public RegisterPresenter(RegisterView view){
        attachView(view);
    }
    public void doRegister(String userName,String mobile,String mobileCode,String  password){
        Map<String,Object> params = new HashMap<>();
        params.put("user_name",userName);
        params.put("mobile",mobile);
        params.put("mobile_code",mobileCode);
        params.put("password",password);
        HttpUtils.getInstance().jsonPost(HttpConstant.REGISTER, params, new DefaultObjectHttpListener<RegisterModel>() {
            @Override
            public void onSuccessParsed(RegisterModel result) {
                myView.doRegisterSuccess(result);
            }
        });

    }

    public void getCode(String mobile){
        Map<String ,Object> params = new HashMap<>();
        params.put("mobile" ,mobile);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_REGISTER_CODE, params, new DefaultObjectHttpListener<String>() {
            @Override
            public void onSuccessParsed(String result) {
                myView.getCodeSuccess(result);
            }
        });
    }
}
