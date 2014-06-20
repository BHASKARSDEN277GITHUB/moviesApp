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
import android.widget.EditText;
import android.widget.Toast;

public class search extends Activity {

	
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.currents); //currents instead of search .. names exchanged ..
		
		Button info = (Button)findViewById(R.id.info);
		Button rev = (Button)findViewById(R.id.reviews);
		Button cast = (Button)findViewById(R.id.cast);
		Button sim = (Button)findViewById(R.id.simillar);
		//Button rel = (Button)findViewById(R.id.cilps);
		
		
		info.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText name = (EditText)findViewById(R.id.Title);
				String getname = name.getText().toString();
				if(getname.equals(""))
				{
					name.setHint("Enter Title of Movie");
				}
				else
				{	
				String transformName ="";
				int size = getname.length() ,index=0;
				while(index<size)  //filling white spaces with '%20' ..
				{
					if(getname.charAt(index)!=' ')
					transformName=transformName+getname.charAt(index);
					else
						transformName=transformName+"%20";
					index++;
				}
				String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=t6dcmne5vvj33bz7s43wb6fm&q="+transformName+"&page_limit=1";
				
				//execute method on object of class which extends asynchtask class ..
				
				
				new operation().execute(url);
				name.setText("");
				}
			}
		});
rev.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText name = (EditText)findViewById(R.id.Title);
				String getname = name.getText().toString();
				if(getname.equals(""))
				{
					name.setHint("Enter Title of Movie");
				}
				else
				{	
				String transformName ="";
				int size = getname.length() ,index=0;
				while(index<size)  //filling white spaces with '%20' ..
				{
					if(getname.charAt(index)!=' ')
					transformName=transformName+getname.charAt(index);
					else
						transformName=transformName+"%20";
					index++;
				}
				String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=t6dcmne5vvj33bz7s43wb6fm&q="+transformName+"&page_limit=10";
				
				//execute method on object of class which extends asynchtask class ..
				
				
				new revoperation().execute(url);
				name.setText("");
				}
			}
		});
cast.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		EditText name = (EditText)findViewById(R.id.Title);
		String getname = name.getText().toString();
		if(getname.equals(""))
		{
			name.setHint("Enter Title of Movie");
		}
		else
		{	
		String transformName ="";
		int size = getname.length() ,index=0;
		while(index<size)  //filling white spaces with '%20' ..
		{
			if(getname.charAt(index)!=' ')
			transformName=transformName+getname.charAt(index);
			else
				transformName=transformName+"%20";
			index++;
		}
		String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=t6dcmne5vvj33bz7s43wb6fm&q="+transformName+"&page_limit=10";
		
		//execute method on object of class which extends asynchtask class ..
		
		
		new castoperation().execute(url);
		name.setText("");
		}
	}
});
sim.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		EditText name = (EditText)findViewById(R.id.Title);
		String getname = name.getText().toString();
		if(getname.equals(""))
		{
			name.setHint("Enter Title of Movie");
		}
		else
		{	
		String transformName ="";
		int size = getname.length() ,index=0;
		while(index<size)  //filling white spaces with '%20' ..
		{
			if(getname.charAt(index)!=' ')
			transformName=transformName+getname.charAt(index);
			else
				transformName=transformName+"%20";
			index++;
		}
		String url = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=t6dcmne5vvj33bz7s43wb6fm&q="+transformName+"&page_limit=10";
		
		//execute method on object of class which extends asynchtask class ..
		
		
		new simoperation().execute(url);
		name.setText("");
		}
	}
});

		 
	}
	
	private  class operation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(search.this);// creating a progress dialog ..
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
					
					
					//EditText ed = (EditText)findViewById(R.id.Title);
					//ed.setText(content);
					Intent i = new Intent(getApplicationContext(),display.class);
					i.putExtra("valueS", content);
					i.putExtra("valueI", 8);
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
	
	private  class revoperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(search.this);// creating a progress dialog ..
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
						i.putExtra("valueI", 9);
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
	private  class castoperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(search.this);// creating a progress dialog ..
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
						i.putExtra("valueI", 10);
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
	private  class simoperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(search.this);// creating a progress dialog ..
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
						i.putExtra("valueI", 11);
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
