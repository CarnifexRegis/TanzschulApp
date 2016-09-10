package activitys;

import java.util.ArrayList;

import task.GetKursTask;
import model.Kurs;
import model.aAdapter;




import com.example.Tanzpartnervermittlung.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class AssignToKurs.
 */
public class AssignToKurs extends ConnectedActivity{
	
	/** The id. */
	int id = -1;
	
	/** The gender. */
	boolean gender;
	
	/** The atk. */
	AssignToKurs atk = this;
	
	/** The kursstufe. */
	int kursstufe = 1;
	
	/** The k. */
	ArrayList<Kurs> k = new ArrayList <Kurs>();
	
	/** The Adapter. */
	aAdapter Adapter;
	
	/** The k view. */
	ListView kView;
	
//http://stackoverflow.com/questions/5195321/remove-an-onclick-listener	
	
	/* (non-Javadoc)
 * @see android.app.Activity#onCreate(android.os.Bundle)
 */
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
		
		final TextView header = (TextView)findViewById(R.id.aKursHeader);
		if (gender){
			header.setText(getResources().getString(R.string.kurs_header_f));
		}else{
			header.setText(getResources().getString(R.string.kurs_header_m));
		}
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
		    
				GetKursTask gkt = new GetKursTask(atk,atk.id, kursstufe);
				gkt.execute();
		    }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				} 
			// instanciating the ListView
			
			
	});
		kView  = (ListView) findViewById(R.id.aKursList);
		Adapter = new aAdapter(this, k, id,atk) ;
		kView.setAdapter(Adapter);
		
		
			GetKursTask gkt = new GetKursTask(atk,atk.id, kursstufe);
			gkt.execute();
}	
	
	/**
	 * Recieve data.
	 *
	 * @param k the k
	 */
	public void recieveData(ArrayList<Kurs> k){
		if (k.isEmpty()){
			Toast.makeText(this,getResources().getString(R.string.empty_result), Toast.LENGTH_LONG).show();
		}
		Adapter = new aAdapter(this, k, id,atk) ;
		kView.setAdapter(Adapter);
		
	}
	
	/**
	 * Added.
	 *
	 * @param position the position
	 */
	public void added(int position) {
		Kurs k = Adapter.getItem(position);
		k.setEnlisted(true);
		Toast.makeText(this,"Eingetragen", Toast.LENGTH_SHORT).show();
			//Adapter.getItem(position);
			
		}
	
	/**
	 * Deleted.
	 *
	 * @param position the position
	 */
	public void deleted(int position) {
		Kurs k = Adapter.getItem(position);
		k.setEnlisted(false);
		Toast.makeText(this,"Ausgetragen", Toast.LENGTH_SHORT).show();
		//Adapter.getItem(position);
		
	}
	
	
	
	}	
