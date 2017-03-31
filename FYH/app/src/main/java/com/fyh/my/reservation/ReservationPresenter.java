package com.fyh.my.reservation;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.releaseHouse.view.ReservationView;

import java.util.List;

/**
 * Created by Cbt on 2016/12/29.
 */
public class ReservationPresenter extends BasePresenter<ReservationView>{
    public ReservationPresenter(ReservationView view){
        attachView(view);
    }
    public void getData(){
         HttpUtils.getInstance().jsonPost(HttpConstant.GET_RESERVATION, null, new DefaultListHttpListener<ReservationModel>() {
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
