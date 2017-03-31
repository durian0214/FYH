package com.fyh.my.personal.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.fyh.R;
import com.fyh.base.BaseActivity;
import com.fyh.my.aboutUs.AboutUsActivity;
import com.fyh.my.personal.presenter.ModifyIconPresenter;
import com.fyh.my.personal.presenter.ModifySexPresenter;
import com.fyh.my.personal.view.ModifyIconView;
import com.fyh.my.personal.view.ModitySexView;
import com.fyh.my.modifyPw.ModifyPasswordActivity;
import com.fyh.releaseHouse.model.UpImgModel;
import com.fyh.releaseHouse.presenter.UpLoadImgPresenter;
import com.fyh.releaseHouse.view.UpLoadImgView;
import com.fyh.utils.Constant;
import com.fyh.utils.GetPathFromUri4kitkat;
import com.fyh.utils.GlideUtil;

/**
 * 个人信息
 */
public class PersonalDetailsActivity extends BaseActivity implements View.OnClickListener ,ModifyIconView,UpLoadImgView,ModitySexView {
    private RelativeLayout rlHead, rlRealName, rlAccount, rlAboutUS, rlModifyPassword;
    private Button btnOutLogin;
    private Switch switchGender;
    private ImageView imgIcon;
    private ModifySexPresenter updateSexPresenter ;
    private int sex = Constant.GENDER;
    //上传图片
    private UpLoadImgPresenter upLoadImgPresenter;
    //url 保存
    private ModifyIconPresenter modifyIconPresenter;
    private String iconUrl = "";
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_details;
    }

    @Override
    public void initView() {
        updateSexPresenter = new ModifySexPresenter(this);
        upLoadImgPresenter = new UpLoadImgPresenter(this);
        modifyIconPresenter = new ModifyIconPresenter(this);
        setMyTitle(R.string.PERSONAL_DETAILS);
        imgIcon= getId(R.id.img_personal_details_icon);
        rlHead = getId(R.id.rl_personal_details_head_portrit);
        rlRealName = getId(R.id.rl_personal_details_real_name_authentication);
        rlAccount = getId(R.id.rl_personal_details_account_information);
        rlAboutUS = getId(R.id.rl_personal_details_about_us);
        btnOutLogin = getId(R.id.btn_personal_details_out_login);
        switchGender = getId(R.id.switch_personal_details_gender);
        rlModifyPassword = getId(R.id.rl_personal_details_modify_password);
        if(sex ==0){
            switchGender.setChecked(false);
        }else{
            switchGender.setChecked(true);
        }
        GlideUtil.getIntance().loaderImg(this,imgIcon,Constant.ICON_URL);
    }

    @Override
    public void setOnclick() {
        rlHead.setOnClickListener(this);
        rlRealName.setOnClickListener(this);
        rlAccount.setOnClickListener(this);
        rlAboutUS.setOnClickListener(this);
        rlModifyPassword.setOnClickListener(this);
        btnOutLogin.setOnClickListener(this);
        switchGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    sex = 1;
                }else{
                    sex = 0;
                }
                Constant.GENDER = sex;
                updateSexPresenter.updateSex(sex);
            }
        });
    }

    @Override
    public <T extends BaseActivity> T getCurrentActivity() {
        return (T) this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_personal_details_head_portrit:
                getPic();
                break;
            case R.id.rl_personal_details_real_name_authentication:
                break;
            case R.id.rl_personal_details_account_information:
                intentJump(getCurrentActivity(), AccountInfoActivity.class, null);
                break;
            case R.id.rl_personal_details_about_us:
                intentJump(getCurrentActivity(),AboutUsActivity.class,null);
                break;
            case R.id.btn_personal_details_out_login:
                Constant.isLogin =false;
                this.finish();
                break;
            case R.id.rl_personal_details_modify_password:
                intentJump(getCurrentActivity(), ModifyPasswordActivity.class, null);
                break;
        }
    }

    @Override
    public void updateSex() {

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
    public void upLoadSuccess(UpImgModel model) {
        iconUrl = model.getPath();
        modifyIconPresenter.modifyIcon(iconUrl);

    }

    @Override
    public void modifyIcon() {
        Constant.ICON_URL = iconUrl;
        GlideUtil.getIntance().loaderImg(this,imgIcon,Constant.ICON_URL);
    }
}
