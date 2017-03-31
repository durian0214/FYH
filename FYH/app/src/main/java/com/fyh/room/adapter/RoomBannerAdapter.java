package com.fyh.room.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fyh.R;
import com.fyh.room.model.RoomDetailModel;
import com.fyh.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/5.
 */
public class RoomBannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<RoomDetailModel.RoomDetailBean.PicInfoBean> lists = null;

    public RoomBannerAdapter(Context mContext) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        lists = new ArrayList<>();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_room_banner,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GlideUtil.getIntance().loaderImg(mContext, ((viewHolder)holder).img ,lists.get(position).getPicUrl());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    public void setLists ( List<RoomDetailModel.RoomDetailBean.PicInfoBean> list){
        if(list!=null){
            lists.addAll(list);
            notifyDataSetChanged();
        }
    }
    private class viewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public viewHolder(View itemView) {
            super(itemView);
            img  = (ImageView) itemView.findViewById(R.id.img_item_room_bannner);
        }
    }
}
