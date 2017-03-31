package com.fyh.my.collection;

import com.fyh.my.collection.CollectionModel;
import com.fyh.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public interface CollectionView extends BaseView  {
    void getData( List<CollectionModel> lists);
}
