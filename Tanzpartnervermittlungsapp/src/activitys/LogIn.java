package activitys;



import task.LoginTask;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
// maby change to popup that runs in an seperate thread
public class LogIn extends Activity{
	Activity calledBy ;
	final LogIn login = this;
	 
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        final Button register = (Button) findViewById(R.id.rButton);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	if(true){
              startActivity(new Intent(getApplicationContext(),EditProfile.class));
            	}
            }
        });
        
        final Button signIn = (Button) findViewById(R.id.sButton);
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	final EditText eMailInsert =(EditText)findViewById(R.id.sEmailInsert);
              String  eMail =eMailInsert.getText().toString();
              final EditText keyInsert =(EditText)findViewById(R.id.sKeyInsert);
              String  key =keyInsert.getText().toString();
            	LoginTask loginTask = new LoginTask(login, eMail, key);
            	loginTask.execute();
            }
        });
	}
	public void getLoginValues(int id, boolean gender){
		//Switch (calledBy.getAct)
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		
		intent.putExtra("intentID", id);
		intent.putExtra("intentGender", gender);
		
		 startActivity(new Intent(intent));
		
	}
}
