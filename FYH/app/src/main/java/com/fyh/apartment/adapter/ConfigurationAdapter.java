package com.fyh.apartment.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.apartment.model.ConfigurationModel;
import com.fyh.listen.onRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cbt on 2016/12/30.
 */
public class ConfigurationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ConfigurationModel>lists;
    private LayoutInflater layoutInflater;
    private Context mContext;
    private onRecyclerViewItemClickListener itemClickListener;
    public ConfigurationAdapter(Context mContext) {
        this.lists  = new ArrayList<>();
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }
    public void setList(List<ConfigurationModel> list) {
        this.lists.addAll(list);
        this.notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_release_house,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((viewHolder) holder) .tv.setText(lists.get(position).getName());
        if(lists.get(position).isCheck()){
            ((viewHolder) holder).cv.setBackgroundColor(ContextCompat.getColor(mContext,R.color.myTheme));
        }else{
            ((viewHolder) holder).cv.setBackgroundColor(ContextCompat.getColor(mContext,R.color.bgWhite));
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }


    class viewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
       TextView tv;
      CardView cv;
        public viewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_item_release_house);
            cv = (CardView) itemView.findViewById(R.id.cv_release_house);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getLayoutPosition());
        }
    }
    public void setConfigurationOnClickListener(onRecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
