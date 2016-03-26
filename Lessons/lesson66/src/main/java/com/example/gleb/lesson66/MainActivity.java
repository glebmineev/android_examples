package com.example.gleb.lesson66;

import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    final int DIALOG = 1;

    Dialog dialog;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    void method1() {
        dialog.dismiss();
    }

    void method2() {
        dialog.cancel();
    }

    public void onclick(View v) {
        showDialog(DIALOG);

        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            public void run() {
                method1();
            }
        }, 2000);

        h.postDelayed(new Runnable() {
            public void run() {
                method2();
            }
        }, 4000);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG) {
            Log.d(LOG_TAG, "Create");
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Title");
            adb.setMessage("Message");
            adb.setPositiveButton("OK", null);
            dialog = adb.create();

            // обработчик отображения
            dialog.setOnShowListener(new OnShowListener() {
                public void onShow(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Show");
                }
            });

            // обработчик отмены
            dialog.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Cancel");
                }
            });

            // обработчик закрытия
            dialog.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Dismiss");
                }
            });
            return dialog;
        }
        return super.onCreateDialog(id);
    }


}
