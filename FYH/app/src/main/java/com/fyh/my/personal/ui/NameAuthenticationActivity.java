package com.fyh.my.personal.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.my.personal.presenter.NameAuthenticationPresenter;
import com.fyh.my.personal.view.NameAuthenticationView;
import com.fyh.utils.ToastUtils;

/**
 * a
 * 2017-2017/1/12
 */
public class NameAuthenticationActivity extends BaseActivity implements View.OnClickListener,NameAuthenticationView {
    private EditText edtName ,edtId;
    private Button btnAuthentication;
    private NameAuthenticationPresenter presenter ;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_name_authentication;
    }

    @Override
    public void initView() {
        presenter = new NameAuthenticationPresenter(this);
        edtName = getId(R.id.edt_name_authentication_name);
        edtId = getId(R.id.edt_name_authentication_id);
        btnAuthentication = getId(R.id.btn_name_authentication);
    }

    @Override
    public void setOnclick() {
        btnAuthentication.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void authentication() {

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
            case R.id.btn_name_authentication:
                if(edtName.getText().toString().isEmpty()){
                     ToastUtils.showToastS(getCurrentActivity(),"请输入姓名");
                    return;
                }
                if(edtId.getText().toString().isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入身份证号");
                    return;
                }
//                presenter.authentication();
                break;
        }
    }
}
