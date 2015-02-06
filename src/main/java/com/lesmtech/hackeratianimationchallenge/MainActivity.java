package com.lesmtech.hackeratianimationchallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter;

import hugo.weaving.DebugLog;


public class MainActivity extends Activity {

    private static final int INITIAL_DELAY_MILLIS = 500;
    private MyExpandableListItemAdapter mExpandableListItemAdapter;
    private ListView mListView;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);

        mListView = (ListView) findViewById(R.id.activity_mylist_listview);

        mActionBar = getActionBar();

        mListView.setOnScrollListener(
                new AbsListView.OnScrollListener() {

                    int lastVisiableItem = 0;

                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                    }

                    @Override
                    @DebugLog
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                        boolean isShowing = mActionBar.isShowing();

                        /*

                        if: scroll up
                        else: scroll down

                        Note:
                            if the different between firstVisibleItem and LastVisibleItem is one, the actionbar will constantly show and hide,
                            because the slowly movement of ListView will make the firstVisibleItem unStable,
                            which is unavailable to decide user's scroll direction.
                         */
                        if (firstVisibleItem < lastVisiableItem - 1) {
                            if (!isShowing) {
                                mActionBar.show();
                            }
                            lastVisiableItem = firstVisibleItem;
                        } else if (firstVisibleItem > lastVisiableItem + 1) {
                            if (isShowing) {
                                mActionBar.hide();
                            }
                            lastVisiableItem = firstVisibleItem;
                        }
                    }
                }
        );


        mExpandableListItemAdapter = new MyExpandableListItemAdapter(this);


        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mExpandableListItemAdapter);
        alphaInAnimationAdapter.setAbsListView(mListView);

        assert alphaInAnimationAdapter.getViewAnimator() != null;
        alphaInAnimationAdapter.getViewAnimator().

                setInitialDelayMillis(INITIAL_DELAY_MILLIS);

        mListView.setAdapter(alphaInAnimationAdapter);

        mExpandableListItemAdapter.setLimit(1);

        Toast.makeText(this, "Click any item to expand or collapse", Toast.LENGTH_LONG).

                show();

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
