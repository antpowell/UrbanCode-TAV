package com.anthony_powell.tav;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;

public class AdventureDescriptionActivity extends Activity {

 TextView adventureDescriptionText, adventurePoints;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_description);
  Intent intent = getIntent();

//  Toast.makeText(this, "Im here!: " + intent.getStringExtra("ADVENTURE_DESCRIPTION"), Toast.LENGTH_SHORT).show();

  adventureDescriptionText = (TextView) findViewById(R.id.adventure_description_title);
  adventureDescriptionText.setText(intent.getStringExtra("ADVENTURE_DESCRIPTION"));

  adventurePoints = (TextView) findViewById(R.id.adventure_point_value);
  adventurePoints.setText(intent.getStringExtra("ADVENTURE_POINTS")+"pts");

  getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
   getWindow().setStatusBarColor(Color.TRANSPARENT);

   FancyButton declineButton = (FancyButton) findViewById(R.id.decline_button);
   FancyButton acceptButton = (FancyButton) findViewById(R.id.accept_button);

   declineButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     finish();
    }
   });


  }


 }
}
