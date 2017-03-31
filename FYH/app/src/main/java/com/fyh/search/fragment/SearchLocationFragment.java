package com.fyh.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fyh.R;
import com.fyh.base.BaseFragment;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.search.activity.WholeSearchPresenter;
import com.fyh.search.adapter.SearchLocationAdapter;
import com.fyh.search.bean.SearchLocationBean;
import com.fyh.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 搜索位置fragment
 * Created by Aramis on 2017/3/3.
 */

public class SearchLocationFragment extends BaseFragment {
    private Activity mActivity;
    private WholeSearchPresenter presenter;
    private RecyclerView recycler_search_location, recycler_search_location2, recycler_search_location3;
    private View layout_search_location_shade;

    private List<SearchLocationBean> dataList, dataList2, dataList3;
    private SearchLocationAdapter searchLocationAdapter, searchLocationAdapter2, searchLocationAdapter3;
    private Map<String, View> coverViewMap;

    private int screenWidth;
    private int status;
    private static final int STATUS_FIRST = 0, STATUS_SECOND = 1, STATUS_THIRD = 2;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        presenter = (WholeSearchPresenter) getArguments().getSerializable("presenter");
        coverViewMap = new HashMap<>();
        screenWidth = ScreenUtils.getScreenWidth(mActivity);

        dataList = new ArrayList<>();
        dataList2 = new ArrayList<>();
        dataList3 = new ArrayList<>();
        dataList.add(new SearchLocationBean("北京"));
        dataList.add(new SearchLocationBean("天津"));
        dataList.add(new SearchLocationBean("上海"));
        dataList.add(new SearchLocationBean("成都"));
        dataList.add(new SearchLocationBean("武汉"));
        dataList.add(new SearchLocationBean("重庆"));
        dataList2.addAll(dataList);
        dataList3.addAll(dataList);
        searchLocationAdapter = new SearchLocationAdapter(mActivity, dataList, false);
        searchLocationAdapter2 = new SearchLocationAdapter(mActivity, dataList2, false);
        searchLocationAdapter3 = new SearchLocationAdapter(mActivity, dataList3, false);
        searchLocationAdapter.setOnItemClickListener(new OnItemClickListener<SearchLocationBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, SearchLocationBean data, int position) {
                onItemClickIml(viewHolder, data, position, STATUS_FIRST);
            }
        });
        searchLocationAdapter2.setOnItemClickListener(new OnItemClickListener<SearchLocationBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, SearchLocationBean data, int position) {
                onItemClickIml(viewHolder, data, position, STATUS_SECOND);
            }
        });
        searchLocationAdapter3.setOnItemClickListener(new OnItemClickListener<SearchLocationBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, SearchLocationBean data, int position) {
                onItemClickIml(viewHolder, data, position, STATUS_THIRD);
            }
        });
    }

    private void onItemClickIml(ViewHolder viewHolder, SearchLocationBean data, int position, int flag) {
        View convertView = viewHolder.getConvertView();
        String tag = flag + "_" + position;
        Set<String> keySet = coverViewMap.keySet();
        if (!keySet.contains(tag)) {
            coverViewMap.put(tag, convertView);
        }

        for (String p : keySet) {
            String[] split = p.split("_");
            if (split[0].equals(String.valueOf(flag))) {
                coverViewMap.get(p).setBackgroundColor(0xffffffff);
            }
        }
        convertView.setBackgroundColor(0xffaaddcc);
//        LogUtil.e(AramisUtils.TAG(), "layoutParams.width:" + layoutParams.width);
        if (status == STATUS_FIRST) {
            status = STATUS_SECOND;
            listDivideScreen(recycler_search_location, 2);
            listDivideScreen(recycler_search_location2, 2);
            recycler_search_location2.setVisibility(View.VISIBLE);
        } else if (status == STATUS_SECOND) {
            status = STATUS_THIRD;
            listDivideScreen(recycler_search_location, 3);
            listDivideScreen(recycler_search_location2, 3);
            listDivideScreen(recycler_search_location3, 3);
            recycler_search_location3.setVisibility(View.VISIBLE);
        } else if (status == STATUS_THIRD) {
//            Toast.makeText(mActivity, data.getName(), Toast.LENGTH_SHORT).show();
            presenter.onSearchLocationSelected(data.getName());
        }
    }

    private void listDivideScreen(View view, int divide) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = screenWidth / divide;
        view.setLayoutParams(layoutParams);
    }

//    private void obj() {
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0.5f);
//        valueAnimator.setDuration(500);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float animatedValue = (Float) animation.getAnimatedValue();
//                ViewGroup.LayoutParams layoutParams = recycler_search_location.getLayoutParams();
//                LogUtil.e(AramisUtils.TAG(), "layoutParams.width:" + layoutParams.width);
//                layoutParams.width = (int) (screenWidth * animatedValue);
//                recycler_search_location.setLayoutParams(layoutParams);
//            }
//        });
//        valueAnimator.start();
//    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        recycler_search_location = (RecyclerView) view.findViewById(R.id.recycler_search_location);
        recycler_search_location.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        recycler_search_location.setAdapter(searchLocationAdapter);
        recycler_search_location2 = (RecyclerView) view.findViewById(R.id.recycler_search_location2);
        recycler_search_location2.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        recycler_search_location2.setAdapter(searchLocationAdapter2);
        recycler_search_location3 = (RecyclerView) view.findViewById(R.id.recycler_search_location3);
        recycler_search_location3.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        recycler_search_location3.setAdapter(searchLocationAdapter3);
        layout_search_location_shade = view.findViewById(R.id.layout_search_location_shade);
    }

    @Override
    protected void setOnClick() {
        layout_search_location_shade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.popDismiss();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_search_location;
    }

}
