package com.fyh.my.contract;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultListHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Locker on 2017/1/16.
 */
public class ContractListPresenter extends BasePresenter<ContractListView>{

    public ContractListPresenter(ContractListView contractListView){
        attachView(contractListView);
    }
    public void getContractListData(){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userId", Constant.sessionId);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_CONTRACT_LIST, params, new DefaultListHttpListener<ContractModel>() {
            @Override
            public void onSuccessParsed(List result) {
                myView.getData(result);
            }

            @Override
            public void onListSizeZero() {

            }
        });
    }
}
