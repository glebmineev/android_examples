package com.example.gleb.leson114_v233;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements MyFragment.OnFragmentInteractionListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        MyFragment myFrag = new MyFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cont, myFrag).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
