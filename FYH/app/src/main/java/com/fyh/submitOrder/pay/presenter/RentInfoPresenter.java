package com.fyh.submitOrder.pay.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.room.model.RoomListModel;
import com.fyh.submitOrder.pay.model.RentInfoModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.submitOrder.pay.view.RentInfoView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/1/13
 */
public class RentInfoPresenter extends BasePresenter<RentInfoView> {
    public RentInfoPresenter(RentInfoView myView) {
        attachView(myView);
    }
    public void getRentInfoData(int roomId) {
        Map<String ,Object> params = new HashMap<>();
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_ROOM_LIST, params, new DefaultObjectHttpListener<RentInfoModel>() {
            @Override
            public void onSuccessParsed(RentInfoModel result) {
                myView.getRentInfo(result);
            }
        });
    }

}
