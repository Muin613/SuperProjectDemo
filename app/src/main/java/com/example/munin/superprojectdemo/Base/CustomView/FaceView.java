package com.example.munin.superprojectdemo.Base.CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.munin.superprojectdemo.Base.BitmapUtil;
import com.example.munin.superprojectdemo.Demo.CameraActivity;
import com.example.munin.superprojectdemo.R;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

public class FaceView extends View {
    private Camera.Face[] mFaces;
    private Paint mPaint;
    private Matrix matrix = new Matrix();
    private RectF mRectF = new RectF();
    private Context mContext;

    public void setFaces(Camera.Face[] faces) {
        mFaces = faces;
        invalidate();
    }

    public FaceView(Context context) {
        super(context);
        init(context);
    }

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        mContext=context;
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5f);
        mPaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mFaces == null || mFaces.length < 0) {
            return;
        }
        CameraActivity.prepareMatrix(matrix, false, 90, getWidth(), getHeight());
        canvas.save();
        matrix.postRotate(0);
        canvas.rotate(-0);
        for (int i = 0; i < mFaces.length; i++) {
            mRectF.set(mFaces[i].rect);
            matrix.mapRect(mRectF);
//            canvas.drawRect(mRectF, mPaint);
            Bitmap bitmap= BitmapUtil.resourceId2Bitmap1(mContext, R.mipmap.ic_launcher);
            canvas.drawBitmap(bitmap,mFaces[i].rect,mRectF,mPaint);
        }
        System.out.println("长度：" + mFaces.length);
        Toast.makeText(mContext, "长度："+mFaces.length, Toast.LENGTH_SHORT).show();
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
    }
}
