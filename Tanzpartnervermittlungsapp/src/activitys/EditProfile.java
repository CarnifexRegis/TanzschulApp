package activitys;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



// Added: 13.06.2016
//Last Modofied:14.6.2016 
// Add Listeners for 2 Radio Groups and one Button Mabe do the first request
public class EditProfile extends Activity {
//	ProfileDataForServer data;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		
		final EditText fn = (EditText)findViewById(R.id.fnameInsert);
		final EditText ln= (EditText)findViewById(R.id.lnameInsert);
		
		// This Button reads the Users inserted information and saves it in a ProfileDataForServer Object 
		final Button ready = (Button) findViewById(R.id.fertigButton);
        ready.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            // TODO nach dem ersten Request das für alle übernehmen
            	
            //	data.setFn(fn.getText().toString());
            //	data.setLn(ln.getText().toString());
            
            }
        });
		
	    }}
