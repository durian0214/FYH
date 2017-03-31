package com.fyh.guide.main;

import com.fyh.aramis.AramisUtils;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.home.AreaModel;
import com.fyh.home.CityModel;
import com.fyh.listen.StringListener;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Cbt on 2016/12/22.
 */
public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void loadCityData() {
        Map<String, Object> params = new HashMap<>();
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_ALLCITY, params, new DefaultHttpListener() {
            @Override
            protected void onSuccessParsedFirst(int code, String data) {
                LogUtil.i("GetAllCity", data);
                List<CityModel> lists = GsonUtil.getIntance().parseArray(data, CityModel.class);
                Constant.cityList = lists;
                myView.loadCityData();
            }
        });
    }

    public void getAreaData() {
        Map<String, Object> params = new HashMap<>();
        params.put("cityId", Constant.cityId);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_AREAS, params, new DefaultListHttpListener<AreaModel>() {
            public void onSuccessParsed(List result) {
                AreaModel bean = new AreaModel();
                bean.setName("不限");
                bean.setId(0);
                bean.setPid(0);
                Constant.areaList.add(bean);
                Constant.areaList.addAll(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });


        OkHttpUtil.getIntance().postHttp(HttpConstant.GET_AREAS, params, new StringListener() {
            @Override
            public void onSusseccData(String msg) {
                LogUtil.e(AramisUtils.TAG(), "OkHttpUtil success" + msg);
            }

            @Override
            public void onError(Request request, IOException e) {
                LogUtil.e(AramisUtils.TAG(), "OkHttpUtil error" + e.toString());
            }
        });
    }
}
