package com.example.gleb.lesson91;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by gleb on 25.02.2016.
 */
public class MyTask  extends AsyncTask<String, Integer, Void> {

    MainActivity activity;

    // получаем ссылку на MainActivity
    void link(MainActivity act) {
        activity = act;
    }

    // обнуляем ссылку
    void unLink() {
        activity = null;
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            for (int i = 1; i <= 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                publishProgress(i);
                Log.d("qwe", "i = " + i
                        + ", MyTask: " + this.hashCode()
                        + ", MainActivity: " + activity.hashCode());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        activity.tv.setText("i = " + values[0]);
    }


}
