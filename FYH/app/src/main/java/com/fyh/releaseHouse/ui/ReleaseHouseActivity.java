package com.fyh.releaseHouse.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fyh.R;
import com.fyh.apartment.adapter.ConfigurationAdapter;
import com.fyh.releaseHouse.adapter.DecorateAdapter;
import com.fyh.releaseHouse.adapter.DoorModelAdapter;
import com.fyh.releaseHouse.adapter.HeatingAdapter;
import com.fyh.home.adapter.LabelAdapter;
import com.fyh.releaseHouse.adapter.LineAdapter;
import com.fyh.submitOrder.pay.adapter.PaymentAdapter;
import com.fyh.releaseHouse.adapter.StationAdapter;
import com.fyh.releaseHouse.adapter.TowardAdapter;
import com.fyh.releaseHouse.adapter.UpLoadImgAdapter;
import com.fyh.apartment.bean.ApartmentRoomExtendBean;
import com.fyh.bean.PicInfoBean;
import com.fyh.bean.RoomBean;
import com.fyh.bean.RoomRequirementsBean;
import com.fyh.bean.SuiteBean;
import com.fyh.listen.onRecyclerViewItemClickListener;
import com.fyh.apartment.model.ConfigurationModel;
import com.fyh.releaseHouse.model.DicModel;
import com.fyh.releaseHouse.model.LineModel;
import com.fyh.releaseHouse.model.StationModel;
import com.fyh.releaseHouse.model.UpImgModel;
import com.fyh.room.presenter.GetHouseTypePresenter;
import com.fyh.releaseHouse.presenter.HouseInfoPresenter;
import com.fyh.releaseHouse.presenter.ReleaseHousePresenter;
import com.fyh.releaseHouse.presenter.UpLoadImgPresenter;
import com.fyh.base.BaseActivity;
import com.fyh.utils.GetPathFromUri4kitkat;
import com.fyh.utils.ToastUtils;
import com.fyh.utils.Utils;
import com.fyh.releaseHouse.view.GetHouseInfoView;
import com.fyh.releaseHouse.view.GetHouseTypeView;
import com.fyh.releaseHouse.view.ReleaseHouseView;
import com.fyh.releaseHouse.view.UpLoadImgView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Durian
 * 2017-2017/1/19
 * 添加房源
 */
