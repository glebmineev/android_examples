package com.example.gleb.lesson72;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by gleb on 17.02.2016.
 */
public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }

}
