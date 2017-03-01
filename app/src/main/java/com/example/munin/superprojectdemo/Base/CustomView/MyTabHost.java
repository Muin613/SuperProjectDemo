package com.example.munin.superprojectdemo.Base.CustomView;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by cxj on 2017/2/19.
 */

public class MyTabHost extends LinearLayout implements View.OnClickListener {


    public MyTabHost(Context context) {
        this(context, null);
    }

    public MyTabHost(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public MyTabHost(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //设置孩子排列的方向是水平的
        setOrientation(HORIZONTAL);

        GradientDrawable d = new GradientDrawable();
        //设置圆角
        d.setCornerRadii(new float[]{radius, radius, radius, radius, radius, radius, radius, radius});
        //设置背景颜色
        d.setColor(backBg);
        setBackground(d);


        //读取自定义属性

        //显示效果
        sove();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 自身控件的背景
     */
    private int backBg = Color.WHITE;


    /**
     * 没有选中的tab的背景
     */
    private int unSelectTabBg = Color.BLUE;

    /**
     * 选中的tab的背景
     */
    private int selectTabBg = Color.WHITE;

    /**
     * 未选中的文本的颜色
     */
    private int unSelectTextColor = Color.WHITE;

    /**
     * 选中的文本的颜色
     */
    private int selectTextColor = Color.BLUE;

    /**
     * 间距
     */
    private int space = 1;


    /**
     * 圆角半径
     */
    private int radius = 5;

    /**
     * 当前的下标
     */
    private int curIndex = 1;

    /**
     * 所有要显示的文本
     */
    private String[] textArr = new String[]{"第一", "第二", "第三"};


    /**
     * 根据所有的参数,弄出效果
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void sove() {

        //移除所有的孩子
        removeAllViews();

        for (int i = 0; i < textArr.length; i++) {

            //创建一个文本
            TextView tv = new TextView(getContext());

            //创建文本的布局对象
            LayoutParams params = new LayoutParams(
                    0,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );

            if (i > 0) {
                params.leftMargin = space;
            }

            GradientDrawable d = null;

            //根据下标决定圆角
            if (i == 0) {
                d = new GradientDrawable();
                //设置圆角
                d.setCornerRadii(new float[]{radius, radius, 0, 0, 0, 0, radius, radius});
            } else if (i == textArr.length - 1) {
                d = new GradientDrawable();
                //设置圆角
                d.setCornerRadii(new float[]{0, 0, radius, radius, radius, radius, 0, 0});
            } else {
                d = new GradientDrawable();
                //设置圆角
                d.setCornerRadii(new float[]{0, 0, 0, 0, 0, 0, 0, 0});
            }

            //如果选中了设置选中的颜色和背景
            if (curIndex == i) {
                tv.setTextColor(selectTextColor);
                d.setColor(selectTabBg);
            } else {
                tv.setTextColor(unSelectTextColor);
                d.setColor(unSelectTabBg);
            }

            //设置文本
            tv.setText(textArr[i]);
            //设置文本显示在中间
            tv.setGravity(Gravity.CENTER);
            //设置文本的背景
            tv.setBackground(d);

            //设置文本(也就是tab)的权重
            params.weight = 1;

            tv.setLayoutParams(params);

            tv.setTag(i);
            tv.setOnClickListener(this);

            //添加孩子
            addView(tv);

        }

    }


    @Override
    public void onClick(View v) {
        int index = (int) v.getTag();
        curIndex = index;
        sove();

        if (mOnSelectListener != null) {
            mOnSelectListener.onSelect(index,textArr[index]);
        }

    }

    private OnSelectListener mOnSelectListener;

    /**
     * 设置监听
     *
     * @param mOnSelectListener
     */
    public void setOnSelectListener(OnSelectListener mOnSelectListener) {
        this.mOnSelectListener = mOnSelectListener;
    }

    /**
     * 回调接口
     */
    public interface OnSelectListener {

        /**
         * 回调方法
         *
         * @param index
         * @param text
         */
        void onSelect(int index, String text);

    }

}
