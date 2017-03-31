package com.fyh.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.base.adapterBase.SpacesItemDecoration;
import com.fyh.listen.onRecyclerViewItemClickListener;
import com.fyh.apartment.model.GetApartmentModel;
import com.fyh.room.model.GetRoomModel;
import com.fyh.apartment.ui.ApartmentDetailActivity;
import com.fyh.home.join.JoinActivity;

import com.fyh.room.ui.RoomDetailActivity;

import com.fyh.room.ui.RoomListActivity;
import com.fyh.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cbt on 2016/12/26.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private final int itemBanner = 0;
    private final int itemApartment = 1;
    private final int itemHouse = 2;
    private final int itemLandlordJoin = 3;
    private ArrayList<GetApartmentModel> apartmentLists;
    private HomeApartmentAdapter apartmentAdapter;
    private ArrayList<GetRoomModel> roomLists;
    private HomeHouseAdapter houseAdapter;

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = mLayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == itemBanner) {
            return itemBanner;
        } else if (position == itemApartment) {
            return itemApartment;
        } else if (position == itemHouse) {
            return itemHouse;
        } else {
            return itemLandlordJoin;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == itemBanner) {
            return new viewHolderLable(mLayoutInflater.inflate(R.layout.item_home_lable, parent, false));
        } else if (viewType == itemApartment) {
            return new viewHolder(mLayoutInflater.inflate(R.layout.item_home_rv, parent, false));
        } else if (viewType == itemHouse) {
            return new viewHolder(mLayoutInflater.inflate(R.layout.item_home_rv, parent, false));
        } else {
            return new viewHolderLandlordJoin(mLayoutInflater.inflate(R.layout.item_home_landlord_join, parent, false));
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == itemBanner) {
            ((viewHolderLable) holder).rv.setLayoutManager(Utils.getHManager(mContext));
            ((viewHolderLable) holder).rv.setAdapter(new HomeBannerAdapter(mContext));
            ((viewHolderLable) holder).rl1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(mContext, RoomListActivity.class);
                    ((Activity) mContext).startActivity(mIntent);
                }
            });
            ((viewHolderLable) holder).rl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(mContext, RoomListActivity.class);
                    ((Activity) mContext).startActivity(mIntent);
                }
            });
            ((viewHolderLable) holder).rl3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String json="";
                    EventBus.getDefault().post(json);
                }
            });
        } else if (position == itemApartment) {
            ((viewHolder) holder).rlTitle.setVisibility(View.VISIBLE);
            ((viewHolder) holder).tvTitle.setText(R.string.RECOMMEND_APARTMENT);
            ((viewHolder) holder).tvMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String json="";
                    EventBus.getDefault().post(json);
                }
            });
            ((viewHolder) holder).rv.setLayoutManager(Utils.getHManager(mContext));
            ((viewHolder) holder).rv.addItemDecoration(new SpacesItemDecoration(16));
            apartmentLists = new ArrayList<>();
            apartmentAdapter = new HomeApartmentAdapter(mContext, apartmentLists);
            apartmentAdapter.setApartmentOnClickListener(new onRecyclerViewItemClickListener() {

                @Override
                public void onItemClick(View v, int position) {
                    Intent mIntent = new Intent(mContext, ApartmentDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("id", apartmentLists.get(position).getId());
                    mIntent.putExtra("bundle", bundle);
                    ((Activity) mContext).startActivity(mIntent);
                }
            });
            ((viewHolder) holder).rv.setAdapter(apartmentAdapter);

        } else if (position == itemHouse) {
            ((viewHolder) holder).rlTitle.setVisibility(View.VISIBLE);
            ((viewHolder) holder).tvTitle.setText(R.string.RECOMMEND_HOUSE);
            ((viewHolder) holder).tvMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(mContext, RoomListActivity.class);
                    ((Activity) mContext).startActivity(mIntent);
                }
            });
            roomLists = new ArrayList<>();
            houseAdapter = new HomeHouseAdapter(mContext, roomLists);
            houseAdapter.setHouseOnClickListener(new onRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("roomId",Integer.parseInt(roomLists.get(position).getRoomId()));
                    bundle.putString("name",roomLists.get(position).getRoomName());
                    Intent mIntent = new Intent(mContext,RoomDetailActivity.class);
                    mIntent.putExtra("bundle",bundle);
                    ((Activity)mContext).startActivity(mIntent);
                }
            });
            ((viewHolder) holder).rv.setLayoutManager(Utils.getHManager(mContext));
            ((viewHolder) holder).rv.addItemDecoration(new SpacesItemDecoration(16));
            ((viewHolder) holder).rv.setAdapter(houseAdapter);
        }  else {
            ((viewHolderLandlordJoin) holder).btnLandlordJoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //房东加盟
                    Intent mIntent = new Intent(mContext,JoinActivity.class);
                    ((Activity)mContext).startActivity(mIntent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public static class viewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvMore;
        private RecyclerView rv;
        private RelativeLayout rlTitle;

        public viewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_item_home);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_home_title);
            rlTitle = (RelativeLayout) itemView.findViewById(R.id.rl_item_home);
            rlTitle.setVisibility(View.GONE);
            tvMore = (TextView) itemView.findViewById(R.id.tv_item_home_more);
        }


    }

    public static class viewHolderLable extends RecyclerView.ViewHolder {
        private RelativeLayout rl1, rl2, rl3;
      private RecyclerView rv;
        public viewHolderLable(View itemView) {
            super(itemView);
            rv  = (RecyclerView) itemView.findViewById(R.id.rv_home_banner);
            rl1 = (RelativeLayout) itemView.findViewById(R.id.rl_home_roommates);
            rl2 = (RelativeLayout) itemView.findViewById(R.id.rl_home_whole_rent);
            rl3 = (RelativeLayout) itemView.findViewById(R.id.rl_home_apartment);
        }
    }

    public class viewHolderLandlordJoin extends RecyclerView.ViewHolder {
        private Button btnLandlordJoin;

        public viewHolderLandlordJoin(View itemView) {
            super(itemView);
            btnLandlordJoin = (Button) itemView.findViewById(R.id.btn_landlord_join);
        }
    }

    public void setItemApartment(List<GetApartmentModel> lists) {
        apartmentLists.addAll(lists);
        apartmentAdapter.notifyDataSetChanged();
    }

    public void setItemRoom(List<GetRoomModel> lists) {
        roomLists.addAll(lists);
        houseAdapter.notifyDataSetChanged();
    }

}
