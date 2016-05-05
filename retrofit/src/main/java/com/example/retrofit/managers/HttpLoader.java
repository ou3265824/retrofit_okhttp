package com.example.retrofit.managers;

import com.example.retrofit.Builder.HeaderInterceptor;
import com.example.retrofit.Builder.LoggingInterceptor;
import com.example.retrofit.apiserver.Server;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/4/27.
 */
public class HttpLoader {


    public static Retrofit getRetrofit() {
        /**
         * 拦截器
         */
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor())
                .retryOnConnectionFailure(true).connectTimeout(Server.OVER_TIME, TimeUnit.SECONDS)
                .addNetworkInterceptor(new HeaderInterceptor()).build();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Server.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        return retrofit;
    }
}
