package com.fyh.my.login;


import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.bean.LoginBean;
import com.fyh.md5.NslmCryptoUtils;
import com.fyh.base.BaseActivity;
import com.fyh.my.forgetPw.ForgetPasswordActivity;
import com.fyh.my.register.RegisterActivity;
import com.fyh.utils.Constant;
import com.fyh.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;


/**
 * 登錄
 */
public class LoginActivity extends BaseActivity implements OnClickListener, LoginView {
    private EditText edtAccount, edtPassword;
    private TextView tvRegister, tvForgetPassword;
    private Button btnLogin;
    private LoginPresenter presenter;
    private RelativeLayout rlAccount,rlPassword;
    private ImageView imgBack;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        bar.hide();
        setMyTitle(R.string .LOGIN);
        presenter = new LoginPresenter(this);
        edtAccount = getId(R.id.edt_login_account);
        edtPassword = getId(R.id.edt_login_password);
        imgBack = getId(R.id.img_login_back);
        imgBack.setOnClickListener(this);
        edtAccount.setText("18201549455");
        edtPassword.setText("123qwe");
        tvRegister = getId(R.id.tv_login_register);
        tvForgetPassword = getId(R.id.tv_login_forget_password);
        btnLogin = getId(R.id.btn_login);
        rlAccount = getId(R.id.rl_login_account);
        rlPassword = getId(R.id.rl_login_password);
        edtAccount.setHintTextColor(0xccffffff);
        edtPassword.setHintTextColor(0xccffffff);
        tvRegister.setTextColor(0xccffffff);
        tvForgetPassword.setTextColor(0xccffffff);
        rlAccount.getBackground().setAlpha(127);//0~255透明度值 
        rlPassword.getBackground().setAlpha(127);//0~255透明度值 
    }

    @Override
    public void setOnclick() {
        tvRegister.setOnClickListener(this);
        tvForgetPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }
    @Override
    public void netError(String msg) {
        ToastUtils.showToastS(getCurrentActivity(),msg);
        hideProgress();
    }

    @Override
    public void showProgress() {
        showDialog("登录中...");
    }

    @Override
    public void hideProgress() {
    disDialog();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_login_back:
                this.finish();
                break;
            case R.id.tv_login_register:
                intentJump(getCurrentActivity(),RegisterActivity.class,null);
                break;
            case R.id.tv_login_forget_password:
                intentJump(getCurrentActivity(),ForgetPasswordActivity.class,null);
                break;
            case R.id.btn_login:
                String account = edtAccount.getText().toString();
                String passWord = edtPassword.getText().toString();
                if(account.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入账号");
                    return;
                }
                if(passWord.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入密码");
                    return;
                }
                showProgress();
                try {
                    presenter.login(account, NslmCryptoUtils.encrypt(passWord));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void doLoginSuccess(LoginModel model) {
        Constant.isLogin = true;
        Constant.ACCOUNT =model.getAccount();
        Constant.sessionId= String.valueOf(model.getId());
        Constant.MOBILE = model.getPhone();
        Constant.GENDER = model.getSex();
        Constant.ICON_URL = model.getPhotoUrl();
        hideProgress();
        LoginBean login= new LoginBean();
        EventBus.getDefault().post(login);
        getCurrentActivity().finish();
    }
}