public class ReleaseHouseActivity extends BaseActivity implements View.OnClickListener, GetHouseInfoView, ReleaseHouseView, UpLoadImgView,GetHouseTypeView {
    //添加图片
    private RecyclerView rvImg;
    //小区名称
    private EditText edtCommunityName;
    //地址
    private EditText edtAddress;
    //门牌号
    private EditText edtFloorNo, edtUnit, edtNo;
    //户型
    private Spinner spDoorModel;
    //面积
    private EditText edtArea;
    //朝向
    private Spinner spToward;
    //楼层
    private EditText edtInFloor, edtAllFloor;
    //租金
    private EditText edtRent;
    //保证金
    private EditText edtMargin;
    //付费方式
    private Spinner spPay;
    //装修风格
    private Spinner spDecorate;
    //房间配置
    private RecyclerView rvConfiguration;
    //供暖方式
    private Spinner spHeating;
    //地铁
    private Spinner spLine, spStation;
    //公寓标签
    private RecyclerView rvLabel;
    //周边环境
    private EditText edtEnvironment;
    //交通情况
    private EditText edtTraffic;
    //提交
    private Button btnSubmit;
    //获取字典
    private HouseInfoPresenter presenter;
    //获取户型
    private GetHouseTypePresenter getHouseTypePresenter;
    //发布房源
    private ReleaseHousePresenter releaseHousePresenter;
    //上传图片
    private UpLoadImgPresenter upLoadImgPresenter;
    //适配器
    LabelAdapter labelAdapter;
    DecorateAdapter decorateAdapter;
    HeatingAdapter heatingAdapter;
    PaymentAdapter paymentAdapter;
    TowardAdapter towardAdapter;
    LineAdapter lineAdapter;
    StationAdapter stationAdapter;
    UpLoadImgAdapter upLoadImgAdapter;
    DoorModelAdapter doorModelAdapter;
    ConfigurationAdapter configurationAdapter ;
    //集合
    List<DicModel> labelLists = new ArrayList<>();
    List<DicModel> decorateLists = new ArrayList<>();
    List<DicModel> heatingLists = new ArrayList<>();
    List<DicModel> paymentLists = new ArrayList<>();
    List<DicModel> towardLists = new ArrayList<>();
    List<DicModel> roomTypeLists = new ArrayList<>();
    List<ConfigurationModel> configurationLists = new ArrayList<>();
    List<LineModel> lineLists = new ArrayList<>();
    List<PicInfoBean> picLists = new ArrayList<>();
    List<StationModel> stationList = new ArrayList<>();
    private int towardId;
    private int payId;
    private int decorateId;
    private int heatingId;
    private int lineId;
    private int stationId;
    private int roomTypeId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_release_house;
    }

    @Override
    public void initView() {
        setMyTitle(R.string.RELEASE_HOUSE_TITLE);
        presenter = new HouseInfoPresenter(this);
        getHouseTypePresenter = new GetHouseTypePresenter(this);
        releaseHousePresenter = new ReleaseHousePresenter(this);
        upLoadImgPresenter = new UpLoadImgPresenter(this);
        rvImg = getId(R.id.rv_release_house_img);
        edtCommunityName = getId(R.id.edt_release_house_community_name);
        edtAddress = getId(R.id.edt_release_house_address);
        edtFloorNo = getId(R.id.edt_release_house_floor_no);
        edtUnit = getId(R.id.edt_release_house_unit);
        edtNo = getId(R.id.edt_release_house_no);
        spDoorModel = getId(R.id.sp_release_house_door_model);
        edtArea = getId(R.id.edt_release_house_area);
        spToward = getId(R.id.sp_release_house_toward);
        edtInFloor = getId(R.id.edt_release_house_in_floor);
        edtAllFloor = getId(R.id.edt_release_house_all_floor);
        edtRent = getId(R.id.edt_release_house_rent);
        edtMargin = getId(R.id.edt_release_house_margin);
        spPay = getId(R.id.sp_release_house_pay);
        spDecorate = getId(R.id.sp_release_house_decorate);
        rvConfiguration = getId(R.id.rv_release_house_configuration);
        spHeating = getId(R.id.sp_release_house_heating);
        spLine = getId(R.id.sp_release_house_line);
        spStation = getId(R.id.sp_release_house_station);
        rvLabel = getId(R.id.rv_release_house_label);
        edtEnvironment = getId(R.id.edt_release_house_environment);
        edtTraffic = getId(R.id.edt_release_house_traffic);
        btnSubmit = getId(R.id.btn_release_house_submit);
        setAdapter();
        setSPListen();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String message) {
        getPic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 设置适配器
     */
    private void setAdapter() {
        labelAdapter = new LabelAdapter(this);
        decorateAdapter = new DecorateAdapter(this);
        heatingAdapter = new HeatingAdapter(this);
        paymentAdapter = new PaymentAdapter(this);
        towardAdapter = new TowardAdapter(this);
        lineAdapter = new LineAdapter(this);
        stationAdapter = new StationAdapter(this);
        upLoadImgAdapter = new UpLoadImgAdapter(this);
        doorModelAdapter = new DoorModelAdapter(this);
        configurationAdapter = new ConfigurationAdapter(this);
        spToward.setAdapter(towardAdapter);
        spPay.setAdapter(paymentAdapter);
        spDecorate.setAdapter(decorateAdapter);
        spHeating.setAdapter(heatingAdapter);
        spLine.setAdapter(lineAdapter);
        spStation.setAdapter(stationAdapter);
        spDoorModel.setAdapter(doorModelAdapter);
        rvImg.setLayoutManager(Utils.getTableManager(this, 5));
        rvConfiguration.setLayoutManager(Utils.getTableManager(this, 4));
        rvLabel.setLayoutManager(Utils.getTableManager(this, 4));
        rvLabel.setAdapter(labelAdapter);
        rvImg.setAdapter(upLoadImgAdapter);
        rvConfiguration.setAdapter(configurationAdapter);
    }

    /**
     * 設置sp监听
     */


    private void setSPListen() {
        spToward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                towardId = Integer.parseInt(towardLists.get(position).getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spPay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                payId = Integer.parseInt(paymentLists.get(position).getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spDecorate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                decorateId = Integer.parseInt(decorateLists.get(position).getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spHeating.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                heatingId = Integer.parseInt(heatingLists.get(position).getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spLine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lineId = lineLists.get(position).getPid();
                presenter.getStation(lineLists.get(position).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spStation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stationId = stationList.get(position).getPid();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spDoorModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                roomTypeId = Integer.parseInt(roomTypeLists.get(position).getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        configurationAdapter.setConfigurationOnClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                boolean status = configurationLists.get(position).isCheck();
                configurationLists.get(position).setCheck(!status);
                configurationAdapter.notifyDataSetChanged();
            }
        });
        labelAdapter.setConfigurationOnClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                boolean status = labelLists.get(position).isCheck();
                labelLists.get(position).setCheck(!status);
                labelAdapter.notifyDataSetChanged();
            }
        });
        getData();
    }

    private void getData() {
        presenter.getToward();
        presenter.getConfiguration();
        presenter.getDecorate();
//        presenter.getHeating();
        presenter.getLabel();
        presenter.getLine();
        presenter.getPayment();
        getHouseTypePresenter.getHouseType();

    }

    @Override
    public void setOnclick() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_release_house_submit:
                ApartmentRoomExtendBean apartmentRoomExtendBean = new ApartmentRoomExtendBean();
                RoomBean roomBean = new RoomBean();
                RoomRequirementsBean roomRequirementsBean = new RoomRequirementsBean();
                SuiteBean suiteBean = new SuiteBean();
                String cellName = edtCommunityName.getText().toString();
                String address = edtAddress.getText().toString();
                String building = edtFloorNo.getText().toString();
                String unit = edtUnit.getText().toString();
                String inFloor = edtInFloor.getText().toString();
                String allFloor = edtAllFloor.getText().toString();
                String number = edtNo.getText().toString();
                String  rentS = edtRent.getText().toString();
                String suiteSizeS = edtArea.getText().toString();
                String environmental = edtEnvironment.getText().toString();
                String isUsed = edtTraffic.getText().toString();
                String betS = edtMargin.getText().toString();
                if (picLists == null) {ToastUtils.showToastS(getCurrentActivity(), "请添加图片");return;}
                if (cellName.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入小区名称");return;}
                if (address.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入地址");return;}
                if (building.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入楼号");return;}
                if (unit.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入单元");return;}
                if (inFloor.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入所在楼层");return;}
                if (allFloor.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入全部楼层");return;}
                if (number.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入门牌号");return;}
                if (rentS.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入租金");return;}
                if (betS.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入保证金");return;}
                if (suiteSizeS.isEmpty()) {ToastUtils.showToastS(getCurrentActivity(), "请输入面积");return;}
                BigDecimal suiteSize = new BigDecimal(suiteSizeS);
                BigDecimal rent = new BigDecimal(rentS);
                int bet = Integer.parseInt(betS);
                roomBean.setRent(rent);
                roomBean.setBet(bet);
                roomBean.setPay(payId);
                apartmentRoomExtendBean.setOrientation(String.valueOf(towardId));
                //地铁线路
                apartmentRoomExtendBean.setSubway(lineId);
                //地铁站
                apartmentRoomExtendBean.setSite(stationId);
                //公寓标签
                apartmentRoomExtendBean.setTags("");
                apartmentRoomExtendBean.setIsUsed(isUsed);
                apartmentRoomExtendBean.setEnvironmental(environmental);
                apartmentRoomExtendBean.setDecorating(String.valueOf(decorateId));
                //房间配置
                for (ConfigurationModel bean :configurationLists) {
                }
                suiteBean.setConfigure("");
                suiteBean.setSuiteSize(suiteSize);
                suiteBean.setCellName(cellName);
                suiteBean.setAddress(address);
                suiteBean.setPicList(picLists);
                suiteBean.setNumber(String.valueOf(number));
                suiteBean.setUnit(String.valueOf(unit));
                //户型
                suiteBean.setHouseType(String.valueOf(roomTypeId));
                suiteBean.setBuilding(String.valueOf(building));
                suiteBean.setFloor(inFloor);
                suiteBean.setFloorNum(Integer.parseInt(allFloor));
                releaseHousePresenter.releaseHouse(apartmentRoomExtendBean, roomBean, roomRequirementsBean, suiteBean);
                break;
        }
    }

    public final static int ALBUM_REQUEST_CODE = 1;

    public void getPic() {
        Intent intent = new Intent();
        intent.setType("image/*");//可选择图片视频
        //修改为以下两句代码
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//使用以上这种模式，并添加以上两句
        startActivityForResult(intent, ALBUM_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == ALBUM_REQUEST_CODE) {
                try {
                    Uri uri = data.getData();
                    String filePath = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(getCurrentActivity(), uri)) {
                        filePath = GetPathFromUri4kitkat.getPath(getCurrentActivity(), uri);
                    } else {
                        String[] projection = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                        cursor.moveToFirst();
                        filePath = cursor.getString(column_index);
                    }
                    upLoadImgPresenter.upLoadImg(filePath);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void getToward(List<DicModel> list) {
        towardLists.addAll(list);
        towardAdapter.setList(list);
    }

    @Override
    public void getPay(List<DicModel> list) {
        paymentLists.addAll(list);
        paymentAdapter.setList(list);
    }

    @Override
    public void getDecorate(List<DicModel> list) {
        decorateLists.addAll(list);
        decorateAdapter.setList(list);
    }

    @Override
    public void getConfiguration(List<ConfigurationModel> list) {
        configurationLists.addAll(list);
        configurationAdapter.setList(list);
    }

    @Override
    public void getHeating(List<DicModel> list) {
        heatingLists.addAll(list);
        heatingAdapter.setList(list);
    }

    @Override
    public void getLine(List<LineModel> list) {
        lineLists.addAll(list);
        lineAdapter.setList(list);
    }

    @Override
    public void getStation(List<StationModel> list) {
        stationList.clear();
            stationList.addAll(list);
            stationAdapter.setNewList(list);
    }
    @Override
    public void getLabel(List<DicModel> list) {
        labelLists.addAll(list);
        labelAdapter.setList(list);
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
    public void releaseSuccess() {
        ToastUtils.showToastS(getCurrentActivity(),"发布成功");
        this.finish();
    }

    @Override
    public void upLoadSuccess(UpImgModel model) {
        PicInfoBean bean = new PicInfoBean();
        bean.setPicUrl(model.getPath());
        upLoadImgAdapter.addBean(bean);
    }



    @Override
    public void getHouseType(List<DicModel> list) {
        roomTypeLists.addAll(list);
        doorModelAdapter.setList(list);
    }
}
