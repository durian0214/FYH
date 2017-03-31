package com.fyh.search.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.search.bean.SearchLocationBean;

import java.util.List;

/**
 * 搜索位置adapter
 * Created by Aramis on 2017/3/10.
 */

public class SearchLocationAdapter extends CommonBaseAdapter<SearchLocationBean> {
    public SearchLocationAdapter(Context context, List<SearchLocationBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, SearchLocationBean data) {
        holder.setText(R.id.text_searchlo_item, data.getName());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.list_search_location;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<SearchLocationBean> itemClickListener) {
        super.setOnItemClickListener(itemClickListener);

    }
}