package com.fyh.my.contract;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.listen.onRecyclerViewItemClickListener;
import com.fyh.base.BaseActivity;
import com.fyh.utils.ToastUtils;
import com.fyh.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Locker on 2017/1/16.
 */
public class MyContractActivity  extends BaseActivity implements View.OnClickListener,ContractListView {

        private RecyclerView rv;
        private ContractListAdapter adapter;
        private ContractListPresenter presenter;
        private String id;
        private ArrayList<ContractModel> lists;
        @Override
        protected int getLayoutId() {
            return R.layout.activity_contract_list;
        }

        @Override
        public void initView() {
            presenter = new ContractListPresenter(this);
            setMyTitle("合同列表");
            rv = getId(R.id.rv_contract_list);
            rv.setLayoutManager(Utils.getVManager(getCurrentActivity()));
            lists = new ArrayList<>();
            adapter = new ContractListAdapter(this,lists);
            rv.setAdapter(adapter);
            presenter.getContractListData();
            adapter.setContractOnClickListener(new onRecyclerViewItemClickListener(){

                @Override
                public void onItemClick(View v, int position) {

//                    Bundle bundle = new Bundle();
//                    bundle.putInt("contractId", lists.get(position).getId());
//                  intentJump(getCurrentActivity(),xxx.class,bundle);
                }
            });
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
            ToastUtils.showToastS(getCurrentActivity(),msg);
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
    public void getData(List<ContractModel> list) {
        hideProgress();
        lists.addAll(list);
        adapter.notifyDataSetChanged();
    }
}

