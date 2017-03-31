package com.fyh.apartment.adapter;


import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.apartment.model.ApartmentListModel;
import com.fyh.utils.GlideUtil;

import java.util.List;

/**
 * Created by a on 2017/1/6.
 */
public class ApartmentListAdapter extends CommonBaseAdapter<ApartmentListModel> {

    public ApartmentListAdapter(Context context, List<ApartmentListModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }
    @Override
    protected void convert(ViewHolder holder, ApartmentListModel data) {
        GlideUtil.getIntance().loaderImg(mContext,holder.getImg(R.id.img_item_apartment),data.getPicUrl());
        holder.setText(R.id.tv_item_apartment_price,data.getApartmentName());
        holder.setText(R.id.tv_item_apartment_address,data.getAddress());

    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_apartment;
    }
}
