package com.malkani.mohitmalkani;

import com.malkani.mohitmalkani.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.malkani.mohitmalkani.MESSAGE";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void changeColor(View view){
    	Intent intent = new Intent(this, ChangeColorActivity.class);
    	int color = 0;
    	if(view.getId()==R.id.blue){
    		color = Color.BLUE;
    		view.setBackgroundColor(0xff0000ff);
    	}
    	else if(view.getId()==R.id.yellow){
    		color = Color.YELLOW;
    		view.setBackgroundColor(0xffffff00);
    	}
    	intent.putExtra("mycolor",color);
    	startActivity(intent);
    }
    
    public void sendMessage(View view){
    	Intent intent = new Intent (this, DisplayMessageActivity.class);
    	EditText editText;
    	LinearLayout ll;
    	
    	if(view.getId()==R.id.button_send)
    	{
    		editText = (EditText) findViewById(R.id.edit_message);
    	}
    	else
    	{
    		editText = (EditText) findViewById(R.id.edit_message2);
    	}
    	
    	String message = editText.getText().toString();
      	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
}
