package com.fyh.my.aboutUs;

import android.view.View;
import android.webkit.WebView;

import com.fyh.R;
import com.fyh.base.BaseActivity;

/**
 * Durian
 * 2017-2017/1/18
 */
public class AboutUsActivity extends BaseActivity implements View.OnClickListener,AboutUsView {
    private WebView wv ;

    @Override
    public void getData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initView() {
    wv  = getId(R.id.wv_about_us   );
    }

    @Override
    public void setOnclick() {

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

    }
}
