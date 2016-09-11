package activitys;



	import java.util.ArrayList;

import model.Adapter;
import model.ProfileChart;
import com.example.Tanzpartnervermittlung.R;
import task.UpdateChartTask;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


	
	// TODO: Auto-generated Javadoc
//Geschlechts bezogenen Menubar fehlt 
	//TODO add add() Method and listener for Start Search Button"
	//Geschlechts bezogenen Menubar fehlt 
	//TODO add add() Method and listener for Start Search Button"
/**
	 * The Class SearchForDancingpartner.
	 *
	 * @author Simon Stolz
	 * @attribute This Activity is used to fulfill the core funktion of the app: finding people who intend to participate in the same course
	 * Source: 
	 * 			http://stackoverflow.com/questions/2789612/how-can-i-check-whether-an-android-device-is-connected-to-the-web
	 * 			http://stackoverf
	 * 
	 * low.com/questions/9208827/how-to-extract-the-text-from-the-selected-item-on-the-listview
	 */
	public class SearchForDancingpartner extends ConnectedActivity {
		private Adapter adapterCustom;
		private ArrayList<ProfileChart> pc;
		private int ID = -1;
		private boolean gender;
		private int kursstufe = 1;
		private int day = 3;
		private String idp;
		private String error = null;
		private final SearchForDancingpartner sfdp = this;
		private boolean ready;
		
		/* (non-Javadoc)
		 * @see android.app.Activity#onCreate(android.os.Bundle)
		 */
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
			gender = extras.getBoolean("gender");
			error = extras.getString("error");
			if (error!= null){
				Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show(); 
			}
			}
			ready  = false;
			super.onCreate(savedInstanceState);
			setContentView(R.layout.search_for_dancingpartner); //instanziieren des Spinners, http://developer.android.com/guide/topics/ui/controls/spinner.html
			// instancing Listview
			
			Spinner kSpinner = (Spinner) findViewById(R.id.KurseSpinner);
			ArrayAdapter<CharSequence> adapterSimple1 = ArrayAdapter.createFromResource(this, R.array.kurs_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
			adapterSimple1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
			kSpinner.setAdapter(adapterSimple1);
			 
kSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
      String ks =  spinner.getSelectedItem().toString();
      switch (ks){
      
      case "Grundkurs 1" :
    	kursstufe = 1;
    	  break;
      case "Grundkurs 2":
    	  kursstufe = 2;
    	  break;
      case "Bronze":
    	  kursstufe = 3;
    	  break;
      case "Silber":
    	  kursstufe = 4;
    	  break;
      case "Gold":
    	  kursstufe = 5;
    	  break;
      case "Goldstar Teil A":
    	  kursstufe = 6;
    	  break;
      case "Goldstar Teil B":
    	  kursstufe = 7;
    	  break;
      case "Jugendkreis 1":
    	  kursstufe = 8;
    	  break;
      case "Jugendkreis 2":
    	  kursstufe = 9;
    	  break;
      } 
      if(ready){
    	  if(isOnline(sfdp)){
    		  UpdateChartTask updateChartTask = new UpdateChartTask (sfdp,ID, kursstufe, gender,day );
    		  updateChartTask.execute();}
			else{
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
		                Toast.LENGTH_SHORT).show(); 
			}
      }
    } 

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
	}
});		
			
			pc =  new ArrayList<ProfileChart>();
			adapterCustom = new Adapter(this,pc );
			final ListView ProfileChartView = (ListView) findViewById(R.id.userListView);
			ProfileChartView.setAdapter(adapterCustom);	
			ProfileChartView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                //the .getName() is accessed from the School POJO class.
	              //  String eMail = adapterCustom.getItem(position).geteMail();
	                //http://stackoverflow.com/questions/9208827/how-to-extract-the-text-from-the-selected-item-on-the-listview
	                Intent intent = new Intent(getApplicationContext(),ShowProfile.class);
					intent.putExtra("ID", ID);
					intent.putExtra("gender", gender);
			//		eMail = adapterCustom.getItem(position).getAge();
					idp= adapterCustom.getItem(position).getIdp();
					intent.putExtra("idp", idp);
					 startActivity(new Intent(intent));
	            }
	        });
			Spinner dSpinner = (Spinner) findViewById(R.id.daySpinner);
			ArrayAdapter<CharSequence> adapterSimple2 = ArrayAdapter.createFromResource(this, R.array.day_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
			adapterSimple2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
			dSpinner.setAdapter(adapterSimple2);
			
			dSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			    @Override
			    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			        Spinner spinner = (Spinner) parent;
			     String d =  spinner.getSelectedItem().toString();
			     switch (d){
			      
			     case "Alle" :
				    	day = 7;
				    	  break;
				    	  // i took my dancing scool as pattern wich didn`t feature dancing lessons on mondays tuesdays and sundays
				    	  //  The server keeps the other days (except Sunday) because that might chhange some day. In that cas you would just have to update your client
			      case "Montag" :
			    	day = 1;
			    	  break;
			      case "Dienstag":
			    	  day = 2;
		    	  break;
			      case "Mittwoch":
			    	  day = 3;
			    	  break;
			      case "Donnerstag":
			    	  day = 4;
			    	  break;
			      case "Freitag":
			    	  day = 5;
			    	  break;
			      case "Samstag":
			    	  day = 6;
			    	  break;
			    	  default: 
			    		  day = 1;
			    		  
			    		 
			      } 
			     
			     ready = true;
			     if(isOnline(sfdp)){
	        			UpdateChartTask updateChartTask = new UpdateChartTask (sfdp,ID, kursstufe, gender,day );
	        			updateChartTask.execute();}
	        			else{
	        				Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
	        		                Toast.LENGTH_SHORT).show(); 
	        			}
			    }
				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
			});
		}
			
			
		 
	       
	        
		//http://stackoverflow.com/questions/2789612/how-can-i-check-whether-an-android-device-is-connected-to-the-web
		
		/**
		 * New kursbuchungen.
		 *
		 * @param pc An Array List of Profilecharts recieved from the Server
		 * 
		 *  This method recieves data in Form of an ArrayList<ProfileChart>
		 * 	(most likely from the server) and passes it on to the Adapter for the listview
		 */
		public void newKursbuchungen(ArrayList<ProfileChart> pc){
			adapterCustom.clear();
			adapterCustom.addAll(pc);
			adapterCustom.notifyDataSetChanged();
		
		}
		
		/**
		 * Charts update.
		 *
		 * @param pc the pc
		 */
		public void chartsUpdate(ArrayList<ProfileChart> pc){
			
			if (pc.isEmpty()){
				Toast.makeText(this,getResources().getString(R.string.empty_result), Toast.LENGTH_LONG).show();
			}
			newKursbuchungen( pc);
				
			}
		
		/**
		 * On create options menu.
		 *
		 * @param menu the menu
		 * @return true, if successful
		 * @ Source http://stackoverflow.com/questions/6439085/android-how-to-create-option-menu
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
						dialog.dismiss();	
						Intent intent = new Intent(getApplicationContext(),LogIn.class);
//						if(ID >= 0){
//						intent.putExtra("intentID", -1);}
//						intent.putExtra("intentGender", false);
						
						 startActivity(new Intent(intent));
					
					}});
					
					nButton. setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
				});
				dialog.show();
		        
		    	break;
	    	}
	    return true;
	}

//		@Override
//		public boolean onOptionsItemSelected(MenuItem item) {
//		    switch(item.getItemId())
//		    {
//		    case R.id.logIn:
//		    	Intent intent = new Intent(getApplicationContext(),LogIn.class);
//				//if(ID >= 0){ it causes a bug in this shape but may be later needed
//				intent.putExtra("intentID", ID);//}
//				intent.putExtra("intentGender", gender);
//				
//				 startActivity(new Intent(intent));
//		        break;
//		    case R.id.logOut:
//		    	//http://stacktips.com/tutorials/android/android-custom-dialog-example
//		    	if(ID >= 0){
//		    		final Dialog dialog = new Dialog(SearchForDancingpartner.this);
//		    		//setting custom layout to dialog
//		    		dialog.setContentView(R.layout.log_out_dialog);
//		    		dialog.setTitle("Wirklich abmelden?");
//		    		//adding text dynamically
//		    		Button yButton = (Button) dialog.findViewById(R.id.yesButton);
//		    		Button nButton = (Button) dialog.findViewById(R.id.noButton);
//		    		//adding button click event
//		    		yButton.setOnClickListener(new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						ID = -1;
//						dialog.dismiss();	
//					}
//					});
//					
//					nButton. setOnClickListener(new OnClickListener() {
//						
//						@Override
//						public void onClick(View v) {
//							dialog.dismiss();
//						}
//				});
//				dialog.show();
//		        
//		    	}else{
//		    		final Dialog dialog2 = new Dialog(SearchForDancingpartner.this);
//		    		//setting custom layout to dialog
//		    		dialog2.setContentView(R.layout.no_log_out_dialog);
//		    		dialog2.setTitle("Sie sind bereits ausgeloggt.");
//		    		//adding text dynamically
//		    		Button okButton = (Button) dialog2.findViewById(R.id.okButton);
//		    		
//		    		//adding button click event
//		    		okButton.setOnClickListener(new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						dialog2.dismiss();	
//					}
//					});
//		    		dialog2.show();
//		    	}
//		    	break;
//		    	}
//		    return true;
//		}
		
		

		/* (non-Javadoc)
 * @see android.app.Activity#onBackPressed()
 */
@Override
		public void onBackPressed(){
			super.onBackPressed();
			Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", ID);
		intent.putExtra("gender", gender);
			 startActivity(new Intent(intent));
		}
	}