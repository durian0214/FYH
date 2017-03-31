package com.fyh.home.join;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.utils.ToastUtils;

/**
 * Created by Natokalol on 2017/1/16.
 */
public class JoinActivity extends BaseActivity implements View.OnClickListener, JoinView {

    private TextView tvCommunityName,tvJoinName,tvJoinCellphone;
    private EditText edtCommunityName,edtJoinName,edtJoinCellphone,edtJoinCode;
    private Button btnJoinGetcode, btnSubmit;
    private JoinPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_join;
    }

    @Override
    public void initView() {
        setMyTitle("房东加盟");
        presenter = new JoinPresenter(this);
        //tvCommunityName = getId(R.id.tv_community_name);
        //tvJoinName = getId(R.id.tv_join_name);
        //tvJoinCellphone = getId(R.id.tv_join_cellphone);
        edtCommunityName = getId(R.id.edt_community_name);
        edtJoinName = getId(R.id.edt_join_name);
        edtJoinCellphone = getId(R.id.edt_join_cellphone);
        edtJoinCode = getId(R.id.edt_join_code);
        btnJoinGetcode = getId(R.id.btn_join_getcode);
        btnSubmit = getId(R.id.btn_submit);
    }

    @Override
    public void setOnclick() {
        btnSubmit.setOnClickListener(this);
        btnJoinGetcode.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void doJoinSuccess() {
        hideProgress();
        getCurrentActivity().finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_join_getcode:
                String cellPhone = edtJoinCellphone.getText().toString();
                if(cellPhone.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入手机号码");
                    return;
                }
                ToastUtils.showToastS(getCurrentActivity(),cellPhone);
                presenter.getCode(cellPhone);
                break;
            case R.id.btn_submit:
                String community = edtCommunityName.getText().toString();
                String name = edtJoinName.getText().toString();
                String cellPhone02 = edtJoinCellphone.getText().toString();
                String code = edtJoinCode.getText().toString();

                if(community.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入小区名称");
                    return;
                }
                if(name.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入姓名");
                    return;
                }
                if(cellPhone02.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入手机号码");
                    return;
                }
                if(code.isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入验证码");
                    return;
                }
                showProgress();
                try {
                    presenter.join(community, name,cellPhone02,code);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void netError(String msg) {
        ToastUtils.showToastS(getCurrentActivity(),msg);
        hideProgress();
    }

    @Override
    public void showProgress() {
        showDialog("...");
    }

    @Override
    public void hideProgress() {
        disDialog();
    }
}
