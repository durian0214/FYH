package com.fyh.my.collection;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.listen.StringListener;

import com.fyh.base.BasePresenter;
import com.fyh.releaseHouse.model.ReservationSeeHouseModel;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public class CollectionPresenter extends BasePresenter<CollectionView> {

    public CollectionPresenter(CollectionView view){
        attachView(view);
    }
    public void getData(Integer pageNo,Integer pageSize){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("pageNo",pageNo);
        params.put("pageSize",pageSize);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_COLLECTION_LIST, params, new DefaultListHttpListener<CollectionModel>() {
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
