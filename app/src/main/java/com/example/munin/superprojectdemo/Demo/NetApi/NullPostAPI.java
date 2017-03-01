package com.example.munin.superprojectdemo.Demo.NetApi;

import com.example.munin.superprojectdemo.Demo.Model.Model;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Munin on 2017/3/1.
 */
public interface NullPostAPI {
    @POST("wap")
    Call<Model>getData();
}
