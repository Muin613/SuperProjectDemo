package com.example.munin.superprojectdemo.Base;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by Munin on 2016/12/16.
 */
public abstract class NHandler extends Handler {

    WeakReference<Activity> mWeakActivity;

    public NHandler(Activity activity) {
        mWeakActivity = new WeakReference<>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        Activity activity = mWeakActivity.get();

        if(null!=activity){
            this.OnActivity(msg);
        }
    }

     public abstract void  OnActivity(Message msg);
}
