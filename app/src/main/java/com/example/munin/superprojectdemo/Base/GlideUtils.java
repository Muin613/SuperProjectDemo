package com.example.munin.superprojectdemo.Base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by Munin on 2017/2/16.
 */
public class GlideUtils {
  public static void loadByUrl(Context context, String url, ImageView img) {
        Glide.with(context).load(url).into(img);
    }

    public static void loadCircleByUrl(Context activity, String url, final ImageView img) {
        Glide.with(activity).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Bitmap bitmap = BitmapUtil.modifyToRoundBitmap(resource);
                img.setImageBitmap(bitmap);
            }
        });

    }

    public static void loadImgToLocalByUrl(Context activity, String url, final NHandler handler) {
        Glide.with(activity).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(final Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FileUtils.saveImgToLocal(resource);
                        Message msg = new Message();
                        msg.what = ResultCodeHEX.SUCCESS;
                        msg.obj = "保存成功";
                        handler.sendMessage(msg);
                    }
                }).start();

            }
        });
    }
}
