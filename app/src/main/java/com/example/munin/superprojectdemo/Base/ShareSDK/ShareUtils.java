package com.example.munin.superprojectdemo.Base.ShareSDK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.munin.superprojectdemo.Base.Tools.CameraUtil;
import com.example.munin.superprojectdemo.Base.Tools.Util;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by Munin on 2017/2/27.
 */
public class ShareUtils {
    private Context context;
    private IWXAPI api;

    public ShareUtils(Context context) {
        this.context = context;
    }

    public ShareUtils initWXShare(String WX_APP_ID) {
        api = WXAPIFactory.createWXAPI(context, WX_APP_ID);
        return this;
    }

    //    @Override（关键）bundle(是回调参数)
//    public void onNewIntent(Intent intent) {
//    super.onNewIntent(intent);
//    bundle = intent.getExtras();
//    }
//分享文字
    public void shareWXText(String txt, Bundle bundle) {
        // 初始化一个WXTextObject对象
        WXTextObject textObj = new WXTextObject();
        textObj.text = txt;

        // 用WXTextObject对象初始化一个WXMediaMessage对象
        WXMediaMessage msg = new WXMediaMessage(textObj);
        msg.description = txt;

        // 构造一个Resp
        GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
        // 将req的transaction设置到resp对象中，其中bundle为微信传递过来的intent所带的内容，通过getExtras方法获取
        resp.transaction = getTransaction(bundle);
        resp.message = msg;

        // 调用api接口响应数据到微信
        api.sendResp(resp);
    }

    //分享缩略图
    public void shareWXThumbBmp(int resID, int THUMB_SIZE, Bundle bundle) {//一般150
        // respond with image message
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resID);
        WXImageObject imgObj = new WXImageObject(bmp);

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;

        // 设置消息的缩略图
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = Util.bmpToByteArray(thumbBmp, true);

        GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
        resp.transaction = getTransaction(bundle);
        resp.message = msg;
        api.sendResp(resp);
    }

    //分享音乐url
    public void shareWXMusic(String musicUrl, int res_ID, String title, String content, Bundle bundle) {
        WXMusicObject music = new WXMusicObject();
        music.musicUrl = musicUrl;

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = music;
        msg.title = title;
        msg.description = content;

        Bitmap thumb = BitmapFactory.decodeResource(context.getResources(), res_ID);
        msg.thumbData = Util.bmpToByteArray(thumb, true);

        GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
        resp.transaction = getTransaction(bundle);
        resp.message = msg;

        api.sendResp(resp);
    }

    //    分享视频Url
    public void shareWXVideo(String videoUrl, String title, String content, Bundle bundle) {
        WXVideoObject video = new WXVideoObject();
        video.videoUrl = videoUrl;

        WXMediaMessage msg = new WXMediaMessage(video);
        msg.title = title;
        msg.description = content;

        GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
        resp.transaction = getTransaction(bundle);
        resp.message = msg;
        api.sendResp(resp);
    }

    //分享网页url
    public void shareWXWeb(String WebUrl, String title, String content, Bundle bundle) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = WebUrl;

        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;

        GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
        resp.transaction = getTransaction(bundle);
        resp.message = msg;

        api.sendResp(resp);
    }

    //分享本地照片
    public void shareWXPhotoReq(Activity activity) {
        CameraUtil.takePhoto(activity, "/mnt/sdcard/tencent/", "get_appdata", 0x0100);
    }

//    反馈
    public void shareWXPhoto(int resultCode,Intent data,Bundle bundle){
        if (resultCode == Activity.RESULT_OK) {
            final WXAppExtendObject appdata = new WXAppExtendObject();
            final String path = CameraUtil.getResultPhotoPath(context, data, "/mnt/sdcard/tencent/");
            appdata.filePath = path;
            appdata.extInfo = "this is ext info";

            final WXMediaMessage msg = new WXMediaMessage();
            msg.setThumbImage(Util.extractThumbNail(path, 150, 150, true));
            msg.title = "this is title";
            msg.description = "this is description";
            msg.mediaObject = appdata;


            GetMessageFromWX.Resp resp = new GetMessageFromWX.Resp();
            resp.transaction = getTransaction(bundle);
            resp.message = msg;

            api.sendResp(resp);
        }
    }

    private String getTransaction(Bundle bundle) {
        try {
            final GetMessageFromWX.Req req = new GetMessageFromWX.Req(bundle);
            return req.transaction;
        } catch (Exception e) {
            return "";
        }
    }
}
