package com.example.gleb.lesson100;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by gleb on 07.03.2016.
 */
public class Resiver extends BroadcastReceiver {

    final String LOG_TAG = "myLogs";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(LOG_TAG, "onReceive " + intent.getAction());
        context.startService(new Intent(context, AnotherService.class));
    }
}
