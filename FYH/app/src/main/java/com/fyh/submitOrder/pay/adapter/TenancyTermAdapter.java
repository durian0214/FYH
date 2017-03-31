package com.fyh.submitOrder.pay.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.listen.onRecyclerViewItemClickListener;

/**
 * Durian
 * 2017-2017/1/13
 * 租期适配器
 */
public class TenancyTermAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private onRecyclerViewItemClickListener itemClickListener;
    private Context mContext;
    private LayoutInflater layoutInflater;
    public TenancyTermAdapter(Context mContext){
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_rent_info,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((viewHolder)holder).cb.setChecked(true);
        ((viewHolder)holder).tv.setText("");
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cv;
        private CheckBox cb;
        private TextView tv;
        public viewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_item_rent_info);
            cb = (CheckBox) itemView.findViewById(R.id.cb_item_rent_info);
            tv = (TextView) itemView.findViewById(R.id.tv_item_rent_info);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getLayoutPosition());
        }
    }
    public void setOnClickListener(onRecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
