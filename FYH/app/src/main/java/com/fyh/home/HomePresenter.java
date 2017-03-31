package com.fyh.home;

import com.fyh.apartment.model.GetApartmentModel;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.room.model.GetRoomModel;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cbt on 2016/12/28.
 */
public class HomePresenter extends BasePresenter<HomeView> {

    public HomePresenter(HomeView myView) {
        attachView(myView);
    }

    public void getApartment() {
        Map<String,Object> params = new HashMap<>();
        params.put("regionId",Constant.REGISON_ID);
        params.put("limit",5);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_RECOMMEND_APARTMENT, params, new DefaultListHttpListener<GetApartmentModel>() {
            @Override
            public void onSuccessParsed(List<GetApartmentModel> result) {
                myView.getApartmentSuccess(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
//        new DefaultHttpListener() {
//            @Override
//            protected void onSuccessParsedFirst(int code, String data) {
//                LogUtil.i("公寓数据==", data);
//                List<GetApartmentModel> lists = GsonUtil.getIntance().parseArray(data, GetApartmentModel.class);
//
//            }
//        }


    }

    public void getRoom() {
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_ROOM, null, new DefaultListHttpListener<GetRoomModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getRoomSuccess(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });

    }
}
