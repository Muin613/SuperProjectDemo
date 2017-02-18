package com.example.munin.superprojectdemo.Base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Description: 图片加载器,只对加载图片的大小进行处理，未对其进行缓存优化。
 * Created by Munin on 2015/11/10.
 */
public class BitmapUtil {

    private static final String mPortraitName = "YM.jpg";
    private static String mUserName = "";

    /**
     * @param res       资源类
     * @param resId     资源id
     * @param reqWidth  请求宽度
     * @param reqHeight 请求高度
     * @description:
     */
    public static Bitmap createBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        //获取Option
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;  //仅获取边界大小
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);//计算缩放比例
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /**
     * @param options   图片工厂设置类
     * @param reqWidth  请求宽度
     * @param reqHeight 请求高度
     * @description: 计算缩放比例
     */
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int bitmapWidth = options.outWidth;
        final int bitmapHeight = options.outHeight;
        int sampleSize = 1;
        while ((bitmapWidth / sampleSize) > reqWidth && (bitmapHeight / sampleSize) > reqHeight) {
            sampleSize *= 2;
        }
        return sampleSize;
    }

    /**
     * 设置圆角图片
     *
     * @param bitmap Bitmap对象
     * @description:
     */
    public static Bitmap modifyToRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;//圆的半径
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            left = 0;
            top = 0;
            right = width;
            bottom = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }

        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;//ARGB
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);

        paint.setAntiAlias(true);// 设置画笔无锯齿(边缘更清晰)

        canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
        paint.setColor(color);

        // 以下有两种方法画圆,drawRounRect和drawCircle
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
        canvas.drawCircle(roundPx, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
        canvas.drawBitmap(bitmap, src, dst, paint); //以Mode.SRC_IN模式合并bitmap和已经draw了的Circle

        return output;
    }

    /**
     * 将Drawable转化为Bitmap
     *
     * @description:
     */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 将根据资源id转化为Bitmap
     *
     * @description:
     */
    public static Bitmap resourceId2Bitmap1(Context context, int resId) {

        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;//颜色模式
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);

    }

    /**
     * 获得圆角图片的方法
     *
     * @param bitmap  目标图片
     * @param roundPx 截取半径
     * @description:
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /**
     * 获取位图文件夹
     *
     * @param filesDir 文件路径getFilesDir()
     * @description:
     */
    public static File getBitmapFile(File filesDir) {
        return new File(filesDir, mUserName + mPortraitName);
    }

    /**
     * 通过文件夹获取位图
     *
     * @param filesDir 文件路径getFilesDir()
     * @description:
     */
    public static Bitmap getBitmapByFile(File filesDir) {
        File f = getBitmapFile(filesDir);
        Bitmap bitmap = null;
        if (f.exists()) {
            //文件存在
            bitmap = BitmapFactory.decodeFile(f.getAbsolutePath());
        }
        return bitmap;
    }

    public static void setmUserName(String mUserName) {
        if (mUserName == null) {
            mUserName = "default";
        }
        BitmapUtil.mUserName = mUserName;
    }

    /**
     * 更改位图的RGBA
     * 位图 defaultFlag 默认 参数RGBA(5个)
     *
     * @description:
     */
    public static Bitmap changeBitmapRGBA(Bitmap bitmapSrc, Boolean defaultFlag, float R1, float R2, float R3, float R4, float R5, float G1, float G2, float G3, float G4, float G5, float B1, float B2, float B3, float B4, float B5, float A1, float A2, float A3, float A4, float A5) {
        if (defaultFlag) {
            R1 = 1f;
            R2 = 0f;
            R3 = 0f;
            R4 = 0f;
            R5 = 0f;//red
            G1 = 0f;
            G2 = 1f;
            G3 = 0f;
            G4 = 0f;
            G5 = 0f;//green
            B1 = 0f;
            B2 = 0f;
            B3 = 1f;
            B4 = 0f;
            B5 = 0f;//blue
            A1 = 0f;
            A2 = 0f;
            A3 = 0f;
            A4 = 1f;
            A5 = 0f;//alpha
        }
        ColorMatrix cMatrix = new ColorMatrix();
        cMatrix.set(new float[]{R1, R2, R3, R4, R5,//改变red
                G1, G2, G3, G4, G5,//改变green
                B1, B2, B3, B4, B5,// 改变Blue
                A1, A2, A3, A4, A5,//改变alpha
        });
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));
        Canvas canvas = new Canvas();
        canvas.drawBitmap(bitmapSrc, 0, 0, paint);
        return bitmapSrc;
    }

    public static Bitmap Byte2Bitmap(byte[] data) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        return bitmap;

    }


    /**
     * 缩放图片
     *
     * @param bitmap
     * @param width
     * @param height
     * @return
     */
    public static Bitmap scaleBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) width / w, (float) height / h);
        return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
    }


    /**
     * 图片变byte数组
     *
     * @param bm
     * @return
     */
    private byte[] Bitmap2Bytes(Bitmap bm) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);

        return baos.toByteArray();

    }


    /**
     * 从网络获取图片
     *
     * @param urlString
     * @return
     */


    public Bitmap getBitmapFromUrl(String urlString) {
        InputStream is = null;
        Bitmap bitmap;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            connection.disconnect();
            //Thread.sleep(1000);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Bitmap getBitmap(String url) {
        URL imageURL = null;
        Bitmap bitmap = null;
        try {
            imageURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) imageURL
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
