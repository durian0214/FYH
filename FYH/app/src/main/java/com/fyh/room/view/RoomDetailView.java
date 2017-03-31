package com.fyh.room.view;

import com.fyh.room.model.RoomDetailModel;
import com.fyh.room.model.RoomNeighborModel;
import com.fyh.base.BaseView;

import java.util.ArrayList;

/**
 * Created by a on 2017/1/5.
 */
public interface RoomDetailView extends BaseView {
    void getData(RoomDetailModel model);

    void getNeighborData(ArrayList<RoomNeighborModel.RoomMateBean> lists);
}
