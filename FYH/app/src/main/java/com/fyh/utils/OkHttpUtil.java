package com.fyh.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.fyh.listen.StringListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Cbt on 2016/12/18.
 */
public class OkHttpUtil {
    private static final String TAG = "OkHttpUtil";
    private static final String TIME_OUT = "time out";
    // 超时时间
    public static final int TIMEOUT = 1000 * 30;
    volatile private static OkHttpUtil intance;
    private OkHttpClient client;
    private Handler mHandler;

    private OkHttpUtil() {
        client = new OkHttpClient();
        /**
         * 在这里直接设置连接超时.读取超时，写入超时
         */
        client.newBuilder().connectTimeout(TIMEOUT, TimeUnit.SECONDS).readTimeout(TIMEOUT, TimeUnit.SECONDS).writeTimeout(TIMEOUT, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").build();

                return chain.proceed(request);
            }
        });

        mHandler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpUtil getIntance() {
        synchronized (OkHttpUtil.class) {
            if (intance == null) {
                intance = new OkHttpUtil();
            }
        }
        return intance;
    }

    //同步get请求
    public Response getHttp(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    //异步get请求
    public void getHttp(String url, final StringListener callBack) {
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                deliverDataFailure(request, e, callBack);
            }

            @Override
            public void onResponse(Call call, Response response) {
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    deliverDataFailure(request, e, callBack);
                }
                deliverDataSuccess(result, callBack);

            }
        });
    }

    /**
     *  上传文件
     * @param url
     * @param callBack
     */
    public void upLoadFile(String url, Bitmap bitmap, final StringListener callBack) {
        String fileName ="androidImg.jpg";
        RequestBody body = null;

        body = RequestBody.create(MediaType.parse("application/octet-stream"), ImageDisposeUtil.Bitmap2Bytes(bitmap));
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"username\""),
                        RequestBody.create(null, "HGR"))
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"uploadfile\"; filename=\"" + fileName + "\""), body)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                deliverDataFailure(request, e, callBack);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    deliverDataFailure(request, e, callBack);
                }
                deliverDataSuccess(result, callBack);
            }
        });

    }

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    //post请求
    public void postHttp(String url, Map<String, Object> params, final StringListener callBack) {
        RequestBody body = null;
        if (params == null) {
            params = new HashMap();
        }
        if (Constant.isLogin) {
            params.put("userId", Integer.parseInt(Constant.sessionId));
        }
        //构建表单
        RequestDTO dto = new RequestDTO();
        dto.setData(params);

        body = RequestBody.create(JSON_TYPE, JSON.toJSONString(dto));
        //结果返回
        final Request request = new Request.Builder().url(url).post(body).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                deliverDataFailure(request, e, callBack);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    deliverDataFailure(request, e, callBack);
                }
                deliverDataSuccess(result, callBack);
            }
        });

    }

    //事件分发失败
    private void deliverDataFailure(final Request request, final IOException e, final StringListener callBack) {
        //异步处理
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onError(request, e);
                }
            }
        });
    }

    //事件分发成功
    private void deliverDataSuccess(final String data, final StringListener callBack) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onSusseccData(data);
                }
            }
        });
    }


}
