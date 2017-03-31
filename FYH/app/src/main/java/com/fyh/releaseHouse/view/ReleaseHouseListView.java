package com.fyh.releaseHouse.view;

import com.fyh.releaseHouse.model.ReleaseHouseListModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Durian
 * 2017-2017/1/22
 */
public interface ReleaseHouseListView extends BaseView{
    void getData(List<ReleaseHouseListModel> list);
}
