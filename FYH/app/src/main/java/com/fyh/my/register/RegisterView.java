package com.fyh.my.register;

import com.fyh.base.BaseView;

/**
 * Created by Cbt on 2016/12/23.
 */
public interface RegisterView extends BaseView {
    void doRegisterSuccess(RegisterModel model);
    void getCodeSuccess( String model);
}
