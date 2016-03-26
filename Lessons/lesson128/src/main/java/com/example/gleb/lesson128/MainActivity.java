package com.example.gleb.lesson128;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Fragment mainFragment;
    FragmentTransaction fTrans;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        if (savedInstanceState == null) {
            mainFragment = new MainFragment();
            fTrans = getSupportFragmentManager().beginTransaction();
            fTrans.add(R.id.frgmCont, mainFragment);
            fTrans.commit();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
