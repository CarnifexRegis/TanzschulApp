package activitys;

import java.util.ArrayList;

import model.Adapter;
import model.Kurs;
import model.ProfileChart;
import model.aeAdapter;
import model.ayAdapter;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class AssignToKurs extends Activity{
	int id = -1;
	boolean gender;
	AssignToKurs atk = this;
	int kursstufe = 1;
	ArrayList<Kurs> k;
	aeAdapter eAdapter;
	ayAdapter yAdapter;
	ListView kView;
//http://stackoverflow.com/questions/5195321/remove-an-onclick-listener	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// ascribing the Layout to the activity
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assign_to_kurs);
		// getting the extras from the Intent
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			System.out.println(extras);
		id = extras.getInt("ID", -1);
		gender = extras.getBoolean("gender");
		}
		// instanciating and configuring Spinner
		final Button refresh = (Button) findViewById(R.id.aRefreshButton);
		
		Spinner kSpinner = (Spinner) findViewById(R.id.aKurseSpinner);
		ArrayAdapter<CharSequence> adapterSimple = ArrayAdapter.createFromResource(this, R.array.kurs_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
		adapterSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
		kSpinner.setAdapter(adapterSimple);
		
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
		    }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				} 
			// instanciating the ListView
			
			
	});
		kView  = (ListView) findViewById(R.id.aKursList);
		eAdapter = new aeAdapter(this, k, id) ;
		kView.setAdapter(eAdapter);
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v){
//				k =  new ArrayList<Kurs>();
//				eAdapter = new aeAdapter(atk, k, id) ;
//				kView.setAdapter(eAdapter);
				// execute rrequest
			}
		});
}	
	public void recieveData(ArrayList<Kurs> k,boolean requesIdentifer){
		// true to add false to delete
		if(requesIdentifer){
			eAdapter.clear();
			eAdapter.addAll(k);
			eAdapter.notifyDataSetChanged();
		}else{
			yAdapter.clear();
			yAdapter.addAll(k);
			yAdapter.notifyDataSetChanged();
		}
	}
	public void Added(int kid,int position) {
			eAdapter.getItem(position);
		}
	public void Deleted(int kid,int position) {
		eAdapter.getItem(position);
		
	}
	public void onError(String error){
		Toast.makeText(this,"Fehler: "+ error, Toast.LENGTH_SHORT).show();
	}
	public void onConnectionError(){
		if(!isOnline(this)){
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
	                Toast.LENGTH_SHORT).show(); 
		
		}else{
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.connection_failed), 
	                Toast.LENGTH_SHORT).show(); 
			
		}
	}
	public boolean isOnline(Context context) {
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
	    if (networkinfo != null && networkinfo.isConnected()) {
	        return true;
	    }
	    return false;}
}
