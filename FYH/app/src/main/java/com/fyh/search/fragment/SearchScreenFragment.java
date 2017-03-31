package com.fyh.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import com.fyh.R;
import com.fyh.base.BaseFragment;
import com.fyh.search.activity.WholeSearchPresenter;
import com.fyh.utils.DensityUtils;
import com.fyh.utils.ScreenUtils;

/**
 * 搜索筛选 fragment
 * Created by Aramis on 2017/3/9.
 */

public class SearchScreenFragment extends BaseFragment {
    private Activity mActivity;
    private WholeSearchPresenter presenter;

    private View space_search_contract, space_search_status1, space_search_status2;
    private AppCompatTextView[] towardsViews, featureViews, aroundViews, contractViews, statusViews;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        presenter = (WholeSearchPresenter) getArguments().getSerializable("presenter");
        towardsViews = new AppCompatTextView[5];
        featureViews = new AppCompatTextView[8];
        aroundViews = new AppCompatTextView[4];
        contractViews = new AppCompatTextView[2];
        statusViews = new AppCompatTextView[3];
    }

    private void initSpace() {
        int space = (int) ((ScreenUtils.getScreenWidth(mActivity) - DensityUtils.dp2px(mActivity, 20) * 2
                - (getResources().getDimension(R.dimen.width_search_item_normal) * 4)) / 3);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(space, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.width = space;
        space_search_contract.setLayoutParams(layoutParams);
        space_search_status1.setLayoutParams(layoutParams);
        space_search_status2.setLayoutParams(layoutParams);
    }

    @Override
    protected void setOnClick() {
        View.OnClickListener onItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatTextView t = (AppCompatTextView) v;
                AppCompatTextView[] views = null;
                int tag = (int) t.getTag();
                switch (tag) {
                    case 0:
                        views = towardsViews;
                        break;
                    case 1:
                        views = featureViews;
                        break;
                    case 2:
                        views = aroundViews;
                        break;
                    case 3:
                        views = contractViews;
                        break;
                    case 4:
                        views = statusViews;
                        break;
                }
                changeItem(views, t);
            }
        };

        for (AppCompatTextView t : towardsViews) {
            t.setTag(0);
            t.setOnClickListener(onItemClickListener);
        }
        for (AppCompatTextView t : featureViews) {
            t.setTag(1);
            t.setOnClickListener(onItemClickListener);
        }
        for (AppCompatTextView t : aroundViews) {
            t.setTag(2);
            t.setOnClickListener(onItemClickListener);
        }
        for (AppCompatTextView t : contractViews) {
            t.setTag(3);
            t.setOnClickListener(onItemClickListener);
        }
        for (AppCompatTextView t : statusViews) {
            t.setTag(4);
            t.setOnClickListener(onItemClickListener);
        }
    }

    private void changeItem(AppCompatTextView[] views, AppCompatTextView clickView) {
        if (views != null && clickView != null) {
            for (AppCompatTextView t : views) {
                t.setBackgroundResource(R.drawable.bg_search_item_normal);
            }
            clickView.setBackgroundResource(R.drawable.bg_search_item_select);
        }
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        space_search_contract = view.findViewById(R.id.space_search_contract);
        space_search_status1 = view.findViewById(R.id.space_search_status1);
        space_search_status2 = view.findViewById(R.id.space_search_status2);
        initSpace();

        towardsViews[0] = (AppCompatTextView) view.findViewById(R.id.text_search_towards_south);
        towardsViews[1] = (AppCompatTextView) view.findViewById(R.id.text_search_towards_north);
        towardsViews[2] = (AppCompatTextView) view.findViewById(R.id.text_search_towards_east);
        towardsViews[3] = (AppCompatTextView) view.findViewById(R.id.text_search_towards_west);
        towardsViews[4] = (AppCompatTextView) view.findViewById(R.id.text_search_towards_southnorth);
        featureViews[0] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_first);
        featureViews[1] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_wc);
        featureViews[2] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_balcony);
        featureViews[3] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_heattoget);
        featureViews[4] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_heatonly);
        featureViews[5] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_heatcenter);
        featureViews[6] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_autolock);
        featureViews[7] = (AppCompatTextView) view.findViewById(R.id.text_search_feature_elevator);
        aroundViews[0] = (AppCompatTextView) view.findViewById(R.id.text_search_around_subway);
        aroundViews[1] = (AppCompatTextView) view.findViewById(R.id.text_search_around_new);
        aroundViews[2] = (AppCompatTextView) view.findViewById(R.id.text_search_around_school);
        aroundViews[3] = (AppCompatTextView) view.findViewById(R.id.text_search_around_green);
        contractViews[0] = (AppCompatTextView) view.findViewById(R.id.text_search_contract_year);
        contractViews[1] = (AppCompatTextView) view.findViewById(R.id.text_search_contract_mouth);
        statusViews[0] = (AppCompatTextView) view.findViewById(R.id.text_search_status_immediately);
        statusViews[1] = (AppCompatTextView) view.findViewById(R.id.text_search_status_book);
        statusViews[2] = (AppCompatTextView) view.findViewById(R.id.text_search_status_switch);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_search_screen;
    }
}
