package com.fyh.my.personal.ui;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.my.personal.view.AccountInfoView;
import com.fyh.my.modifyMobile.ModifyMobileActivity;
import com.fyh.utils.Constant;

/**
 * Durian
 * 2017-2017/1/18
 * 账号信息
 */
public class AccountInfoActivity extends BaseActivity implements View.OnClickListener,AccountInfoView {
    private TextView tvAccount,tvMobile;
    private RelativeLayout rlMobile;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_info;
    }

    @Override
    public void initView() {
        tvAccount = getId(R.id.tv_account_info_account);
        tvMobile = getId(R.id.tv_account_info_mobile);
        rlMobile = getId(R.id.rl_account_info_mobile);
        tvAccount.setText(Constant.ACCOUNT);
        tvMobile.setText(Constant.MOBILE);
    }

    @Override
    public void setOnclick() {
        rlMobile.setOnClickListener(this);

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
            case R.id.rl_account_info_mobile:
                intentJump(getCurrentActivity(),ModifyMobileActivity.class,null);
                break;
        }
    }
}
