package com.fyh.apartment.view;

import com.fyh.apartment.model.ApartmentListModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Created by Cbt on 2016/12/30.
 */
public interface ApartmentListView extends BaseView{
    void getDataSuccess(List<ApartmentListModel> list);
}
