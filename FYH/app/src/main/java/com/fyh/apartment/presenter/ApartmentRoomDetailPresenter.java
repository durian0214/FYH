package com.fyh.apartment.presenter;

import com.fyh.apartment.model.ApartmentRoomDetailModel;
import com.fyh.apartment.model.ApartmentRoomNeighborModel;
import com.fyh.apartment.view.ApartmentRoomDetailView;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a on 2017/1/5.
 */
public class ApartmentRoomDetailPresenter extends BasePresenter<ApartmentRoomDetailView>{
    public ApartmentRoomDetailPresenter(ApartmentRoomDetailView myView){
        attachView(myView);
    }
    public void getRoomData(final String roomId , final String apartmentId){
        Map<String,Object> params = new HashMap<>();
        params.put("roomId",Integer.parseInt(roomId));
        params.put("apartmentId",Integer.parseInt(apartmentId));
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_APARTMENT_ROOM_DETAIL, params, new DefaultObjectHttpListener<ApartmentRoomDetailModel>() {
            @Override
            public void onSuccessParsed(ApartmentRoomDetailModel result) {
                myView.getData(result);
            }
        });
    }
    public void getNeighbor( String suiteId ){
        Map<String,Object> params = new HashMap<>();
        params.put("suiteId",Integer.parseInt(suiteId));

        HttpUtils.getInstance().jsonPost(HttpConstant.GET_APARTMENT_ROOM_NEIGHBOR, params, new DefaultListHttpListener<ApartmentRoomNeighborModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getNeighborData(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
}
