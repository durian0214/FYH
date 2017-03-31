package com.fyh.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fyh.R;

/**
 * Created by Cbt on 2016/12/26.
 */
public class HomeBannerAdapter extends RecyclerView.Adapter<HomeBannerAdapter.viewHolder>{

    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private int[] imgs = {R.drawable.banner_1,R.drawable.banner_2};
    public HomeBannerAdapter(Context mContext){
        this.mContext= mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_home_banner_child,parent,false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.imgHomeBanner.setBackgroundResource(imgs[position]);
    }

    @Override
    public int getItemCount() {
        return imgs == null ? 0 : imgs.length;
    }


    public static class viewHolder extends RecyclerView.ViewHolder {
    private ImageView imgHomeBanner;

    public viewHolder(View itemView) {
        super(itemView);
        imgHomeBanner = (ImageView) itemView.findViewById(R.id.img_item_home_banner);
    }
}
}
