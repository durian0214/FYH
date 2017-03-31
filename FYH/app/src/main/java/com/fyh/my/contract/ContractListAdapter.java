package com.fyh.my.contract;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.listen.onRecyclerViewItemClickListener;
import com.fyh.utils.GlideUtil;

import java.util.ArrayList;

/**
 * Created by Locker on 2017/1/16.
 */
public class ContractListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<ContractModel> lists;
    private onRecyclerViewItemClickListener itemClickListener = null;

    public ContractListAdapter(Context mContext,ArrayList<ContractModel> lists){
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        this.lists = lists;
        lists = new ArrayList<>();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView image;
        private TextView tvRoomFull,tvStartTime,tvEndTime,tvPay,tvRent;
        private CardView cv;
        public viewHolder(View itemView){
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.img_item_contract);
            tvRoomFull = (TextView)itemView.findViewById(R.id.tv_item_roomFull);
            tvStartTime = (TextView)itemView.findViewById(R.id.tv_item_startTime);
            tvEndTime = (TextView)itemView.findViewById(R.id.tv_item_endTime);
            tvPay = (TextView)itemView.findViewById(R.id.tv_item_pay);
            tvRent = (TextView)itemView.findViewById(R.id.tv_item_rent);
             cv = (CardView) itemView.findViewById(R.id.cv_item_contract);
            cv.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if(itemClickListener != null){
                itemClickListener.onItemClick(v,getLayoutPosition());
            }
        }
    }

    public void setContractOnClickListener(onRecyclerViewItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_contract_list,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GlideUtil.getIntance().loaderImg(mContext,((viewHolder)holder).image, lists.get(position).getPicUrl());
        ((viewHolder)holder).tvRoomFull.setText(lists.get(position).getRoomName());

        ((viewHolder)holder).tvStartTime.setText(lists.get(position).getStartDate());
        ((viewHolder)holder).tvEndTime.setText(lists.get(position).getEndDate());
        ((viewHolder)holder).tvPay.setText(lists.get(position).getPay());
        ((viewHolder)holder).tvRent.setText(lists.get(position).getRent());

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
