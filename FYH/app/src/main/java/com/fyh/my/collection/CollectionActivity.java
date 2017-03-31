package com.fyh.my.collection;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.listen.OnLoadMoreListener;
import com.fyh.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16 0016.
 * 我的收藏
 */
public class CollectionActivity extends BaseActivity implements View.OnClickListener, CollectionView {

    private RecyclerView rv;
    private CollectionPresenter presenter;
    private CollectionAdapter mAdapter;
    private ArrayList<CollectionModel> lists;
    private Integer pageNo = 1;
    private Integer pageSize = 8;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.MY_COLLECT);
        presenter =new CollectionPresenter(this);
        rv = getId(R.id.rv_collection);
        rv.setLayoutManager(Utils.getVManager(getCurrentActivity()));
        lists = new ArrayList<>();
        mAdapter = new CollectionAdapter(getCurrentActivity(),lists,true);
        rv.setAdapter(mAdapter);
        //初始化 开始加载更多的loading View
        mAdapter.setLoadingView(R.layout.test_load_loading_layout);
        //设置加载更多触发的事件监听
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener<CollectionModel>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, CollectionModel data, int position) {

            }
        });

        presenter.getData(pageNo,pageSize);
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
    public void netError(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void getData(List<CollectionModel> lists) {
            mAdapter.setData(lists);
    }
}
