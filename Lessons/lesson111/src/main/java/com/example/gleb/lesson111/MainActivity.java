package com.example.gleb.lesson111;

import java.util.ArrayList;
import java.util.List;
import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity /* extends AppCompatActivity */{

    private static List<String> validFragmentNames = new ArrayList<>();

    static {
        validFragmentNames.add(Fragment1.class.getName());
        validFragmentNames.add(Fragment2.class.getName());
    }

    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return validFragmentNames.contains(fragmentName);
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new Fragment1()).commit();

    }*/
}
