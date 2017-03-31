package com.fyh.room.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.releaseHouse.model.DicModel;

import java.util.List;

/**
 * Created by a on 2017/1/10.
 */
public class RoomListHouseTypeAdapter extends CommonBaseAdapter<DicModel> {


    public RoomListHouseTypeAdapter(Context context, List<DicModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, DicModel data) {
        holder.setText(R.id.tv_item_pop,data.getName());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_pop;
    }


}
