package com.fyh.search.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.aramis.AramisUtils;
import com.fyh.base.BaseActivity;
import com.fyh.search.adapter.SearchMainAdapter;
import com.fyh.search.bean.SearchMainBean;
import com.fyh.search.fragment.SearchBaseFragment;
import com.fyh.search.pop.WholeSearchPop;
import com.fyh.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局搜索
 * Created by Aramis on 2017/3/3.
 */

public class WholeSearchActivity extends BaseActivity implements WholeSearchView {
    private RelativeLayout layout_search_tab1, layout_search_tab2, layout_search_tab3, layout_search_tab4;
    private TextView[] searchTabs;
    private WholeSearchPop wholeSearchPop;

    private WholeSearchPresenter presenter;
    private boolean isFragmentAttach;
    private int currentPopPosition = -1;

    private SearchBaseFragment searchBaseFragment;
    private RecyclerView recycler_search;
    private SearchMainAdapter searchMainAdapter;
    private List<SearchMainBean> dataList;

    private String selectSearchStyle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_whole;
    }

    @Override
    public void initView() {
        initControl();
//        layout_search_tab1 = (RelativeLayout) findViewById(R.id.layout_search_tab1);
        layout_search_tab2 = (RelativeLayout) findViewById(R.id.layout_search_tab2);
        layout_search_tab3 = (RelativeLayout) findViewById(R.id.layout_search_tab3);
        layout_search_tab4 = (RelativeLayout) findViewById(R.id.layout_search_tab4);
        searchTabs = new TextView[4];
        searchTabs[0] = (TextView) findViewById(R.id.text_search_tab1);
        searchTabs[1] = (TextView) findViewById(R.id.text_search_tab2);
        searchTabs[2] = (TextView) findViewById(R.id.text_search_tab3);
        searchTabs[3] = (TextView) findViewById(R.id.text_search_tab4);

        recycler_search = (RecyclerView) findViewById(R.id.recycler_search);
        recycler_search.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler_search.setAdapter(searchMainAdapter);


        wholeSearchPop = new WholeSearchPop(this);
        wholeSearchPop.setAdapter();

    }

    private void initControl() {
        presenter = new WholeSearchPresenter(this);
        searchBaseFragment = new SearchBaseFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("presenter", presenter);
        searchBaseFragment.setArguments(bundle);

        dataList = new ArrayList<>();
        dataList.addAll(presenter.getMainTestData());
        searchMainAdapter = new SearchMainAdapter(this, dataList, true);
    }

    @Override
    public void setOnclick() {
        View.OnClickListener tabOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = -1;
                switch (v.getId()) {
                    case R.id.layout_search_tab1:
//                        LogUtil.e(AramisUtils.TAG(), "search tag1 click");
                        position = 0;
                        break;
                    case R.id.layout_search_tab2:
                        position = 1;
                        break;
                    case R.id.layout_search_tab3:
                        position = 2;
                        break;
                    case R.id.layout_search_tab4:
                        position = 3;
                        break;
                }
                if (!isFragmentAttach) {
                    repleaceFragment(position);
                    sendChangePage(position);
                    changeTabView(position, false);
                }
                if (position != currentPopPosition) {
                    sendChangePage(position);
                    changeTabView(position, false);
                }
            }
        };
        layout_search_tab1.setOnClickListener(tabOnclickListener);
        layout_search_tab2.setOnClickListener(tabOnclickListener);
        layout_search_tab3.setOnClickListener(tabOnclickListener);
        layout_search_tab4.setOnClickListener(tabOnclickListener);

    }

    //更换tab
    private void sendChangePage(int position) {
        currentPopPosition = position;
        LogUtil.e(AramisUtils.TAG(), "WholeSearchActivity sendChangePage:" + currentPopPosition);
        searchBaseFragment.setPagerPosition(position);
    }

    private void changeTabView(int position, boolean isClear) {
        for (TextView t : searchTabs) {
            t.setTextColor(ContextCompat.getColor(this, R.color.color_search_tab));
        }
        if (!isClear)
            searchTabs[position].setTextColor(ContextCompat.getColor(this, R.color.color_search_tab_select));
    }

    private void repleaceFragment(int position) {
        isFragmentAttach = true;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.frg_search_enter,
                R.anim.frg_search_exit, R.anim.frg_search_enter,
                R.anim.frg_search_exit);
        searchBaseFragment.getArguments().putInt("openPosition", position);

//        fragmentTransaction.add(R.id.layout_search_container, searchBaseFragment);
        fragmentTransaction.replace(R.id.layout_search_container, searchBaseFragment);
        // 加入到BackStack中
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onScreenComplete() {

    }


    @Override
    public void popDismiss() {
        isFragmentAttach = false;
        getSupportFragmentManager().beginTransaction().remove(searchBaseFragment).commit();
    }

    @Override
    public void onFragmentPageSelected(int position) {
        changeTabView(position, false);
    }

    @Override
    public void onSearchStyleSelected(String itemName) {
        searchTabs[0].setText(itemName);
    }

    @Override
    public void onSearchLocationSelected(String item) {
        searchTabs[1].setText(item);
    }

    @Override
    public void onSearchRentalSelected(String item) {
        searchTabs[2].setText(item);
    }

    @Override
    public void onSearchScreenSelected(String item) {
        searchTabs[3].setText(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        popDismiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isFragmentAttach) {
            isFragmentAttach = false;
            changeTabView(0, true);
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_HOME) {
//            getSupportFragmentManager().beginTransaction().remove(searchBaseFragment).commit();
//        }
//        return super.onKeyDown(keyCode, event);
//    }


}
