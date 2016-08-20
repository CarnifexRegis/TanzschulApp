package activitys;



	import java.util.ArrayList;

import model.ProfileChart;

import com.example.Tanzpartnervermittlung.R;

import enums.Gender;
import searchutils.Adapter;
import searchutils.Kursbuchung;
import task.UpdateChartTask;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;


	
	//Geschlechts bezogenen Menubar fehlt 
	//TODO add add() Method and listener for Start Search Button"
	//Geschlechts bezogenen Menubar fehlt 
	//TODO add add() Method and listener for Start Search Button"
/**
 * 
 * @author Simon
 * @attribute This Activity is used to fulfill the core funktion of the app: finding people who intend to participate in the same course
 */
	public class SearchForDancingpartner extends Activity {
		Adapter adapterCustom;
		ArrayList<ProfileChart> pc;
		int ID = -1;
		boolean gender;
		int kursstufe;
		final SearchForDancingpartner sfdp = this;
		
		@Override
		/**
		 * @Sources: http://stackoverflow.com/questions/2091465/how-do-i-pass-data-between-activities-on-android
		 */
		protected void onCreate(Bundle savedInstanceState) {
			//gets the passed on data from mainActivity
			Bundle extras = getIntent().getExtras();
			if(extras != null){
				System.out.println(extras);
			ID = extras.getInt("ID", -1);
			gender = extras.getBoolean("intentGender");
			}
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.search_for_dancingpartner); //instanziieren des Spinners, http://developer.android.com/guide/topics/ui/controls/spinner.html
			Spinner spinner = (Spinner) findViewById(R.id.KurseSpinner);
			
			ArrayAdapter<CharSequence> adapterSimple = ArrayAdapter.createFromResource(this, R.array.kurs_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
			adapterSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
			spinner.setAdapter(adapterSimple);
			
			pc =  new ArrayList<ProfileChart>();
			// Create the adapter to convert the array to views
			adapterCustom = new Adapter(this,pc );
			// Create ListView
		final ListView kursbuchungView = (ListView) findViewById(R.id.userListView);
			// Attach the adapter to a ListView
			kursbuchungView.setAdapter(adapterCustom);
			//Adds test user
			
			
		 final Button sB = (Button) findViewById(R.id.searchButton);
	        sB.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	// do the request
	            	// wit succesfull answer execute:
	            	
	            	//TODO set topical ArrayList to returned List
	            	adapterCustom.clear();
	            	//kursbuchungView.invalidate();//tells the gui to update the values
	            	adapterCustom.notifyDataSetChanged();
	            	
	        			kursstufe = 1;
	        			ID = 1;
	        			gender = true;
	        			if(isOnline(sfdp)){
	        			UpdateChartTask updateChartTask = new UpdateChartTask (sfdp,ID, kursstufe, gender );
	        			updateChartTask.execute();}else{System.out.println("not connected");}
	            }
	        });
		    }
		public boolean isOnline(Context context) {
		    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
		    if (networkinfo != null && networkinfo.isConnected()) {
		        return true;
		    }
		    return false;
		}
		/**
		 * 
		 * @param pc	An Array List of Profilecharts recieved from the Server
		 * 
		 *  This method recieves data in Form of an ArrayList<ProfileChart>
		 *	(most likely from the server) and passes it on to the Adapter for the listview
		 */
		public void newKursbuchungen(ArrayList<ProfileChart> pc){
			adapterCustom.clear();
			adapterCustom.addAll(pc);
			adapterCustom.notifyDataSetChanged();
		
		}
		public void chartsUpdate(ArrayList<ProfileChart> pc){
			newKursbuchungen( pc);
				
			}
		/**
		 * @ Source http://stackoverflow.com/questions/6439085/android-how-to-create-option-menu
		 */
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
		    MenuInflater inflater=getMenuInflater();
		    inflater.inflate(R.layout.main_menue, menu);
		    return super.onCreateOptionsMenu(menu);
		}
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch(item.getItemId())
		    {
		    case R.id.logIn:
		    	Intent intent = new Intent(getApplicationContext(),LogIn.class);
				//if(ID >= 0){ it causes a bug in this shape but may be later needed
				intent.putExtra("intentID", ID);//}
				intent.putExtra("intentGender", gender);
				
				 startActivity(new Intent(intent));
		        break;
		    case R.id.logOut:
		    	//http://stacktips.com/tutorials/android/android-custom-dialog-example
		    	if(ID >= 0){
		    		final Dialog dialog = new Dialog(SearchForDancingpartner.this);
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
						ID = -1;
						dialog.dismiss();	
					}
					});
					
					nButton. setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
				});
				dialog.show();
		        
		    	}else{
		    		final Dialog dialog2 = new Dialog(SearchForDancingpartner.this);
		    		//setting custom layout to dialog
		    		dialog2.setContentView(R.layout.no_log_out_dialog);
		    		dialog2.setTitle("Sie sind bereits ausgeloggt.");
		    		//adding text dynamically
		    		Button okButton = (Button) dialog2.findViewById(R.id.okButton);
		    		
		    		//adding button click event
		    		okButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog2.dismiss();	
					}
					});
		    		dialog2.show();
		    	}
		    	break;
		    	}
		    return true;
		}
//		public boolean onCreateOptionsMenu(Menu menu) {
//			
//			//ActionBar actionBar = getActionBar(); With the following code you could hide the MenureBar, obviously.
//		   // actionBar.hide();
//			// Inflate the menu; this adds items to the action bar if it is present.
//			getMenuInflater().inflate(R.layout.main_menue, menu);
//			return true;   
//		}
		@Override
		public void onBackPressed(){
			super.onBackPressed();
			Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("intentID", ID);
		intent.putExtra("intentGender", gender);
			 startActivity(new Intent(intent));
		}
	}



		
