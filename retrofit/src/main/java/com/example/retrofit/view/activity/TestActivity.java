package com.example.retrofit.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.apiserver.ApiServer;
import com.example.retrofit.managers.HttpManager;

public class TestActivity extends AppCompatActivity {

    private TextView text2;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        text2 = (TextView) findViewById(R.id.text2);
        text2.setText("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,MyActivity.class));
            }
        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////                get();
////                get2();
//            }
//        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    String s = null;

    private void get() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                s= HttpManager.get(ApiServer.url);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text2.setText(s);
                        Toast.makeText(TestActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();
    }

//    private void get2() {
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
//                HttpManager.get2(ApiServer.url, new BaseBackCall() {
//
//                    @Override
//                    public void onFailure() {
//
//                    }
//
//                    @Override
//                    public void onSucced(Response succed) {
//                        try {
//                            final String baseEntity = succed.body().string();
////                            runOnUiThread(new Runnable() {
////                                @Override
////                                public void run() {
//                            text2.setText(baseEntity);
//                            Toast.makeText(TestActivity.this, baseEntity, Toast.LENGTH_SHORT).show();
////                                }
////                            });
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                });
////            }
////        }).start();
//
//    }


}
