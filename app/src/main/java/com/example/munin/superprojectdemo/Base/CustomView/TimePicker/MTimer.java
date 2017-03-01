// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.munin.superprojectdemo.Base.CustomView.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

final class MTimer extends TimerTask {

    int a;//透明白色
    int b;//(黑色)
    final int c;//当前位置偏移(有正有负)
    final Timer timer;
    final LoopView loopView;

    MTimer(LoopView loopview, int i, Timer timer) {
        super();
        loopView = loopview;
        c = i;
        this.timer = timer;
        a = 0x7fffffff;
        b = 0;
    }

    public final void run() {
        System.out.println("c:"+c);
        if (a == 0x7fffffff) {
            if (c < 0) {
                if ((float) (-c) > (loopView.l * (float) loopView.h) / 2.0F) {
                    a = (int) (-loopView.l * (float) loopView.h - (float) c);
                } else {
                    a = -c;
                }
            } else if ((float) c > (loopView.l * (float) loopView.h) / 2.0F) {
                a = (int) (loopView.l * (float) loopView.h - (float) c);
            } else {
                a = -c;
            }
        }
        System.out.println("a:"+a);
        b = (int) ((float) a * 0.1F);
        if (b == 0) {
            if (a < 0) {
                b = -1;
            } else {
                b = 1;
            }
        }
        System.out.println("b:"+b);
        if (Math.abs(a) <= 0) {
            timer.cancel();
            loopView.handler.sendEmptyMessage(3000);
            return;
        } else {
            LoopView loopview = loopView;
            loopview.totalScrollY = loopview.totalScrollY + b;
            loopView.handler.sendEmptyMessage(1000);
            a = a - b;
            return;
        }
    }
}
