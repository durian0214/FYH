package com.fyh.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.fyh.R;
import com.fyh.base.BaseFragment;
import com.fyh.base.adapterBase.ViewPagerFragmentAdapter;
import com.fyh.search.activity.WholeSearchPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * search 弹窗
 * Created by Aramis on 2017/3/8.
 */

public class SearchBaseFragment extends BaseFragment {
    private Activity mActivity;
    private RelativeLayout layout_search_pop;
    private ViewPager viewpager_search_base;
    private List<Fragment> fragmentList;
    private WholeSearchPresenter presenter;
    private int openPosition;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        fragmentList = new ArrayList<>();
        presenter = (WholeSearchPresenter) getArguments().getSerializable("presenter");
        initFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        openPosition = getArguments().getInt("openPosition");
        setPagerPosition(openPosition);
    }

    private void initFragment() {
        SearchStyleFragment searchStyleFragment = new SearchStyleFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("presenter", presenter);
        searchStyleFragment.setArguments(bundle);

        SearchLocationFragment searchLocationFragment = new SearchLocationFragment();
        searchLocationFragment.setArguments(bundle);

        SearchRentalFragment searchRentalFragment = new SearchRentalFragment();
        searchRentalFragment.setArguments(bundle);

        SearchScreenFragment searchScreenFragment = new SearchScreenFragment();
        searchScreenFragment.setArguments(bundle);

        fragmentList.add(searchStyleFragment);
        fragmentList.add(searchLocationFragment);
        fragmentList.add(searchRentalFragment);
        fragmentList.add(searchScreenFragment);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        layout_search_pop = (RelativeLayout) view.findViewById(R.id.layout_search_pop);
        viewpager_search_base = (ViewPager) view.findViewById(R.id.viewpager_search_base);
        viewpager_search_base.setOffscreenPageLimit(4);
        viewpager_search_base.setAdapter(new ViewPagerFragmentAdapter(getChildFragmentManager(), fragmentList));
    }

    @Override
    protected void setOnClick() {
        viewpager_search_base.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                presenter.onFragmentPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        layout_search_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.popDismiss();
            }
        });
    }

    public void setPagerPosition(int position) {
        if (viewpager_search_base != null && position >= 0) {
            viewpager_search_base.setCurrentItem(position);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_search_base;
    }
}
