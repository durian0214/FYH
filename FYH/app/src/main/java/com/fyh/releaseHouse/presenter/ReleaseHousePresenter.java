package com.fyh.releaseHouse.presenter;

import com.fyh.apartment.bean.ApartmentRoomExtendBean;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.bean.RoomBean;
import com.fyh.bean.RoomRequirementsBean;
import com.fyh.bean.SuiteBean;
import com.fyh.listen.StringListener;
import com.fyh.base.BasePresenter;
import com.fyh.releaseHouse.model.ReleaseHouseListModel;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.releaseHouse.view.ReleaseHouseView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/1/23
 */
public class ReleaseHousePresenter extends BasePresenter<ReleaseHouseView> {
    public ReleaseHousePresenter(ReleaseHouseView view){
        attachView(view);
    }
    public void releaseHouse(ApartmentRoomExtendBean extend, RoomBean room, RoomRequirementsBean requirements, SuiteBean suite){
        Map<String, Object> params = new HashMap<>();
        params.put("extend",extend);
        params.put("room",room);
        params.put("requirements",requirements);
        params.put("suite",suite);
        HttpUtils.getInstance().jsonPost(HttpConstant.RELEASE_HOUSE, params, new DefaultObjectHttpListener<String>() {
            @Override
            public void onSuccessParsed(String result) {
                LogUtil.i("发布房源：",result);
                myView.releaseSuccess();
            }
        });
    }

}
