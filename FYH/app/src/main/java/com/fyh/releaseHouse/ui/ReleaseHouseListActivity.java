package com.fyh.releaseHouse.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.releaseHouse.adapter.ReleaseHouseListAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnLoadMoreListener;
import com.fyh.listen.OnMultiItemClickListeners;
import com.fyh.releaseHouse.model.ReleaseHouseListModel;
import com.fyh.releaseHouse.presenter.ReleaseHouseListPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.utils.Utils;
import com.fyh.releaseHouse.view.ReleaseHouseListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Durian
 * 2017-2017/1/22
 * 发布房源列表
 */
public class ReleaseHouseListActivity extends BaseActivity implements View.OnClickListener,ReleaseHouseListView {
    private RecyclerView rv;
    private ReleaseHouseListAdapter mAdapter;
    private ReleaseHouseListPresenter releaseHouseListPresenter;
    private List<ReleaseHouseListModel> lists;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_release_house_list;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.RELEASE_HOUSE_LIST_TITLE);
        releaseHouseListPresenter = new ReleaseHouseListPresenter(this);
        rv = getId(R.id.rv_release_house_list);
        rv.setLayoutManager(Utils.getVManager(this));
        lists = new ArrayList<>();
        lists.add(new ReleaseHouseListModel());
        mAdapter = new ReleaseHouseListAdapter(this,lists,true);

        //设置加载更多触发的事件监听
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
            }
        });
        mAdapter.setOnMultiItemClickListener(new OnMultiItemClickListeners<ReleaseHouseListModel>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, ReleaseHouseListModel data, int position, int viewType) {

            }
        });
        rv.setAdapter(mAdapter);
        releaseHouseListPresenter.getData();
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
    public void getData(List<ReleaseHouseListModel> list) {
        mAdapter.setData(list);
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
