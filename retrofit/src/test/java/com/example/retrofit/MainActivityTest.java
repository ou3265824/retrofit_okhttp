package com.example.retrofit;

import com.example.retrofit.view.MainActivity;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2016/5/5.
 */
public class MainActivityTest extends TestCase {

    private MainActivity mainActivity;

    public void setUp() throws Exception {
        super.setUp();
        mainActivity = new MainActivity();
    }

    public void testGetPview() throws Exception {
//        assertEquals("11",mainActivity.getPview1(),"11");
    }
    public void testGetPview2() throws Exception {
//        assertEquals("1",mainActivity.getPview(ApiServer.pid,ApiServer.cid,ApiServer.token,ApiServer.seed),"2");
    }

    public void testShowText() throws Exception {

    }
}