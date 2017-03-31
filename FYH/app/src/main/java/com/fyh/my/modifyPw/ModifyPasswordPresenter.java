package com.fyh.my.modifyPw;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public class ModifyPasswordPresenter extends BasePresenter<ModifyPasswordView> {
    public ModifyPasswordPresenter(ModifyPasswordView modifyPasswordView){
            attachView(modifyPasswordView);
    }
   public void  modifyPassword(String oldPassword,String newPassword,String id){
       Map<String,Object> params = new HashMap<String,Object>();
       params.put("newPassword",newPassword);
       params.put("userId",Integer.parseInt(id));
       params.put("oldPassword",oldPassword);
       HttpUtils.getInstance().jsonPost(HttpConstant.MODIFY_PASSWORD, params, new DefaultObjectHttpListener<ModifyPasswordModel>() {
           @Override
           public void onSuccessParsed(ModifyPasswordModel result) {
               myView.doModifySuccess();
           }
       });
    }
}
