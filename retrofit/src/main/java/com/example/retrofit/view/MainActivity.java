package com.example.retrofit.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.BackCall.BaseBackCall;
import com.example.retrofit.IUiView.IMainUi;
import com.example.retrofit.R;
import com.example.retrofit.apiserver.ApiServer;
import com.example.retrofit.event.EventBusBean;
import com.example.retrofit.event.EventBusUtils;
import com.example.retrofit.model.bean.ProductDetails;
import com.example.retrofit.model.modelpresenter.ProduModelPresenter;
import com.example.retrofit.model.modelpresenter.ProduModelPresenterImpl;


public class MainActivity extends AppCompatActivity implements IMainUi,EventBusUtils.onMain<EventBusBean>{

    private TextView text;
    private ProduModelPresenter pmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBusUtils.getDefault().register(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pmp=new ProduModelPresenterImpl(this);
        text= (TextView) findViewById(R.id.text);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getprode(ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);

//                getproduct(ApiServer.pid,ApiServer.cid);

//                getproduct(ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);

//                pmp.getProduct1(MainActivity.this,ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);


                getPview1();

//                getPview(ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);

            }
        });
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }

    public void getPview1(){


        pmp.getProduct1(MainActivity.this,ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);
    }

    public void getPview(String pid,String cid,String token,String seed){

        pmp.getProduct1(MainActivity.this,pid,cid,token,seed);

//        pmp.getProduct1(MainActivity.this,ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed);
    }

    private void getproduct(String prodid,String custid ){
        new ProduModelPresenterImpl().getProduct(prodid, custid, new BaseBackCall<ProductDetails>() {
            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onSucced(ProductDetails productDetails) {
//                Toast.makeText(MainActivity.this,productDetails.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getproduct(String prodid,String custid,String token,String seed){
        new ProduModelPresenterImpl().getProduct(getApplicationContext(), prodid, custid, token, seed, new BaseBackCall<ProductDetails>() {

            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onSucced(ProductDetails productDetails) {
                Toast.makeText(MainActivity.this, productDetails.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

//    private String url="http://test.ddearn.com/appservice.svc/";
//
//    public void getprode(String prodid,String custid,String token,String seed){
//        Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
//        ApiServer apiServer=retrofit.create(ApiServer.class);
//        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail1(prodid, custid, token, seed);
//
////        Call<BaseEntity<ProductDetails>> productDetail=apiServer.getProductDetail();
//        productDetail.enqueue(new Callback<BaseEntity<ProductDetails>>() {
//            @Override
//            public void onResponse(Response<BaseEntity<ProductDetails>> response, Retrofit retrofit) {
//                BaseEntity baseEntity=response.body();
////                Toast.makeText(getApplicationContext(),baseEntity.getStateExplain(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),baseEntity.getStateCode()+"---"+baseEntity.getStateExplain()+"---"+baseEntity.getDataObj() , Toast.LENGTH_SHORT).show();
////                ProductDetails productDetails= (ProductDetails) baseEntity.getDataObj();
//
////                Log.i("test",baseEntity+"--");
////                Toast.makeText(getApplicationContext(),productDetails.toString(),Toast.LENGTH_SHORT).show();
////                Log.i("test", response != null ? "ok" : "no");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(getApplicationContext(),t.toString()+"" , Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
////        Call<BaseEntity<List<AppConfig>>> productDetail=apiServer.GetConfigInfo();
////        productDetail.enqueue(new Callback<BaseEntity<List<AppConfig>>>() {
////            @Override
////            public void onResponse(Response<BaseEntity<List<AppConfig>>> response, Retrofit retrofit) {
////                BaseEntity baseEntity=response.body();
////                List<AppConfig> appConfig= (List<AppConfig>) baseEntity.getDataObj();
////
////                Toast.makeText(getApplicationContext(),baseEntity.getDataObj()+"" , Toast.LENGTH_SHORT).show();
////                Log.i("test",baseEntity+"--");
//////                Toast.makeText(getApplicationContext(),baseEntity.getStateCode()+"---"+baseEntity.getStateExplain()+"---"+a,Toast.LENGTH_SHORT).show();
////                Log.i("test", response != null ? "ok" : "no");
////            }
////
////            @Override
////            public void onFailure(Throwable t) {
////
////            }
////        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showText(ProductDetails p) {
        text.setText(p.toString());
    }

    @Override
    public void onEventMainThread(EventBusBean event) {
        if(event.getType().equals("1")){
            text.setText("1212121212121212");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.getDefault().unregister(this);
    }
}
