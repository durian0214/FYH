package com.fyh.my;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fyh.R;
import com.fyh.bean.LoginBean;
import com.fyh.my.collection.CollectionActivity;
import com.fyh.my.personal.ui.PersonalDetailsActivity;
import com.fyh.my.reservation.ReservationActivity;
import com.fyh.my.login.LoginActivity;
import com.fyh.releaseHouse.ui.ReleaseHouseListActivity;
import com.fyh.base.BaseFragment;
import com.fyh.utils.Constant;
import com.fyh.utils.GlideUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Cbt on 2016/12/20.
 */
public class MyFragment extends BaseFragment implements View.OnClickListener {
    private ImageView ivIcon;
    private TextView tvName;
    private Button btnReservation, btnNoPayment, btnEvaluate;
    private RelativeLayout rlContract, rlKey, rlMessage, rlColloct,rlReleaseHouse;

    public static MyFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(LoginBean login) {
        isShowLogin();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ivIcon = (ImageView) view.findViewById(R.id.iv_fragment_set_icon);
        tvName = (TextView) view.findViewById(R.id.tv_fragment_set_name);
        btnReservation = (Button) view.findViewById(R.id.btn_set_my_reservation);
        btnNoPayment = (Button) view.findViewById(R.id.btn_set_no_payment);
        btnEvaluate = (Button) view.findViewById(R.id.btn_set_to_evaluate);
        rlContract = (RelativeLayout) view.findViewById(R.id.rl_set_contract);
        rlKey = (RelativeLayout) view.findViewById(R.id.rl_set_my_key);
        rlMessage = (RelativeLayout) view.findViewById(R.id.rl_set_my_message);
        rlColloct = (RelativeLayout) view.findViewById(R.id.rl_set_my_colloct);
        rlReleaseHouse = (RelativeLayout)view.findViewById(R.id.rl_set_release_house);
        rlKey.setVisibility(View.GONE);
        btnNoPayment.setVisibility(View.GONE);
        btnEvaluate.setVisibility(View.GONE);
        EventBus.getDefault().register(this);
    }
    public void isShowLogin(){
        if(Constant.isLogin){
            tvName.setText(Constant.ACCOUNT);

            GlideUtil.getIntance().loaderImg(getContext(),ivIcon,Constant.ICON_URL,R.drawable.icon_user);
        }else{
            tvName.setText("请登录");
            ivIcon.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.icon_user));
        }

    }
    @Override
    protected void setOnClick() {
        ivIcon.setOnClickListener(this);
        btnReservation.setOnClickListener(this);
        btnNoPayment.setOnClickListener(this);
        btnEvaluate.setOnClickListener(this);
        rlContract.setOnClickListener(this);
        rlKey.setOnClickListener(this);
        rlMessage.setOnClickListener(this);
        rlColloct.setOnClickListener(this);
        rlReleaseHouse.setOnClickListener(this);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_set;
    }

    @Override
    public void onResume() {
        super.onResume();
        isShowLogin();


    }

    @Override
    public void onClick(View v) {
        if (!Constant.isLogin) {
            intentJump(getActivity(), LoginActivity.class, null);
            return;
        }
        switch (v.getId()) {
            case R.id.iv_fragment_set_icon:
                intentJump(getActivity(), PersonalDetailsActivity.class, null);
                break;
            case R.id.btn_set_my_reservation:
                intentJump(getActivity(), ReservationActivity.class, null);
                break;
            case R.id.btn_set_no_payment:
                break;
            case R.id.btn_set_to_evaluate:
                break;
            case R.id.rl_set_contract:
                break;
            case R.id.rl_set_my_message:
                break;
            case R.id.rl_set_my_colloct:
                intentJump(getActivity(),CollectionActivity.class,null);
                break;
            case R.id.rl_set_release_house:
                intentJump(getActivity(),ReleaseHouseListActivity.class,null);
                break;
        }
    }
}
