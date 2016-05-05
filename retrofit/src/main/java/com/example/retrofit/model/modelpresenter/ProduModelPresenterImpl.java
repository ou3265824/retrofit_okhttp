package com.example.retrofit.model.modelpresenter;

import android.content.Context;

import com.example.retrofit.BackCall.BaseBackCall;
import com.example.retrofit.IUiView.IMainUi;
import com.example.retrofit.model.bean.ProductDetails;
import com.example.retrofit.model.modelimpl.ProduModel;
import com.example.retrofit.model.modelimpl.ProduModelImpl;

/**
 * Created by Administrator on 2016/4/28.
 */
public class ProduModelPresenterImpl implements ProduModelPresenter{

    private ProduModel produModel;
    private IMainUi iMainUi;

    public ProduModelPresenterImpl() {
        produModel=new ProduModelImpl();
    }

    public ProduModelPresenterImpl(IMainUi iMainUi) {
        this.produModel =new ProduModelImpl();
        this.iMainUi = iMainUi;
    }

    public void getProduct(String pid,String cid,BaseBackCall<ProductDetails> backCall){
        produModel.getProduct(pid,cid,backCall);
    }

    public void getProduct(Context context,String pid,String cid,String token,String seed,BaseBackCall<ProductDetails> backCall){
        produModel.getProduct(context,pid,cid,token,seed,backCall);
    }

    @Override
    public void getProduct1(Context context, String pid, String cid, String token, String seed) {
        produModel.getProduct(context, pid, cid, token, seed, new BaseBackCall<ProductDetails>() {
            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onSucced(ProductDetails productDetails) {
                iMainUi.showText(productDetails);
            }
        });
    }
}
