package com.example.gleb.lesson93;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickStart(View v) {
        startService(new Intent(this, MyService.class).putExtra("time", 7));
        startService(new Intent(this, MyService.class).putExtra("time", 2));
        startService(new Intent(this, MyService.class).putExtra("time", 4));
    }
}
