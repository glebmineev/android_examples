package com.example.gleb.lesson91;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyTask mt;
    TextView tv;

    private RetainedFragment dataFragment;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("qwe", "create MainActivity: " + this.hashCode());

        tv = (TextView) findViewById(R.id.tv);

        FragmentManager fm = getFragmentManager();
        dataFragment = (RetainedFragment) fm.findFragmentByTag("data");

        if (dataFragment == null) {
            mt = new MyTask();
            mt.execute();
            // add the fragment
            dataFragment = new RetainedFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
            // load the data from the web
            dataFragment.setData(mt);
        } else {
            mt = dataFragment.getData();
        }

        // передаем в MyTask ссылку на текущее MainActivity
        mt.link(this);

        Log.d("qwe", "create MyTask: " + mt.hashCode());
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        // удаляем из MyTask ссылку на старое MainActivity
        mt.unLink();
        dataFragment.setData(mt);
        return mt;
    }

}
