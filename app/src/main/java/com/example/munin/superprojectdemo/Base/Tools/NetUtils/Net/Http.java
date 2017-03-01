package com.example.munin.superprojectdemo.Base.Tools.NetUtils.Net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Munin on 2017/3/1.
 */
public class Http {


   public  Retrofit getRetrofit(String url){
        return new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
