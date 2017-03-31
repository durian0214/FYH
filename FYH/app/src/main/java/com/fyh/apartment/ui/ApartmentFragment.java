package com.fyh.apartment.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.apartment.adapter.ApartmentListAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.listen.OnLoadMoreListener;
import com.fyh.apartment.model.ApartmentListModel;
import com.fyh.apartment.presenter.ApartmentListPresenter;
import com.fyh.base.BaseFragment;
import com.fyh.utils.Utils;
import com.fyh.apartment.view.ApartmentListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cbt on 2016/12/21.
 */
public class ApartmentFragment extends BaseFragment implements View.OnClickListener, ApartmentListView {
    private RecyclerView rv;
    private ApartmentListPresenter presenter;
    private  int page = 1;
    private static int pageNum = 10;
    private ApartmentListAdapter mAdapter;
    private List<ApartmentListModel> lists;
    public static ApartmentFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        ApartmentFragment fragment = new ApartmentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        presenter = new ApartmentListPresenter(this);
        rv = (RecyclerView) view.findViewById(R.id.rv_fragment_second);
        rv.setLayoutManager(Utils.getVManager(getActivity()));
        lists = new ArrayList<>();
        mAdapter = new ApartmentListAdapter(getActivity(), lists, true);
        //设置数据加载失败，无数据view
        mAdapter.setEmptyView(Utils.inflate(getActivity(), R.layout.item_baseadapter_nodata));
        //初始化 开始加载更多的loading View
        mAdapter.setLoadingView(R.layout.test_load_loading_layout);
        //设置加载更多触发的事件监听
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {

                getData();
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener<ApartmentListModel>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, ApartmentListModel data, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("id",String.valueOf( lists.get(position).getId()));
                intentJump(getActivity(), ApartmentDetailActivity.class,bundle);
            }
        });
        rv.setAdapter(mAdapter);
        getData();

    }
    private  void getData(){
        presenter.getApartmentListData(page, pageNum);
    }
    @Override
    protected void setOnClick() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_apartment;
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

    @Override
    public void getDataSuccess(List<ApartmentListModel> list) {
        if (list.size() < pageNum) {
            mAdapter.setLoadEndView(R.layout.test_load_end_layout);
        }
        if(page ==1){
            mAdapter.setNewData(list);
        }else{
            mAdapter.setData(list);
        }
        page++;
    }
}
