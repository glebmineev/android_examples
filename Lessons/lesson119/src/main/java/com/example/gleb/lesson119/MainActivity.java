package com.example.gleb.lesson119;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

/**
 * Created by gleb on 19.03.2016.
 */
public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    NotificationManager nm;
    AlarmManager am;
    Intent intent1;
    Intent intent2;
    PendingIntent pIntent1;
    PendingIntent pIntent2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void onClick1(View view) {
        intent1 = createIntent("action 1", "extra 1");
        pIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        intent2 = createIntent("action 2", "extra 2");
        pIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        Log.d(LOG_TAG, "start");
        am.set(AlarmManager.RTC, System.currentTimeMillis() + 4000, pIntent1);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 1000, 1000, pIntent2);
    }

    public void onClick2(View view) {
        am.cancel(pIntent2);
    }

/*    public void onClick1(View view) {

        intent1 = createIntent("action", "extra 1");
        pIntent1 = PendingIntent.getBroadcast(this, 1, intent1, 0);

        intent2 = createIntent("action", "extra 2");
        pIntent2 = PendingIntent.getBroadcast(this, 2, intent2, 0);

        compare();

        sendNotif(1, pIntent1);
        sendNotif(2, pIntent2);

    }

    public void onClick2(View view) {
        pIntent1.cancel();
        Log.d(LOG_TAG, "cancel pIntent1");
    }*/

    Intent createIntent(String action, String extra) {
        Intent intent = new Intent(this, Receiver.class);
        intent.setAction(action);
        intent.putExtra("extra", extra);
        return intent;
    }

    void compare() {
        Log.d(LOG_TAG, "intent1 = intent2: " + intent1.filterEquals(intent2));
        Log.d(LOG_TAG, "pIntent1 = pIntent2: " + pIntent1.equals(pIntent2));
    }

    void sendNotif(int id, PendingIntent pIntent) {

        Notification notif = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Notif")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build();
        nm.notify(id, notif);
    }

}
