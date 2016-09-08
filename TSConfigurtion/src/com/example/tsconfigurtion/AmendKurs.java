package com.example.tsconfigurtion;

import java.util.ArrayList;
import tasks.aGetKursTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import model.AmendAdapter;
import model.ConnectedActivity;

import model.aKurs;

public class AmendKurs  extends ConnectedActivity {
	int id;
	ArrayList <aKurs> kl;
	int kursstufe;
	AmendAdapter Adapter;
	ListView kView;
	Button refresh;
	AmendKurs amk = this;

	protected void onCreate(Bundle savedInstanceState) {
		
		
		 Bundle extras = getIntent().getExtras();
		if(extras != null){
		id = extras.getInt("id");
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amend_kurs);
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
		      
//		      case "Alle" :
//			    	kursstufe = 0625725735;
//			    	  break;
		     
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
		      refresh.setEnabled(false);
				aGetKursTask gkt = new aGetKursTask(amk,amk.id, kursstufe);
				gkt.execute();
		    }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				} 
			// instanciating the ListView
			
			
	});
		kView  = (ListView) findViewById(R.id.aKursList);
		Adapter = new AmendAdapter(this, kl, id,amk) ;
		kView.setAdapter(Adapter);
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v){
				
				refresh.setEnabled(false);
				aGetKursTask gkt = new aGetKursTask(amk,id, kursstufe);
				gkt.execute();
				
			}
		});
	
		
	}

	public void recieveData(ArrayList<aKurs> kl) {
		if (kl.isEmpty()){
			Toast.makeText(this,getResources().getString(R.string.empty_result), Toast.LENGTH_LONG).show();
		}
		Adapter = new AmendAdapter(this, kl, id,amk) ;
		kView.setAdapter(Adapter);
		refresh.setEnabled(true);
	}
		
		
	public void enableRefresh(){
		refresh.setEnabled(true);
	}
	public void deleteItem(int position){
		Adapter.remove(Adapter.getItem(position));
		Adapter.notifyDataSetChanged();
		
	}
	
}
