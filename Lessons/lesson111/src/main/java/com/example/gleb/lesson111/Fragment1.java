package com.example.gleb.lesson111;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by gleb on 12.03.2016.
 */
public class Fragment1 extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref1);
    }

}
