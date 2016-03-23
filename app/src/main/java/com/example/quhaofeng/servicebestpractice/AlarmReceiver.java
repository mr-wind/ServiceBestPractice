package com.example.quhaofeng.servicebestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Quhaofeng on 2016-3-23-0023.
 * 在每个时间间断后要执行的内容
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, LongRunningService.class);
        context.startService(i);
        Log.w("AlarmReceiver", "Thread id is " + Thread.currentThread().getId());
    }
}
