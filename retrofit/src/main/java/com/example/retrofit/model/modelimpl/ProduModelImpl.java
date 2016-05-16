package com.example.retrofit.model.modelimpl;

import android.content.Context;
import android.util.Log;

import com.example.retrofit.backcall.BaseBackCall;
import com.example.retrofit.apiserver.ApiServer;
import com.example.retrofit.model.bean.BaseEntity;
import com.example.retrofit.model.bean.ProductDetails;
import com.example.retrofit.managers.HttpLoader;
import com.example.retrofit.apiserver.Chek;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/4/28.
 */
public class ProduModelImpl implements ProduModel{

    @Override
    public void getProduct(String pid, String cid, final BaseBackCall<ProductDetails> backCall) {
        ApiServer apiServer=HttpLoader.getRetrofit().create(ApiServer.class);
        Call<BaseEntity<ProductDetails>> call=apiServer.getProductDetail1(pid,cid, Chek.getToken(),Chek.getSeed());
        call.enqueue(new Callback<BaseEntity<ProductDetails>>() {
            @Override
            public void onResponse(Call<BaseEntity<ProductDetails>> call, Response<BaseEntity<ProductDetails>> response) {
                BaseEntity<ProductDetails> baseEntity= (BaseEntity<ProductDetails>) response.body();
                ProductDetails productDetails=(ProductDetails)baseEntity.getDataObj();
                Log.i("test",baseEntity.getDataObj()+"--");
                backCall.onSucced(productDetails);
            }

            @Override
            public void onFailure(Call<BaseEntity<ProductDetails>> call, Throwable t) {
                backCall.onFailure(t);
            }
        });
//        Call<BaseEntity<ProductDetails>> call=apiServer.getProductDetail2(pid, cid);
//        call.enqueue(new Callback<BaseEntity<ProductDetails>>() {
//            @Override
//            public void onResponse(Response<BaseEntity<ProductDetails>> response, Retrofit retrofit) {
//                BaseEntity<ProductDetails> baseEntity= (BaseEntity<ProductDetails>) response.body();
//                ProductDetails productDetails=(ProductDetails)baseEntity.getDataObj();
//                backCall.onSucced(productDetails);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                backCall.onFailure(t);
//            }
//        });
    }

    @Override
    public void getProduct(Context context, String pid, String cid, String token, String seed, final BaseBackCall<ProductDetails> backCall) {
        ApiServer apiServer=HttpLoader.getRetrofit().create(ApiServer.class);
        Call<BaseEntity<ProductDetails>> call=apiServer.getProductDetail1(pid,cid, token,seed);
        call.enqueue(new Callback<BaseEntity<ProductDetails>>() {
            @Override
            public void onResponse(Call<BaseEntity<ProductDetails>> call, Response<BaseEntity<ProductDetails>> response) {
                BaseEntity<ProductDetails> baseEntity= (BaseEntity<ProductDetails>) response.body();
                ProductDetails productDetails=(ProductDetails)baseEntity.getDataObj();
                Log.i("test",baseEntity.getStateCode()+"----"+baseEntity.getDataObj()+"--");
                backCall.onSucced(productDetails);
            }

            @Override
            public void onFailure(Call<BaseEntity<ProductDetails>> call, Throwable t) {
                backCall.onFailure(t);
            }
        });
    }
}
