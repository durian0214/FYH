package com.fyh.home;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.base.adapterBase.RecycleViewDivider;
import com.fyh.base.adapterBase.SpacesItemDecoration;
import com.fyh.home.adapter.HomeAdapter;
import com.fyh.apartment.model.GetApartmentModel;
import com.fyh.room.model.GetRoomModel;
import com.fyh.base.BaseFragment;
import com.fyh.utils.ToastUtils;
import com.fyh.utils.Utils;

import java.util.List;


/**
 * Created by Cbt on 2016/12/20.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener ,HomeView{
    private RecyclerView rv;
    private HomePresenter presenter;
    private HomeAdapter mAdapter;
    public static HomeFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name",name);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        presenter = new HomePresenter(this);
        rv = (RecyclerView)view.findViewById(R.id.rv_fragment_home);
        rv.addItemDecoration(new RecycleViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, 24, ContextCompat.getColor(getActivity(),R.color.myBackground)
               ));
        rv.setLayoutManager(Utils.getVManager(getActivity()));
        mAdapter = new HomeAdapter(getActivity());
        rv.setAdapter(mAdapter);
        getData();
    }
    private void getData(){
        presenter.getApartment();
        presenter.getRoom();
    }
    @Override
    protected void setOnClick() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
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
    public void getApartmentSuccess(List<GetApartmentModel> lists) {
        ToastUtils.showToastS(getContext(),"获取到公寓数据");
        mAdapter.setItemApartment(lists);
    }

    @Override
    public void getRoomSuccess(List<GetRoomModel> lists) {
        ToastUtils.showToastS(getActivity(),"获取到房源数据");
        mAdapter.setItemRoom(lists);
    }
}
