package com.fyh.room.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;

import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.room.model.RoomDetailModel;
import com.fyh.room.model.RoomNeighborModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.room.view.RoomDetailView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 2017/1/10.
 */
public class RoomDetailPresenter extends BasePresenter<RoomDetailView>{
    public RoomDetailPresenter(RoomDetailView myView){
        attachView(myView);
    }
    public void getRoomData(final int roomId){
        Map<String,Object> params = new HashMap<>();
        params.put("roomId",roomId);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_ROOM_DETAIL, params, new DefaultObjectHttpListener<RoomDetailModel>() {
            @Override
            public void onSuccessParsed(RoomDetailModel result) {
                myView.getData(result);
            }
        });

    }
    public void getNeighbor( int roomId ){
        Map<String,Object> params = new HashMap<>();
        params.put("roomId",roomId);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_HOUSE_NEIGHBOR, params, new DefaultObjectHttpListener<RoomNeighborModel>() {
            @Override
            public void onSuccessParsed(RoomNeighborModel result) {
                myView.getNeighborData(result.getRoomMate());
            }
        });

    }
}
