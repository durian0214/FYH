package com.fyh.releaseHouse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fyh.R;
import com.fyh.bean.PicInfoBean;
import com.fyh.utils.GlideUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Durian
 * 2017-2017/1/23
 */
public class UpLoadImgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int ADD = 0 ;
    private static final int IMG = 1;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<PicInfoBean> lists ;
    public UpLoadImgAdapter(Context mContext){
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        lists = new ArrayList<>();
    }
    public void addBean(PicInfoBean bean){
        lists.add(bean);
        notifyDataSetChanged();
    }
    public void setList(List<PicInfoBean> list){
        lists.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==ADD){
            return new AddViewHolder(layoutInflater.inflate(R.layout.item_up_load_img_add,parent,false));
        }else{
            return new ImgViewHolder(layoutInflater.inflate(R.layout.item_up_load_img,parent,false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(lists.size()!=5){
            if(position==ADD) return ADD;
            else
                return IMG;
        }else{
           return IMG;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position!=0){
            if(lists.size()!=5){
                GlideUtil.getIntance().loaderImg(mContext,((ImgViewHolder)holder).img,lists.get(position-1).getPicUrl());
            }else{
                GlideUtil.getIntance().loaderImg(mContext,((ImgViewHolder)holder).img,lists.get(position).getPicUrl());
            }

        }
    }

    @Override
    public int getItemCount() {
        if(lists.size()!=5){
            return lists.size()+1;
        }else{
            return lists.size();
        }
    }
    public class AddViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgAdd;
        public AddViewHolder(View itemView) {
            super(itemView);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_item_up_load_img_add);
            imgAdd.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String json="";
            EventBus.getDefault().post(json);
        }
    }
    public class ImgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private ImageView img;
        public ImgViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_item_up_load_img);
            img.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
