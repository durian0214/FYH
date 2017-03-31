package com.fyh.apartment.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.apartment.model.ApartmentDetailModel;
import com.fyh.apartment.model.ApartmentDetailRoomModelList;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.apartment.view.ApartmentDetailView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 2017/1/3.
 */
public class ApartmentDetailPresenter extends BasePresenter<ApartmentDetailView> {
    public ApartmentDetailPresenter(ApartmentDetailView myView) {
        attachView(myView);
    }

    public void getDetail(String apartmentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("apartmentId",Integer.parseInt(apartmentId));

        HttpUtils.getInstance().jsonPost(HttpConstant.GET_APARTMENT_DETAIL, params, new DefaultObjectHttpListener<ApartmentDetailModel>() {
            @Override
            public void onSuccessParsed(ApartmentDetailModel result) {
                myView.loadDetail(result);
            }
        });
    }
    public void getRoomLists(String apartmentId ,int page,int pageNum) {
        Map<String, Object> params = new HashMap<>();
        params.put("apartmentId",Integer.parseInt(apartmentId));
        params.put("pageNo",page);
        params.put("pageSize",pageNum);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_APARTMENT_DETAIL_LISTS, params, new DefaultObjectHttpListener<ApartmentDetailRoomModelList>() {
            @Override
            public void onSuccessParsed(ApartmentDetailRoomModelList result) {
                myView.loadLists(result.getRows());
            }
        });
    }
}
