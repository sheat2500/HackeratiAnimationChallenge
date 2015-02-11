package com.lesmtech.hackeratianimationchallenge;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;

import hugo.weaving.DebugLog;

/**
 * Created by Te on 2/7/15.
 */
public class MyExpandableListFragment extends Fragment {

    private static final int INITIAL_DELAY_MILLIS = 500;
    private MyExpandableListItemAdapter mExpandableListItemAdapter;
    private ListView mListView;
    private ActionBar mActionBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.activity_mylist, container, false);

        mListView = (ListView) rootView.findViewById(R.id.activity_mylist_listview);

        mActionBar = getActivity().getActionBar();

        mListView.setOnScrollListener(
                new AbsListView.OnScrollListener() {

                    int lastVisiableItem = 0;

                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                    }

                    @Override
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

        mExpandableListItemAdapter = new MyExpandableListItemAdapter(getActivity());

        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(mExpandableListItemAdapter);
        alphaInAnimationAdapter.setAbsListView(mListView);

        assert alphaInAnimationAdapter.getViewAnimator() != null;

        alphaInAnimationAdapter.getViewAnimator()
                .setInitialDelayMillis(INITIAL_DELAY_MILLIS);

        mListView.setAdapter(alphaInAnimationAdapter);

        mExpandableListItemAdapter.setLimit(1);

        return rootView;
    }
}
