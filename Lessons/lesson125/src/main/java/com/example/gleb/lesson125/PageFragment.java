package com.example.gleb.lesson125;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


public class PageFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String SAVE_PAGE_NUMBER = "save_page_number";

    static final String TAG = "myLogs";

    int pageNumber;
    int backColor;

    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        Log.d(TAG, "onCreate: " + pageNumber);
        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        int savedPageNumber = -1;
        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER);
        }
        Log.d(TAG, "savedPageNumber = " + savedPageNumber);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int temp = pageNumber - 1;
        MainActivity mainActivity = (MainActivity) inflater.getContext();
        Log.d(TAG, "Prevprev view: " + getView(mainActivity.findFragmentByPosition(temp - 2)) +
                    " | Prev view: " + getView(mainActivity.findFragmentByPosition(temp - 1)) +
                    " | Current view : " + getView(mainActivity.findFragmentByPosition(temp)) +
                    " | Next view: " + getView(mainActivity.findFragmentByPosition(temp + 1)) +
                    " | Nextnext view : " + getView(mainActivity.findFragmentByPosition(temp + 2)));


        View view = inflater.inflate(R.layout.fragment, null);

        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        tvPage.setText("Page " + pageNumber);
        tvPage.setBackgroundColor(backColor);

        return view;
    }

    public Integer getView(Fragment frag) {
        return frag != null ? (frag.getView() != null ? frag.getView().getId() : -1) : null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + pageNumber);
    }


}
