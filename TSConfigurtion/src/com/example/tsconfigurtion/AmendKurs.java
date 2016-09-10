package com.example.tsconfigurtion;

import java.util.ArrayList;











import tasks.ADeleteTask;
import tasks.AGetKursTask;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import model.AmendAdapter;
import model.ConnectedActivity;
import model.aKurs;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class AmendKurs  extends ConnectedActivity {
	private int id;
	private ArrayList <aKurs> kl = new ArrayList<aKurs>();
	private  int kursstufe;
	private AmendAdapter Adapter;
	private ListView kView;
	private int kid = 0;
	private  AmendKurs amk = this;
	private  boolean m = false;
//	RadioButton mature;
	private RadioButton notMature;
	private  int position;
	private Dialog dialog ;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_amend_kurs);
		
		 Bundle extras = getIntent().getExtras();
		if(extras != null){
		id = extras.getInt("id");
		}
		super.onCreate(savedInstanceState);
		
		// mature = (RadioButton) findViewById(R.id.ErwachseneRadio);
		 notMature = (RadioButton) findViewById(R.id.SchuelerRadio);
		 notMature.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				m = !isChecked;
			}
		});
		
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
		      
				AGetKursTask gkt = new AGetKursTask(amk,amk.id, kursstufe,m);
				gkt.execute();
		    }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				} 
			// instanciating the ListView
			
			
	});
		
		kView  = (ListView) findViewById(R.id.aKursList);
		Adapter = new AmendAdapter(this, kl, amk) ;
		kView.setAdapter(Adapter);
	
		
	}

	/**
	 * Recieve data.
	 *
	 * @param kl the kl
	 */
	public void recieveData(ArrayList<aKurs> kl) {
		if (kl.isEmpty()){
			Toast.makeText(this,getResources().getString(R.string.empty_result), Toast.LENGTH_LONG).show();
		}
		Adapter = new AmendAdapter(this, kl,amk) ;
		kView.setAdapter(Adapter);
		
	}
		
		
	
	/**
	 * Request delete.
	 *
	 * @param position the position
	 * @param kid the kid
	 */
	public void requestDelete(int position , int kid){
		this.kid = kid;
		dialog = new Dialog(AmendKurs.this);
		//setting custom layout to dialog
		dialog.setContentView(R.layout.toast_options);
		dialog.setTitle("Unwiderruflich löschen?");
		//adding text dynamically
		Button yButton = (Button) dialog.findViewById(R.id.yesButton);
		Button nButton = (Button) dialog.findViewById(R.id.noButton);
		//adding button click event
		yButton.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			ADeleteTask adt= new ADeleteTask(amk, amk.kid, id,amk.position ,v) ;
			adt.execute();
			v.setClickable(false);
		
		}});
		
		nButton. setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
	});
	dialog.show();
    
	}
	
	/**
	 * Delete item.
	 *
	 * @param position the position
	 */
	public void deleteItem(int position){
		Adapter.remove(Adapter.getItem(position));
		Adapter.notifyDataSetChanged();
		dialog.dismiss();
		Toast.makeText(this, "Kurs erfolgreich gelöscht.", Toast.LENGTH_SHORT).show();;
		
	}
	
}
