package com.anthony_powell.tav;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by powel on 2/19/2017.
 */

public class AdventureItemAdapter extends ArrayAdapter<String> {
 private String adventureDescription, clickedItemPoints;
 List<String> points = new ArrayList<String>();
 Activity activity;
 Context context;

 public AdventureItemAdapter(Context context, String[] values) {
  super(context,R.layout.adventure_item_layout, values);
 }
 public AdventureItemAdapter(Context context, String[] values, List<String> points) {
  super(context,R.layout.adventure_item_layout, values);
  this.points = points;
  this.context = context;
  activity = (Activity) context;
 }

 @NonNull
 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  LayoutInflater inflater = LayoutInflater.from(getContext());
  View view = inflater.inflate(R.layout.adventure_item_layout, parent, false);

  final String adventureName = getItem(position);

  final TextView adventure = (TextView) view.findViewById(R.id.adventure_title);
  final TextView pointsTV = (TextView) view.findViewById(R.id.adventure_point_value);

  adventure.setText(adventureName);
  
  adventure.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    adventureDescription = adventure.getText().toString();

    ((AdventureActivity)context).descriptionIntent();

   }
  });

  if(!points.isEmpty() && points.size()>0){
   clickedItemPoints = points.get(position);
   pointsTV.setText(points.get(position));

  }
  return view;
 }

 public String getClickedItemText(){
  return TextUtils.isEmpty(adventureDescription) ? "Error getting your awesome adventure, try again.": adventureDescription;
 }

 public String getClickedItemPoints() {
  return clickedItemPoints;
 }
}
