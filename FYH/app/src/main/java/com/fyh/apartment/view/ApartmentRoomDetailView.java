package com.fyh.apartment.view;

import com.fyh.apartment.model.ApartmentRoomDetailModel;
import com.fyh.apartment.model.ApartmentRoomNeighborModel;
import com.fyh.base.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/5.
 */
public interface ApartmentRoomDetailView extends BaseView {
    void getData(ApartmentRoomDetailModel model);

    void getNeighborData(List<ApartmentRoomNeighborModel> lists);
}
