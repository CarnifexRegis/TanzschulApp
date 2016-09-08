package com.example.tsconfigurtion;

import model.ConnectedActivity;
import tasks.LoginTask;






import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
/**
 * 
 * @author Simon
 *	Activity icon source: http://findicons.com/files/icons/1580/devine_icons_part_2/128/control_panel.png
 *@ Source : //http://stackoverflow.com/questions/18341269/save-the-data-and-using-it-after-restarting-the-app-android
 */ 
public class Login extends ConnectedActivity {
	//Source 
	final Login login = this;
	//http://stacktips.com/tutorials/android/android-checkbox-example
	private CheckBox safelogin;
	private String name = null;
	private String password = null;
	private boolean c = false;
	String errorCode = null;
	
	private TextView errorView;
	private EditText keyInsert;
	private EditText nameInsert;
	
	private SharedPreferences prefs;
	
	protected void onCreate(Bundle savedInstanceState) {
		
		
		 Bundle extras = getIntent().getExtras();
		if(extras != null){
		errorCode = extras.getString("error");
		}
		
		//TODO Hardcoded Create XML Fiel color in values
		 
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        errorView = (TextView)findViewById(R.id.errorView);
       
        
         keyInsert =(EditText)findViewById(R.id.sKeyInsert);
        nameInsert =(EditText)findViewById(R.id.sEmailInsert);
         errorView.setTextColor(0xffff0000);
		if (errorCode== null){
			errorView.setVisibility(View.GONE);
		}else{
			errorView.setVisibility(View.VISIBLE);
			errorView.setText(errorCode);
		}
		
		
	    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	    safelogin = (CheckBox) findViewById(R.id.safelogin);
	    safelogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Editor editor = prefs.edit();
                if(safelogin.isChecked()){
                	c = true;
                	//editor.putBoolean("c ", true);  
                }else{
                	c = false;
            	     // editor.putBoolean("c ", false);
                }
                editor.commit();
            }
        });
	   String p = prefs.getString("password", null);
	   String  e = prefs.getString("eMail", null);
	   c = prefs.getBoolean("c", false);
		   
	 password =  p;
	   
	   if(e!=null){
		  name =  e;
	   }
	   
		   safelogin.setChecked(c);
	   
		 keyInsert.setText(password);
       nameInsert.setText(name);
       
       
        
        
       
      
      
        final Button signIn = (Button) findViewById(R.id.sButton);
        signIn.setOnClickListener(new View.OnClickListener() {
        	//http://stackoverflow.com/questions/21668632/android-check-length-of-a-string
            public void onClick(View v) {
            	
            		String  eMail =nameInsert.getText().toString();
            	
            		String  key =keyInsert.getText().toString();
            	System.out.println(eMail + key + "Values");
              if(key.length()> 0 && eMail.length() > 0){
            	LoginTask loginTask = new LoginTask(login, eMail, key);
            	errorView.setVisibility(View.GONE);
            	
            	loginTask.execute();
            	
            	}else{
            		errorView.setVisibility(View.VISIBLE);
            		if(key.length() == 0&& eMail.length() <= 0){
            			errorView.setText(getResources().getString(R.string.missing_login_data));
            		}else{
            			if(key.length() == 0){
            			
            			errorView.setText(getResources().getString(R.string.missing_key));
            			}else{
            			errorView.setText(getResources().getString(R.string.missing_admin));
            			}
            		}
            	}
            	
            }
        });
	}
	
	public void getLoginValues(int id){
		//Switch (calledBy.getAct)
		
		Intent intent = new Intent(getApplicationContext(),ManageKurs.class);
		intent.putExtra("id", id);
		
		startActivity(new Intent(intent));
		
		


		
	}
	@Override
	public void onConnectionError(){
		errorView.setVisibility(View.VISIBLE);
		if(!isOnline(this)){
			errorView.setText(getResources().getString(R.string.check_connection));
		}else{
			errorView.setText(getResources().getString(R.string.connection_failed));
		}
		}
	
	public boolean isOnline(Context context) {
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
	    if (networkinfo != null && networkinfo.isConnected()) {
	        return true;
	    }
	    return false;}

	
	@Override
	public void onPause(){
		super.onPause();
		// prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	      Editor editor = prefs.edit();
	      if(c){
	      editor.putString("password",keyInsert.getText().toString());
	      editor.putBoolean("c", true);
	      }
	      else{
	    	  editor.putString("password",null); 
	    	  editor.putBoolean("c",false);
	      }
	      editor.putString("eMail",nameInsert.getText().toString() );
	      editor.commit();
	     
	}
	@Override
	public void onError(String ec) {
		switch (ec){
		case  "wrongLogin":
			errorView.setVisibility(View.VISIBLE);
			errorView.setText(getResources().getString(R.string.wrong_login));
			break;
		case "notFound" :
			errorView.setVisibility(View.VISIBLE);
			errorView.setText(getResources().getString(R.string.unknown_error));
			break;
		}
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.login, menu);
//		return true;
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
