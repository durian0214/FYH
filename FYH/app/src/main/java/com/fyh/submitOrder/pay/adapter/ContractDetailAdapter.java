package com.fyh.submitOrder.pay.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.my.contract.ContractDetailModel;

import java.util.List;

/**
 * 个人中心-合同详情 (交租日期列表赋值)
 * Created by LiuXL
 * on 2017/1/16 0016.
 */
public class ContractDetailAdapter extends CommonBaseAdapter<ContractDetailModel.RentDayListBean> {

    public ContractDetailAdapter(Context context, List<ContractDetailModel.RentDayListBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, ContractDetailModel.RentDayListBean data) {

        holder.setText(R.id.tv_return_times,data.getReturnTimes()+"");
        holder.setText(R.id.tv_pay_date,data.getPayDate());
        holder.setText(R.id.tv_payments,data.getPayments()+"");
        String during = data.getStartDate()+"\n" +data.getEndDate();
        holder.setText(R.id.tv_curtDuring,during);
        String pstatus = data.getPayStatus()==1?"已付款":"待支付";
        holder.setText(R.id.tv_pay_status,pstatus);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_contract_detail;
    }






}
