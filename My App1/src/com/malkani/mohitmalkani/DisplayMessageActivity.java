package com.malkani.mohitmalkani;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.location.*;

public class DisplayMessageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display);
        
        //Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        
        //Create the Text View
        TextView textView = (TextView) findViewById(R.id.txt);
        textView.setTextSize(20);
        textView.setText(message);
        textView.setGravity(10);
        
        // Set the text view as the activity layout
        //setContentView(R.layout.activity_display_message);
        
        
        
        
    }
}
