package com.fyh.apartment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.apartment.model.ApartmentRoomDetailModel;
import com.fyh.apartment.model.ApartmentRoomNeighborModel;
import com.fyh.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/5.
 */
public class ApartmentRoomDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private static int ROOM_DETAIL = 0;
    private static int NEIGHBOR = 1;
    private ApartmentRoomDetailModel detailModel = null;
    private ArrayList<ApartmentRoomNeighborModel> lists;
    ApartmentRoomNeighborAdapter neighborAdapter;

    public ApartmentRoomDetailAdapter(Context mContext) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        this.lists = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ROOM_DETAIL) {
            return new RoomDetailViewHolder(layoutInflater.inflate(R.layout.item_apartment_room_detail, parent, false));
        } else {
            return new NeighboViewHolder(layoutInflater.inflate(R.layout.item_rv, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == ROOM_DETAIL) {
            return ROOM_DETAIL;
        } else {
            return NEIGHBOR;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == ROOM_DETAIL) {
            if (detailModel != null) {
                ((RoomDetailViewHolder) holder).rvBanner.setLayoutManager(Utils.getHManager(mContext));
                ApartmentRoomBannerAdapter bannerAdapter = new ApartmentRoomBannerAdapter(mContext);
                ((RoomDetailViewHolder) holder).rvBanner.setAdapter(bannerAdapter);
                bannerAdapter.setLists(detailModel.getPicInfo());
                ((RoomDetailViewHolder) holder).rvConfiguration.setLayoutManager(Utils.getTableManager(mContext,5));
                ApartmentRoomConfigurationAdapter configurationAdapter = new ApartmentRoomConfigurationAdapter(mContext);
                ((RoomDetailViewHolder) holder).rvConfiguration.setAdapter(configurationAdapter);
                configurationAdapter.setList(detailModel.getConfigure());
                ((RoomDetailViewHolder) holder).tvName.setText(detailModel.getFullName());
                ((RoomDetailViewHolder) holder).tvPaymet.setText(String.valueOf(detailModel.getRent()) );
                int payment = detailModel.getPay();
                String paymentName = "";
                if(payment ==0){
                    paymentName  ="月付";
                }else if(payment ==1){
                    paymentName  ="季付";
                }else if(payment ==2){
                    paymentName  ="半年付";
                }else if(payment ==3){
                    paymentName  ="年付";
                }
                ((RoomDetailViewHolder) holder).tvPaymetDescribe.setText("元/月("+paymentName+")");

                ((RoomDetailViewHolder) holder).tvRoomSize.setText("面积:" + (int)detailModel.getRoomSize() + "㎡");
                ((RoomDetailViewHolder) holder).tvFloor.setText("楼层:" + detailModel.getDecorating()+"/");
                ((RoomDetailViewHolder) holder).tvDoorModel.setText("戶型：" + detailModel.getHouseType());
            }
        } else {
            neighborAdapter = new ApartmentRoomNeighborAdapter(mContext, lists);
            ((NeighboViewHolder) holder).rv.setLayoutManager(Utils.getVManager(mContext));
            ((NeighboViewHolder) holder).rv.setAdapter(neighborAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class RoomDetailViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rvBanner, rvConfiguration;
        private TextView tvName, tvPaymetDescribe,tvPaymet, tvRoomSize,tvFloor,tvDoorModel;

        public RoomDetailViewHolder(View itemView) {
            super(itemView);
            rvBanner = (RecyclerView) itemView.findViewById(R.id.rv_item_apartment_room_detail_banner);
            rvConfiguration = (RecyclerView) itemView.findViewById(R.id.rv_item_apartment_room_detail_configuration);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_apartment_room_detail_name);
            tvPaymet = (TextView) itemView.findViewById(R.id.tv_item_apartment_room_detail_paymet);
            tvRoomSize = (TextView) itemView.findViewById(R.id.tv_item_apartment_room_detail_room_size);

            tvPaymetDescribe = (TextView) itemView.findViewById(R.id.tv_item_apartment_room_detail_paymet_describe);
                    tvFloor = (TextView) itemView.findViewById(R.id.tv_item_apartment_room_detail_room_floor);
            tvDoorModel = (TextView) itemView.findViewById(R.id.tv_item_apartment_room_detail_door_model);

        }
    }

    public class NeighboViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv;

        public NeighboViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_item_rv);
        }
    }

    public void setRoomDetail(ApartmentRoomDetailModel model) {
        this.detailModel = model;
        notifyItemChanged(0);
    }

    public void setNeighbor(List<ApartmentRoomNeighborModel> list) {
        this.lists.addAll(list);
        notifyItemChanged(1);
    }
}
