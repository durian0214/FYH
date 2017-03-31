package com.fyh.my.collection;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.utils.GlideUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public class CollectionAdapter extends CommonBaseAdapter<CollectionModel> {

    public CollectionAdapter(Context context, List<CollectionModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }
    @Override
    protected void convert(ViewHolder holder, CollectionModel data) {
        GlideUtil.getIntance().loaderImg(mContext,holder.getImg(R.id.img_item_set_collection),data.getPicUrl());
        holder.setText(R.id.tv_item_set_collection_price,data.getRent());
        holder.setText(R.id.tv_item_set_collection_address,data.getAddress());
    }
    @Override
    protected int getItemLayoutId() {
        return R.layout.item_set_collection;
    }
}

