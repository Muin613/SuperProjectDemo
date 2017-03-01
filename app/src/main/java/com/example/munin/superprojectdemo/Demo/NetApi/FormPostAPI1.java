package com.example.munin.superprojectdemo.Demo.NetApi;

import com.example.munin.superprojectdemo.Demo.Model.Model2;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Munin on 2017/3/1.
 */
public interface FormPostAPI1 {
    @POST("getorder")
    @FormUrlEncoded
    Call<Model2> getData(@FieldMap Map<String, Object> params);
}
