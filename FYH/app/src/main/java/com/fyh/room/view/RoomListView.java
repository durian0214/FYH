package com.fyh.room.view;

import com.fyh.room.model.RoomListModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Created by a on 2017/1/9.
 */
public interface RoomListView  extends BaseView{
    void getRoomListData(List<RoomListModel.RowsBean> list);
}
