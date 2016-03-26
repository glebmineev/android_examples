package com.example.gleb.lesson113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ActionMode actionMode;
    ListView lvActionMode;
    final String LOG_TAG = "myLogs";

    String[] data = { "one", "two", "three", "four", "five" };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, data);
        lvActionMode = (ListView) findViewById(R.id.lvActionMode);
        lvActionMode.setAdapter(adapter);
        lvActionMode.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lvActionMode.setMultiChoiceModeListener(new MultiChoiceModeListener() {

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.context, menu);
                return true;
            }

            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                mode.finish();
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
            }

            public void onItemCheckedStateChanged(ActionMode mode,
                                                  int position, long id, boolean checked) {
                Log.d(LOG_TAG, "position = " + position + ", checked = "
                        + checked);
            }
        });
        lvActionMode.setItemChecked(0,true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context, menu);
        return true;
    }

/*    ActionMode actionMode;
    final String LOG_TAG = "myLogs";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context, menu);
        return true;
    }

    public void onClick(View v) {
        if (actionMode == null)
            actionMode = startActionMode(callback);
        else
            actionMode.finish();
    }

    private ActionMode.Callback callback = new ActionMode.Callback() {

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.context, menu);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.d(LOG_TAG, "item " + item.getTitle());
            return false;
        }

        public void onDestroyActionMode(ActionMode mode) {
            Log.d(LOG_TAG, "destroy");
            actionMode = null;
        }

    };*/

}
