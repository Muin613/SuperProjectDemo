package com.example.munin.superprojectdemo.Demo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.munin.superprojectdemo.Base.CommonAdapter;
import com.example.munin.superprojectdemo.Base.ViewHolder;
import com.example.munin.superprojectdemo.R;

import java.util.List;

/**
 * Created by Munin on 2017/2/17.
 */
public class ECAdapter extends CommonAdapter {
    private CommonAdapterDemoActivity.Bean bean;

    public ECAdapter(Context context, List<CommonAdapterDemoActivity.Bean> mDatas) {
        super(context, mDatas, R.layout.test_lv_item_layout);
    }

    @Override
    public void convert(final ViewHolder helper, Object item) {

        bean = (CommonAdapterDemoActivity.Bean) item;
        ((TextView) helper.getView(R.id.txt10)).setText("" + bean.a);
        ((TextView) helper.getView(R.id.txt11)).setText("" + bean.b);
//        helper.getView(R.id.txt11).setTag(item);
        helper.setTag(R.id.txt11,item);
        helper.getView(R.id.txt11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击了"+((CommonAdapterDemoActivity.Bean)helper.getView(R.id.txt11).getTag()).a);
            }
        });
    }
}
