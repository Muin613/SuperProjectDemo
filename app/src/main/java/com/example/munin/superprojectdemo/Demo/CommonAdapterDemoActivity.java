package com.example.munin.superprojectdemo.Demo;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.munin.superprojectdemo.Base.BaseActivity;
import com.example.munin.superprojectdemo.Base.CommonAdapter;
import com.example.munin.superprojectdemo.Base.ViewHolder;
import com.example.munin.superprojectdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Munin on 2017/2/16.
 */
public class CommonAdapterDemoActivity extends BaseActivity {
    private ListView lv;
    private ECAdapter mAdapter;
    private List<Bean> data = new ArrayList<>();

    @Override

    public void setMainView() {
        setContentView(R.layout.test_common_adapter_layout);
    }

    @Override
    public void findView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void setView() {
        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean();
            bean.a = i;
            bean.b = "A" + i;
            data.add(bean);
        }
        mAdapter = new ECAdapter(this,data);
        lv.setAdapter(mAdapter);
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

    class Bean {
        int a;
        String b;
    }
}
