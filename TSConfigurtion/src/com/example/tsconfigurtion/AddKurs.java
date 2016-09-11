package com.example.tsconfigurtion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import tasks.AAddKursTask;
import model.ConnectedActivity;
import model.SQLKurs;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 * The Class AddKurs.
 */
@SuppressLint("SimpleDateFormat")
public class AddKurs extends ConnectedActivity {
// values
private int kursstufe;
private int id;
private int day;
private boolean mature;
private AddKurs ak = this;
//date values
//private String dateDay;
private EditText dateDayE;
private String dateMonth;
private String dateYear;
private String stringDay;
private EditText insertTime1;
private EditText insertTime2;
private Spinner dateMonthS;
private Spinner dateYearS;
private Button addKursB;
private Spinner stringDayS;
private Spinner kustuS;
private Spinner matureS;

/**
 * On create.
 *
 * @param savedInstanceState the saved instance state
 * @author: Simon Stolz;
 * 	This class is used to add new courses to the Server datbase.
 * 	The majority of data required for a Kurs object  is collected from sinners.
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_add_kurs);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			id = extras.getInt("id");
		}
		super.onCreate(savedInstanceState);
		addKursB = (Button) findViewById(R.id.AddKursButton);
		insertTime1 = (EditText) findViewById(R.id.InsertTime1);
		insertTime2 = (EditText) findViewById(R.id.InsertTime2);
		
		dateDayE = (EditText) findViewById(R.id.insertDay);
		kustuS = (Spinner) findViewById(R.id.addKursstufeSpinner);
		ArrayAdapter<CharSequence> adapterSimple = ArrayAdapter.createFromResource(this, R.array.kurs_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
		adapterSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
		kustuS.setAdapter(adapterSimple);
		kustuS.setOnItemSelectedListener(new OnItemSelectedListener() {
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
		    	  default:
		    		  Toast.makeText(ak, "Fehler beim Ermitteln des Tages", Toast.LENGTH_LONG).show();
		      } 
		      	
		    }

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				kursstufe =1;
				
			}
		
	});
		stringDayS = (Spinner) findViewById(R.id.addStringDaySpinner);
		ArrayAdapter<CharSequence> stringDayA = ArrayAdapter.createFromResource(this, R.array.day_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
		stringDayA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
		stringDayS.setAdapter(stringDayA);
		
		stringDayS.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		        Spinner spinner = (Spinner) parent;
		     stringDay =  spinner.getSelectedItem().toString();
		     
		}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}});
		
		matureS = (Spinner) findViewById(R.id.addMatureSpinner);
		ArrayAdapter<CharSequence> matureA = ArrayAdapter.createFromResource(this, R.array.mature_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
		
		matureA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
		matureS.setAdapter(matureA);
		matureS.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		        Spinner spinner = (Spinner) parent;
		     String d =  spinner.getSelectedItem().toString();
		     switch (d){
		      
		     case "Schülerkurs" :
			    	mature = false;
			    	  break;
			    	  // i took my dancing scool as pattern wich didn`t feature dancing lessons on mondays tuesdays and sundays
			    	  //  The server keeps the other days (except Sunday) because that might chhange some day. In that cas you would just have to update your client
		      case "Erwachsenenkurs" :
		    	mature = true;
		    	  break;
		     
		    	  default:
		    		 Toast.makeText(ak, "Fehler beim Ermitteln der Kursaltersstufe", Toast.LENGTH_LONG).show();
		    		  
		    		 
		      } 
		     
		     
        			}
		    

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				mature = false;
				
			}
		});
		dateYearS = (Spinner) findViewById(R.id.addYearSpinner);
		/**
		 * @source http://stackoverflow.com/questions/2215069/inserting-the-current-year-into-a-textview
		 */
		Calendar calendar = Calendar.getInstance();
	final int year = calendar.get(Calendar.YEAR); 
	// i know there might  appear a bug at silverster night but i don´t care # EasterEgg
		ArrayAdapter<CharSequence> dateYearA = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		dateYearA.add(year + "");
		dateYearA.add(year+1 + "");
		dateYearA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
		dateYearS.setAdapter(dateYearA);
		dateYearS.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		        Spinner spinner = (Spinner) parent;
		    dateYear =  spinner.getSelectedItem().toString();
		     
		     
        			}
		    

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				dateYear = year +"";
				
			}
		});
		
