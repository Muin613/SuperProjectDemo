package com.example.munin.superprojectdemo.Demo.NetApi;

import com.example.munin.superprojectdemo.Demo.Model.Model2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Munin on 2017/3/1.
 */
public interface FromPostAPI {
    @POST("getorder")
    @FormUrlEncoded
    Call<Model2> getData(@Field("cid")String cid,@Field("paymode")String paymode,@Field("amount")double amount,@Field("token")String token);
}
