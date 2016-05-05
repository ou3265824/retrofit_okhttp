package com.example.retrofit.Builder;

import com.example.retrofit.apiserver.Chek;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/4/27.
 */
public class HeaderInterceptor implements Interceptor{

    private String KOTEN="token";
    private String SEED="seed";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request=chain.request().newBuilder()
                .addHeader(KOTEN,Chek.getToken())
                .addHeader(SEED, Chek.getSeed()).build();

        return chain.proceed(request);
    }



}
