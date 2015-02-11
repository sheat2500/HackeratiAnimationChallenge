package com.lesmtech.hackeratianimationchallenge;

import android.support.v4.view.ViewPager;
import android.view.View;

import hugo.weaving.DebugLog;

/**
 * Created by Te on 2/7/15.
 */
public class RotationYTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            view.setAlpha(Math.abs(1 - Math.abs(position)));
            view.setRotationY(180 * position);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}
