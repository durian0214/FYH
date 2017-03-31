package com.fyh.my.contract;

import com.fyh.my.contract.ContractModel;
import com.fyh.base.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Locker on 2017/1/16.
 */
public interface ContractListView extends BaseView {
    void getData(  List<ContractModel> list);
}
