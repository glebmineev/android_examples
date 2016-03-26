package com.example.gleb.lesson100;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by gleb on 07.03.2016.
 */
public class AnotherService extends Service {

    public static String LOG_TAG = "mineLogge";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand: " + intent.getAction());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(LOG_TAG, "onDestroy: ");
        super.onDestroy();
    }
}
