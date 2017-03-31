package com.fyh.releaseHouse.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.fyh.R;
import com.fyh.base.adapterBase.MultiBaseAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.releaseHouse.model.ReleaseHouseListModel;
import com.fyh.releaseHouse.ui.ReleaseHouseActivity;
import com.fyh.utils.GlideUtil;

import java.util.List;

/**
 * Created by Cbt on 2016/12/30.
 */
public class ReleaseHouseListAdapter extends MultiBaseAdapter<ReleaseHouseListModel> {
    private static final int ITEM_ADD = 0;
    private static final int  ITEM_LIST = 1;
    public ReleaseHouseListAdapter(Context context, List<ReleaseHouseListModel> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, ReleaseHouseListModel data, int viewType) {
        if(viewType==ITEM_LIST){
            holder.setText(R.id.tv_item_release_house_list_name,data.getCellName());
            holder.setText(R.id.tv_item_release_house_list_price,data.getRent()+"元");
            GlideUtil.getIntance().loaderImg(mContext,holder.getImg(R.id.img_item_release_house_list),data.getPicUrl());
        }else if(viewType==ITEM_ADD){
            holder.setOnClickListener(R.id.rl_release_house_list_add, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(mContext,ReleaseHouseActivity.class );
                    ((Activity)mContext ) .startActivity(mIntent);
                }
            });
        }
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        if(viewType==ITEM_ADD)
            return R.layout.item_release_house_list_add;
        else
            return R.layout.item_release_house_list;
    }

    @Override
    protected int getViewType(int position, ReleaseHouseListModel data) {
        if(position==ITEM_ADD) return ITEM_ADD;
        else
            return ITEM_LIST;
    }
}
