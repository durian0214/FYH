package com.fyh.releaseHouse.presenter;

import com.fyh.listen.StringListener;
import com.fyh.releaseHouse.model.UpImgModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.utils.OkHttpUtil;
import com.fyh.utils.ScaleImgUtil;
import com.fyh.releaseHouse.view.UpLoadImgView;

import java.io.IOException;

import okhttp3.Request;

/**
 * Durian
 * 2017-2017/1/23
 */
public class UpLoadImgPresenter extends BasePresenter<UpLoadImgView> {
    public UpLoadImgPresenter(UpLoadImgView view) {
        attachView(view);
    }

    public void upLoadImg(String filePath) {
        OkHttpUtil.getIntance().upLoadFile(HttpConstant.UP_LOAD_IMG, ScaleImgUtil.equalRatioScale(filePath,200,200), new StringListener() {
            @Override
            public void onSusseccData(String msg) {
                UpImgModel model = GsonUtil.getIntance().parseObject(msg, UpImgModel.class);
                    myView.upLoadSuccess(model);
                    LogUtil.i("图片上传=", msg);
            }

            @Override
            public void onError(Request request, IOException e) {
                myView.netError("网络异常");
            }
        });
    }
}
