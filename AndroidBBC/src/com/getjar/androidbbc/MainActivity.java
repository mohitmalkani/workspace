package com.getjar.androidbbc;

import java.util.ArrayList;
import java.util.List;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.getjar.sdk.GetJarContext;
import com.getjar.sdk.GetJarManager;
import com.getjar.sdk.GetJarPage;
import com.getjar.sdk.response.PurchaseSucceededResponse;

public class MainActivity extends Activity {
	private GetJarContext _getJarContext = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get a list of the account names found on the device
        List<String> accountNames = new ArrayList<String>();
        for(Account account : AccountManager.get(this).getAccounts()){
        	accountNames.add(account.name);
        }
        //Populate our List UI with the account names
        ArrayAdapter<String> accountListSource = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,accountNames);
        ListView accountList = (ListView) this.findViewById(R.id.listViewAccounts);
        accountList.setAdapter(accountListSource);
        
        accountList.setOnItemClickListener(this._listItemClickListener);
        
        // If the user has not purchased the full version annoy the heck out of them
        SharedPreferences prefs = this.getSharedPreferences("AndroidBBCPrefsFile", Context.MODE_PRIVATE);
        if(!prefs.getBoolean("isFullVersion", false)) {
            this.showDialog(1);
        }
        
     // Start the GetJar Rewards SDK and tell it what to do when the user makes a purchase

        try {

            this._getJarContext = GetJarManager.createContext(
                "a782658d-54fa-45c6-f423-cb3103b21f89",
                this,
                new ResultReceiver(null) {
                    @Override
                    protected void onReceiveResult (int resultCode, Bundle resultData) {
                        for(String key : resultData.keySet()) {
                            if(resultData.get(key) instanceof PurchaseSucceededResponse) {
                                // The user has successfully purchased the full version, so do our work for a purchase here
                                Editor edit = getSharedPreferences("AndroidBBCPrefsFile", Context.MODE_PRIVATE).edit();
                                edit.putBoolean("isFullVersion", true).commit();
                                edit.commit();
                            }
                        }
                    }
                }
            );
        } catch (InterruptedException e) {
            e.printStackTrace();  // Log the error
        }     
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /** A click handler to do something when someone clicks on a list item */
    private OnItemClickListener _listItemClickListener = new OnItemClickListener() {
    	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            
    		// Get the selected item (an email address hopefully)
    		String accountName = (String)parent.getAdapter().getItem(position);
    		
    		// Tell the Android OS that we would like to compose and send an email to the selected account.
            // This is an example of something very common in Android. It is essentially asking the OS to
            // do a task and to have the OS select the best way to do the task for you.
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] { accountName });
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject: HI!");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Body: An email from some random Android app.");
            startActivity(Intent.createChooser(emailIntent, "Send eMail..."));
    		
    	}
	};
	
	@Override
    protected Dialog onCreateDialog (int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();
        // Inflate and set the layout for the dialog
        View dialogView = inflater.inflate(R.layout.ad, null);
        builder.setView(dialogView);
        // Add a "Buy" button
        builder.setPositiveButton("Buy Full Version", new DialogInterface.OnClickListener() {

        	public void onClick(DialogInterface dialog, int which) {
        		 // Show the GetJar Rewards page, so the user can buy the full version of this lovely app
        	    GetJarPage rewardsPage = new GetJarPage(_getJarContext);
        	    rewardsPage.setProduct("AndroidBBCProdID", "AndroidBBC Full Version", "AndroidBBC Full Version", 1);
        	    rewardsPage.showPage();
        	}

        });
        // Add a "Continue" button
        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        return(builder.create());
    }
}
