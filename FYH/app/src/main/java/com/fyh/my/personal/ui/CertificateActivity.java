package com.fyh.my.personal.ui;


import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.my.personal.model.CertificateModel;
import com.fyh.my.personal.presenter.CertificatePresenter;
import com.fyh.my.personal.view.CertificateView;


/**
 * Created by Administrator on 2017/1/16 0016.
 * 认证
 */
public class CertificateActivity extends BaseActivity implements CertificateView {

    private CertificatePresenter presenter;
    private TextView tv1,tv2;
    @Override

    protected int getLayoutId() {
        return R.layout.activity_center_certificate;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.AUTHENTICATION);
        tv1 =getId(R.id.reality_name);
        tv2 =getId(R.id.certificates_num);
        presenter = new CertificatePresenter(this);
        presenter.getData();
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return null;
    }

    @Override
    public void getData(CertificateModel model) {
        tv1.setText(model.getRealityName());
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
}
