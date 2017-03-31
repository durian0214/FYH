package com.fyh.room.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.home.AreaModel;
import com.fyh.room.model.RoomListModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.room.view.RoomListView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 2017/1/9.
 */
public class RoomListPresenter extends BasePresenter<RoomListView> {
    public RoomListPresenter(RoomListView myView) {
        attachView(myView);
    }

    /**
     * 获取房源列表
     *
     * @param rentalType 出租类型（1整租2，合租）
     * @param areasId    区域id
     * @param houseType  房源类型
     * @param pageNo     页码
     * @param pageSize   分页数量
     * @param orderSort  排序类型（asc 升序 desc降序）
     * @param sortField  排序字段（“zj” 租金）
     * @param keyword    关键字
     */
    public void getRoomList(int rentalType, int areasId
            , int houseType, int pageNo
            , int pageSize, int orderSort, String sortField, String keyword) {
        Map<String, Object> params = new HashMap<>();
        if (rentalType != 0)
            params.put("rentalType", rentalType);
        if (areasId != 0)
            params.put("areasId", ((AreaModel) Constant.areaList.get(areasId)).getId());
        if (houseType!=0)
            params.put("houseType", houseType);
        params.put("regionId", Constant.REGISON_ID);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        if (orderSort != 0) {
            if(orderSort==1){
                params.put("orderSort", "asc");
            }else{
                params.put("orderSort", "desc");
            }
            params.put("sortField", sortField);
        }
        if (!keyword.equals(""))
            params.put("keyword", keyword);

        LogUtil.i("房源列表", HttpConstant.GET_ROOM_LIST);
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_ROOM_LIST, params, new DefaultObjectHttpListener<RoomListModel>() {
            @Override
            public void onSuccessParsed(RoomListModel result) {
                myView.getRoomListData(result.getRows());
            }
        });

    }
}
