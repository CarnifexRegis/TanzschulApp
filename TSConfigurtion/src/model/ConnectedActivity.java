package model;



import com.example.tsconfigurtion.Login;
import com.example.tsconfigurtion.R;
import com.example.tsconfigurtion.R.string;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectedActivity.
 */
public abstract class ConnectedActivity extends Activity {
	
	
	/**
	 * On error.
	 *
	 * @param ec the ec
	 */
	public void onError(String ec){
		Intent intent;
		switch (ec){
		case  "wrongLogin":
			intent = new Intent(getApplicationContext(),Login.class);
			intent.putExtra("error", getResources().getString(R.string.session_expired));
			startActivity(new Intent(intent));
			break;
		case "notFound" :
			Toast.makeText(getApplicationContext(),getResources().getString(R.string.unknown_error), 
	                Toast.LENGTH_LONG).show(); 
			break;
		default:
			intent = new Intent(getApplicationContext(),Login.class);
			intent.putExtra("error", "Fatal error: " + ec);
			startActivity(new Intent(intent));
			break;
		}
	}
	
	/**
	 * On connection error.
	 */
	public void  onConnectionError() {
		if(!isOnline(this)){
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
	                Toast.LENGTH_LONG).show(); 
		
		}else{
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.connection_failed), 
	                Toast.LENGTH_LONG).show(); 	
		}
	}
	
	/**
	 * Checks if is online.
	 *
	 * @param context the context
	 * @return true, if is online
	 */
	public boolean isOnline(Context context) {
	    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    android.net.NetworkInfo networkinfo = cm.getActiveNetworkInfo();
	    if (networkinfo != null && networkinfo.isConnected()) {
	        return true;
	    }
	    return false;
	    }
	
}

