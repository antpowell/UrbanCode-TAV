package com.anthony_powell.tav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by powel on 2/19/2017.
 */

public class AdventureItemAdapter extends ArrayAdapter<String> {
 public AdventureItemAdapter(Context context, String[] values) {
  super(context,R.layout.adventure_item_layout, values);
 }

 @NonNull
 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  LayoutInflater inflater = LayoutInflater.from(getContext());
  View view = inflater.inflate(R.layout.adventure_item_layout, parent, false);

  String adventureName = getItem(position);

  TextView adventure = (TextView) view.findViewById(R.id.adventure_title);
  adventure.setText(adventureName);

  TextView points = (TextView) view.findViewById(R.id.points_text);

  return view;
 }
}
