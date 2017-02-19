package com.anthony_powell.tav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AdventureActivity extends AppCompatActivity {

 ListView listView;
 String[] adventureTitles ={"Read three chapters from book of the week.", "Clean the Chalk Board.", "Present summary to class.",
 "Complete questions 1-13 odd numbers only from homework."};

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_adventure);
  final ListAdapter adapter = new AdventureItemAdapter(this,  adventureTitles);
  listView = (ListView) findViewById(R.id.adventure_listView);
  listView.setAdapter(adapter);

  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(AdventureActivity.this, "Great, now just accept your new adventure: "+ adapter.getItem(position), Toast.LENGTH_SHORT).show();
   }
  });
 }
 private void populateListView(){

 }
}
