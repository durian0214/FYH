package com.fyh.my.personal.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.my.personal.model.ModifyIconModel;
import com.fyh.my.personal.view.ModifyIconView;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Durian
 * 2017-2017/3/10
 */

public class ModifyIconPresenter extends BasePresenter<ModifyIconView> {
    public ModifyIconPresenter(ModifyIconView view) {
        attachView(view);
    }

    public void modifyIcon(String url) {
        Map<String, Object> params = new HashMap<>();
        params.put("photoUrl", url);
        HttpUtils.getInstance().jsonPost(HttpConstant.MODIFY_ICON, params, new DefaultObjectHttpListener<ModifyIconModel>() {
            @Override
            public void onSuccessParsed(ModifyIconModel result) {
                myView.modifyIcon();
            }
        });
    }
}
