package com.fyh.apartment.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.apartment.model.ApartmentDetailRoomModelList;
import com.fyh.utils.GlideUtil;

import java.util.List;

/**
 * Created by Cbt on 2017/1/3.
 */
public class ApartmentDetailListAdapter extends CommonBaseAdapter<ApartmentDetailRoomModelList.itemRows> {


    public ApartmentDetailListAdapter(Context context, List<ApartmentDetailRoomModelList.itemRows> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }



    @Override
    protected void convert(ViewHolder holder, ApartmentDetailRoomModelList.itemRows data) {
        GlideUtil .getIntance().loaderImg(mContext,holder.getImg(R.id.img_item_apartment_detail_lists_child),data.getPicUrl());
        holder.setText(R.id.tv_item_apartment_detail_lists_child_price,data.getRent()+"");
        holder.setText(R.id.tv_item_apartment_detail_lists_child_address,data.getFullName()+"");
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_apartment_detail_lists_child;
    }




}
