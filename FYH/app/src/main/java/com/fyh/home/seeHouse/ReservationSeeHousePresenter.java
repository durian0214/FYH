package com.fyh.home.seeHouse;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.releaseHouse.model.ReservationSeeHouseModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.room.view.ReservationSeeHouseView;

import java.util.HashMap;
import java.util.Map;

/**
 * 预约看房
 * 2017-2017/1/12
 */
public class ReservationSeeHousePresenter extends BasePresenter<ReservationSeeHouseView>{
    public ReservationSeeHousePresenter(ReservationSeeHouseView view){
        attachView(view);
    }
    public void submitData(String name,String phone,String remark,int roomId){
        Map<String,Object> params  = new HashMap<>();
        params.put("name",name);
        params.put("phone",phone);
        params.put("roomId",roomId);
        params.put("description",remark);
        HttpUtils.getInstance().jsonPost(HttpConstant.SUBMIT_SEE_ROOM, params, new DefaultObjectHttpListener<ReservationSeeHouseModel>() {
            @Override
            public void onSuccessParsed(ReservationSeeHouseModel result) {
                myView.submitData();
            }
        });

    }
}

