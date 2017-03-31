package com.fyh.my.personal.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.base.BasePresenter;
import com.fyh.my.personal.model.ModifyIconModel;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.my.personal.view.ModitySexView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/2/20
 * 修改性別
 */
public class ModifySexPresenter extends BasePresenter<ModitySexView> {
    public ModifySexPresenter(ModitySexView view) {
        attachView(view);
    }

    /**
     *修改性別
     * @param sex  1男  0 女
     */
    public void updateSex(int sex) {
        Map<String, Object> params = new HashMap<>();
        params.put("sex", sex);
        HttpUtils.getInstance().jsonPost(HttpConstant.UPDATE_SEX, params, new DefaultObjectHttpListener<String>() {
            @Override
            public void onSuccessParsed(String result) {
                LogUtil.i("修改性別", result);
            }
        });
    }
}
