package com.fyh.search.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.BaseFragment;
import com.fyh.search.activity.WholeSearchPresenter;

/**
 * search 租住类型fragment
 * Created by Aramis on 2017/3/3.
 */

public class SearchStyleFragment extends BaseFragment {
    private Activity activity;
    private WholeSearchPresenter presenter;

    private AppCompatTextView text_search_style_long, text_search_style_short, text_search_style_whole,
            text_search_style_together;
    private TextView[] searchStyleItems;
    private AppCompatButton btn_searchstyle_reset;
    private View layout_search_style_shade;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = (WholeSearchPresenter) getArguments().getSerializable("presenter");

        searchStyleItems = new TextView[4];
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        activity = getActivity();
        text_search_style_long = (AppCompatTextView) view.findViewById(R.id.text_search_style_long);
        text_search_style_short = (AppCompatTextView) view.findViewById(R.id.text_search_style_short);
        text_search_style_whole = (AppCompatTextView) view.findViewById(R.id.text_search_style_whole);
        text_search_style_together = (AppCompatTextView) view.findViewById(R.id.text_search_style_together);
        searchStyleItems[0] = text_search_style_long;
        searchStyleItems[1] = text_search_style_short;
        searchStyleItems[2] = text_search_style_whole;
        searchStyleItems[3] = text_search_style_together;
        btn_searchstyle_reset = (AppCompatButton) view.findViewById(R.id.btn_searchstyle_reset);
        layout_search_style_shade = view.findViewById(R.id.layout_search_style_shade);
    }

    @Override
    protected void setOnClick() {
        View.OnClickListener onItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (TextView t : searchStyleItems) {
                    t.setBackgroundResource(R.drawable.bg_search_item_normal);
                }
                AppCompatTextView tv = (AppCompatTextView) v;
                tv.setBackgroundResource(R.drawable.bg_search_item_select);
                presenter.onSearchStyleItemSelected(tv.getText().toString());
            }
        };
        text_search_style_long.setOnClickListener(onItemClickListener);
        text_search_style_short.setOnClickListener(onItemClickListener);
        text_search_style_whole.setOnClickListener(onItemClickListener);
        text_search_style_together.setOnClickListener(onItemClickListener);
        btn_searchstyle_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.popDismiss();
            }
        });

        layout_search_style_shade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.popDismiss();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_search_style;
    }
}
