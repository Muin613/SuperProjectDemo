package com.example.munin.superprojectdemo.Base;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Munin on 2016/12/29.
 */
public class FileUtils {

    //保存图片到本地
    public static File saveImgToLocal(Bitmap bitmap) {
        String imgName = "doudouchong"  + ".png";
        File ESD = Environment.getExternalStorageDirectory();
        File picture = new File(ESD, imgName);
        if (!picture.exists()) {
            try {
                picture.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(picture);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            return picture;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
