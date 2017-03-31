package com.fyh.my.modifyMobile;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.my.modifyMobile.ModifyMobileView;

/**
 * Durian
 * 2017-2017/1/18
 * 更换手机号
 */
public class ModifyMobileActivity extends BaseActivity implements View.OnClickListener, ModifyMobileView {
    private Button btnGetCode, btnAffirm;
    private EditText edtPassword, edtPhone, edtCode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_mobile;
    }

    @Override
    public void initView() {
        edtPassword = getId(R.id.edt_modify_mobile_password);
        edtPhone = getId(R.id.edt_modify_mobile_phone);
        edtCode = getId(R.id.edt_modify_mobile_code);
        btnGetCode = getId(R.id.btn_modify_mobile_get_code);
        btnAffirm = getId(R.id.btn_modify_mobile_affirm);

    }

    @Override
    public void setOnclick() {
        btnGetCode.setOnClickListener(this);
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
            case R.id.btn_modify_mobile_get_code:
                break;
            case R.id.btn_modify_mobile_affirm:
                break;
        }
    }
}
