package activitys;

import model.ProfileData;
import task.ProfileDataTask;
import task.UpdateProfileTask;

import com.example.Tanzpartnervermittlung.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



// TODO: Auto-generated Javadoc
// Added: 13.06.2016
//Last Modofied:14.6.2016 
/**
 * @author Simon Stolz
 * Source : http://codetheory.in/android-pick-select-image-from-gallery-with-intents/
 */
// Add Listeners for 2 Radio Groups and one Button Mabe do the first request
public class EditProfile extends ConnectedActivity {

//	ProfileDataForServer data;
	private EditText pnInsert;
	private EditText pTextInsert;
	private EditText ageInsert;
	private EditText heightInsert;
	private TextView nView;
	private CheckBox paCheck;
	
	private EditProfile edp = this;

	private int id;
	private String pn;
	private int height;
	private int age;
	private String pText;
	private boolean pa;
	private boolean gender;
	private ImageView pic;
	private int PICK_IMAGE_REQUEST = 1;


	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		 Bundle extras = getIntent().getExtras();
			if(extras != null){
				id = extras.getInt("ID");
			}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		 pnInsert = (EditText) findViewById(R.id.pNumberInsert);
		 pTextInsert = (EditText) findViewById(R.id.aboutMeInsert);
		 ageInsert = (EditText) findViewById(R.id.ageInsert);
		 heightInsert = (EditText) findViewById(R.id.heightInsert);
		 nView = (TextView) findViewById(R.id.epNameView);
		 pic = (ImageView) findViewById(R.id.editProfileImage);
		
		 paCheck = (CheckBox) findViewById(R.id.checkBox1);
		 
	ProfileDataTask pdTask = new ProfileDataTask(edp,id);
    	pdTask.execute();
    	
		
		// This Button reads the Users inserted information and saves it in a ProfileDataForServer Object 
		final Button ready = (Button) findViewById(R.id.fertigButton);
        ready.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            // TODO nach dem ersten Request das für alle übernehmen
            	if(pnInsert.getText().toString().length()>0){
            	pn = pnInsert.getText().toString();
            	}else{
            		pn = getString(R.string.missing_value);  
            	}
            	if(ageInsert.getText().toString().length()>0){
            		age = Integer.valueOf(ageInsert.getText().toString());
            		}else{
            			age = 0;}
            	if(heightInsert.getText().toString().length()>0){
            		height = Integer.valueOf(heightInsert.getText().toString());}
            			else{height  = 0;}
            	if(!pTextInsert.getText().toString().equals(getString(R.string.about_me))
            			&&!pTextInsert.getText().toString().equals(getString(R.string.missing_value))
            			&&pTextInsert.getText().toString().length()>0)
            		{
            		pText =  pTextInsert.getText().toString();}
            	else{
            		pText =getString(R.string.missing_value); 
            		}
            	pa = paCheck.isChecked();
            	UpdateProfileTask upTask = new UpdateProfileTask(edp,id,pn,height,age,pText,pa);
            	upTask.execute();
            }
        });
		pic.setOnClickListener(new OnClickListener() {
			/**
			 *  http://codetheory.in/android-pick-select-image-from-gallery-with-intents/
			 */
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				// Show only images, no videos or anything else
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				// Always show the chooser (if there are multiple options available)
				startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
				
			}
		});
	    }
	
	/**
	 * Rechieve data.
	 *
	 * @param pd the pd
	 */
	public void rechieveData(ProfileData pd) {
		
		if(pd.getPhoneNumber().length()>0){
			pnInsert.setText( pd.getPhoneNumber());
		}
		pTextInsert.setText(pd.getpText());
		nView.setText(pd.getFn()+" "+pd.getLn());
		
		gender = pd.isGender();
		paCheck.setChecked(pd.isPa());
		pnInsert.setText(pd.getPhoneNumber()+"");
		pTextInsert.setText(pd.getpText());
		ageInsert.setText(pd.getAge()+"");
		heightInsert.setText(pd.getHeight()+"");
				}
	
	
	/**
	 * Update sucessful.
	 */
	public void updateSucessful() {
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		startActivity(new Intent(intent));
	}
	
	/* (non-Javadoc)
	 * @see activitys.ConnectedActivity#onConnectionError()
	 */
	@Override // must be overrided see TODO
	public void onConnectionError() {
		
			//TODO Error Handling 
			//this activity has to switch back to the activity that called it
			if(!isOnline(this)){
				
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
		                Toast.LENGTH_SHORT).show(); 
			
			}else{
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.connection_failed), 
		                Toast.LENGTH_SHORT).show(); 
				
			}	
	}
	
	}
