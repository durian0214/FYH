package com.fyh.my.reservation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.utils.GlideUtil;

import java.util.ArrayList;

/**
 * Created by Cbt on 2016/12/29.
 */
public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.viewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<ReservationModel> lists;
    private Context mContext;
    public ReservationAdapter(Context mContext, ArrayList<ReservationModel> lists) {
        mLayoutInflater = mLayoutInflater.from(mContext);
        this.lists = lists;
        this.mContext = mContext;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(mLayoutInflater.inflate(R.layout.item_set_reservation, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        GlideUtil.getIntance().loaderImg(mContext,holder.img,lists.get(position).getPic_url());
        holder.tvPrice.setText(lists.get(position).getRent());
        holder.tvAddress.setText(lists.get(position).getRoomName());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public void addList(ArrayList<ReservationModel> list) {
        lists.addAll(list);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvPrice, tvAddress;

        public viewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_set_reservation);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_item_set_reservation_price);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_item_set_reservation_address
            );
        }
    }
}
