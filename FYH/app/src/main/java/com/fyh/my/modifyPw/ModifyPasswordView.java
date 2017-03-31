package com.fyh.my.modifyPw;

import com.fyh.base.BaseView;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public interface ModifyPasswordView extends BaseView {
    void doModifySuccess();
    void doModifyFailed(String msg);
}
