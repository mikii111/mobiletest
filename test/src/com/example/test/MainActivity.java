package com.example.test;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends Activity {
	
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Set the user interface layout for this Activity
	    // The layout file is defined in the project res/layout/main_activity.xml file
	    setContentView(R.layout.main_activity);
	    
	    // Initialize member TextView so we can manipulate it later
	    mTextView = (TextView) findViewById(R.id.text_message);
	    
	    // Make sure we're running on Honeycomb or higher to use ActionBar APIs
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	        // For the main activity, make sure the app icon in the action bar
	        // does not behave as a button
	        ActionBar actionBar = getActionBar();
	        actionBar.setHomeButtonEnabled(false);
	    }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void sendMessage (View view){
		 Intent intent = new Intent(this, MainMessageActivity.class);
		    EditText editText = (EditText) findViewById(R.id.edit_message);
		    String message = editText.getText().toString();
		    intent.putExtra(EXTRA_MESSAGE, message);
		    startActivity(intent);

		
	}

}
