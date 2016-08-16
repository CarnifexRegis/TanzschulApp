package activitys;



import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends Activity{
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
            	if(true){
              startActivity(new Intent(getApplicationContext(),Menue.class));
            	}
            }
        });
	}
}
