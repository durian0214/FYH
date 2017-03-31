package com.fyh.submitOrder.pay.ui;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.submitOrder.pay.adapter.TenancyTermAdapter;
import com.fyh.submitOrder.pay.model.RentInfoModel;
import com.fyh.my.contract.ContractActivity;
import com.fyh.submitOrder.pay.presenter.RentInfoPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.utils.Utils;
import com.fyh.submitOrder.pay.view.RentInfoView;

/**
 * Durian
 * 2017-2017/1/13
 * 租期信息
 */
public class RentInfoActivity extends BaseActivity implements View.OnClickListener ,RentInfoView{
    private TextView tvStartTime,tvEndTime;
    private AppCompatSpinner sp;
    private RecyclerView rv;
    private Button btnNext;
    private RentInfoPresenter presenter;
    private TenancyTermAdapter mAdapter;
    private int roomId;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_rent_info;
    }

    @Override
    public void initView() {
        presenter = new RentInfoPresenter(this);
        roomId = getIntent().getBundleExtra("bundle").getInt("roomId");
        tvStartTime = getId(R.id.tv_rent_info_start_time);
        tvEndTime = getId(R.id.tv_rent_info_end_time);
        sp= getId(R.id.sp_rent_info_tenancy_term);
        rv= getId(  R.id.rv_rent_info);rv.setLayoutManager(Utils.getVManager(this));
        mAdapter = new TenancyTermAdapter(this);
        rv.setAdapter(mAdapter);
        btnNext = getId(R.id.btn_rent_info_next);
        presenter.getRentInfoData(roomId);
    }
    @Override
    public void setOnclick() {
        btnNext.setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.btn_rent_info_next:
                intentJump(getCurrentActivity(),ContractActivity.class,null);
                break;
        }
    }

    @Override
    public void getRentInfo(RentInfoModel model) {

    }
}
