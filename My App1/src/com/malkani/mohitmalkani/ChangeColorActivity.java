package com.malkani.mohitmalkani;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;

public class ChangeColorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color);
        
        //Get message from the Intent
        Intent intent = getIntent();
        int colorChange= intent.getIntExtra("mycolor", Color.RED);
        
        findViewById(R.id.relative).setBackgroundColor(colorChange);       
     }
}
