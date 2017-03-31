package com.fyh.submitOrder.pay.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fyh.R;
import com.fyh.home.seeHouse.ReservationSeeHousePresenter;
import com.fyh.base.BaseActivity;
import com.fyh.utils.ToastUtils;
import com.fyh.room.view.ReservationSeeHouseView;

/**
 * Created by a on 2017/1/12.
 */
public class ReservationSeeHouseActivity extends BaseActivity implements View.OnClickListener,ReservationSeeHouseView {
    private int roomId ;
    private EditText edtName ,edtPhone,edtRemark;
    private Button btnSubmit;
    private ReservationSeeHousePresenter presenter ;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reservation_see_house;
    }

      public void initView() {
          setMyTitle(R.string.RESERVATION_LOOK_ROOM);
          presenter =new ReservationSeeHousePresenter(this);
        roomId = getIntent().getBundleExtra("bundle").getInt("roomId");
        edtName  = getId(R.id.edt_reservation_see_house_name);
        edtPhone = getId(R.id.edt_reservation_see_house_phone);
        edtRemark = getId(R.id.edt_reservation_see_house_remark);
        btnSubmit = getId(R.id.btn_reservation_see_house_submit);
    }

    @Override
    public void setOnclick() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_reservation_see_house_submit:

                if(edtName.getText().toString().isEmpty()){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入姓名");
                    return;
                }
                if(edtPhone.getText().toString().length()!=11){
                    ToastUtils.showToastS(getCurrentActivity(),"请输入手机号");
                    return;
                }

                presenter.submitData(edtName.getText().toString(),edtPhone.getText().toString(),edtRemark.getText().toString(),roomId);
                break;
        }
    }

    @Override
    public void submitData() {
        this.finish();
    }

    @Override
    public void netError(String msg) {
        ToastUtils.showToastS(getCurrentActivity(),msg);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
