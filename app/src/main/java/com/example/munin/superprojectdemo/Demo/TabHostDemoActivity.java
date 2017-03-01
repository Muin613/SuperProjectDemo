package com.example.munin.superprojectdemo.Demo;

import android.app.Activity;

import com.example.munin.superprojectdemo.Base.BaseActivity;
import com.example.munin.superprojectdemo.Base.CustomView.MyTabHost;
import com.example.munin.superprojectdemo.R;

/**
 * Created by Munin on 2017/2/20.
 */
public class TabHostDemoActivity extends BaseActivity {
    private MyTabHost host;

    @Override
    public void setMainView() {
        setContentView(R.layout.test_tabhost_layout);
    }

    @Override
    public void findView() {
        host = (MyTabHost) findViewById(R.id.tab_host);
    }

    @Override
    public void setView() {
        host.setOnSelectListener(new MyTabHost.OnSelectListener() {
            @Override
            public void onSelect(int index, String text) {
                System.out.println("点击的文本"+text);
                System.out.println("点击"+index);
            }
        });
    }

    @Override
    public void connectNet() {

    }

    @Override
    public void Loading() {

    }

    @Override
    public void freshing() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void stopFreshing() {

    }
}
