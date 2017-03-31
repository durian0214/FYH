package com.fyh.room.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.room.model.RoomListModel;
import com.fyh.utils.GlideUtil;

import java.util.List;

/**
 * Created by a on 2017/1/9.
 */
public class RoomListAdapter extends CommonBaseAdapter<RoomListModel.RowsBean> {
    public RoomListAdapter(Context context, List<RoomListModel.RowsBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, RoomListModel.RowsBean data) {
        GlideUtil.getIntance().loaderImg(mContext,holder.getImg(R.id.img_item_room_list),data.getPicUrl());
        holder.setText(R.id.tv_item_room_list_price,data.getFullName()+"");
        holder.setText(R.id.tv_item_room_list_address,data.getAddress()+"");
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_room_list;
    }
}
