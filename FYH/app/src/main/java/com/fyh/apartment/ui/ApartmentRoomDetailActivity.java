package com.fyh.apartment.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.fyh.R;
import com.fyh.apartment.adapter.ApartmentRoomDetailAdapter;
import com.fyh.apartment.model.ApartmentRoomDetailModel;
import com.fyh.apartment.model.ApartmentRoomNeighborModel;
import com.fyh.apartment.presenter.ApartmentRoomDetailPresenter;
import com.fyh.apartment.view.ApartmentRoomDetailView;
import com.fyh.base.BaseActivity;
import com.fyh.my.personal.ui.NameAuthenticationActivity;
import com.fyh.submitOrder.pay.ui.ReservationSeeHouseActivity;
import com.fyh.room.presenter.SetCollectionPresenter;
import com.fyh.my.login.LoginActivity;
import com.fyh.utils.Constant;
import com.fyh.utils.ToastUtils;
import com.fyh.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/5.
 */
public class ApartmentRoomDetailActivity extends BaseActivity implements View.OnClickListener, ApartmentRoomDetailView {
    private RecyclerView rv;
    private ApartmentRoomDetailPresenter presenter;
    private SetCollectionPresenter addCPresenter;
    private String roomId;
    private String apartmentId;
    private ApartmentRoomDetailAdapter mAdapter;
    private String roomName;
    private String suiteId;
    private Button btnLookRoom, btnPay;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apartment_room_detail;
    }

    @Override
    public void initView() {
        Bundle bundle = getIntent().getExtras().getBundle("bundle");
        roomId = bundle.getString("roomId");
        apartmentId = bundle.getString("apartmentId");
        imgRight.setBackground(ContextCompat.getDrawable(this, R.drawable.collect));
        roomName = bundle.getString("name");
        suiteId = bundle.getString("suiteId");
        setMyTitle(roomName);
        isShowRight(true);
        presenter = new ApartmentRoomDetailPresenter(this);
//        addCPresenter = new SetCollectionPresenter(this);
        rv = getId(R.id.rv_apartment_room_detail);
        rv.setLayoutManager(Utils.getVManager(getCurrentActivity()));
        mAdapter = new ApartmentRoomDetailAdapter(this);
        rv.setAdapter(mAdapter);
        btnLookRoom = getId(R.id.btn_apartment_room_detail_reservation_look_room);
        btnPay = getId(R.id.btn_apartment_room_detail_pay);
        btnPay.setVisibility(View.GONE);
        showProgress();
        presenter.getRoomData(roomId, apartmentId);
        presenter.getNeighbor(suiteId);
    }

    @Override
    public void setOnclick() {
        btnLookRoom.setOnClickListener(this);
        btnPay.setOnClickListener(this);
        imgRight.setOnClickListener(this);
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
        if (!Constant.isLogin) {
            intentJump(getCurrentActivity(), LoginActivity.class, null);
            return;
        }
        switch (v.getId()) {
            case R.id.btn_apartment_room_detail_reservation_look_room:
                Bundle bundle = new Bundle();
                bundle.putInt("roomId", Integer.parseInt(roomId));
                intentJump(getCurrentActivity(), ReservationSeeHouseActivity.class, bundle);
                break;
            case R.id.btn_apartment_room_detail_pay:

                intentJump(getCurrentActivity(), NameAuthenticationActivity.class, null);

                break;
            case R.id.img_bar_right:
                if (!Constant.isLogin) {
                    intentJump(getCurrentActivity(), LoginActivity.class, null);
                    return;
                }
                addCPresenter.setCollection(Integer.parseInt(roomId));
                break;
        }
    }

    @Override
    public void getData(ApartmentRoomDetailModel model) {
        hideProgress();
        mAdapter.setRoomDetail(model);
    }

    @Override
    public void getNeighborData(List<ApartmentRoomNeighborModel> lists) {
        hideProgress();
        mAdapter.setNeighbor(lists);
    }


}
