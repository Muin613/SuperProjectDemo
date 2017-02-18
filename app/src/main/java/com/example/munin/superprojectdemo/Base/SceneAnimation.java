package com.example.munin.superprojectdemo.Base;


import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

/*
 * 一组加载10张图片方法
 * 帧动画（专用）
 */
public class SceneAnimation {
	private ImageView mImageView;
	private int[] mFrameRess;
	private int[] mDurations;
	private int mDuration;
	private FrameLayout  login_layout;

	private int mLastFrameNo;
	private long mBreakDelay;
	private Context mContext;

	public SceneAnimation(ImageView pImageView, int[] pFrameRess,
						  int[] pDurations) {
		mImageView = pImageView;
		mFrameRess = pFrameRess;
		mDurations = pDurations;
		mLastFrameNo = pFrameRess.length - 1;

		mImageView.setBackgroundResource(mFrameRess[0]);
		play(1);
	}

	public SceneAnimation(ImageView pImageView, int[] pFrameRess, int pDuration, Context mContext, FrameLayout login_layout) {
		mImageView = pImageView;
		mFrameRess = pFrameRess;
		mDuration = pDuration;
		mLastFrameNo = pFrameRess.length - 1;
		this.mContext=mContext;
		this.login_layout=login_layout;
		mImageView.setBackgroundResource(mFrameRess[0]);
		playConstant(1);
	}

	public SceneAnimation(ImageView pImageView, int[] pFrameRess,
						  int pDuration, long pBreakDelay) {
		mImageView = pImageView;
		mFrameRess = pFrameRess;
		mDuration = pDuration;
		mLastFrameNo = pFrameRess.length - 1;
		mBreakDelay = pBreakDelay;

		mImageView.setBackgroundResource(mFrameRess[0]);
		playConstant(1);
	}

	private void play(final int pFrameNo) {
		mImageView.postDelayed(new Runnable() {
			public void run() {
				mImageView.setBackgroundResource(mFrameRess[pFrameNo]);
				if (pFrameNo == mLastFrameNo){}
//					play(0);
				else
					play(pFrameNo + 1);
			}
		}, mDurations[pFrameNo]);
	}

	private void playConstant(final int pFrameNo) {
		mImageView.postDelayed(new Runnable() {
			public void run() {
				mImageView.setBackgroundResource(mFrameRess[pFrameNo]);
				if (pFrameNo == mLastFrameNo) {

					return;
				} else {
					playConstant(pFrameNo + 1);
				}
			}
		}, 5);
	}
};