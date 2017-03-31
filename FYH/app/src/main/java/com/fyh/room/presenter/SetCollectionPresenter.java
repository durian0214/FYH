package com.fyh.room.presenter;

import com.fyh.apartment.model.ApartmentRoomNeighborModel;
import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.listen.StringListener;
import com.fyh.base.BasePresenter;
import com.fyh.utils.Constant;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.room.view.SetCollectionView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/1/19
 * 设置收藏
 */
public class SetCollectionPresenter extends BasePresenter<SetCollectionView>{
    public SetCollectionPresenter(SetCollectionView view){
        attachView(view);
    }
    public void setCollection(int roomId){
        Map<String,Object> params = new HashMap<>();
        params.put("roomId",roomId);
        HttpUtils.getInstance().jsonPost(HttpConstant.ADD_SAVE, params, new DefaultObjectHttpListener<String>() {
            @Override
            public void onSuccessParsed(String result) {
                LogUtil.i("添加收藏",result);
            }
        });
    }
}
