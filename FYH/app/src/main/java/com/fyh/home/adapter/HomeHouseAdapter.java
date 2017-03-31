package com.fyh.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fyh.R;
import com.fyh.listen.onRecyclerViewItemClickListener;
import com.fyh.room.model.GetRoomModel;
import com.fyh.utils.GlideUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * Created by Cbt on 2016/12/26.
 */
public class HomeHouseAdapter extends RecyclerView.Adapter<HomeHouseAdapter.viewHolder>{
    private static onRecyclerViewItemClickListener itemClickListener;
    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private ArrayList<GetRoomModel> lists;
    public HomeHouseAdapter(Context mContext, ArrayList<GetRoomModel> lists){
        this.lists = lists;
        this.mContext= mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_home_house_child,parent,false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        String url = lists.get(position).getPicUrl();
        GlideUtil.getIntance().loaderCornersImg(mContext,holder.img,url);
        holder.tvPrice.getBackground().setAlpha(127);//0~255透明度值 
        holder.tvPrice.setText(lists.get(position).getRoomName());
        holder.tvAddress.setText(lists.get(position).getAddress());
        }

    @Override
    public int getItemCount() {
        return lists == null ? 0 :lists.size();
    }


    public static class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RelativeLayout rv;
    private RoundedImageView img;
    private TextView tvPrice ,tvAddress ;
    public viewHolder(View itemView) {
        super(itemView);
        rv = (RelativeLayout) itemView.findViewById(R.id.rv_item_house);
        img = (RoundedImageView) itemView.findViewById(R.id.img_item_home_house);
        tvPrice  = (TextView) itemView.findViewById(R.id.tv_item_home_house_price);
        tvAddress = (TextView)itemView.findViewById(R.id.tv_item_home_house_address);
        rv.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            if(itemClickListener!=null){
                itemClickListener.onItemClick(v,getLayoutPosition());
            }
        }
    }
    public void setHouseOnClickListener(onRecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
