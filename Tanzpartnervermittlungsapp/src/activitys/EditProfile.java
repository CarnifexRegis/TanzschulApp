package activitys;

import model.ProfileData;
import task.ProfileDataTask;
import task.RegisterTask;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;



// Added: 13.06.2016
//Last Modofied:14.6.2016 
// Add Listeners for 2 Radio Groups and one Button Mabe do the first request
public class EditProfile extends Activity {
//	ProfileDataForServer data;
	EditText pNumber;
	EditText pText;
	TextView fnView;
	TextView lnView;
	CheckBox paCheck;
int id;
boolean gender;
EditProfile edp = this;


	protected void onCreate(Bundle savedInstanceState) {
		 Bundle extras = getIntent().getExtras();
			if(extras != null){
			id = extras.getInt("ID");
			}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		 pNumber = (EditText) findViewById(R.id.pNumberInsert);
		  pText = (EditText) findViewById(R.id.aboutMeInsert);
		  fnView = (TextView) findViewById(R.id.fnameView);
		  lnView= (TextView) findViewById(R.id.lnameView);
		  paCheck = (CheckBox) findViewById(R.id.checkBox1);
	ProfileDataTask pdTask = new ProfileDataTask(edp,id);
    	pdTask.execute();
    	
		
		// This Button reads the Users inserted information and saves it in a ProfileDataForServer Object 
		final Button ready = (Button) findViewById(R.id.fertigButton);
        ready.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            // TODO nach dem ersten Request das für alle übernehmen
            	
            //	data.setFn(fn.getText().toString());
            //	data.setLn(ln.getText().toString());
            
            }
        });
		
	    }
	public void onBackPressed() {
	}
	public void rechieveData(ProfileData pd) {
		
		if(pd.getPhoneNumber()>0){
			pNumber.setText(""+ pd.getPhoneNumber());
		}
		if(pd.getpText()!= null){
			 pText.setText(pd.getpText());
		}
		fnView.setText(pd.getFn());
		lnView.setText(pd.getLn());
		
		paCheck.setChecked(pd.isPa());
		gender = pd.isGender();
		
				}
	
	
	
	public void onError(String error) {
		// ther is just one possible error code
		
		
			
			Intent intent = new Intent(getApplicationContext(),LogIn.class);
			intent.putExtra("error", "Sitzung abgelaufen");
				 startActivity(new Intent(intent));
		
	}
	}
