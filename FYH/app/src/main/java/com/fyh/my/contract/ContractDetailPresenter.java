package com.fyh.my.contract;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心-合同详情 数据访问（获取数据）
 * Created by LiuXL
 * on 2017/1/16 0016.
 */
public class ContractDetailPresenter extends BasePresenter<ContractDetailView> {

    public ContractDetailPresenter(ContractDetailView view){
        attachView(view);
    }
    public void getData(Integer contractId){
        Map<String,Object> params = new HashMap<>();
        params.put("contractId",contractId);
        params.put("userId",Constant.sessionId);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_CONTRACT_DETAIL, params, new DefaultObjectHttpListener<ContractDetailModel>() {
            @Override
            public void onSuccessParsed(ContractDetailModel result) {
                myView.getContract(result);
            }
        });
    }
}
