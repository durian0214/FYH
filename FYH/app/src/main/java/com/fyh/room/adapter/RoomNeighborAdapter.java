package com.fyh.room.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.room.model.RoomNeighborModel;
import com.fyh.utils.GlideUtil;

import java.util.ArrayList;

/**
 * Created by a on 2017/1/6.
 */
public class RoomNeighborAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext ;
    private LayoutInflater layoutInflater ;
    private ArrayList<RoomNeighborModel.RoomMateBean> lists;

    public RoomNeighborAdapter(Context mContext , ArrayList<RoomNeighborModel.RoomMateBean> lists){
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        this.lists = lists;
    }
     @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_room_neighbor,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((viewHolder)holder).tvNub.setText(String.valueOf(lists.get(position).getId()));
        if(lists.get(position).getIsRent()==0){
            ((viewHolder)holder).tvStatus.setText(R.string.UN_CHECK_IN);
            ((viewHolder)holder).img.setVisibility(View.GONE);
            ((viewHolder)holder).tvTime.setText(R.string.CHECK_ROOM);
            ((viewHolder)holder).tvSex.setText(String.valueOf(lists.get(position).getSex()));
            ((viewHolder)holder).tvTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }else{
            ((viewHolder)holder).tvStatus.setText(R.string.CHECK_IN);
            ((viewHolder)holder).img.setVisibility(View.VISIBLE);
            GlideUtil.getIntance().loaderImg(mContext, ((viewHolder)holder).img,lists.get(position).getUrl());
            ((viewHolder)holder).tvTime.setText(R.string.CHECK_IN_TIME+lists.get(position).getStartDate());
            if(lists.get(position).getSex()==0){
                ((viewHolder)holder).tvSex.setText(R.string.WOMAN);
            }else{
                ((viewHolder)holder).tvSex.setText(R.string.MAN);
            }
        }

        ((viewHolder)holder).tvNub.setText(String.valueOf(lists.get(position).getId()));
        ((viewHolder)holder).tvNub.setText(String.valueOf(lists.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvNub,tvStatus,tvSex,tvTime;

        public viewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_room_neihgbor);
            tvNub = (TextView) itemView.findViewById(R.id.tv_item_room_neighbor_room_nub);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_item_room_neighbor_status);
            tvSex = (TextView) itemView.findViewById(R.id.tv_item_room_neighbor_sex);
            tvTime = (TextView) itemView.findViewById(R.id.tv_item_room_neighbor_time);
        }
    }
}

