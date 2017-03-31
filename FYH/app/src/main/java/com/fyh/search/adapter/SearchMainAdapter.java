package com.fyh.search.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.search.bean.SearchMainBean;

import java.util.List;

/**
 * 搜索位置adapter
 * Created by Aramis on 2017/3/10.
 */

public class SearchMainAdapter extends CommonBaseAdapter<SearchMainBean> {
    public SearchMainAdapter(Context context, List<SearchMainBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, SearchMainBean data) {
        holder.setText(R.id.text_search_name, data.getName());
        holder.setText(R.id.text_search_area, data.getArea());
        holder.setText(R.id.text_search_price, data.getPrice());
        ImageView img = holder.getImg(R.id.img_search_main);
        img.setBackgroundColor(Color.rgb(125, 203, 77));
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.list_search_main;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<SearchMainBean> itemClickListener) {
        super.setOnItemClickListener(itemClickListener);

    }
}