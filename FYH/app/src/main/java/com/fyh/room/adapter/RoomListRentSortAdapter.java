package com.fyh.room.adapter;

import android.content.Context;

import com.fyh.R;
import com.fyh.base.adapterBase.CommonBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;

import java.util.List;

/**
 * Created by a on 2017/1/10.
 */
public class RoomListRentSortAdapter  extends CommonBaseAdapter<String> {


    public RoomListRentSortAdapter(Context context, List<String> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, String data) {
        holder.setText(R.id.tv_item_pop,data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_pop;
    }


}
