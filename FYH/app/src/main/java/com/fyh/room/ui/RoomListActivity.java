package com.fyh.room.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.room.adapter.RoomListAdapter;
import com.fyh.room.adapter.RoomListAreaAdapter;
import com.fyh.room.adapter.RoomListHouseTypeAdapter;
import com.fyh.room.adapter.RoomListRentSortAdapter;
import com.fyh.room.adapter.RoomListTypeAdapter;
import com.fyh.base.adapterBase.ViewHolder;
import com.fyh.listen.OnItemClickListener;
import com.fyh.listen.OnLoadMoreListener;
import com.fyh.home.AreaModel;
import com.fyh.releaseHouse.model.DicModel;
import com.fyh.room.model.RoomListModel;
import com.fyh.room.presenter.GetHouseTypePresenter;
import com.fyh.room.presenter.RoomListPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.utils.Constant;
import com.fyh.utils.Utils;
import com.fyh.releaseHouse.view.GetHouseTypeView;
import com.fyh.room.view.RoomListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2017/1/9.
 */
public class RoomListActivity extends BaseActivity implements View.OnClickListener, RoomListView, GetHouseTypeView {
    private RecyclerView rvRoomList;
    private RoomListPresenter presenter;
    private GetHouseTypePresenter getHouseTypePresenter;
    private RoomListAdapter mAdapter;
    private LinearLayout ll;
    private TextView tvHouseType,
            tvRentType,
            tvRentSort,
            tvArea;
    private static final int RENT_TYPE = 0;
    private static final int AREA = 1;
    private static final int HOUSE_TYPE = 2;
    private static final int RENT_SORT = 3;
    private int page = 1;
    private final int pageSize = 2;
    private int rentalType = 0; //1集中式2，分散式
    private int areasId = 0;//区域id
    private int houseType = 0;//房源类型
    private int orderSort = 0;//排序类型
    private String sortField = "zj";//排序字段
    private String keyword = "";//关键字
    private List<RoomListModel.RowsBean> lists = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_room_list;
    }

    @Override
    public void initView() {
        ll = getId(R.id.ll_room_list);
        getHouseTypePresenter = new GetHouseTypePresenter(this);
        tvHouseType = getId(R.id.tv_room_list_house_type);
        tvRentType = getId(R.id.tv_room_list_rent_type);
        tvRentSort = getId(R.id.tv_room_list_rent_sort);
        tvArea = getId(R.id.tv_room_list_area);
        rvRoomList = getId(R.id.rv_room_list);
        rvRoomList.setLayoutManager(Utils.getVManager(this));
        presenter = new RoomListPresenter(this);
        lists = new ArrayList<>();
        mAdapter = new RoomListAdapter(this, lists, true);
        //设置数据加载失败，无数据view
        mAdapter.setEmptyView(Utils.inflate(this, R.layout.item_baseadapter_nodata));
        //初始化 开始加载更多的loading View
        mAdapter.setLoadingView(R.layout.test_load_loading_layout);
        //设置加载更多触发的事件监听
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {

                getData();
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener<RoomListModel.RowsBean>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, RoomListModel.RowsBean data, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt("roomId", data.getId());
                bundle.putString("name", data.getFullName());
                intentJump(getCurrentActivity(), RoomDetailActivity.class, bundle);
            }
        });

        rvRoomList.setAdapter(mAdapter);
        isShowSeach(true);
        isShowRight(true);
        getData();
        setInitialData();

    }

    private List<String> listsRoomType = new ArrayList<>();
    private List<DicModel> listsHouseType = new ArrayList<>();
    private List<String> listsRentSort = new ArrayList<>();
    private RoomListTypeAdapter roomListTypeAdapter;
    private RoomListAreaAdapter roomListAreaAdapter;
    private RoomListHouseTypeAdapter roomListHouseTypeAdapter;
    private RoomListRentSortAdapter roomListRentSortAdapter;
    String sType = "类型";
    String sArea = "区域";
    String sHouseType = "居室";
    String sRent = "租金";

    public void setInitialData() {
        roomListTypeAdapter = new RoomListTypeAdapter(this, listsRoomType, false);
        roomListAreaAdapter = new RoomListAreaAdapter(this, Constant.areaList, false);
        roomListHouseTypeAdapter = new RoomListHouseTypeAdapter(this, listsHouseType, false);
        roomListRentSortAdapter = new RoomListRentSortAdapter(this, listsRentSort, false);
        for (int i = 0; i < Constant.rentType.length; i++) {
            listsRoomType.add(Constant.rentType[i]);
        }
        getHouseTypePresenter.getHouseType();
        for (int i = 0; i < Constant.rentSort.length; i++) {
            listsRentSort.add(Constant.rentSort[i]);
        }

        roomListTypeAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, String data, int position) {

                if (position == 0) {
                    rentalType = 0;
                    sType = "类型";
                } else {
                    rentalType = position - 1;
                    sType = data;
                }
                tvRentType.setText(sType);
                setTextColor(tvRentType, position);
                doScreening();
            }
        });
        roomListAreaAdapter.setOnItemClickListener(new OnItemClickListener<AreaModel>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, AreaModel data, int position) {
                if (position == 0) {
                    areasId = 0;
                    sArea = "区域";
                } else {
                    areasId = data.getPid();
                    sArea = data.getName();
                }
                tvArea.setText(sArea);
                setTextColor(tvArea, position);
                doScreening();
            }
        });
        roomListHouseTypeAdapter.setOnItemClickListener(new OnItemClickListener<DicModel>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, DicModel data, int position) {
                if (position == 0) {
                    houseType = 0;
                    sHouseType = "居室";
                } else {
                    houseType = Integer.parseInt(data.getCode());
                    sHouseType = data.getName();
                }
                tvHouseType.setText(sHouseType);
                setTextColor(tvHouseType, position);
                doScreening();
            }
        });
        roomListRentSortAdapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, String data, int position) {
                if (position == 0) {
                    orderSort = position;
                    sRent = "租金";
                } else {
                    orderSort = position;
                    sRent = data;
                }
                tvRentSort.setText(sRent);
                setTextColor(tvRentSort, position);
                doScreening();
            }
        });

    }

    private void setTextColor(TextView tv, int position) {
        if (position == 0) {
            tv.setTextColor(ContextCompat.getColor(getCurrentActivity(), R.color.tvBlack));
        } else {
            tv.setTextColor(ContextCompat.getColor(getCurrentActivity(), R.color.myTheme));
        }
    }

    /**
     * 初始化列表
     */
    private void doScreening() {
        //初始化 开始加载更多的loading View
        mAdapter.setLoadingView(R.layout.test_load_loading_layout);
        page = 1;
        getData();
        popupWindow.dismiss();
    }

    private void getData() {
        presenter.getRoomList(rentalType, areasId, houseType, page, pageSize, orderSort, sortField, keyword);
    }

    @Override
    public void setOnclick() {
        tvHouseType.setOnClickListener(this);
        tvRentType.setOnClickListener(this);
        tvRentSort.setOnClickListener(this);
        tvArea.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void netError(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_room_list_rent_type:
                showPopupWindow(RENT_TYPE);
                break;
            case R.id.tv_room_list_area:
                showPopupWindow(AREA);
                break;
            case R.id.tv_room_list_house_type:
                showPopupWindow(HOUSE_TYPE);
                break;
            case R.id.tv_room_list_rent_sort:
                showPopupWindow(RENT_SORT);
                break;
        }
    }

    private View ppw = null;
    RecyclerView rv;
    private PopupWindow popupWindow = null;

    private void showPopupWindow(int type) {
        // 一个自定义的布局，作为显示的内容

        if (ppw == null) {
            ppw = LayoutInflater.from(this).inflate(
                    R.layout.popupwindow_room_list, null);
            rv = (RecyclerView) ppw.findViewById(R.id.rv_popupwindow_room_list);
            rv.setLayoutManager(Utils.getVManager(this));
        }

        switch (type) {
            case RENT_TYPE:
                rv.setAdapter(roomListTypeAdapter);
                break;
            case AREA:
                rv.setAdapter(roomListAreaAdapter);
                break;
            case HOUSE_TYPE:
                rv.setAdapter(roomListHouseTypeAdapter);
                break;
            case RENT_SORT:
                rv.setAdapter(roomListRentSortAdapter);
                break;
        }
        if (popupWindow == null) {
            popupWindow = new PopupWindow(ppw,
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
        }
        popupWindow.showAsDropDown(ll);
    }

    @Override
    public void getRoomListData(List<RoomListModel.RowsBean> list) {
        if (list.size() < pageSize) {
            mAdapter.setLoadEndView(R.layout.test_load_end_layout);
        }
        if (page == 1) {
            mAdapter.setNewData(list);
        } else {
            mAdapter.setData(list);
        }
        page++;

    }

    @Override
    public void getHouseType(List<DicModel> list) {
        DicModel bean = new DicModel();
        listsHouseType.add(bean);
        listsHouseType.addAll(list);
        bean.setName("不限");
    }
}
