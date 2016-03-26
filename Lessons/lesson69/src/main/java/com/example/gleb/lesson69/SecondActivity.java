package com.example.gleb.lesson69;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
/**
 * Created by gleb on 16.02.2016.
 */
public class SecondActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Log.d(LOG_TAG, "getParcelableExtra");
        MyObject myObj = (MyObject) getIntent().getParcelableExtra(
                MyObject.class.getCanonicalName());
        Log.d(LOG_TAG, "myObj: " + myObj.s + ", " + myObj.i);
    }


}
