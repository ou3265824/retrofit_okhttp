package com.example.retrofit.model.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class ProductDetails extends BaseEntity{

    private List<ProductDetail> ProductDetail;
    private List<ProductDetail> ProductDetail2;
    private List<ProductDetail> ProductDetail3;

    public List<com.example.retrofit.model.bean.ProductDetail> getProductDetail() {
        return ProductDetail;
    }

    public void setProductDetail(List<com.example.retrofit.model.bean.ProductDetail> productDetail) {
        ProductDetail = productDetail;
    }

    public List<com.example.retrofit.model.bean.ProductDetail> getProductDetail2() {
        return ProductDetail2;
    }

    public void setProductDetail2(List<com.example.retrofit.model.bean.ProductDetail> productDetail2) {
        ProductDetail2 = productDetail2;
    }

    public List<com.example.retrofit.model.bean.ProductDetail> getProductDetail3() {
        return ProductDetail3;
    }

    public void setProductDetail3(List<com.example.retrofit.model.bean.ProductDetail> productDetail3) {
        ProductDetail3 = productDetail3;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "ProductDetail=" + ProductDetail +
                ", ProductDetail2=" + ProductDetail2 +
                ", ProductDetail3=" + ProductDetail3 +
                '}';
    }
}
