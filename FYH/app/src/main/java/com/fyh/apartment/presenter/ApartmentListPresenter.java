package com.fyh.apartment.presenter;

import com.fyh.apartment.model.ApartmentListModel;
import com.fyh.apartment.view.ApartmentListView;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a on 2017/1/6.
 */
public class ApartmentListPresenter extends BasePresenter<ApartmentListView>{
    public ApartmentListPresenter(ApartmentListView myView){
        attachView(myView);
    }
    public void getApartmentListData(int page,int pageNum){
        Map<String, Object> params = new HashMap<>();
        params.put("regionId",Constant.REGISON_ID);
        params.put("pageNo", page);
        params.put("pageSize", pageNum);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_APARTMENT_LIST, params, new DefaultListHttpListener<ApartmentListModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getDataSuccess(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
}
