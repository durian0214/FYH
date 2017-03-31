package com.fyh.search.activity;

/**
 * Created by Aramis on 2017/3/3.
 */

public interface WholeSearchView {
    void onScreenComplete();

    void popDismiss();

    void onFragmentPageSelected(int position);

    void onSearchStyleSelected(String itemName);

    void onSearchRentalSelected(String item);

    void onSearchLocationSelected(String item);

    void onSearchScreenSelected(String item);
}
