package com.fyh.apartment.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.apartment.adapter.ApartmentDetailAdapter;
import com.fyh.apartment.model.ApartmentDetailModel;
import com.fyh.apartment.model.ApartmentDetailRoomModelList;
import com.fyh.apartment.presenter.ApartmentDetailPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.utils.ToastUtils;
import com.fyh.utils.Utils;
import com.fyh.apartment.view.ApartmentDetailView;

import java.util.List;

/**
 * Created by Cbt on 2017/1/3.
 */
public class ApartmentDetailActivity extends BaseActivity implements View.OnClickListener, ApartmentDetailView {
    private RecyclerView rv;
    private ApartmentDetailAdapter mAdapter;
    private ApartmentDetailPresenter presenter;
    private String id;
    private int page = 1;
    private int pageNum = 10;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_apartment_detail;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void initView() {
        setMyTitle(R.string.APARTMENT_DETAIL);
        id = getIntent().getBundleExtra("bundle").getString("id");
        presenter = new ApartmentDetailPresenter(this);
        rv = getId(R.id.rv_apartment_detail);
        LinearLayoutManager llm = Utils.getVManager(getCurrentActivity());
        rv.setLayoutManager(llm);

        mAdapter = new ApartmentDetailAdapter(getCurrentActivity());
        rv.setAdapter(mAdapter);
        showProgress();
        presenter.getDetail(id);
        presenter.getRoomLists(id, page, pageNum);
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
        hideProgress();
        ToastUtils.showToastS(getCurrentActivity(), msg);
    }

    @Override
    public void showProgress() {
        showDialog("加载中");
    }

    @Override
    public void hideProgress() {
        disDialog();
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void loadDetail(ApartmentDetailModel model) {
        hideProgress();
        mAdapter.setDetail(model);
    }


    @Override
    public void loadLists(List<ApartmentDetailRoomModelList.itemRows> lists) {
        hideProgress();
        if (lists.size() < pageNum) {
            mAdapter.endList();
        } else {
            page++;
        }
        mAdapter.addLists(lists);
    }
}
