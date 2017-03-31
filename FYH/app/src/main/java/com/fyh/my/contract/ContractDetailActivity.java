package com.fyh.my.contract;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.listen.OnLoadMoreListener;
import com.fyh.submitOrder.pay.adapter.ContractDetailAdapter;
import com.fyh.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人中心-合同详情
 * Created by LiuXL
 * on 2017/1/16 0016.
 */
public class ContractDetailActivity extends BaseActivity implements View.OnClickListener ,ContractDetailView {
    private RecyclerView rv;
    private ContractDetailAdapter cdAdapter;
    private ContractDetailPresenter cdPresenter;
    private List<ContractDetailModel.RentDayListBean> lists ;
    private TextView tvNoVal,tvAddressVal,tvDuringVal,tvRentVal,tvDepositVal,tvPayVal;
    private int contractId ;
    @Override
    public void initView() {
        Bundle bundle =  getIntent().getBundleExtra("bundle");
        contractId  = bundle.getInt("contractId");
        setMyTitle("合同详情");
        cdPresenter = new ContractDetailPresenter(this);
        tvNoVal = getId(R.id.tv_contract_no_val);
        tvAddressVal = getId(R.id.tv_contract_address_val);
        tvDuringVal = getId(R.id.tv_contract_during_val);
        tvRentVal = getId(R.id.tv_contract_rent_val);
        tvDepositVal = getId(R.id.tv_contract_deposit_val);
        tvPayVal = getId(R.id.tv_contract_pay_val);
        rv = getId(R.id.rv_rentday_list);
        rv.setLayoutManager(Utils.getVManager(getCurrentActivity()));
        lists = new ArrayList<>();
        cdAdapter = new ContractDetailAdapter(getCurrentActivity(),lists,true);
        //初始化 开始加载更多的loading View
        cdAdapter.setLoadingView(R.layout.test_load_loading_layout);
        //设置加载更多触发的事件监听
        cdAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
            }
        });
        cdAdapter.setOnItemClickListener(new OnItemClickListener<ContractDetailModel.RentDayListBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, ContractDetailModel.RentDayListBean data, int position) {

            }

        });

        rv.setAdapter(cdAdapter);
        cdPresenter.getData(contractId);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_contract_detail;
    }


    @Override
    public void setOnclick() {

    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void netError(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void getContract(ContractDetailModel contract) {
        lists.addAll(contract.getRentDayList());
        cdAdapter.notifyDataSetChanged();
        tvNoVal.setText(contract.getContractNo());
        tvAddressVal.setText(contract.getRoomName());
        String during = contract.getStartDate()+"/"+contract.getEndDate();
        tvDuringVal.setText(during);
        tvRentVal.setText(contract.getRent()+"");
        tvDepositVal.setText(contract.getDeposit()+"");
        String pay = contract.getPay();
        String payType ="1".equals(pay)?"月付":"3".equals(pay)?"季付":"6".equals(pay)?"半年付":"年付";
        tvPayVal.setText(payType);
    }
}
