package com.fyh.my.reservation;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.utils.Utils;
import com.fyh.releaseHouse.view.ReservationView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cbt on 2016/12/29.
 */
public class ReservationActivity extends BaseActivity implements View.OnClickListener, ReservationView {
    private RecyclerView rv;
    private ReservationPresenter presenter;
    private ReservationAdapter mAdapter;
    private ArrayList<ReservationModel> lists;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reservation;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.RESERVATION);
        presenter =new ReservationPresenter(this);
        rv = getId(R.id.rv_reservation);

        rv.setLayoutManager(Utils.getVManager(getCurrentActivity()));
        lists = new ArrayList<>();
        mAdapter = new ReservationAdapter(getCurrentActivity(),lists);
        rv.setAdapter(mAdapter);
        presenter.getData();
    }

    @Override
    public void setOnclick() {

    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getData(List<ReservationModel> model) {
        lists.addAll(model);
        mAdapter.notifyDataSetChanged();
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
