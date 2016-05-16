package com.example.retrofit.model.modelimpl;

import android.content.Context;

import com.example.retrofit.backcall.BaseBackCall;
import com.example.retrofit.model.bean.ProductDetails;

/**
 * Created by Administrator on 2016/4/28.
 */
public interface ProduModel {

    public void getProduct(String pid, String cid, BaseBackCall<ProductDetails> backCall);

    public void getProduct(Context context, String pid, String cid, String token, String seed, BaseBackCall<ProductDetails> backCall);

}
