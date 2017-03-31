package com.fyh.room.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.apartment.bean.ConfigurationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/5.
 */
public class RoomConfigurationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private  List<ConfigurationBean> lists;
    public RoomConfigurationAdapter(Context mContext) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        lists =new ArrayList<>();
    }
    public void setList( List<ConfigurationBean> list){
        if(lists!=null){
            lists.addAll(list);
            notifyDataSetChanged();
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(layoutInflater.inflate(R.layout.item_room_configuration,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ((viewHolder)holder) .img.setBackground(ContextCompat.getDrawable(mContext, Config.getMipmap(lists.get(position).getCode())));
//        ((viewHolder)holder) .tv.setText(lists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    private class viewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;

        public viewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_room_configuration);
            tv = (TextView) itemView.findViewById(R.id.tv_item_room_configuration);
        }
    }

}
