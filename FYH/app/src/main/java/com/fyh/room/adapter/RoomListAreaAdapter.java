package com.fyh.room.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.home.AreaModel;

import java.util.List;

/**
 * Created by a on 2017/1/10.
 */
public class RoomListAreaAdapter   extends CommonBaseAdapter<AreaModel> {


    public RoomListAreaAdapter(Context context, List<AreaModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder,AreaModel data) {
        holder.setText(R.id.tv_item_pop,data.getName());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_pop;
    }


}