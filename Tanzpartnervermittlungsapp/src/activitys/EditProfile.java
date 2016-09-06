package activitys;

import model.ProfileData;
import task.ProfileDataTask;
import task.RegisterTask;
import task.UpdateProfileTask;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



// Added: 13.06.2016
//Last Modofied:14.6.2016 
// Add Listeners for 2 Radio Groups and one Button Mabe do the first request
public class EditProfile extends Activity {
//	ProfileDataForServer data;
	EditText pnInsert;
	EditText pTextInsert;
	EditText ageInsert;
	EditText heightInsert;
	TextView fnView;
	TextView lnView;
	TextView errorView;
	CheckBox paCheck;
EditProfile edp = this;
int id;
String pn;
int height;
int age;
String pText;
boolean pa;

boolean gender;



	protected void onCreate(Bundle savedInstanceState) {
		 Bundle extras = getIntent().getExtras();
			if(extras != null){
				id = extras.getInt("ID");
			}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		 pnInsert = (EditText) findViewById(R.id.pNumberInsert);
		 pTextInsert = (EditText) findViewById(R.id.aboutMeInsert);
		 ageInsert = (EditText) findViewById(R.id.ageInsert);
		 heightInsert = (EditText) findViewById(R.id.heightInsert);
		 fnView = (TextView) findViewById(R.id.fnameView);
		 lnView = (TextView) findViewById(R.id.lnameView);
		 errorView = (TextView) findViewById(R.id.epErrorView);
		 paCheck = (CheckBox) findViewById(R.id.checkBox1);
		 
	ProfileDataTask pdTask = new ProfileDataTask(edp,id);
    	pdTask.execute();
    	errorView.setVisibility(View.GONE);
		
		// This Button reads the Users inserted information and saves it in a ProfileDataForServer Object 
		final Button ready = (Button) findViewById(R.id.fertigButton);
        ready.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            // TODO nach dem ersten Request das für alle übernehmen
            	if(pnInsert.getText().toString().length()>0){
            	pn = pnInsert.getText().toString();
            	}else{
            		pn = getString(R.string.missing_value);  
            	}
            	if(ageInsert.getText().toString().length()>0){
            		age = Integer.valueOf(ageInsert.getText().toString());
            		}else{
            			age = 0;}
            	if(heightInsert.getText().toString().length()>0){
            		height = Integer.valueOf(heightInsert.getText().toString());}
            			else{height  = 0;}
            	if(!pTextInsert.getText().toString().equals(getString(R.string.about_me))
            			&&!pTextInsert.getText().toString().equals(getString(R.string.missing_value))
            			&&pTextInsert.getText().toString().length()>0)
            		{
            		pText =  pTextInsert.getText().toString();}
            	else{
            		pText =getString(R.string.missing_value); 
            		}
            	pa = paCheck.isChecked();
            	UpdateProfileTask upTask = new UpdateProfileTask(edp,id,pn,height,age,pText,pa);
            	upTask.execute();
            }
        });
		
	    }
	public void rechieveData(ProfileData pd) {
		
		if(pd.getPhoneNumber().length()>0){
			pnInsert.setText( pd.getPhoneNumber());
		}
		pTextInsert.setText(pd.getpText());
		fnView.setText(pd.getFn());
		lnView.setText(pd.getLn());
		gender = pd.isGender();
		paCheck.setChecked(pd.isPa());
		pnInsert.setText(pd.getPhoneNumber()+"");
		pTextInsert.setText(pd.getpText());
		ageInsert.setText(pd.getAge()+"");
		heightInsert.setText(pd.getHeight()+"");
				}
	
	public void onError() {
		// there is just one possible error code		
		Intent intent = new Intent(getApplicationContext(),LogIn.class);
		intent.putExtra("error", "Sitzung abgelaufen");
		startActivity(new Intent(intent));
	}
	public void updateSucessful() {
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		startActivity(new Intent(intent));
	}
	public void onError(String error) {
		Intent intent = new Intent(getApplicationContext(),LogIn.class);
		intent.putExtra("error", "Fatal error: " + error);
		startActivity(new Intent(intent));
		
	}
	public boolean isOnline(Context context) {
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
	    if (networkinfo != null && networkinfo.isConnected()) {
	        return true;
	    }
	    return false;}
	
	public void ConnectionError() {
		
			
			if(!isOnline(this)){
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
		                Toast.LENGTH_SHORT).show(); 
			
			}else{
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.connection_failed), 
		                Toast.LENGTH_SHORT).show(); 
				
			}
			
		
	}
	}
