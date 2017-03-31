package com.fyh.my.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.my.login.LoginActivity;
import com.fyh.base.BaseActivity;
import com.fyh.utils.ToastUtils;


/**
 * 註冊
 */
public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener {
    private EditText edtAccount, edtPhone, edtCode, edtPassWord;
    private Button btnRegister, btnGetCode;
    private TextView tvLogin;
    private RegisterPresenter presenter;
    private String sendCode;
    private RelativeLayout rlAccount,rlPhone,rlCode,rlPassword;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.REGISTER);
        presenter = new RegisterPresenter(this);
        edtAccount = getId(R.id.edt_register_account);
        edtPhone = getId(R.id.edt_register_phone);
        edtCode = getId(R.id.edt_register_code);
        edtPassWord = getId(R.id.edt_register_password);
        btnRegister = getId(R.id.btn_register);
//        edtAccount.setText("1122131");
//        edtPhone.setText("18810375905");
//        edtPassWord.setText("123456  ");
        tvLogin = getId(R.id.tv_register_login);
        btnGetCode = getId(R.id.btn_register_getcode);
        rlAccount = getId(R.id.rl_register_account);
        rlPhone = getId(R.id.rl_register_phone);
        rlCode = getId(R.id.rl_register_code);
        rlPassword = getId(R.id.rl_register_password);
        rlAccount.getBackground().setAlpha(127);//0~255透明度值 
        rlPassword.getBackground().setAlpha(127);//0~255透明度值 
        rlCode.getBackground().setAlpha(127);//0~255透明度值 
        rlPhone.getBackground().setAlpha(127);//0~255透明度值 
    }

    @Override
    public void setOnclick() {
        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        btnGetCode.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                String account = edtAccount.getText().toString();
                String password = edtPassWord.getText().toString();
                String code = edtCode.getText().toString();
                String mobile = edtPhone.getText().toString();
                if (code.isEmpty()) {
                    ToastUtils.showToastS(getCurrentActivity(), "请输入验证码");
                    return;
                }
                if (!sendCode.equals(code)) {
                    ToastUtils.showToastS(getCurrentActivity(), "验证码错误");
                    return;
                }
                if (account.isEmpty()) {
                    ToastUtils.showToastS(getCurrentActivity(), "请输入账号");
                    return;
                }
                if (password.isEmpty()) {
                    ToastUtils.showToastS(getCurrentActivity(), "请输入密码");
                    return;
                }
                if (mobile.isEmpty()) {
                    ToastUtils.showToastS(getCurrentActivity(), "请输入手机号");
                    return;
                }
                showProgress();
                presenter.doRegister(account, mobile, code, password);
                break;
            case R.id.tv_register_login:
                intentJump(getCurrentActivity(), LoginActivity.class, null);
                break;
            case R.id.btn_register_getcode:
                String m = edtPhone.getText().toString();
                if (m.isEmpty()) {
                    ToastUtils.showToastS(getCurrentActivity(), "请输入手机号");
                }
                showProgress();
                presenter.getCode(m);
                break;
        }
    }

    @Override
    public void doRegisterSuccess(RegisterModel model) {
        hideProgress();
        ToastUtils.showToastS(getCurrentActivity(), "注册成功");
        String account = model.getAccount();
        String password = model.getPassword();
        getCurrentActivity().finish();
    }


    @Override
    public void getCodeSuccess(String model) {
        hideProgress();
        sendCode = model;
        edtCode.setText(sendCode);
        ToastUtils.showToastS(getCurrentActivity(), "发送成功");
    }

    @Override
    public void netError(String msg) {
        hideProgress();
        ToastUtils.showToastS(getCurrentActivity(), msg);
    }

    @Override
    public void showProgress() {
        showDialog("请稍等");
    }

    @Override
    public void hideProgress() {
        disDialog();
    }
}
