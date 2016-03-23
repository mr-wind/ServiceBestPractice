package com.example.quhaofeng.servicebestpractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by Quhaofeng on 2016-3-23-0023.
 * 主要进行后台的计时
 */
public class LongRunningService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.w("LongRunningService", "executed at " + new Date().toString());
                Log.w("LongRunningService", "Thread id is " + Thread.currentThread().getId());
            }
        }).start();
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        int anHour = 30 * 1000;//时间间隔1小时
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this, AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }
}
