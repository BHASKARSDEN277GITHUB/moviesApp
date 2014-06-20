package com.example.moviesapp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class dvd extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dvd);
		
		Button current = (Button)findViewById(R.id.current);
		Button getting = (Button)findViewById(R.id.newr);
		Button upcoming = (Button)findViewById(R.id.upcomingr);
		
		
current.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			String url="http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/current_releases.json?apikey=t6dcmne5vvj33bz7s43wb6fm&page_limit=10";
			new currentOperation().execute(url);
				
			}
		});
getting.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	String url="http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/new_releases.json?apikey=t6dcmne5vvj33bz7s43wb6fm&page_limit=10";
	new gettingOperation().execute(url);
		
	}
});
upcoming.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
	String url="http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/upcoming.json?apikey=t6dcmne5vvj33bz7s43wb6fm&page_limit=10";
	new upcomingOperation().execute(url);
		
	}
});
		
	}
	
	private  class currentOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(dvd.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		
		 private final HttpClient client =new DefaultHttpClient();
		

		
		protected void onPreExecute()
		{
			dialog.setMessage("Getting resources ..");
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(String... urls) {
					
			
			try {
				HttpGet httpget = new HttpGet(urls[0]);
			   ResponseHandler<String> responsehandler=new BasicResponseHandler();
			   content=client.execute(httpget,responsehandler);
			   
			}
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				error=e.getMessage();
				cancel(true);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				error=e.getMessage();
				cancel(true);
			}
			return null;
			
		}
			
			protected void onPostExecute(Void unused)
			{
					dialog.dismiss();
					if(error== null)
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						i.putExtra("valueS", content);
						i.putExtra("valueI", 5);
						startActivity(i);
					}
					else
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						i.putExtra("valueS", content);
						i.putExtra("valueI",0); 
						startActivity(i);
								
					}
			}
			
			
		
	}
	
	private  class gettingOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(dvd.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		
		 private final HttpClient client =new DefaultHttpClient();
		

		
		protected void onPreExecute()
		{
			dialog.setMessage("Getting resources ..");
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(String... urls) {
					
			
			try {
				HttpGet httpget = new HttpGet(urls[0]);
			   ResponseHandler<String> responsehandler=new BasicResponseHandler();
			   content=client.execute(httpget,responsehandler);
			   
			}
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				error=e.getMessage();
				cancel(true);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				error=e.getMessage();
				cancel(true);
			}
			return null;
			
		}
			
			protected void onPostExecute(Void unused)
			{
					dialog.dismiss();
					if(error== null)
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						i.putExtra("valueS", content);
						i.putExtra("valueI", 6);
						startActivity(i);
					}
					else
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						i.putExtra("valueS", content);
						i.putExtra("valueI",0); 
						startActivity(i);
								
					}
			}
			
			
		
	}

	private  class upcomingOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(dvd.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		
		 private final HttpClient client =new DefaultHttpClient();
		

		
		protected void onPreExecute()
		{
			dialog.setMessage("Getting resources ..");
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(String... urls) {
					
			
			try {
				HttpGet httpget = new HttpGet(urls[0]);
			   ResponseHandler<String> responsehandler=new BasicResponseHandler();
			   content=client.execute(httpget,responsehandler);
			   
			}
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				error=e.getMessage();
				cancel(true);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				error=e.getMessage();
				cancel(true);
			}
			return null;
			
		}
			
			protected void onPostExecute(Void unused)
			{
					dialog.dismiss();
					if(error== null)
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						i.putExtra("valueS", content);
						i.putExtra("valueI", 7);
						startActivity(i);
					}
					else
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						i.putExtra("valueS", content);
						i.putExtra("valueI",0); 
						startActivity(i);
								
					}
			}
			
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
