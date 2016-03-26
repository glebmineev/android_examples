package com.example.gleb.lesson91;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by gleb on 25.02.2016.
 */
public class RetainedFragment extends Fragment {
    // data object we want to retain
    private MyTask mt;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public void setData(MyTask mt) {
        this.mt = mt;
    }

    public MyTask getData() {
        return mt;
    }
}
