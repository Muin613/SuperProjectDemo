package com.example.munin.superprojectdemo.Base.CustomView;

/**
 * Created by Munin on 2017/2/13.
 */

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.munin.superprojectdemo.R;


public class CustomProgressDialog {


    /**
     * 得到自定义的progressDialog
     *
     * @param context
     * @param
     * @return
     */
    private Dialog loadingDialog;

    public CustomProgressDialog(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.progress_dialog_view, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
        // main.xml中的ImageView
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.progress_dialog_anim);
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        loadingDialog = new Dialog(context, R.style.progress_dialog_style);// 创建自定义样式dialog

        loadingDialog.setCancelable(false);// 不可以用“返回键”取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
    }

    public void show() {
        loadingDialog.show();
    }

    public void dismiss() {
        loadingDialog.dismiss();
    }

    public CustomProgressDialog setTouchOutside(boolean cancel) {
        loadingDialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

}