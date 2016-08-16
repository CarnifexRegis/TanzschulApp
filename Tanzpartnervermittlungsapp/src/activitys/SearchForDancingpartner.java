package activitys;



	import java.util.ArrayList;

import model.ProfileChart;

import com.example.Tanzpartnervermittlung.R;

import searchutils.Adapter;
import searchutils.Kursbuchung;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;


	
	//Geschlechts bezogenen Menubar fehlt 
	//TODO add add() Method and listener for Start Search Button"
	//Geschlechts bezogenen Menubar fehlt 
	//TODO add add() Method and listener for Start Search Button"

	public class SearchForDancingpartner extends Activity {
		Adapter adapterCustom;
		ArrayList<ProfileChart> pc;
		int ID ;
		boolean gender;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			ID = getIntent().getIntExtra("ID", -1);
			gender = getIntent().getBooleanExtra("gender", false);
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
			adapterCustom = new Adapter(this,pc );	
			
			
			final Button sB = (Button) findViewById(R.id.searchButton);
	        sB.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	// do the request
	            	// wit succesfull answer execute:
	            	
	            	//TODO set topical ArrayList to returned List
	            	adapterCustom.clear();
	            	//kursbuchungView.invalidate();//tells the gui to update the values
	            	adapterCustom.notifyDataSetChanged();
	            }
	        });
		    }
		public void newKursbuchungen(ArrayList<ProfileChart> pc){
			adapterCustom = new Adapter(this,pc );
		}
		public void chartsUpdate(ArrayList<ProfileChart> pc){
			newKursbuchungen( pc);
				
			}
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			//ActionBar actionBar = getActionBar(); With the following code you could hide the MenureBar, obviously.
		   // actionBar.hide();
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.layout.main_menue, menu);
			return true;

	       
		}}



		
