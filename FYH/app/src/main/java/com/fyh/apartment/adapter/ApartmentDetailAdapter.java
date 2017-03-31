package com.fyh.apartment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.listen.OnLoadMoreListener;
import com.fyh.apartment.model.ApartmentDetailModel;
import com.fyh.apartment.model.ApartmentDetailRoomModelList;
import com.fyh.apartment.ui.ApartmentRoomDetailActivity;
import com.fyh.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cbt on 2017/1/3.
 */
public class ApartmentDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
   private Context mContext;
    private LayoutInflater layoutInflater ;
    private static final int ITEM_BANNER = 0;
    private static final int ITEM_DETAIL = 1;
    private static  final int ITEM_LISTS = 2;
    private  ApartmentDetailBannerAdapter bannerAdapter;
    private ApartmentDetailListAdapter listsAdapter;
    private ArrayList<ApartmentDetailRoomModelList.itemRows> roomLists;
    public ApartmentDetailAdapter(Context mContext){
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        roomLists = new ArrayList<>();
        bannerAdapter = new ApartmentDetailBannerAdapter(mContext);
        listsAdapter =new ApartmentDetailListAdapter(mContext,roomLists,true);
    }
    public ApartmentDetailModel model =null;
    @Override
    public int getItemViewType(int position) {
        if(position ==ITEM_BANNER){
            return ITEM_BANNER;
        }else if(position ==ITEM_DETAIL){
            return ITEM_DETAIL;
        }else{
            return ITEM_LISTS;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==ITEM_BANNER){
            return new bannerViewHolder(layoutInflater.inflate(R.layout.item_rv,parent,false));
        }
        else if(viewType ==ITEM_DETAIL){
            return new detailViewHolder(layoutInflater.inflate(R.layout.item_apartment_detail,parent,false));

        }else{
            return new listsViewHolder(layoutInflater.inflate(R.layout.item_rv,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position==ITEM_BANNER){
            ((bannerViewHolder)holder).rv.setLayoutManager(Utils.getHManager(mContext));
            ((bannerViewHolder)holder).rv.setAdapter(bannerAdapter);
        }else if(position ==ITEM_DETAIL){
            if(model!=null){
                ((detailViewHolder)holder).tvName.setText(model.getApartmentName());
                ((detailViewHolder)holder).tvContext.setText(model.getDescription());
                ((detailViewHolder)holder).tvAddress.setText(model.getAddress());
                ((detailViewHolder)holder).tvSelect.setText("查看地图");
                ((detailViewHolder)holder).tvSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

        }else{
            ((listsViewHolder)holder).rv.setLayoutManager(Utils.getVManager(mContext));
            //初始化EmptyView
            View emptyView = LayoutInflater.from(mContext).inflate(R.layout.test_empty_layout, (ViewGroup) ((listsViewHolder)holder).rv.getParent(), false);
            listsAdapter.setEmptyView(emptyView);
            //初始化 开始加载更多的loading View
            listsAdapter.setLoadingView(R.layout.test_load_loading_layout);
            //设置加载更多触发的事件监听
            listsAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(boolean isReload) {
                }
            });
            listsAdapter.setOnItemClickListener(new OnItemClickListener<ApartmentDetailRoomModelList.itemRows>() {
                @Override
                public void onItemClick(ViewHolder viewHolder, ApartmentDetailRoomModelList.itemRows data, int position) {
                    Intent mIntent = new Intent(mContext, ApartmentRoomDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("roomId",String.valueOf(data.getId()));
                    bundle.putString("apartmentId",String.valueOf(data.getApartmentId()));
                    bundle.putString("name",data.getFullName());
                    bundle.putString("suiteId",String.valueOf(data.getSuiteId()));
                    mIntent.putExtra("bundle",bundle);
                    ((Activity)mContext) .startActivity(mIntent);
                }
            });
            ((listsViewHolder)holder).rv.setAdapter(listsAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
    public class bannerViewHolder extends  RecyclerView.ViewHolder{
        private RecyclerView rv;
        public bannerViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_item_rv);
        }
    }
    public class detailViewHolder extends  RecyclerView.ViewHolder {
        private TextView tvName,tvContext,tvAddress,tvSelect;
        public detailViewHolder(View itemView) {
            super(itemView);
            tvName  = (TextView) itemView.findViewById(R.id.tv_item_apartment_detail_name);
            tvContext = (TextView) itemView.findViewById(R.id.tv_item_apartment_detail_context);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_item_apartment_detail_address);
            tvSelect = (TextView) itemView.findViewById(R.id.tv_item_apartment_detail_select);
        }
    }
    public class listsViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView rv;
        public listsViewHolder(View itemView) {
            super(itemView);
            rv  = (RecyclerView) itemView.findViewById(R.id.rv_item_rv);
        }
    }

    public  void addLists(List<ApartmentDetailRoomModelList.itemRows> list){
        listsAdapter.setLoadMoreData(list);
    }

    public  void setDetail(ApartmentDetailModel model){
          bannerAdapter.setBanner(model.getPicInfo());
        this.model =model;
        notifyItemChanged(1);
    }
    public void endList(){
        listsAdapter.setLoadEndView(R.layout.test_load_end_layout);
    }
}
