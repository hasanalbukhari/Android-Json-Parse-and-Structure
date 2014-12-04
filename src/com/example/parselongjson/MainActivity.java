package com.example.parselongjson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements HttpResponsered {

	public TextView stateTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		stateTextView = (TextView)findViewById(R.id.stateTextView);
		
		new HttpClientThread().execute(this, "https://api.vk.com/method/wall.get?owner_id=-81865402&v=5.27");
		stateTextView.setText("Getting Data...");
	}

	@Override
	public void responseWithError(String error, Object... parameters) {
		stateTextView.setText("Getting Data Fail... " + error);
		Toast.makeText(this, "Fail Request! ", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void response(String response, Object... parameters) {
		stateTextView.setText("Getting Data Completed");
		
		ArrayList<Item> items = new JsonParser(response).getItems();
		Item item = items.get(1);
		PhotoAttachment photoAttachment = (PhotoAttachment)item.getAttachments().get(0);
		
		DateFormat formatter = new SimpleDateFormat("ss");
		Date date = null;
		try {
			date = formatter.parse(photoAttachment.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stateTextView.setText(item.getText() + "\n\n"
								+ photoAttachment.getPhoto_75() + "\n\n"
								+ date.toString() + "\n\n"
								+ date.getDate() + "-" + (date.getMonth()+1) + "-" + (date.getYear()+1900) + " " 
								+ date.getHours()  + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n\n");
		
		// you can move date conversion to the class date setter.
	}
}
