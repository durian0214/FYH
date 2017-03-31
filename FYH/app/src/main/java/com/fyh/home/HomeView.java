package com.fyh.home;

import com.fyh.apartment.model.GetApartmentModel;
import com.fyh.room.model.GetRoomModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Created by Cbt on 2016/12/28.
 */
public interface HomeView extends BaseView{
    void getApartmentSuccess(List<GetApartmentModel> lists);
    void getRoomSuccess( List<GetRoomModel> lists);
}
