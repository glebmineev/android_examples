package com.example.gleb.lesson116;

import android.support.v7.app.AppCompatActivity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public abstract class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    List<RunningTaskInfo> list;
    ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    public void onInfoClick(View v) {
        list = am.getRunningTasks(20);
        for (RunningTaskInfo task : list) {
            if (task.baseActivity.flattenToShortString().startsWith("com.example.gleb")){
                Log.d(LOG_TAG, "------------------");
                Log.d(LOG_TAG, "Count: " + task.numActivities);
                Log.d(LOG_TAG, "Root: " + task.baseActivity.flattenToShortString());
                Log.d(LOG_TAG, "Top: " + task.topActivity.flattenToShortString());
            }
        }
    }

    abstract public void onClick(View v);

}
