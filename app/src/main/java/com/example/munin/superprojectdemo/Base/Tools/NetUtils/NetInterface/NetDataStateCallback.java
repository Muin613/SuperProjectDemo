package com.example.munin.superprojectdemo.Base.Tools.NetUtils.NetInterface;

/**
 * Created by Munin on 2017/3/1.
 */
public interface NetDataStateCallback {

    void getDataIsSuccess(boolean b,int tag);
    void getData(Object object,int tag);
}
