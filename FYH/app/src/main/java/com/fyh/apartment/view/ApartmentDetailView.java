package com.fyh.apartment.view;

import com.fyh.apartment.model.ApartmentDetailModel;
import com.fyh.apartment.model.ApartmentDetailRoomModelList;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Created by Cbt on 2017/1/3.
 */
public interface ApartmentDetailView extends BaseView{
    void loadDetail(ApartmentDetailModel model);
    void loadLists(List<ApartmentDetailRoomModelList.itemRows> lists);
}
