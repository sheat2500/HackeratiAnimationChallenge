package com.lesmtech.hackeratianimationchallenge;

import android.content.Context;
import android.view.LayoutInflater;
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

        LayoutInflater layoutInflater = android.view.LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.activity_expanded_content,viewGroup,false);
        ((TextView) v).setText("I am an expanded filed!");
       return v;
    }

}
