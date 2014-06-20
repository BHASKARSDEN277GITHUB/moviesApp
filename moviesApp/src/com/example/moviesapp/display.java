package com.example.moviesapp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;


public class display extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display); //search instead of currents . names exchanged ...
		
		TextView output = (TextView)findViewById(R.id.output);
		output.setMovementMethod(new ScrollingMovementMethod());
		Intent i = getIntent();
	    String	content = i.getStringExtra("valueS");
	    int id=i.getIntExtra("valueI",0);
		
		
		
		
		switch(id)
		{
		
			case 0:
				output.setText("ERROR WHILE FETCHING DATA . TRY AGAIN LATER .");
				break ;
			case 1:
			try {
				JSONParser parser = new JSONParser();
				JSONObject obj= (JSONObject) parser.parse(content);
				JSONArray movies = (JSONArray) obj.get("movies");
				JSONObject mov1 = (JSONObject)movies.get(0);
				JSONObject mov2 = (JSONObject)movies.get(1);
				JSONObject mov3 = (JSONObject)movies.get(2);
				JSONObject mov4 = (JSONObject)movies.get(3);
				JSONObject mov5 = (JSONObject)movies.get(4);
				
				JSONObject rat1 = (JSONObject)mov1.get("ratings");
				JSONObject rat2 = (JSONObject)mov2.get("ratings");
				JSONObject rat3 = (JSONObject)mov3.get("ratings");
				JSONObject rat4 = (JSONObject)mov4.get("ratings");
				JSONObject rat5 = (JSONObject)mov5.get("ratings");


				String cast ="";
				JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
				JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
				JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
				JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
				JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
				
			
				
				String S1 , S2,S3,S4,S5;
				S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n"+((JSONObject)castJ1.get(1)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
				S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n"+((JSONObject)castJ2.get(1)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
				S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n"+((JSONObject)castJ3.get(1)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
				S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n"+((JSONObject)castJ4.get(1)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
				S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n"+((JSONObject)castJ5.get(1)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
				
				output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
				
				
				
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    break;
			case 2:
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					JSONObject mov1 = (JSONObject)movies.get(0);
					JSONObject mov2 = (JSONObject)movies.get(1);
					JSONObject mov3 = (JSONObject)movies.get(2);
					JSONObject mov4 = (JSONObject)movies.get(3);
					JSONObject mov5 = (JSONObject)movies.get(4);
					JSONObject rat1 = (JSONObject)mov1.get("ratings");
					JSONObject rat2 = (JSONObject)mov2.get("ratings");
					JSONObject rat3 = (JSONObject)mov3.get("ratings");
					JSONObject rat4 = (JSONObject)mov4.get("ratings");
					JSONObject rat5 = (JSONObject)mov5.get("ratings");
					
					JSONObject rel1 = (JSONObject)mov1.get("release_dates");
					JSONObject rel2 = (JSONObject)mov2.get("release_dates");
					JSONObject rel3 = (JSONObject)mov3.get("release_dates");
					JSONObject rel4 = (JSONObject)mov4.get("release_dates");
					JSONObject rel5 = (JSONObject)mov5.get("release_dates");
					
					String cast ="";
					JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
					JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
					JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
					JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
					JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
					
				
					
					String S1 , S2,S3,S4,S5;
					S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
					S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
					S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
					S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
					S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
					
					output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
					
					
					
						
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					JSONObject mov1 = (JSONObject)movies.get(0);
					JSONObject mov2 = (JSONObject)movies.get(1);
					JSONObject mov3 = (JSONObject)movies.get(2);
					JSONObject mov4 = (JSONObject)movies.get(3);
					JSONObject mov5 = (JSONObject)movies.get(4);
					JSONObject rat1 = (JSONObject)mov1.get("ratings");
					JSONObject rat2 = (JSONObject)mov2.get("ratings");
					JSONObject rat3 = (JSONObject)mov3.get("ratings");
					JSONObject rat4 = (JSONObject)mov4.get("ratings");
					JSONObject rat5 = (JSONObject)mov5.get("ratings");
					
					JSONObject rel1 = (JSONObject)mov1.get("release_dates");
					JSONObject rel2 = (JSONObject)mov2.get("release_dates");
					JSONObject rel3 = (JSONObject)mov3.get("release_dates");
					JSONObject rel4 = (JSONObject)mov4.get("release_dates");
					JSONObject rel5 = (JSONObject)mov5.get("release_dates");
					
					String cast ="";
					JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
					JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
					JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
					JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
					JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
					
				
					
					String S1 , S2,S3,S4,S5;
					S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
					S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
					S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
					S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
					S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
					
					output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
					
					
					
						
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					JSONObject mov1 = (JSONObject)movies.get(0);
					JSONObject mov2 = (JSONObject)movies.get(1);
					JSONObject mov3 = (JSONObject)movies.get(2);
					JSONObject mov4 = (JSONObject)movies.get(3);
					JSONObject mov5 = (JSONObject)movies.get(4);
					JSONObject rat1 = (JSONObject)mov1.get("ratings");
					JSONObject rat2 = (JSONObject)mov2.get("ratings");
					JSONObject rat3 = (JSONObject)mov3.get("ratings");
					JSONObject rat4 = (JSONObject)mov4.get("ratings");
					JSONObject rat5 = (JSONObject)mov5.get("ratings");
					
					JSONObject rel1 = (JSONObject)mov1.get("release_dates");
					JSONObject rel2 = (JSONObject)mov2.get("release_dates");
					JSONObject rel3 = (JSONObject)mov3.get("release_dates");
					JSONObject rel4 = (JSONObject)mov4.get("release_dates");
					JSONObject rel5 = (JSONObject)mov5.get("release_dates");
					
					String cast ="";
					JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
					JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
					JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
					JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
					JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
					
				
					
					String S1 , S2,S3,S4,S5;
					S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
					S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
					S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
					S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
					S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n" +"RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
					
					output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
					
					
					
						
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					JSONObject mov1 = (JSONObject)movies.get(0);
					JSONObject mov2 = (JSONObject)movies.get(1);
					JSONObject mov3 = (JSONObject)movies.get(2);
					JSONObject mov4 = (JSONObject)movies.get(3);
					JSONObject mov5 = (JSONObject)movies.get(4);
					JSONObject rat1 = (JSONObject)mov1.get("ratings");
					JSONObject rat2 = (JSONObject)mov2.get("ratings");
					JSONObject rat3 = (JSONObject)mov3.get("ratings");
					JSONObject rat4 = (JSONObject)mov4.get("ratings");
					JSONObject rat5 = (JSONObject)mov5.get("ratings");
					
					JSONObject rel1 = (JSONObject)mov1.get("release_dates");
					JSONObject rel2 = (JSONObject)mov2.get("release_dates");
					JSONObject rel3 = (JSONObject)mov3.get("release_dates");
					JSONObject rel4 = (JSONObject)mov4.get("release_dates");
					JSONObject rel5 = (JSONObject)mov5.get("release_dates");
					
					String cast ="";
					JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
					JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
					JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
					JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
					JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
					
					
					
				
					
					String S1 , S2,S3,S4,S5;
					S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
					S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
					S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
					S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
					S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
					
					output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
					
					
					
						
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					JSONObject mov1 = (JSONObject)movies.get(0);
					JSONObject mov2 = (JSONObject)movies.get(1);
					JSONObject mov3 = (JSONObject)movies.get(2);
					JSONObject mov4 = (JSONObject)movies.get(3);
					JSONObject mov5 = (JSONObject)movies.get(4);
					JSONObject rat1 = (JSONObject)mov1.get("ratings");
					JSONObject rat2 = (JSONObject)mov2.get("ratings");
					JSONObject rat3 = (JSONObject)mov3.get("ratings");
					JSONObject rat4 = (JSONObject)mov4.get("ratings");
					JSONObject rat5 = (JSONObject)mov5.get("ratings");
					
					JSONObject rel1 = (JSONObject)mov1.get("release_dates");
					JSONObject rel2 = (JSONObject)mov2.get("release_dates");
					JSONObject rel3 = (JSONObject)mov3.get("release_dates");
					JSONObject rel4 = (JSONObject)mov4.get("release_dates");
					JSONObject rel5 = (JSONObject)mov5.get("release_dates");
					
					String cast ="";
					JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
					JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
					JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
					JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
					JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
					
					
					
				
					
					String S1 , S2,S3,S4,S5;
					S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
					S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
					S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
					S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
					S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
					
					output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
					
					
					
						
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					JSONObject mov1 = (JSONObject)movies.get(0);
					JSONObject mov2 = (JSONObject)movies.get(1);
					JSONObject mov3 = (JSONObject)movies.get(2);
					JSONObject mov4 = (JSONObject)movies.get(3);
					JSONObject mov5 = (JSONObject)movies.get(4);
					JSONObject rat1 = (JSONObject)mov1.get("ratings");
					JSONObject rat2 = (JSONObject)mov2.get("ratings");
					JSONObject rat3 = (JSONObject)mov3.get("ratings");
					JSONObject rat4 = (JSONObject)mov4.get("ratings");
					JSONObject rat5 = (JSONObject)mov5.get("ratings");
					
					JSONObject rel1 = (JSONObject)mov1.get("release_dates");
					JSONObject rel2 = (JSONObject)mov2.get("release_dates");
					JSONObject rel3 = (JSONObject)mov3.get("release_dates");
					JSONObject rel4 = (JSONObject)mov4.get("release_dates");
					JSONObject rel5 = (JSONObject)mov5.get("release_dates");
					
					String cast ="";
					JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
					JSONArray castJ2 =(JSONArray)mov2.get("abridged_cast");
					JSONArray castJ3 =(JSONArray)mov3.get("abridged_cast");
					JSONArray castJ4 =(JSONArray)mov4.get("abridged_cast");
					JSONArray castJ5 =(JSONArray)mov5.get("abridged_cast");
					
					
					
				
					
					String S1 , S2,S3,S4,S5;
					S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
					S2="\n\n"+"SEARCH RESULT 2 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ2.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov2.get("title").toString() +"\n\n" +"YEAR		:	" + mov2.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov2.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat2.get("audience_rating")+"\n\n\n";
					S3="\n\n"+"SEARCH RESULT 3 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ3.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov3.get("title").toString() +"\n\n" +"YEAR		:	" + mov3.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov3.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat3.get("audience_rating")+"\n\n\n";
					S4="\n\n"+"SEARCH RESULT 4 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ4.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov4.get("title").toString() +"\n\n" +"YEAR		:	" + mov4.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov4.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat4.get("audience_rating")+"\n\n\n";
					S5="\n\n"+"SEARCH RESULT 5 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ5.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov5.get("title").toString() +"\n\n" +"YEAR		:	" + mov5.get("year").toString() +"\n\n" +"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov5.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat5.get("audience_rating")+"\n\n\n";
					
					output.setText("__________________\n"+S1+"__________________\n"+S2+"__________________\n"+S3+"__________________\n"+S4+"__________________\n"+S5);
					
					
					
						
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 8:
				//info
				try {
					
					
					JSONParser parser = new JSONParser();
					JSONObject obj= (JSONObject) parser.parse(content);
					JSONArray movies = (JSONArray) obj.get("movies");
					int size = movies.size();
					//int size =Integer.parseInt(obj.get("total").toString());
					
					if(size==0) 
					{
						
						output.setText("Sorry ! No Movie with given Name Found \n");
						
					}						//////////////////////////////////////////	ATLAST DONE ......  lol ... debugging needs most of the concentration ..
					else 
					{

						JSONObject mov1 = (JSONObject)movies.get(0);
						
						JSONObject rat1 = (JSONObject)mov1.get("ratings");
						
						
						JSONObject rel1 = (JSONObject)mov1.get("release_dates");
						
						
						//String cast ="";
						JSONArray castJ1 =(JSONArray)mov1.get("abridged_cast");
						
						
						String S1="" ;
						//checking if some release date is unavailable ..
						if(rel1.size()==1)
						{
							
						if(rel1.get("dvd")!=null)
						{	
						S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
						}
						
						else if(rel1.get("dvd")==null&&rel1.get("theater")!=null)
						{
							S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n"+"\n\n"+"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
						}
						
						else if(rel1.get("dvd")==null&&rel1.get("theater")==null)
						{
							S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
						}
						
						}
						else
							S1="\n\n"+"SEARCH RESULT 1 :\n"+"\n"+"CAST		:	" + ((JSONObject)castJ1.get(0)).get("name").toString()+"\n\n"+"TITLE		:	" + mov1.get("title").toString() +"\n\n" +"YEAR		:	" + mov1.get("year").toString() +"\n\n"+"\n\n"+"THEATER RELEASE DATE		:	"+rel1.get("theater").toString() +"\n\n"+"DVD RELEASE DATE		:	"+rel1.get("dvd").toString() +"\n\n"+"SYNOPSIS		:	" + mov1.get("synopsis").toString()+"\n\n"+"AUDIENCE RATINGS		:	" + rat1.get("audience_rating")+"\n\n\n";
						
						
						output.setText("__________________\n"+S1);	
						
					}
					
					
					
					
					
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					output.setText("Unable to process Request for this movie");
				}
				  
				break;
			
			case 10:
				//cast
				try {
				JSONParser parser = new JSONParser();
				JSONObject obj;
			
				obj = (JSONObject) parser.parse(content);
				
				JSONArray movies = (JSONArray) obj.get("movies");
				
				int size =Integer.parseInt(obj.get("total").toString());
				
				if(size==0)
				{
					output.setText("Sorry ! No Movie with given Name Found \n");
				}
				else
				{
					JSONObject mov1 = (JSONObject)movies.get(0);
					String identifier = mov1.get("id").toString();
					String url = "http://api.rottentomatoes.com/api/public/v1.0/movies/"+identifier+"/cast.json?apikey=t6dcmne5vvj33bz7s43wb6fm";
					
					//using asynchtask to get this url's contents ..
					
					new castOperation().execute(url);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break ;
				
			case 9:
				//reviews
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj;
				
					obj = (JSONObject) parser.parse(content);
					
					JSONArray movies = (JSONArray) obj.get("movies");
					
					int size =Integer.parseInt(obj.get("total").toString());
					
					if(size==0)
					{
						output.setText("Sorry ! No Movie with given Name Found \n");
					}
					else
					{
						JSONObject mov1 = (JSONObject)movies.get(0);
						String identifier = mov1.get("id").toString();
						String url = "http://api.rottentomatoes.com/api/public/v1.0/movies/"+identifier+"/reviews.json?apikey=t6dcmne5vvj33bz7s43wb6fm";
						
						//using asynchtask to get this url's contents ..
						
						new reviewOperation().execute(url);
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break ;
					
			case 11:
				//simillar movies list ..
				
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj;
				
					obj = (JSONObject) parser.parse(content);
					
					JSONArray movies = (JSONArray) obj.get("movies");
					
					int size =Integer.parseInt(obj.get("total").toString());
					
					if(size==0)
					{
						output.setText("Sorry ! No Movie with given Name Found \n");
					}
					else
					{
						JSONObject mov1 = (JSONObject)movies.get(0);
						String identifier = mov1.get("id").toString();
						String url = "http://api.rottentomatoes.com/api/public/v1.0/movies/"+identifier+"/similar.json?apikey=t6dcmne5vvj33bz7s43wb6fm&limit=5";
						
						//using asynchtask to get this url's contents ..
						
						new simillarOperation().execute(url);
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break ;
		}
		
		
			
		
		
	}
	
	private  class castOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(display.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		
		TextView output = (TextView)findViewById(R.id.output);
		
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
						try {
							JSONParser parser = new JSONParser() ;
						    JSONObject obj = (JSONObject)parser.parse(content);
							
							JSONArray castarray = (JSONArray)obj.get("cast");
							
							int size = castarray.size();
							int index=0;
							JSONObject object = new JSONObject();
							
							String S ="";
							while(index<size)
							{
								object = (JSONObject)castarray.get(index);
								String name = object.get("name").toString();
								S=S+"__________________\n"+name+"\n\n";
								index++;
							}
							
							output.setText(S);
							
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else
					{
						output.setText("error");
					}
			}
			
			
		
	}
	
	
	private  class reviewOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(display.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		
		TextView output = (TextView)findViewById(R.id.output);
		
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
						try {
							JSONParser parser = new JSONParser() ;
						    JSONObject obj = (JSONObject)parser.parse(content);
							
							JSONArray reviewarray = (JSONArray)obj.get("reviews");
							
							int size = reviewarray.size();
							int index=0;
							JSONObject object = new JSONObject();
							
							String S ="";
							if(size==0)
							{
								output.setText("No Reviews Availaible for this Movie");
							}
							else
							{	
							while(index<3)
							{
								object = (JSONObject)reviewarray.get(index);
								String critic = object.get("critic").toString();
								String date = object.get("date").toString();
								String freshness = object.get("freshness").toString();
								String publication = object.get("publication").toString();
								S = S +"__________________\n"+ "CRITICS		:	" +critic+ "\n\n" +"DATE		:	"+date+"\n\n"+"FRESHNESS		:	"+freshness+"\n\n"+"PUBLICATION		:	"+publication+"\n\n\n"		;
								index++;
							}
							
							output.setText(S);
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else
					{
						output.setText("error");
					}
			}
			
			
		
	}
	
	private  class simillarOperation extends AsyncTask<String ,Void,Void>
	{
		
		
		private ProgressDialog dialog = new ProgressDialog(display.this);// creating a progress dialog ..
		private String content ="";
		private String error=null;
		
		TextView output = (TextView)findViewById(R.id.output);
		
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
						try {
							JSONParser parser = new JSONParser() ;
						    JSONObject obj = (JSONObject)parser.parse(content);
							
							JSONArray simillararray = (JSONArray)obj.get("movies");
							
							int size = simillararray.size();
							int index=0;
							JSONObject object = new JSONObject();
							
							String S ="";
							
							if(size==0)
							{
								output.setText("No Simmilar Movies to the given Movie Found \n");
							}
							
							else
							{
							while(index<size)
							{
								object = (JSONObject)simillararray.get(index);
								String title = object.get("title").toString();
								S=S+"__________________\n"+"SEARCH RESULT"+(index+1)+" :\n"+title+"\n\n";
								index++;
							}
							
							output.setText(S);
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else
					{
						output.setText("error");
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


