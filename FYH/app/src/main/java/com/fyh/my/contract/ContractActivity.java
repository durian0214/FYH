package com.fyh.my.contract;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.submitOrder.pay.presenter.ContractPresenter;
import com.fyh.submitOrder.pay.ui.FundDetailActivity;
import com.fyh.submitOrder.pay.view.ContractView;

/**
 * Durian
 * 2017-2017/1/16
 * 合同
 */
public class ContractActivity extends BaseActivity implements ContractView,View.OnClickListener{
    private Button btnContract;
    private WebView wb;
    private ContractPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_contract;
    }

    @Override
    public void initView() {
        presenter = new ContractPresenter(this);
        btnContract  = getId(R.id.btn_contract);
        wb = getId(R.id.wv_contract);
    }

    @Override
    public void setOnclick() {
        btnContract.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void getContract() {

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
            case R.id.btn_contract:
                intentJump(getCurrentActivity(),FundDetailActivity.class,null);
                break;
        }
    }
}
