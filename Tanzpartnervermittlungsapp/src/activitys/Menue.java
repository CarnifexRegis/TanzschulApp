package activitys;

import task.GetAllTask;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.Tanzpartnervermittlung.R;
// TODO: Auto-generated Javadoc
//SQL für Fortgeschritttene join..on group by Roman Create Table, insert,update 
//Php my table
/**
 * The Class Menue.
 *
 * @author Simon
 */

public class Menue extends ConnectedActivity {
	
	/** The Constant prefName. */
	//https://developer.android.com/guide/topics/data/data-storage.html#pref
	 public static final String prefName = "MyPrefsFile";
	
	/** The id. */
	int ID ;
	
	/** The gender. */
	boolean gender;
	
	/** The menue. */
	final Menue menue = this;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	/**
	 * 
	 */
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Requesttest
				//GetAllTask getAllTask = new GetAllTask(menue, 1234);
				//getAllTask.execute();
		//Intenttest
		
		Bundle extras = getIntent().getExtras();
		if(extras != null){
		ID = extras.getInt("ID", -1);
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
			public void onClick(View v) {
		
				Intent intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
				
				intent.putExtra("ID", ID);
				intent.putExtra("gender", gender);
				
				 startActivity(new Intent(intent));
			}
		});
		
		
		final Button myProfile = (Button) findViewById(R.id.Profil);
		myProfile.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
Intent intent = new Intent(getApplicationContext(),EditProfile.class);
				intent.putExtra("ID", ID);
				intent.putExtra("gender", gender);
				startActivity(new Intent(intent));
			}
		});
	
	final Button myKurs = (Button) findViewById(R.id.mMyKurs);
	myKurs.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),AssignToKurs.class);
			intent.putExtra("ID", ID);
			intent.putExtra("gender", gender);
			startActivity(new Intent(intent));
		}
	});
}

	/**
	 * Test ausgabe.
	 *
	 * @param text the text
	 */
	public void testAusgabe(String text) {
	//	TextView testView = (TextView) findViewById(R.id.test1);
		//testView.setText(text);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater=getMenuInflater();
	    inflater.inflate(R.layout.new_main_menue, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId())
	    {

	    case R.id.options:
	    	break;
	    case R.id.logOut:
	    	//http://stacktips.com/tutorials/android/android-custom-dialog-example
	    	if(ID >= 0){
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
//					if(ID >= 0){
//					intent.putExtra("intentID", -1);}
//					intent.putExtra("intentGender", false);
					
					 startActivity(new Intent(intent));
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
//	    	else{
//	    		final Dialog dialog2 = new Dialog(Menue.this);
//	    		//setting custom layout to dialog
//	    		dialog2.setContentView(R.layout.no_log_out_dialog);
//	    		dialog2.setTitle("Sie sind bereits ausgeloggt.");
//	    		//adding text dynamically
//	    		Button okButton = (Button) dialog2.findViewById(R.id.okButton);
//	    		
//	    		//adding button click event
//	    		okButton.setOnClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					dialog2.dismiss();	
//				}
//				});
//	    		dialog2.show();
//	    	}
	    	break;
	    	}
	    return true;
	}

}
