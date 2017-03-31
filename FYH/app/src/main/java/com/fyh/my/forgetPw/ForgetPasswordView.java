package com.fyh.my.forgetPw;

import com.fyh.base.BaseView;

/**
 * Created by Cbt on 2016/12/28.
 */
public interface ForgetPasswordView extends BaseView{
    void getCodeSuccess(String code);
    void setPasswordSuccess(ForgetPasswordModel model);
}
