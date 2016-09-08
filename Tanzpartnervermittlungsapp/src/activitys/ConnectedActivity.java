package activitys;

import com.example.Tanzpartnervermittlung.R;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

public abstract class ConnectedActivity extends Activity {
	
	ConnectedActivity(){
		super();
	}
	public void ConnectionError() {
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
