package com.fyh.my.contract;

import com.fyh.my.contract.ContractDetailModel;
import com.fyh.base.BaseView;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public interface ContractDetailView extends BaseView {
    void getContract(ContractDetailModel contract);
}
