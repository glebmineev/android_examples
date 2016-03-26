package com.example.gleb.lesson128;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainFragment extends Fragment {
    MyTask mt;
    TextView tv;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("qwe", "create MainActivity: " + this.hashCode());
        View v = inflater.inflate(R.layout.fragment, null);
        tv = (TextView) v.findViewById(R.id.tv);
        if (mt == null) {
            mt = new MyTask();
            mt.execute();
        }


        Log.d("qwe", "create MyTask: " + mt.hashCode());


        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    class MyTask extends AsyncTask<String, Integer, Void> {

        @Override
        protected Void doInBackground(String... params) {
            try {
                for (int i = 1; i <= 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    publishProgress(i);
                    Log.d("qwe", "i = " + i
                            + ", MyTask: " + this.hashCode()
                            + ", MainActivity: " + MainFragment.this.hashCode());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tv.setText("i = " + values[0]);
        }
    }

}
