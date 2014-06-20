package com.example.moviesapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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

public class currents extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search); //search instead of currents . names exchanged ...
		
		Button boxoffice = (Button)findViewById(R.id.box);
		Button upcoming = (Button)findViewById(R.id.upcoming);
		Button theater = (Button)findViewById(R.id.theater);
		Button opening = (Button)findViewById(R.id.opening);
		
		
		// funcitons here ..
		
		boxoffice.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			String url="http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=t6dcmne5vvj33bz7s43wb6fm&limit=10";
			new boxOperation().execute(url);
				
			}
		});
		upcoming.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String url="http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=t6dcmne5vvj33bz7s43wb6fm&page_limit=10";
				new upcomingOperation().execute(url);
			}
		});
		
		
	theater.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		String url="http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?apikey=t6dcmne5vvj33bz7s43wb6fm&page_limit=10";
		new theaterOperation().execute(url);
		}
	});
	
	
	opening.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		String url="http://api.rottentomatoes.com/api/public/v1.0/lists/movies/opening.json?apikey=t6dcmne5vvj33bz7s43wb6fm&limit=10";
		new openingOperation().execute(url);
		
		}
	});
		
		//private classes extending asynchtask here ..\
	}
	
	private  class boxOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(currents.this);// creating a progress dialog ..
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
						i.putExtra("valueI", 1);
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
	
	
	private class upcomingOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(currents.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		//TextView data = (TextView)findViewById(R.id.data);
		 private final HttpClient client =new DefaultHttpClient();
		int l=0;

		
		protected void onPreExecute()
		{
			dialog.setMessage("Getting resources ..");
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(String... urls) {
					
			URL url;
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
						i.putExtra("valueI", 2);
						startActivity(i);
					}
					else
					{
						Intent i = new Intent(getApplicationContext(),display.class);
						//i.putExtra("valueS", content);
						i.putExtra("valueI",0); 
						startActivity(i);
								
					}
			
			}
		
	}
	
	private class theaterOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(currents.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		//TextView data = (TextView)findViewById(R.id.data);
		 private final HttpClient client =new DefaultHttpClient();
		int l=0;

		
		protected void onPreExecute()
		{
			dialog.setMessage("Getting resources ..");
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(String... urls) {
					
			URL url;
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
						i.putExtra("valueI", 3);
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
	
	private class openingOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(currents.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		//TextView data = (TextView)findViewById(R.id.data);
		 private final HttpClient client =new DefaultHttpClient();
		int l=0;

		
		protected void onPreExecute()
		{
			dialog.setMessage("Getting resources ..");
			dialog.show();
		}
		
		@Override
		protected Void doInBackground(String... urls) {
					
			URL url;
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
						i.putExtra("valueI", 4);
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