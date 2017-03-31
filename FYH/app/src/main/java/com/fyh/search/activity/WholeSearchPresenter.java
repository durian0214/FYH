package com.fyh.search.activity;


import com.fyh.base.BasePresenter;
import com.fyh.search.bean.SearchMainBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局搜索 Presenter
 * Created by Aramis on 2017/3/3.
 */

public class WholeSearchPresenter extends BasePresenter<WholeSearchView> implements Serializable {
    public WholeSearchPresenter(WholeSearchView wholeSearchView) {
        attachView(wholeSearchView);
    }

    public void onScreenOkClick() {
    }

    public void onSreenResetClick() {

    }


    public void popDismiss() {
        myView.popDismiss();
    }

    public void onFragmentPageSelected(int position) {
        myView.onFragmentPageSelected(position);
    }

    public void onSearchStyleItemSelected(String itemName) {
        myView.onSearchStyleSelected(itemName);
    }

    public void onSearchRentalSelected(String item) {
        myView.onSearchRentalSelected(item);
    }

    public void onSearchLocationSelected(String item) {
        myView.onSearchLocationSelected(item);
    }

    public void onSearchScreenSelected(String item) {
        myView.onSearchScreenSelected(item);
    }

    public List<SearchMainBean> getMainTestData() {
        List<SearchMainBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            SearchMainBean searchMainBean = new SearchMainBean();
            searchMainBean.setName("公寓" + i);
            searchMainBean.setPrice((1500 + i * 100) + "元/月");
            searchMainBean.setArea((60 + i) + "㎡|10/15层");
            list.add(searchMainBean);
        }
        return list;
    }

}
