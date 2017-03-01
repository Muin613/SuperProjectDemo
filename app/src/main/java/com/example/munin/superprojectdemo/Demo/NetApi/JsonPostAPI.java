package com.example.munin.superprojectdemo.Demo.NetApi;

import com.example.munin.superprojectdemo.Demo.Model.Model1;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Munin on 2017/3/1.
 */
public interface JsonPostAPI {
    @POST("checkinfo")
    Call<Model1> getData(@Body RequestBody requestBody);
}
