package com.example.gleb.lesson99;

import java.util.concurrent.TimeUnit;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;

/**
 * Created by gleb on 07.03.2016.
 */
public class MyService extends Service {
    NotificationManager nm;

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    void sendNotif() {
        // 1-я часть

        Notification.Builder builder = new Notification.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText("Text in status bar")
            .setWhen(System.currentTimeMillis())
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{0, 1, 1, 2});

        //Notification notif = new Notification(R.mipmap.ic_launcher, "Text in status bar",
        //        System.currentTimeMillis());

        // 3-я часть
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.FILE_NAME, "somefile");
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // 2-я часть
        //notification.setLatestEventInfo(this, "Notification's title", "Notification's text", pIntent);
        builder.setAutoCancel(true);
        builder.setContentIntent(pIntent);

        // ставим флаг, чтобы уведомление пропало после нажатия
        //notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // отправляем
        nm.notify((int) System.currentTimeMillis(), builder.build());
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

}
