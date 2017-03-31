package com.fyh.apartment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fyh.R;
import com.fyh.apartment.model.ApartmentDetailModel;
import com.fyh.utils.GlideUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/3.
 */
public class ApartmentDetailBannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<ApartmentDetailModel.itemPicInfo> lists;

    public ApartmentDetailBannerAdapter(Context mContext) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        lists = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new itemHolderView(layoutInflater.inflate(R.layout.item_apartment_detail_banner_child, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GlideUtil.getIntance().loaderImg(mContext, ((itemHolderView) holder).img, lists.get(position).getPicUrl());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class itemHolderView extends RecyclerView.ViewHolder {
        private ImageView img;

        public itemHolderView(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_apartment_detail_banner_child);
        }
    }

    public void setBanner(List<ApartmentDetailModel.itemPicInfo> lists) {
        this.lists = lists;
    }
}
