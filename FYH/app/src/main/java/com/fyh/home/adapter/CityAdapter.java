package com.fyh.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.home.CityModel;

import java.util.List;

/**
 * Created by Cbt on 2016/12/30.
 */
public class CityAdapter extends BaseAdapter {
    private List<CityModel> lists;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public CityAdapter(Context mContext, List<CityModel> lists) {
        this.lists = lists;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder mHolder =null;
        if(convertView==null){
            mHolder = new viewHolder();
            convertView = layoutInflater.inflate(R.layout.item_city,null);
            mHolder.tv = (TextView) convertView.findViewById(R.id.tv_item_city_name);
            convertView.setTag(mHolder);
        }else{
           mHolder= (viewHolder) convertView.getTag();
        }
        mHolder.tv
                .setText(lists.get(position).getName());
        return convertView;
    }
    class viewHolder {
       TextView tv;
    }
}
