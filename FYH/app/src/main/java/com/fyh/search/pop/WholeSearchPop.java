package com.fyh.search.pop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.aramis.AramisUtils;
import com.fyh.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import razerdp.basepopup.BasePopupWindow;

/**
 * 全局搜索pop
 * Created by Aramis on 2017/3/3.
 */

public class WholeSearchPop extends BasePopupWindow {
    private View mView;
    private ViewPager viewpager_search_pop;
    private FragmentActivity mActivity;
    private FragmentManager supportFragmentManager;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPagerAdapter2 viewPagerAdapter2;
    private ListView list_test;

    public WholeSearchPop(FragmentActivity context) {
//        super(context, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        super(context);
        this.mActivity = context;
        this.supportFragmentManager = context.getSupportFragmentManager();
//        viewPagerAdapter = new ViewPagerFragmentAdapter(supportFragmentManager);
//        viewPagerAdapter2 = new ViewPagerAdapter2();

//        list_test = (ListView) findViewById(R.id.list_test);
//        list_test.setAdapter(new ListViewAdapter());
        viewpager_search_pop = (ViewPager) findViewById(R.id.viewpager_search_pop);

        viewpager_search_pop = (ViewPager) mView.findViewById(R.id.viewpager_search_pop);
        if (viewpager_search_pop == null) {
            LogUtil.e(AramisUtils.TAG(), "构造 viewpager_search_pop is null");
        } else {
            LogUtil.e(AramisUtils.TAG(), "构造 viewpager_search_pop is exsit");
        }

        viewpager_search_pop.setAdapter(new ViewPagerAdapter(supportFragmentManager));
        LogUtil.e(AramisUtils.TAG(), "==============================");
    }

    public void setAdapter() {
        if (viewpager_search_pop == null) {
            LogUtil.e(AramisUtils.TAG(), "============= viewpager_search_pop=null =================");
        } else {
            LogUtil.e(AramisUtils.TAG(), "============= viewpager_search_pop  setAdapter =================");

        }
    }

    @Override
    public void showPopupWindow(View v) {
//        setOffsetX(-(getPopupViewWidth() - v.getWidth() / 2));
        setOffsetY(v.getHeight());
//        viewpager_search_pop.setAdapter(viewPagerAdapter);

        super.showPopupWindow(v);
    }

    @Override
    public View onCreatePopupView() {
        mView = createPopupById(R.layout.pop_search);
//        viewpager_search_pop = (ViewPager) mView.findViewById(R.id.viewpager_search_pop);
//        viewpager_search_pop.setAdapter(new ViewPagerFragmentAdapter(supportFragmentManager));
        if (viewpager_search_pop == null) {
            LogUtil.e(AramisUtils.TAG(), "onCreatePopupView() viewpager_search_pop is null");
        } else {
            LogUtil.e(AramisUtils.TAG(), "onCreatePopupView() viewpager_search_pop is exsit:" +
                    viewpager_search_pop.getId());
        }
        if (viewPagerAdapter == null) {
            LogUtil.e(AramisUtils.TAG(), "onCreatePopupView() viewPagerAdapter is null");
        } else {
            LogUtil.e(AramisUtils.TAG(), "onCreatePopupView() viewPagerAdapter is exsit");
        }

//        testFragment = new TestFragment();
        return mView;
    }

    @Override
    public View initAnimaView() {
//        return getPopupWindowView().findViewById(R.id.text_search_pop);
        return null;
    }

    @Override
    protected Animation initShowAnimation() {
//        AnimationSet set = new AnimationSet(true);
//        set.setInterpolator(new DecelerateInterpolator());
//        set.addAnimation(getScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0));
//        set.addAnimation(getDefaultAlphaAnimation());
//        return set;
//        return AnimationUtils.loadAnimation(mActivity, R.anim.anim_fb_pop_bottom);
        return null;
    }

    @Override
    public View getClickToDismissView() {
        return getPopupWindowView().findViewById(R.id.layout_search_bg);
    }

    private class ListViewAdapter extends android.widget.BaseAdapter {
        private List<String> list;

        public ListViewAdapter() {
            list = new ArrayList<>();
            list.add("a");
            list.add("a");
            list.add("a");
            list.add("a");
            list.add("a");
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(mActivity);
            textView.setText("sdfsdfsdf++" + position);
            textView.setTextSize(25);
            return textView;
        }

    }


    public class ViewPagerAdapter2 extends PagerAdapter {
        private List<View> list;

        public ViewPagerAdapter2() {
            list = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                TextView textView = new TextView(mActivity);
                textView.setText("ccccc" + i);
                textView.setTextSize(25);
                list.add(textView);
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(list.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;

        ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            list = new ArrayList<>();
//            list.add(testFragment);
//            list.add(new TestFragment());
//            list.add(new TestFragment());
//            list.add(new TestFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
