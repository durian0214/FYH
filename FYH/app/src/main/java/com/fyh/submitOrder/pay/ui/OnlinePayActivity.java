package com.fyh.submitOrder.pay.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.submitOrder.pay.view.OnlinePayView;

/**
 * Durian
 * 2017-2017/1/16
 * 在线支付
 */
public class OnlinePayActivity extends BaseActivity implements OnlinePayView,View.OnClickListener{
    private Button btnOnlinePay;
    private TextView tvTime,tvApartmentAddress,tvShouldPay;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_online_pay;
    }

    @Override
    public void initView() {
        btnOnlinePay = getId(R.id.btn_online_pay);
        tvTime = getId(R.id.tv_online_pay_time);
        tvApartmentAddress = getId(R.id.tv_online_pay_apartment_address);
        tvShouldPay = getId(R.id.tv_fund_detail_should_pay);
    }

    @Override
    public void setOnclick() {
        btnOnlinePay.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
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
        switch(v.getId()){
            case R.id.btn_online_pay:
                break;
        }
    }
}
