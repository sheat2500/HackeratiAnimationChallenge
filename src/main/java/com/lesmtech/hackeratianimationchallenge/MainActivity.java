package com.lesmtech.hackeratianimationchallenge;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter;


public class MainActivity extends Activity {

    private static final int INITIAL_DELAY_MILLIS = 500;
    private MyExpandableListItemAdapter mExpandableListItemAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);

        mListView = (ListView) findViewById(R.id.activity_mylist_listview);

        mExpandableListItemAdapter = new MyExpandableListItemAdapter(this);


        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mExpandableListItemAdapter);
        alphaInAnimationAdapter.setAbsListView(mListView);

        assert alphaInAnimationAdapter.getViewAnimator() != null;
        alphaInAnimationAdapter.getViewAnimator().setInitialDelayMillis(INITIAL_DELAY_MILLIS);

        mListView.setAdapter(alphaInAnimationAdapter);

        // Expanding an item should 'collapse' any items that had already been expanded
        mExpandableListItemAdapter.setExpandCollapseListener(new ExpandableListItemAdapter.ExpandCollapseListener() {
            @Override
            public void onItemExpanded(int i) {

                Integer item_position = mExpandableListItemAdapter.getExpaned_position();

                if (item_position == null || item_position == i) {
                    mExpandableListItemAdapter.setExpaned_position(i);
                } else {
                    mExpandableListItemAdapter.collapse(item_position);
                    mExpandableListItemAdapter.setExpaned_position(i);
                }
            }

            @Override
            public void onItemCollapsed(int i) {
            }
        });

        Toast.makeText(this, "Click any item to expand or collapse", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
