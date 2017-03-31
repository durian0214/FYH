package com.fyh.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fyh.R;
import com.fyh.base.BaseFragment;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.search.activity.WholeSearchPresenter;
import com.fyh.search.adapter.SearchRentalAdapter;
import com.fyh.search.bean.SearchRentalBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 搜索租金 fragment
 * Created by Aramis on 2017/3/9.
 */

public class SearchRentalFragment extends BaseFragment {
    private Activity mActivity;
    private WholeSearchPresenter presenter;
    private RecyclerView recycler_search_rental;
    private View view_search_rental_shade;
    private List<SearchRentalBean> dataList;
    private SearchRentalAdapter searchRentalAdapter;
    private Map<Integer, View> rentalViews;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        presenter = (WholeSearchPresenter) getArguments().getSerializable("presenter");
        dataList = new ArrayList<>();
        dataList.add(new SearchRentalBean("不限"));
        dataList.add(new SearchRentalBean("1500以下"));
        dataList.add(new SearchRentalBean("1500-2000元"));
        dataList.add(new SearchRentalBean("2000-2500元"));
        dataList.add(new SearchRentalBean("2500-3000元"));
        dataList.add(new SearchRentalBean("3000元以上"));
        searchRentalAdapter = new SearchRentalAdapter(mActivity, dataList, false);

        rentalViews = new HashMap<>();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recycler_search_rental = (RecyclerView) view.findViewById(R.id.recycler_search_rental);
        recycler_search_rental.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        recycler_search_rental.setAdapter(searchRentalAdapter);
        view_search_rental_shade = view.findViewById(R.id.view_search_rental_shade);
    }

    @Override
    protected void setOnClick() {
        searchRentalAdapter.setOnItemClickListener(new OnItemClickListener<SearchRentalBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, SearchRentalBean data, int position) {
                presenter.onSearchRentalSelected(data.getName());
                Set<Integer> keySet = rentalViews.keySet();
                View convertView = viewHolder.getConvertView();
                if (!keySet.contains(position)) {
                    rentalViews.put(position, convertView);
                }
                for (Integer i : keySet) {
                    rentalViews.get(i).setBackgroundColor(0xffdddddd);
                }
                convertView.setBackgroundColor(0xffffffff);
            }
        });
        view_search_rental_shade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.popDismiss();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_search_rental;
    }
}
