package com.fyh.home.join;

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
 * Created by Natokalol on 2017/1/16.
 * 获取忘记密码验证码
 */
public class JoinPresenter extends BasePresenter<JoinView> {


    public  JoinPresenter(JoinView myView) {
        attachView(myView);
    }

    public void getCode(String cellPhone){
        Map<String,Object> params = new HashMap();
        params.put("mobile",cellPhone);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_FORGET_PASSWORD_CODE, params, new DefaultObjectHttpListener<JoinModel>() {
            @Override
            public void onSuccessParsed(JoinModel result) {
                myView.doJoinSuccess();
            }
        });
    }

    public void join(String community, String name, String cellPhone, String code){
        Map<String,Object> params = new HashMap();
        params.put("city","");
        params.put("neighbourhoods",community);
        params.put("name",name);
        params.put("phone",cellPhone);
        LogUtil. i("Join", HttpConstant.GET_JOIN);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_JOIN, params, new DefaultObjectHttpListener<JoinModel>() {
            @Override
            public void onSuccessParsed(JoinModel result) {
                myView.doJoinSuccess();
            }
        });
    }
}
