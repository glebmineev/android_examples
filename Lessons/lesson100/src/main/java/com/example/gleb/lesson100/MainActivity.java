package com.example.gleb.lesson100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickStart(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent.putExtra("time", 3).putExtra("label", "Call 1") );
        startService(intent.putExtra("time", 1).putExtra("label", "Call 2") );
        startService(intent.putExtra("time", 4).putExtra("label", "Call 3") );
    }

}
