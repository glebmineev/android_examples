package com.example.gleb.lesson97;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    boolean bound = false;
    ServiceConnection sConn;
    Intent explicitFromImplicitIntent;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = new Intent("com.example.gleb.lesson97service.MyService");
        explicitFromImplicitIntent = createExplicitFromImplicitIntent(this, intent);

        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.d(LOG_TAG, "MainActivity onServiceConnected");
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.d(LOG_TAG, "MainActivity onServiceDisconnected");
                bound = false;
            }
        };
    }

    public void onClickStart(View v) {
        startService(explicitFromImplicitIntent);
    }

    public void onClickStop(View v) {
        stopService(explicitFromImplicitIntent);
    }

    public void onClickBind(View v) {
        bindService(explicitFromImplicitIntent, sConn, 0);
    }

    public void onClickUnBind(View v) {
        if (!bound) return;
        unbindService(sConn);
        bound = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        onClickUnBind(null);
    }

    public Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        //Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        //Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        //Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        //Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        //Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }

}
