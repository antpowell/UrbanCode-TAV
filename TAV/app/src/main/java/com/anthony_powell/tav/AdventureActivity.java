package com.anthony_powell.tav;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdventureActivity extends AppCompatActivity {

 ListView listView;
 public Intent intent;

 String[] adventureTitles = {"Read three chapters from book of the week.", "Clean the Chalk Board.", "Present summary to class.",
   "Complete questions 1-13 odd numbers only from homework.", "Recite times table", "Answer five questions in class.", "Answer three questions in class.",
   "Help pass out pencils."};
 List<String> points =new ArrayList<String>();
 AdventureItemAdapter adapter;


 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_adventure);

  Random random = new Random();
  for(int i = 0; i<=adventureTitles.length-1; i++){
   points.add(String.valueOf((random.nextInt(1550)+ 450)));
  }


  adapter = new AdventureItemAdapter(this, adventureTitles, points);
  listView = (ListView) findViewById(R.id.adventure_listView);
  listView.setAdapter(adapter);

  intent = new Intent(AdventureActivity.this, AdventureDescriptionActivity.class);
//  intent.putExtra("ADVENTURE_DESCRIPTION", adapter.getClickedItemText());
//  startActivity(intent);

 }
 public void descriptionIntent(){
  intent = new Intent(AdventureActivity.this, AdventureDescriptionActivity.class);
  intent.putExtra("ADVENTURE_DESCRIPTION", adapter.getClickedItemText());
  intent.putExtra("ADVENTURE_POINTS", adapter.getClickedItemPoints());
  startActivity(intent);
 }

}
