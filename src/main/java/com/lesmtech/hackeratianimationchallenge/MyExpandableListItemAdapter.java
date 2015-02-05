package com.lesmtech.hackeratianimationchallenge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter;

import java.util.ArrayList;

/**
 * Created by Te on 2/5/15.
 */
public class MyExpandableListItemAdapter extends ExpandableListItemAdapter<Integer> {


    private Context context;
    private Integer expaned_position;

    protected MyExpandableListItemAdapter(Context context) {
        super(context, R.layout.activity_expandablelistitem_card, R.id.activity_expandablelistitem_card_title, R.id.activity_expandablelistitem_card_content);
        this.context = context;

        for (int i = 0; i < 100; i++) {
            add(i);
        }
    }

    @Override
    public View getTitleView(int i, View view, ViewGroup viewGroup) {

        TextView tv = (TextView) view;
        if (tv == null) {
            tv = new TextView(context);
        }
        tv.setText(context.getString(R.string.expandorcollapsecard, (int) getItem(i)));
        return tv;
    }

    @Override
    public View getContentView(int i, View view, ViewGroup viewGroup) {

        TextView v = (TextView) view;
        if (v == null) {
            v = new TextView(context);
        }
        v.setText("asdasdasd");
        return v;
    }


    public Integer getExpaned_position() {
        return expaned_position;
    }

    public void setExpaned_position(Integer expaned_position) {
        this.expaned_position = expaned_position;
    }

}
