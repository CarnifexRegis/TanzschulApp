package activitys;




import task.LoginTask;
import com.example.Tanzpartnervermittlung.R;
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
// TODO: Auto-generated Javadoc

/**
 * @author Simon Stolz
 */
// maby change to popup that runs in an seperate thread
public class LogIn extends ConnectedActivity{
	final LogIn login = this;
	//http://stacktips.com/tutorials/android/android-checkbox-example
	private CheckBox safelogin;
	private String eMail = null;
	private String password = null;
	private boolean c = false;
	private String errorCode = null;
	//Special thanks to Leander for this Tip
	//https://developer.android.com/training/basics/activity-lifecycle/recreating.html
	
	//static final String STATE_EMAIL = "logineMail";
	//static final String STATE_PASSWORD = "loginPassword";
	//static final String STATE_CHECK = "check";
	private TextView errorView;
	private EditText keyInsert;
	private EditText eMailInsert;

	//http://stackoverflow.com/questions/18341269/save-the-data-and-using-it-after-restarting-the-app-android
	private SharedPreferences prefs;
//	 public static final String prefName = "MyPrefsFile";
	
	
	//https://www.youtube.com/watch?v=iW71-sVyMzM
	
	/* (non-Javadoc)
 * @see android.app.Activity#onCreate(android.os.Bundle)
 */
protected void onCreate(Bundle savedInstanceState) {
		
		
		 Bundle extras = getIntent().getExtras();
		if(extras != null){
		errorCode = extras.getString("error");
		}
		
		//TODO Hardcoded Create XML Fiel color in values
		 
		super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        errorView = (TextView)findViewById(R.id.errorView);
       
        
         keyInsert =(EditText)findViewById(R.id.sKeyInsert);
         eMailInsert =(EditText)findViewById(R.id.sEmailInsert);
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
		  eMail =  e;
	   }
	   
		   safelogin.setChecked(c);
	   
		 keyInsert.setText(password);
       eMailInsert.setText(eMail);
       
       
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
	
	/**
	 * Gets the login values.
	 *
	 * @param id the id
	 * @param gender the gender
	 * @return the login values
	 */
	public void getLoginValues(int id, boolean gender){
		//Switch (calledBy.getAct)
		
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		startActivity(new Intent(intent));
		
		


		
	}
	
	/* (non-Javadoc)
	 * @see activitys.ConnectedActivity#onConnectionError()
	 */
	@Override
	public void onConnectionError(){
		errorView.setVisibility(View.VISIBLE);
		if(!isOnline(this)){
			errorView.setText(getResources().getString(R.string.check_connection));
		}else{
			errorView.setText(getResources().getString(R.string.connection_failed));
		}
		}
	
	/* (non-Javadoc)
	 * @see activitys.ConnectedActivity#isOnline(android.content.Context)
	 */
	public boolean isOnline(Context context) {
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
	    if (networkinfo != null && networkinfo.isConnected()) {
	        return true;
	    }
	    return false;}

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
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
	      editor.putString("eMail",eMailInsert.getText().toString() );
	      editor.commit();
	     
	}
	
	/* (non-Javadoc)
	 * @see activitys.ConnectedActivity#onError(java.lang.String)
	 */
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
	
		
	}
