package com.fyh.guide.main;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.fyh.R;
import com.fyh.apartment.ui.ApartmentFragment;
import com.fyh.aramis.AramisUtils;
import com.fyh.base.BaseActivity;
import com.fyh.home.HomeFragment;
import com.fyh.home.adapter.CityAdapter;
import com.fyh.my.MyFragment;
import com.fyh.search.activity.WholeSearchActivity;
import com.fyh.service.BaiDuMapServer;
import com.fyh.utils.Constant;
import com.fyh.utils.FYHUtils;
import com.fyh.utils.LogUtil;
import com.fyh.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity implements MainView, BottomNavigationBar.OnTabSelectedListener {
    private ArrayList<Fragment> fragments;
    private static BottomNavigationBar bnb;
    private MainPresenter presenter;
    private CityAdapter cityAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private int[] fragmentName = {R.string.HOME, R.string.APARTMENT, R.string.SET};
    private int[] fragmentImg = {R.drawable.home, R.drawable.apartment, R.drawable.my};
    private int[] fragmentColor = {R.color.myTheme, R.color.myTheme, R.color.myTheme};

    @Override
    public void initView() {
        isShowBack(false);
        isShowSp(true);
        isShowRight(true);
        isShowLogo(true);
        bnb = getId(R.id.bnb_main);
        bnb.setMode(BottomNavigationBar.MODE_DEFAULT);
        bnb.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bnb.setBarBackgroundColor(R.color.bgWhite);
        for (int i = 0; i < fragmentName.length; i++) {
            bnb.addItem(new BottomNavigationItem(fragmentImg[i], getResources().getString(fragmentName[i])).setActiveColorResource(fragmentColor[i]));
        }
        bnb.setFirstSelectedPosition(0);
        bnb.initialise();
        fragments = getFragments();
        setDefaultFragment();
        bnb.setTabSelectedListener(this);
        imgRight.setBackground(ContextCompat.getDrawable(this, R.drawable.magnifying_glass));
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test
                ToastUtils.showToastS(MainActivity.this, "right click");
                startActivity(new Intent(MainActivity.this, WholeSearchActivity.class));
            }
        });
        getData();
        Intent mIntent = new Intent(this, BaiDuMapServer.class);
        startService(mIntent);
    }

    private void getData() {
        LogUtil.e(AramisUtils.TAG(), "getData()");
        presenter = new MainPresenter(this);
        presenter.getAreaData();
        if (Constant.cityList == null) {
            presenter.loadCityData();
        } else {
            cityAdapter = new CityAdapter(getCurrentActivity(), Constant.cityList);
            spCity.setAdapter(cityAdapter);
        }
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivityPermissionsDispatcher.getExternalStoragePermissionWithCheck(this);
        MainActivityPermissionsDispatcher.getAccssCoarseLocationWithCheck(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        toApartment();
    }

    public void toApartment() {
        bnb.selectTab(1);
        setUnSelected(0);

    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> f = new ArrayList<>();
        f.add(HomeFragment.newInstance("Home"));
        f.add(ApartmentFragment.newInstance("Apartment"));
        f.add(MyFragment.newInstance("Set"));
        return f;
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_main, fragments.get(0));
        transaction.commit();
        setMyTitle(fragmentName[0]);
    }

    @Override
    public void setOnclick() {

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
    public void onTabSelected(int position) {
        if(fragmentName[position]==R.string.HOME){
            isShowSp(true);
            isShowRight(true);
            isShowLogo(true);
        }else if(fragmentName[position]==R.string.APARTMENT){
            isShowSp(true);
            isShowRight(true);
            isShowLogo(false);
        }else if(fragmentName[position]==R.string.SET){
            isShowSp(false);
            isShowRight(false);
            isShowLogo(false);
        }

        //选中
        if (fragments != null) {
            if (position < fragments.size()) {
                setMyTitle(fragmentName[position]);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    transaction.show(fragment);
                } else {
                    transaction.add(R.id.fl_main, fragment);
                }

                transaction.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        //未选中
        setUnSelected(position);
    }

    public void setUnSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                transaction.hide(fragment);
//                transaction.remove(fragment);
                transaction.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void loadCityData() {
        cityAdapter = new CityAdapter(getCurrentActivity(), Constant.cityList);
        spCity.setAdapter(cityAdapter);

    }

    @Override
    public void getArea() {

    }

    @NeedsPermission({Manifest.permission.ACCESS_COARSE_LOCATION})
    void getAccssCoarseLocation() {
    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void getExternalStoragePermission() {
        //获取SD卡书写权限后，创建文件夹
        FYHUtils.getInstence().createFYHFolder();
    }
}

