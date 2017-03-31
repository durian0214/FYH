package com.fyh.releaseHouse.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.apartment.model.ConfigurationModel;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.releaseHouse.model.DicModel;
import com.fyh.releaseHouse.model.LineModel;
import com.fyh.releaseHouse.model.StationModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.releaseHouse.view.GetHouseInfoView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Durian
 * 2017-2017/1/20
 * 获取公寓字典
 */
public class HouseInfoPresenter extends BasePresenter<GetHouseInfoView> {
    public HouseInfoPresenter(GetHouseInfoView view){
        attachView(view);
    }

    /**
     * 获取朝向
     */
   public void getToward(){
       Map<String ,Object> params = new HashMap<>();
       params.put("dicCode","orientation");
       HttpUtils.getInstance().jsonPost(HttpConstant.GET_DIC, params, new DefaultListHttpListener<DicModel>() {
           @Override
           public void onSuccessParsed(List result) {
               myView.getToward(result);
           }

           @Override
           public void onListSizeZero() {

           }
       });

   }
    /**
     * 获取支付方式
     */
    public  void getPayment(){
        Map<String ,Object> params = new HashMap<>();
        params.put("dicCode","paymentMethod");
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_DIC, params, new DefaultListHttpListener<DicModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getPay(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
    /**
     * 获取装修风格
     */
    public  void getDecorate(){
        Map<String ,Object> params = new HashMap<>();
        params.put("dicCode","decorating");
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_DIC, params, new DefaultListHttpListener<DicModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getDecorate(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
    /**
     * 获取房屋配置
     */
    public void getConfiguration(){

        HttpUtils.getInstance().jsonPost(HttpConstant.GET_CONFIGS, null, new DefaultListHttpListener<ConfigurationModel>() {
            @Override
            public void onSuccessParsed(List result) {
                   myView.getConfiguration(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
    /**
     * 获取供暖方式
     */
    public void getHeating(){
        Map<String ,Object> params = new HashMap<>();
        params.put("dicCode","steamType");
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_DIC, params, new DefaultListHttpListener<DicModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getHeating(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });

    }
    /**
     * 获取地铁线路
     */
    public void getLine(){
        Map<String ,Object> params = new HashMap<>();
        params.put("regionId",Constant.REGISON_ID);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_LINE, params, new DefaultListHttpListener<LineModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getLine(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
    /**
     * 获取地铁站
     */
    public void getStation(int lineId){
        Map<String ,Object> params = new HashMap<>();
        params.put("lineId",lineId);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_STATION, params, new DefaultListHttpListener<StationModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getStation(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });

    }
    /**
     * 获取公寓标签
     */
    public void getLabel() {
        Map<String, Object> params = new HashMap<>();
        params.put("dicCode", "tags");
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_DIC, params, new DefaultListHttpListener<DicModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getLabel(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
}
