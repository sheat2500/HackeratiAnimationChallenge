package com.lesmtech.hackeratianimationchallenge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import hugo.weaving.DebugLog;


public class MainActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    private MenuItem mActionBack;

    // True:  last swipe is to left;
    private boolean flag = false;

    private int lastPageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new RotationYTransformer());

        // Item Status in ActionBar
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            @DebugLog
            public void onPageSelected(int position) {

                // Page 0: MenuItem invisible
                if (mActionBack == null) {
                    // Do Nothing
                } else if (mPager.getCurrentItem() == 0) {
                    mActionBack.setVisible(false);
                } else {
                    mActionBack.setVisible(true);
                }

                // Swipe to left
                if (lastPageNumber < mPager.getCurrentItem()) {
                    flag = true;
                    lastPageNumber++;
                // Swipe to right
                } else {
                    flag = false;
                    lastPageNumber--;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mActionBack = menu.getItem(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {
            mPager.setCurrentItem(mPager.getCurrentItem() - (flag ? 1 : -1));
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A simple pager adapter that represents 5 MyExpandableListFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MyExpandableListFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

    }

}