//		     dateDay =  Integer.parseInt(spinner.getSelectedItem().toString());	
		    
		dateMonthS = (Spinner) findViewById(R.id.addMonthSpinner);
		ArrayAdapter<CharSequence> dateMonthA = ArrayAdapter.createFromResource(this, R.array.date_month_array, android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
		dateMonthA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
		dateMonthS.setAdapter(dateMonthA);
		dateMonthS.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		        Spinner spinner = (Spinner) parent;
		     
		  String  d =   spinner.getSelectedItem().toString();
		  switch (d){
	      
		     case "Januar" :
			    	dateMonth = "01";
			    	  break;
		      case "Februar" :
		    	  dateMonth = "02";
		    	  break;
		      case "März" :
		    	  dateMonth = "03";
		    	  break;
		      case "April" :
		    	  dateMonth = "04";
		    	  break;
		      case "Mai" :
		    	  dateMonth = "05";
		    	  break;
		      case "Juni" :
		    	  dateMonth = "06";
		    	  break;
		      case "Juli" :
		    	  dateMonth = "07";
		    	  break;
		      case "August" :
		    	  dateMonth = "08";
		    	  break;
		      case "September" :
		    	  dateMonth = "09";
		    	  break;
		      case "Oktober" :
		    	  dateMonth = "10";
		    	  break;
		      case "November" :
		    	  dateMonth = "11";
		    	  break;
		      case "Dezember" :
		    	  dateMonth = "12";
		    	  break;
		    	  
		     
		    	  default:
		    		 Toast.makeText(ak, "Fehler beim Ermitteln des Monats", Toast.LENGTH_LONG).show();
		    		  
		    		 
		      } 
		    
		   
		     }
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				dateMonth = "01";
				
			}
		});
		addKursB .setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/**
				 * @source http://stackoverflow.com/questions/32199517/how-to-convert-year-month-day-date-formateg-2015-05-12-which-is-a-value-retr
				 * http://www.java2s.com/Tutorial/Java/0040__Data-Type/ConvertfromajavautilDateObjecttoajavasqlDateObject.htm
				 */
				
				//String oldstring = "2015-05-12"; 
				if(insertTime1.length()<1||insertTime1.length()<1||dateDayE.length()<1){
					Toast.makeText(ak, "Alle Felder sind Pflichfelder, bitte überprüfen sie noch einaml ihren Angaben.", Toast.LENGTH_LONG).show();
					
				}else{
				if(day<=31){
					try{
				String oldstring = dateYear+"-"+dateMonth+"-"+dateDayE.getText().toString();
				java.util.Date jDate = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
				
			    java.sql.Date sqlDate = new java.sql.Date(jDate.getTime());
		
			    AAddKursTask akt =  new AAddKursTask(ak, id,new SQLKurs( kursstufe,insertTime1.getText().toString()+":"+insertTime2.getText().toString(),sqlDate, stringDay) );
			    addKursB.setEnabled(false);
			    akt.execute();
			    }catch(Exception e){
			    	Toast.makeText(ak, "Fehler beim erstellen des Datums überprüfen sie ihre Angaben", Toast.LENGTH_LONG).show();
			    	e.printStackTrace();
			    	
			    }
//			    System.out.println("utilDate:" + jDate);
//			    System.out.println("sqlDate:" + sqlDate);
				
				}else{
					Toast.makeText(ak, "Vorbild ist der gregorianische Kalender, sie haben einen Tag Wert über 31 angegeben.", Toast.LENGTH_LONG).show();
				}}
				//Use SimpleDateFormat#format() to format a Date into a String in a certain pattern.
				
				
//				java.util.Date utilDate = new java.util.Date();
//			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//			    System.out.println("utilDate:" + utilDate);
//			    System.out.println("sqlDate:" + sqlDate);
			    
//			    String newstring = new SimpleDateFormat("dd-MM-yyyy").format(date);
//				System.out.println(newstring); // 12-05-2015
				
				
			}
			
		});
		
		
		}
	
	/**
	 * Enable add button.
	 */
	public void enableAddButton()	
	{
		addKursB.setEnabled(true);
	}
		
/**
 * On add succes.
 */
public void onAddSucces() {
	Toast.makeText(this, "Successfully added Kurs", Toast.LENGTH_LONG).show();
	addKursB.setEnabled(true);
}
	}
