package com.example.munin.superprojectdemo.Base;

import android.util.Log;

/**
 * Created by Munin on 2017/2/15.
 */
public class DebugUtils {
    static boolean flag = true;
    static boolean logFlag = false;

    public static void show(boolean showFlag, String content) {
        if (flag)
            if (showFlag)
                System.out.println(content);
    }

    public static void log(String tag, String content) {
        if (logFlag)
            Log.i(tag, content);
    }
}
