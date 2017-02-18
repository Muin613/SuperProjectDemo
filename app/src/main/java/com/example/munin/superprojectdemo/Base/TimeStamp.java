package com.example.munin.superprojectdemo.Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Munin on 2016/12/16.
 */
public class TimeStamp {

    public static String getTimeStampAll(String time) {
        float f = Float.valueOf(time);
        long l = Math.round(f);
        SimpleDateFormat fmat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = fmat.format(new Date(l * 1000));
        return time1;

    }

    public static String getTimeStampH(String time) {
        float f = Float.valueOf(time);
        long l = Math.round(f);
        SimpleDateFormat fmat = new SimpleDateFormat("HH");
        String time1 = fmat.format(new Date(l * 1000));
        return time1;
    }

    public static String getTimeStampM(String time) {
        float f = Float.valueOf(time);
        long l = Math.round(f);
        SimpleDateFormat fmat = new SimpleDateFormat("mm");
        String time1 = fmat.format(new Date(l * 1000));
        return time1;
    }

    public static String getTimeStampS(String time) {
        float f = Float.valueOf(time);
        long l = Math.round(f);
        SimpleDateFormat fmat = new SimpleDateFormat("ss");
        String time1 = fmat.format(new Date(l * 1000));
        return time1;
    }


    public static long getTimeAll(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date d1;
        long dd1 = 0;
        try {
            d1 = sdf.parse(time);
            dd1 = d1.getTime();
            return dd1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dd1;
    }

    public static int getHour(String time) {
        long time1 = Long.valueOf(time);

        return (int) (time1 / 60 / 60 / 10);
    }

    public static int getHour1(String time) {
        long time1 = Long.valueOf(time);
        return (int) (time1 / 60 / 60 - (int) (time1 / 60 / 60 / 10) * 10);
    }

    public static int getMinute(String time) {
        long time1 = Long.valueOf(time);
        return (int) (time1 / 60 - (int) (time1 / 60 / 60) * 60) / 10;
    }

    public static int getMinute1(String time) {
        long time1 = Long.valueOf(time);
        return (int) (time1 / 60 - (int) (time1 / 60 / 10) * 10);
    }

    public static int getSecond(String time) {
        long time1 = Long.valueOf(time);
        return (int) (time1 - (int) (time1 / 60) * 60) / 10;

    }

    public static int getSecond1(String time) {
        long time1 = Long.valueOf(time);
        return (int) (time1 - (int) (time1 / 10) * 10);
    }

    public static int getMSecond(String time){
        long time1=Long.valueOf(time);
        return (int)(time1-(int)(time1/1000)*1000)/100;
    }


    public static int getMSecond1(String time){
        long time1=Long.valueOf(time);
        return (int)(time1-(int)(time1/100)*100)/10;
    }
}
