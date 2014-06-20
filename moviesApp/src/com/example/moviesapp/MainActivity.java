package com.example.moviesapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	public static final int MENU_ABOUT=Menu.FIRST;
	public static final int MENU_EXIT=Menu.FIRST+1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button current=(Button)findViewById(R.id.buttonCurrents);
		Button search=(Button)findViewById(R.id.buttonSearchMovie);
		Button dvd=(Button)findViewById(R.id.dvd);
		current.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(),currents.class);
				startActivity(i);
				
			}
		});
		search.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					Intent i = new Intent(getApplicationContext(),search.class);
					startActivity(i);
				
				}
			});
		dvd.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(),dvd.class);
				startActivity(i);
		
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		/* Creates the menu items */
		
		    menu.add(0, MENU_ABOUT, 0, "ABOUT");
		    menu.add(0,MENU_EXIT,0,"QUIT");
		   
		return true;
	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case MENU_ABOUT:
	        Intent about = new Intent(this,about.class);
	        startActivity(about);
	        
	        return true;
	    case MENU_EXIT:
	        finish();
	        return true;    
	    }
	    return false;
	}

}
