package com.fyh.submitOrder.pay.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.submitOrder.pay.presenter.FundDetailPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.submitOrder.pay.view.FundDetailView;

/**
 * Durian
 * 2017-2017/1/16
 * 款项详情
 */
public class FundDetailActivity extends BaseActivity implements FundDetailView,View.OnClickListener{
    private TextView tvRent,tvCashDeposit,tvServiceCharge,tvShouldPay;
    private Button btnNext;
    private FundDetailPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_fund_detail;
    }

    @Override
    public void initView() {
        presenter = new FundDetailPresenter(this);
        tvRent = getId(R.id.tv_fund_detail_rent);
        tvCashDeposit = getId(R.id.tv_fund_detail_cash_deposit);
        tvServiceCharge = getId(R.id.tv_fund_detail_service_charge);
        tvShouldPay = getId(R.id.tv_fund_detail_should_pay);
        btnNext = getId(R.id.btn_fund_detail_next);
    }

    @Override
    public void setOnclick() {
        btnNext.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void getFundDetail() {

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
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.btn_fund_detail_next:
            intentJump(getCurrentActivity(),AffirmContractActivity.class,null);
            break;
    }
    }
}
