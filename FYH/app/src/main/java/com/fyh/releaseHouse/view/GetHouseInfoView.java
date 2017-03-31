package com.fyh.releaseHouse.view;

import com.fyh.apartment.model.ConfigurationModel;
import com.fyh.releaseHouse.model.DicModel;
import com.fyh.releaseHouse.model.LineModel;
import com.fyh.releaseHouse.model.StationModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Durian
 * 2017-2017/1/20
 */
public interface GetHouseInfoView extends BaseView{
    void getToward(List<DicModel> list );
    void getPay(List<DicModel> list);
    void getDecorate(List<DicModel> list);
    void getConfiguration(List<ConfigurationModel> list);
    void getHeating(List<DicModel> list);
    void getLine(List<LineModel> list);
    void getStation(List<StationModel> list);
    void getLabel(List<DicModel> list);
}
