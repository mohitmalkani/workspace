package com.malkani.location;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Location _currentLocationCHANGE;
	private LocationManager _locationManager;
	private TextView _locationText;
	private TextView _addressText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        _addressText= (TextView)findViewById(R.id.address_text);
        _locationText= (TextView)findViewById(R.id.location_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
