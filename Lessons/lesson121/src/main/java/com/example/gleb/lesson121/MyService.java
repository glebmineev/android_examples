package com.example.gleb.lesson121;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by gleb on 20.03.2016.
 */
public class MyService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new MyFactory(getApplicationContext(), intent);
    }

}
