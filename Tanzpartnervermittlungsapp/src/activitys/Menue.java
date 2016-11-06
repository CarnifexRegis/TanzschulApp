package activitys;

import model.ConnectedActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.Tanzpartnervermittlung.R;
// TODO: Auto-generated Javadoc
//SQL für Fortgeschritttene join..on group by Roman Create Table, insert,update 
//Php my table
/**
 * The Menue Activitys purpose is to help the User navigate trough the Functions of the App
 *
 * @author Simon Stolz
 */

public class Menue extends ConnectedActivity {

	//https://developer.android.com/guide/topics/data/data-storage.html#pref
	 public static final String prefName = "MyPrefsFile";

	private Menue m = this;
	private int exitC;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Requesttest
				//GetAllTask getAllTask = new GetAllTask(menue, 1234);
				//getAllTask.execute();
		//Intenttest
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
		id = extras.getInt("ID", -1);
		gender = extras.getBoolean("gender", true);
		}
		setContentView(R.layout.menue);
		
		// Restore preferences
	    //   SharedPreferences settings = getSharedPreferences(prefName, 0);
	    //   settings.getBoolean("gender",true);
	     //  settings.getInt("ID", -1);
	      
		//button to open SearchDancingPartner Activity and pass on i and gender
		final Button tpFinden = (Button) findViewById(R.id.TpFinden);
		tpFinden.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isOnline(m)){
				Intent intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
				intent.putExtra("ID", id);
				intent.putExtra("gender", gender);
				 startActivity(new Intent(intent));}
				else{
					Toast.makeText(m,"Überprüfen Sie ihre Internetverbindung", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		final Button myProfile = (Button) findViewById(R.id.Profil);
		myProfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isOnline(m)){
				Intent intent = new Intent(getApplicationContext(),EditProfile.class);
				intent.putExtra("ID", id);
				intent.putExtra("gender", gender);
				intent.putExtra("RegisterCalled", false);
				startActivity(new Intent(intent));
				}
				else{
					Toast.makeText(m,"Überprüfen Sie ihre Internetverbindung", Toast.LENGTH_SHORT).show();
				}
			}
		});
	
	final Button myKurs = (Button) findViewById(R.id.mMyKurs);
	myKurs.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if(isOnline(m)){
			Intent intent = new Intent(getApplicationContext(),AssignToKurs.class);
			intent.putExtra("ID", id);
			intent.putExtra("gender", gender);
			startActivity(new Intent(intent));
			}
			else{
				Toast.makeText(m,"Überprüfen Sie ihre Internetverbindung", Toast.LENGTH_SHORT).show();
			}
		}
	});
	final Button fr = (Button) findViewById(R.id.mFRequests);
	fr.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if(isOnline(m)){
			Intent intent = new Intent(getApplicationContext(),FriendRequest.class);
			intent.putExtra("ID", id);
			intent.putExtra("gender", gender);
			 startActivity(new Intent(intent));
			}
			else{
				Toast.makeText(m,"Überprüfen Sie ihre Internetverbindung", Toast.LENGTH_SHORT).show();
			}
		}
	});
	final Button conversations = (Button) findViewById(R.id.Konv);
	conversations.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if(isOnline(m)){
			Intent intent = new Intent(getApplicationContext(),Friends.class);
			intent.putExtra("ID", id);
			intent.putExtra("gender", gender);
			 startActivity(new Intent(intent));
			}
			else{
				Toast.makeText(m,"Überprüfen Sie ihre Internetverbindung", Toast.LENGTH_SHORT).show();
			}
		}
	});
}

	/**
	 * Test ausgabe.
	 *
	 * @param text the text
	 */



	@Override
	public void onBackPressed() {
		//http://stackoverflow.com/questions/8430805/clicking-the-back-button-twice-to-exit-an-activity
		   exitC++;
		   if(exitC==1){
			   Toast.makeText(this, "Rücktaste nocheinmal drücken um die App zu verlassen.", Toast.LENGTH_LONG).show();
		   }else{
		     super.onBackPressed();
		   }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater=getMenuInflater();
	    inflater.inflate(R.layout.new_main_menue, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId())
	    {

	    case R.id.options:
	    	break;
	    case R.id.logOut:
	    	//http://stacktips.com/tutorials/android/android-custom-dialog-example
	    	if(id >= 0){
	    		final Dialog dialog = new Dialog(Menue.this);
	    		//setting custom layout to dialog
	    		dialog.setContentView(R.layout.log_out_dialog);
	    		dialog.setTitle("Wirklich abmelden?");
	    		//adding text dynamically
	    		Button yButton = (Button) dialog.findViewById(R.id.yesButton);
	    		Button nButton = (Button) dialog.findViewById(R.id.noButton);
	    		//adding button click event
	    		yButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();	
					Intent intent = new Intent(getApplicationContext(),LogIn.class);
					startActivity(new Intent(intent));
					m.finish();
				}
				});
				
				nButton. setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
			});
			dialog.show();
	        
	    	}
	    	break;
	    	}
	    return true;
	}

}
