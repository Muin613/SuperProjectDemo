package com.example.munin.superprojectdemo.Demo.NetApi;


import com.example.munin.superprojectdemo.Demo.Model.Model;
import com.example.munin.superprojectdemo.Demo.Model.Model1;
import com.example.munin.superprojectdemo.Demo.Model.Model2;
import com.google.gson.Gson;
import com.example.munin.superprojectdemo.Base.Tools.NetUtils.NetInterface.*;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Munin on 2017/3/1.
 */
public class HttpCallback1 {
    private NetDataStateCallback listener;

    public HttpCallback1(NetDataStateCallback listener) {
        this.listener = listener;
    }

    //分装方法（N条）
    public void getData(Retrofit retrofit, final int tag) {
        NullPostAPI api = retrofit.create(NullPostAPI.class);
        Call<Model> call = api.getData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (listener != null) {
                    listener.getData(response.body(), tag);
                    listener.getDataIsSuccess(true, tag);
                }
                System.out.println("数据" + response.body());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                if (listener != null) {
                    listener.getDataIsSuccess(false, tag);
                }
            }
        });
    }


    public void getData1(Retrofit retrofit, String uid, final int tag) {
        JsonPostAPI api = retrofit.create(JsonPostAPI.class);
        HashMap<String, String> data = new HashMap<>();
        data.put("u_id", uid);
        Gson json = new Gson();
        String jsonString = json.toJson(data);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonString);
        Call<Model1> call = api.getData(requestBody);
        call.enqueue(new Callback<Model1>() {
            @Override
            public void onResponse(Call<Model1> call, Response<Model1> response) {
                if (listener != null) {
                    listener.getData(response.body(), tag);
                    listener.getDataIsSuccess(true, tag);
                }
                System.out.println("带json的post数据" + response.body());
            }

            @Override
            public void onFailure(Call<Model1> call, Throwable t) {
                if (listener != null) {
                    listener.getDataIsSuccess(false, tag);
                }
            }
        });
    }

    public void getData2(Retrofit retrofit, String cid, String paymode, double amount, String token, final int tag) {
        FromPostAPI api = retrofit.create(FromPostAPI.class);
        Call<Model2> call = api.getData(cid, paymode, amount, token);
        call.enqueue(new Callback<Model2>() {
            @Override
            public void onResponse(Call<Model2> call, Response<Model2> response) {
                if (listener != null) {
                    listener.getData(response.body(), tag);
                    listener.getDataIsSuccess(true, tag);
                }
                System.out.println("form的post数据" + response.body());
            }

            @Override
            public void onFailure(Call<Model2> call, Throwable t) {
                if (listener != null) {
                    listener.getDataIsSuccess(false, tag);
                }
            }
        });
    }

    public void getData21(Retrofit retrofit, Map<String, Object> data, final int tag) {
        FormPostAPI1 api = retrofit.create(FormPostAPI1.class);
        Call<Model2> call = api.getData(data);
        call.enqueue(new Callback<Model2>() {
            @Override
            public void onResponse(Call<Model2> call, Response<Model2> response) {
                if (listener != null) {
                    listener.getData(response.body(), tag);
                    listener.getDataIsSuccess(true, tag);
                }
                System.out.println("form的post数据" + response.body());
            }

            @Override
            public void onFailure(Call<Model2> call, Throwable t) {
                if (listener != null) {
                    listener.getDataIsSuccess(false, tag);
                }
            }
        });
    }
}
