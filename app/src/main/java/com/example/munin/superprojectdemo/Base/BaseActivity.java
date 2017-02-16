package com.example.munin.superprojectdemo.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.munin.superprojectdemo.Base.CustomView.CustomProgressDialog;


/**
 * Created by Munin on 2017/2/13.
 * time
 */
public abstract class BaseActivity extends FragmentActivity {
    CustomProgressDialog loadingProgress;//进度条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMainView();
        findView();
        initView();
        setView();
    }

    public abstract void connectNet();

    public abstract void setMainView();

    void initView() {
        loadingProgress = new CustomProgressDialog(getApplicationContext());
    }

    public abstract void setView();

    public abstract void Loading();

    public abstract void freshing();

    public abstract void stopLoading();

    public  abstract void stopFreshing();

    void showProgress() {
        loadingProgress.show();
    }

    void stopProgress() {
        loadingProgress.dismiss();
    }

    /*
     *外面不可点击
     * 默认是外面点击消失
     */
    void setProgressTouchOutside() {
        loadingProgress.setTouchOutside(false);
    }

    public abstract void findView();

    /*
     * Toast 吐司一些反馈信息
     */
    void showToast(String content) {
        Toast.makeText(BaseActivity.this, "" + content, Toast.LENGTH_SHORT).show();
    }


    void startActivity(Class cls) {
        Intent intent = new Intent(BaseActivity.this, cls);
        startActivity(intent);
    }
}
