package com.fyh.my.forgetPw;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.utils.ToastUtils;

/**
 * Created by Cbt on 2016/12/23.
 * 忘记密码
 *
 */
public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener ,ForgetPasswordView {
    private EditText edtMobile ,edtCode,edtPassword,edtAffirmPassword;
    private Button btnGetCode,btnCompleteLogin;
    private ForgetPasswordPresenter presenter ;
    private RelativeLayout rlMobile,rlCode,rlPassword,rlAffirmPassword;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.FORGET_PASSWORD);
        presenter = new ForgetPasswordPresenter(this);
        edtMobile = getId(R.id.edt_forget_password_mobile);
        edtCode = getId(R.id.edt_forget_password_code) ;
        edtPassword = getId(R.id.edt_forget_password_password);
        edtAffirmPassword = getId(R.id.edt_forget_password_affirm_password);
        btnGetCode = getId(R.id.btn_forget_password_getcode);
        btnCompleteLogin = getId(R.id.btn_forget_password_complete_login);
        rlMobile = getId(R.id.rl_forget_password_mobile);
        rlCode= getId(R.id.rl_forget_password_code);
        rlPassword= getId(R.id.rl_forget_password_password);
        rlAffirmPassword= getId(R.id.rl_edt_forget_password_affirm_password);
        rlMobile.getBackground().setAlpha(127);//0~255透明度值 
         rlCode.getBackground().setAlpha(127);//0~255透明度值 
         rlPassword.getBackground().setAlpha(127);//0~255透明度值 
         rlAffirmPassword.getBackground().setAlpha(127);//0~255透明度值 
        edtMobile.setText("18810375905");
        edtPassword.setText("123456");
        edtAffirmPassword.setText("123456");

    }

    @Override
    public void setOnclick() {
        btnGetCode.setOnClickListener(this);
        btnCompleteLogin.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_forget_password_getcode:
                String mobile = edtMobile.getText().toString();
                if(mobile.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入手机号");
                return;
                }
                showProgress();
                presenter.getCode(mobile);
                break;
            case R.id.btn_forget_password_complete_login:
                String m = edtMobile.getText().toString();
                String code = edtCode.getText().toString();
                String pwd = edtPassword.getText().toString();
                String apwd = edtAffirmPassword.getText().toString();
                if(m.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入手机号");
                    return;
                }
                if(code.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入验证码");
                    return;
                }
                if(pwd.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入密码");
                    return;
                }
                if(apwd.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入确认密码");
                    return;
                }
                showProgress();
                presenter.setPassword(m,pwd,apwd,code);
                break;
        }
    }

    @Override
    public void getCodeSuccess(String code) {
        hideProgress();
        ToastUtils.showToastS(getCurrentActivity(),"发送成功");
        edtCode.setText(code);
    }

    @Override
    public void setPasswordSuccess(ForgetPasswordModel model) {
        hideProgress();
        ToastUtils.showToastS(getCurrentActivity(),"注册成功");
        this.finish();
    }

    @Override
    public void netError(String msg) {
        hideProgress();
        ToastUtils.showToastS(getCurrentActivity(),msg);
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
