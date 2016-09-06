package activitys;

import model.ProfileData;
import task.ForeignProfileTask;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Simon
 *@ Source: http://stackoverflow.com/questions/19253786/how-to-copy-text-to-clip-board-in-android
 */
public class ShowProfile extends Activity {
int id;
boolean gender;
String eMail;
ShowProfile sp = this;
TextView nameView;


TextView ageText;
TextView ageView;
TextView heightView;
TextView aboutMeView;
TextView pnView;
TextView errorView;
private ClipData myClip;
private ClipboardManager myClipboard;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       setContentView(R.layout.show_profile);
	       Bundle extras = getIntent().getExtras();
			if(extras != null){
			id = extras.getInt("ID");
			gender = extras.getBoolean("gender");
			eMail = extras.getString("eMail");
			}
			
			nameView = (TextView) findViewById(R.id.spnView);
			
			ageText = (TextView) findViewById(R.id.spAgeText);
			ageView = (TextView) findViewById(R.id.spAgeView);
			heightView = (TextView) findViewById(R.id.spHeightView);
			aboutMeView = (TextView) findViewById(R.id.spAboutMeView);
			pnView = (TextView) findViewById(R.id.spPhoneView);
			errorView = (TextView) findViewById(R.id.spErrorView);
			errorView.setTextColor(0xffff0000);
			errorView.setVisibility(View.GONE);
			
	       final Button menueButton = (Button) findViewById(R.id.spMenueButton);
	       menueButton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	Intent intent = new Intent(getApplicationContext(),Menue.class);
	        		intent.putExtra("ID", id);
	        		intent.putExtra("gender", gender);
	        			 startActivity(new Intent(intent));     	
	            }
	        });	
	       final Button addUserButton = (Button) findViewById(R.id.spAddUserButton);
	       addUserButton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	
	            }
	        });	
	   
	       final Button ZwischenablageButton = (Button) findViewById(R.id.spZwischenablageButton);
	    		   ZwischenablageButton.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	if(pnView.getText().toString().equals(getString(R.string.missing_value))){
	            		Toast.makeText(getApplicationContext(),getString(R.string.missing_value), 
	        	                Toast.LENGTH_SHORT).show(); 
	            	}
	            	else{
	            	String text = pnView.getText().toString();
	                myClip = ClipData.newPlainText("text", text);
	                myClipboard.setPrimaryClip(myClip);
	                Toast.makeText(getApplicationContext(), "In Zwischenablage.", 
	                Toast.LENGTH_SHORT).show(); 
	            	}}
	        });	  
	   ForeignProfileTask fpt =new ForeignProfileTask(sp, eMail);
			fpt.execute();
			}

	
		public void connectionError(){
			
			String error;
			if(!isOnline(this)){
				
				  error = getResources().getString(R.string.check_connection);
			}else{
				error =getResources().getString(R.string.connection_failed);
			}
//				Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show(); 
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch bloc
//				e.printStackTrace();
//			}
			Intent intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
			intent.putExtra("ID", id);
			intent.putExtra("gender", gender);
			intent.putExtra("error", error);
			startActivity(new Intent(intent));
			}
		
		
		
	public boolean isOnline(Context context) {
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
	    if (networkinfo != null && networkinfo.isConnected()) {
	        return true;
	    }
	    return false;}

	public void onError(String error) {

//		errorView.setVisibility(View.VISIBLE);
//		errorView.setText("Das gesuchte Benutzerkonto konnte nicht gefunden werden.");
//		Toast.makeText(getApplicationContext(), "Das gesuchte Benutzerkonto konnte nicht gefunden werden.", Toast.LENGTH_LONG).show(); 
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch bloc
//			e.printStackTrace();
//		}
		Intent intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		intent.putExtra("error", "Fatal error: "+error);
		startActivity(new Intent(intent));
	}


	public void rechieveData(ProfileData pd) {
		
		if(pd.isPa()){
		 ageView.setText(pd.getAge()+"");
		 }else{
			ageView.setText(R.string.missing_value);
		 }
		 heightView.setText(pd.getHeight()+"");
		 aboutMeView.setText(pd.getpText());
		 pnView.setText(pd.getPhoneNumber()+"");
		 nameView.setText(pd.getFn()+" "+pd.getLn());
	}
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		String e  = null;
		Intent intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		intent.putExtra("error", e);
		startActivity(new Intent(intent));
	}
}
	

