package com.fyh.room.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.fyh.R;
import com.fyh.room.adapter.RoomDetailAdapter;
import com.fyh.room.model.RoomDetailModel;
import com.fyh.room.model.RoomNeighborModel;
import com.fyh.room.presenter.RoomDetailPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.my.personal.ui.NameAuthenticationActivity;
import com.fyh.submitOrder.pay.ui.ReservationSeeHouseActivity;
import com.fyh.my.login.LoginActivity;
import com.fyh.utils.Constant;
import com.fyh.utils.ToastUtils;
import com.fyh.utils.Utils;
import com.fyh.room.view.RoomDetailView;

import java.util.ArrayList;

/**
 * Created by a on 2017/1/10.
 */
public class RoomDetailActivity extends BaseActivity implements RoomDetailView,View.OnClickListener {
    private RecyclerView rv;
    private Button btnLookRoom,btnPay;
    private RoomDetailAdapter mAdapter ;
    private int roomId ;
    private RoomDetailPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_room_detail;
    }

    @Override
    public void initView() {
        roomId = getIntent().getBundleExtra("bundle").getInt("roomId");
        setMyTitle(getIntent().getBundleExtra("bundle").getString("name"));
        presenter = new RoomDetailPresenter(this);
        rv = getId(R.id.rv_room_detail);
        rv.setLayoutManager(Utils.getVManager(this));
        mAdapter = new RoomDetailAdapter(this);
        rv.setAdapter(mAdapter);
        imgRight.setBackground(ContextCompat.getDrawable(this,R.drawable.collect));
        btnLookRoom= getId(R.id.btn_room_detail_reservation_look_room);
        btnPay = getId(R.id.btn_room_detail_pay);
        btnPay.setVisibility(View.GONE);
        presenter.getRoomData(roomId);
        presenter.getNeighbor(roomId);
    }

    @Override
    public void setOnclick() {
        btnLookRoom.setOnClickListener(this);
        btnPay.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
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

    @Override
    public void onClick(View v) {
        if(!Constant.isLogin){
            intentJump(getCurrentActivity(),LoginActivity.class,null);
            return;
        }
        switch (v.getId()){
            case R.id.btn_room_detail_reservation_look_room:
                Bundle bundle = new Bundle();
                bundle.putInt("roomId",roomId);
                intentJump(getCurrentActivity(),ReservationSeeHouseActivity.class,bundle);
                break;
            case R.id.btn_room_detail_pay:
                intentJump(getCurrentActivity(),NameAuthenticationActivity.class,null);
                break;
        }
    }

    @Override
    public void getData(RoomDetailModel model) {
        hideProgress();
        mAdapter.setRoomDetail(model);
    }

    @Override
    public void getNeighborData(ArrayList<RoomNeighborModel.RoomMateBean> lists) {
        hideProgress();
        if(lists!=null){
            mAdapter.setNeighbor(lists);
        }
    }
}
