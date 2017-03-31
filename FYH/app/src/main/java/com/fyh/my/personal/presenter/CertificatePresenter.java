package com.fyh.my.personal.presenter;

import com.fyh.aramis.http.HttpUtils;
import com.fyh.aramis.http.interfaces.DefaultHttpListener;
import com.fyh.aramis.http.interfaces.DefaultObjectHttpListener;
import com.fyh.my.personal.model.CertificateModel;
import com.fyh.base.BasePresenter;
import com.fyh.utils.GsonUtil;
import com.fyh.utils.HttpConstant;
import com.fyh.utils.LogUtil;
import com.fyh.my.personal.view.CertificateView;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public class CertificatePresenter extends BasePresenter<CertificateView> {

    public CertificatePresenter(CertificateView view){
        attachView(view);
    }
    public void getData(){
        HttpUtils.getInstance().jsonPost(HttpConstant.GET_CENTER_CERTIFICATE, null, new DefaultObjectHttpListener<CertificateModel>() {
            @Override
            public void onSuccessParsed(CertificateModel result) {
                   myView.getData(result);
            }
        });
    }
}
