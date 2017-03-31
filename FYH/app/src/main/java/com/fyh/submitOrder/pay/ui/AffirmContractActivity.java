package com.fyh.submitOrder.pay.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.submitOrder.pay.presenter.AffirmContractPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.submitOrder.pay.view.AffirmContractView;

/**
 * Durian
 * 2017-2017/1/16
 * 确认合同
 */
public class AffirmContractActivity extends BaseActivity implements View.OnClickListener, AffirmContractView {
    private TextView tvName, tvId, tvApartmentAddress, tvContractDate, tvPayWay;
    private Button btnAffirm;
    private AffirmContractPresenter presenter;
    @Override
    public void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_contract;
    }

    @Override
    public void initView() {
        presenter = new AffirmContractPresenter(this);
        tvName = getId(R.id.tv_affirm_contract_name);
        tvId = getId(R.id.tv_affirm_contract_id);
        tvApartmentAddress = getId(R.id.tv_affirm_contract_apartment_address);
        tvContractDate = getId(R.id.tv_affirm_contract_contract_date);
        tvPayWay = getId(R.id.tv_affirm_contract_pay_way);
        btnAffirm = getId(R.id.btn_affirm_contract);
    }

    @Override
    public void setOnclick() {
        btnAffirm.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.btn_affirm_contract:
                intentJump(getCurrentActivity(),OnlinePayActivity.class,null);
                break;
        }
    }
}
