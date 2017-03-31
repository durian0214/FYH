package com.fyh.releaseHouse.view;

import com.fyh.my.reservation.ReservationModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Created by Cbt on 2016/12/29.
 */
public interface ReservationView extends BaseView{
    void getData(List<ReservationModel> model);
}
