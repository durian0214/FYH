package com.fyh.room.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.releaseHouse.model.DicModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.releaseHouse.view.GetHouseTypeView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/2/22
 */
public class GetHouseTypePresenter extends BasePresenter<GetHouseTypeView>{
    public GetHouseTypePresenter(GetHouseTypeView view){
        attachView(view);
    }
    /**
     * 获取房间类型
     */
    public void getHouseType(){
        Map<String ,Object> params = new HashMap<>();
        params.put("dicCode","houseType");
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_DIC, params, new DefaultListHttpListener<DicModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getHouseType(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
}
