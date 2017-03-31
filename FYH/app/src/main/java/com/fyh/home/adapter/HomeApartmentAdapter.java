package com.fyh.home.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.listen.onRecyclerViewItemClickListener;
import com.fyh.apartment.model.GetApartmentModel;
import com.fyh.utils.Constant;
import com.fyh.utils.GlideUtil;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * Created by Cbt on 2016/12/26.
 */
public class HomeApartmentAdapter extends RecyclerView.Adapter<HomeApartmentAdapter.viewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context mContext;
    private ArrayList<GetApartmentModel> lists;
    private static onRecyclerViewItemClickListener itemClickListener = null;

    public HomeApartmentAdapter(Context mContext, ArrayList<GetApartmentModel> lists) {
        this.mContext = mContext;
        this.lists = lists;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public viewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = layoutInflater.inflate(R.layout.item_home_apartment_child, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        String url = lists.get(position).getPicUrl();
        GlideUtil.getIntance().loaderCornersImg(mContext,holder.img,url);
        holder.tvAddress.setText(lists.get(position).getAddress());
        holder.tvPrice.setText(lists.get(position).getApartmentName());
        holder.tvPrice.getBackground().setAlpha(127);//0~255透明度值 
        holder.tvArea.setText(lists.get(position).getApartmentName());
    }

    @Override
    public int getItemCount() {
        return lists == null ? 0 : lists.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RoundedImageView img;
        private TextView tvPrice, tvAddress,tvArea;
        private RelativeLayout cv;

        public viewHolder(View itemView) {
            super(itemView);
            cv = (RelativeLayout) itemView.findViewById(R.id.cv_item_home_apartment_child);
            cv.setMinimumWidth((int) (Constant.width*0.8));
            cv.setOnClickListener(this);
            tvArea= (TextView) itemView.findViewById(R.id.tv_item_home_apartment_area);
            img = (RoundedImageView) itemView.findViewById(R.id.img_item_home_apartment);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_item_home_apartment_price);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_item_home_apartment_address);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

    public void setApartmentOnClickListener(onRecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
