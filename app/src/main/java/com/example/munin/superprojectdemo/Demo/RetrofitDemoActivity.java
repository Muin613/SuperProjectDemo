package com.example.munin.superprojectdemo.Demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.munin.superprojectdemo.Base.Tools.Common.Constants;
import com.example.munin.superprojectdemo.Base.Tools.MD5Utils;
import com.example.munin.superprojectdemo.Base.Tools.NetUtils.Net.Http;
import com.example.munin.superprojectdemo.Base.Tools.NetUtils.NetInterface.NetDataStateCallback;
import com.example.munin.superprojectdemo.Demo.Model.Model;
import com.example.munin.superprojectdemo.Demo.Model.Model2;
import com.example.munin.superprojectdemo.Demo.NetApi.HttpCallback1;
import com.example.munin.superprojectdemo.R;
import java.util.HashMap;


import retrofit2.Retrofit;

/**
 * Created by Munin on 2017/3/1.
 */
public class RetrofitDemoActivity extends Activity implements NetDataStateCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_test_demo);

    }

    public void click(View view) {
//        Post1();
//        Post2();
//        Post3();
        Post4();
    }


    //直接请求
    public void Post1() {
        Retrofit retrofit = new Http().getRetrofit(Constants.POST_URL);
        new HttpCallback1(this).getData(retrofit, 1);
    }

    //json请求
    void Post2() {
        Retrofit retrofit = new Http().getRetrofit(Constants.POST_URL1);
        new HttpCallback1(this).getData1(retrofit, "39", 2);
    }

    //表单请求
    void Post3() {
        Retrofit retrofit = new Http().getRetrofit(Constants.POST_URL2);
        new HttpCallback1(this).getData2(retrofit, "39", "androidwx", 1, MD5Utils.MD5Encode("39" + "androidwxddcwxpay", "UTF-8"), 3);
    }

    void Post4() {
        Retrofit retrofit = new Http().getRetrofit(Constants.POST_URL2);
        HashMap<String, Object> map = new HashMap<>();
        map.put("cid", "39");
        map.put("paymode", "androidwx");
        map.put("amount", 1);
        map.put("token", MD5Utils.MD5Encode("39" + "androidwxddcwxpay", "UTF-8"));
        new HttpCallback1(this).getData21(retrofit, map, 4);
    }

    @Override
    public void getDataIsSuccess(boolean b, int tag) {
        System.out.println("请求状态" + b + tag);
    }

    @Override
    public void getData(Object object, int tag) {
        if (tag == 3 || tag == 4)
            System.out.println("反馈:" + (Model2) object);
        if (tag == 1)
            System.out.println("反馈:" + (Model) object);
    }

}
