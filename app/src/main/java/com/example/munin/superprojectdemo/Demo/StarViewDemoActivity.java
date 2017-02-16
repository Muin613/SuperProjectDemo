package com.example.munin.superprojectdemo.Demo;

import android.widget.RatingBar;
import android.widget.TextView;

import com.example.munin.superprojectdemo.Base.BaseActivity;
import com.example.munin.superprojectdemo.Base.CustomView.StarBarView;
import com.example.munin.superprojectdemo.Base.Debug;
import com.example.munin.superprojectdemo.R;

public class StarViewDemoActivity extends BaseActivity {
    private RatingBar ratingBar;//原生控件
    private StarBarView starBarView;//自定义控件
    private TextView txt;



    @Override
    public void setMainView() {
        setContentView(R.layout.test_star_bar_layout);
    }

    @Override
    public void findView() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        starBarView = (StarBarView) findViewById(R.id.star_bar);
        txt= (TextView) findViewById(R.id.txt);
    }

    @Override
    public void setView() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Debug.show(true,"原生控件，实时结果:"+rating);
            }
        });
        starBarView.setOnStarChangeListener(new StarBarView.OnStarChangeListener() {
            @Override
            public void onStarChange(float mark) {
                Debug.show(true,"自定义评分控件,实时结果:"+mark);
                txt.setText(""+mark);
            }

            @Override
            public void onStarChangeFinished(float mark) {
                Debug.show(true,"自定义评分控件，最终结果:"+mark);
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
