package activitys;



import task.LoginTask;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
// maby change to popup that runs in an seperate thread
public class LogIn extends Activity{
	Activity calledBy ;
	final LogIn login = this;
	//http://stacktips.com/tutorials/android/android-checkbox-example
	private CheckBox safelogin;
	String eMail = null;
	String password = null;
	//Special thanks to Leander for this Tip
	//https://developer.android.com/training/basics/activity-lifecycle/recreating.html
	
	static final String STATE_EMAIL = "logineMail";
	static final String STATE_PASSWORD = "loginPassword";
	private TextView errorView;
	private EditText keyInsert;
	private EditText eMailInsert;
	//http://stackoverflow.com/questions/18341269/save-the-data-and-using-it-after-restarting-the-app-android
	private SharedPreferences prefs;
//	 public static final String prefName = "MyPrefsFile";
	
	
	//https://www.youtube.com/watch?v=iW71-sVyMzM
	
	protected void onCreate(Bundle savedInstanceState) {
		
		//TODO Hardcoded Create XML Fiel color in values
		 
		super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        errorView = (TextView)findViewById(R.id.errorView);
         keyInsert =(EditText)findViewById(R.id.sKeyInsert);
         eMailInsert =(EditText)findViewById(R.id.sEmailInsert);
        
		errorView.setVisibility(View.GONE);
		errorView.setTextColor(0xffff0000);
	    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	    safelogin = (CheckBox) findViewById(R.id.safelogin);
	   String p = prefs.getString("password", null);
	   String  e = prefs.getString("eMail", null);
	   
		   password =  p;
	   
	   if(e!=null){
		  eMail =  e;
	   }
	   
		   safelogin.setChecked(prefs.getBoolean("checked", false));
	   
		if(password!= null) keyInsert.setText(password);
        if(eMail != null )eMailInsert.setText(eMail);
       
       
        final Button register = (Button) findViewById(R.id.rButton);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	if(true){
              startActivity(new Intent(getApplicationContext(),Registration.class));
            	}
            }
        });
        
       
      
      
        final Button signIn = (Button) findViewById(R.id.sButton);
        signIn.setOnClickListener(new View.OnClickListener() {
        	//http://stackoverflow.com/questions/21668632/android-check-length-of-a-string
            public void onClick(View v) {
            	
            		String  eMail =eMailInsert.getText().toString();
            	
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
            			errorView.setText(getResources().getString(R.string.missing_email));
            			}
            		}
            	}
            	
            }
        });
	}
	public void getLoginValues(int id, boolean gender){
		//Switch (calledBy.getAct)
		if(id > -1){
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		startActivity(new Intent(intent));
		}
		else{
			final TextView errorView = (TextView)findViewById(R.id.errorView);	
			errorView.setText(getResources().getString(R.string.wrong_login));
		}
		
	}
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    // Save the user's current game state
	    savedInstanceState.putString(STATE_EMAIL, eMailInsert.getText().toString());
	    
	    
	    if(safelogin.isChecked()){
    		savedInstanceState.putString(STATE_PASSWORD,keyInsert.getText().toString() );
    	}

	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}
	public void onRestoreInstanceState(Bundle savedInstanceState) {
	    // Always call the superclass so it can restore the view hierarchy
	    super.onRestoreInstanceState(savedInstanceState);

	    // Restore state members from saved instance
	    eMail = savedInstanceState.getString(STATE_EMAIL);
	    password = savedInstanceState.getString(STATE_PASSWORD);
	}
	public void connectionError(){
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
	      if(safelogin.isChecked()){
	      editor.putString("password",keyInsert.getText().toString());
	      editor.putBoolean("checked ", true);
	      }
	      else{
	    	  editor.putString("password",null); 
	    	  editor.putBoolean("checked ",true);
	      }
	      editor.putString("eMail",eMailInsert.getText().toString() );
	      editor.commit();
	}		
	}
