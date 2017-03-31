package com.fyh.releaseHouse.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.releaseHouse.model.DicModel;
import com.fyh.releaseHouse.model.ReleaseHouseListModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.releaseHouse.view.ReleaseHouseListView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/1/22
 */
public class ReleaseHouseListPresenter extends BasePresenter<ReleaseHouseListView>{
    public ReleaseHouseListPresenter(ReleaseHouseListView view){
        attachView(view);
    }
    public void getData(){
        Map<String,Object> params = new HashMap<>();
        params.put("cityId",Constant.REGISON_ID);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_DISTRIBUTED_LIST, params, new DefaultListHttpListener<ReleaseHouseListModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getData(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
}
