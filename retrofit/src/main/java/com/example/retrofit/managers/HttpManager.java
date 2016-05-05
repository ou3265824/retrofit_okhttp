package com.example.retrofit.managers;

import android.util.Log;

import com.example.retrofit.BackCall.BaseBackCall;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/4/26.
 */
public class HttpManager {

    private static OkHttpClient okHttpClient=new OkHttpClient();

    /**
     *
     * @param url
     */
    public static String get(String url) {

        Request request=new Request.Builder().url(url).build();
        String message=null;
        try {
            Response response = okHttpClient.newCall(request).execute();
            message=response.body().string();
            Log.i("test",message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static void get2(String url, final BaseBackCall backCall){
        Request request=new Request.Builder().url(url).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                backCall.onFailure();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                backCall.onSucced(response);
//            }
//        });
    }



}
