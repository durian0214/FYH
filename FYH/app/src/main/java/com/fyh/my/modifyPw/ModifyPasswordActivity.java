package com.fyh.my.modifyPw;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.fyh.R;
import com.fyh.my.login.LoginActivity;
import com.fyh.base.BaseActivity;
import com.fyh.utils.Constant;
import com.fyh.utils.ToastUtils;

/**
 * Created by Administrator on 2017/1/16 0016.
 * 修改密码
 */
public class ModifyPasswordActivity extends BaseActivity implements View.OnClickListener,ModifyPasswordView{
    private EditText edtOldPassword, edtNewPassword,edtReNewPassword;
    private Button btnModifyPassword;
    private ModifyPasswordPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password;
    }

    @Override
    public void initView() {
        setMyTitle("修改密码");
        edtOldPassword = getId(R.id.edt_old_password);
        edtNewPassword = getId(R.id.edt_new_password);
        edtReNewPassword = getId(R.id.edt_re_new_password);
        btnModifyPassword = getId(R.id.btn_modify_password);

    }

    @Override
    public void setOnclick() {
        btnModifyPassword.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_modify_password:
               String oldPassword = edtOldPassword.getText().toString();
               String newPassword = edtNewPassword.getText().toString();
               String reNewPassword = edtReNewPassword.getText().toString();
               String id = Constant.sessionId;

               if(id.isEmpty()){
                   ToastUtils.showToastS(getCurrentActivity(),"请登录");
                   intentJump(getCurrentActivity(),LoginActivity.class,null);
                   return;
               }
               if(oldPassword.isEmpty()){
                   ToastUtils.showToastS(getCurrentActivity(),"请输入密码");
                   return;
               }
               if(newPassword.isEmpty()){
                   ToastUtils.showToastS(getCurrentActivity(),"请输入新密码");
                   return;
               }
               if(!newPassword.equals(reNewPassword)){
                   ToastUtils.showToastS(getCurrentActivity(),"请确认密码");
                   return;
               }
               if(newPassword.equals(oldPassword)){
                   ToastUtils.showToastS(getCurrentActivity(),"修改的密码不能和当前密码相同");
                   return;
               }
                    presenter = new ModifyPasswordPresenter(this);
               try {

                     presenter.modifyPassword(oldPassword,newPassword,id);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               break;

       }
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
    public void doModifySuccess() {
        ToastUtils.showToastS(this,"修改成功");
        getCurrentActivity().finish();
    }

    @Override
    public void doModifyFailed(String msg) {
        ToastUtils.showToastS(this,msg);
    }
}
