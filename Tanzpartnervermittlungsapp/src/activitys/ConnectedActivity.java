package activitys;

import java.io.StringWriter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.example.Tanzpartnervermittlung.R;

/**
 * @author Simon Stolz
 *Every Activity that connects with the server or needs to acces Internet resources extends this class
 * 
 * http://stackoverflow.com/questions/12947916/android-remove-all-the-previous-activities-from-the-back-stack
 */
public abstract class ConnectedActivity extends Activity {
	protected int id;
	protected boolean gender;
	/**
	 * @author Simon Stolz
	 */
	ConnectedActivity(){
		super();
	}
	
	/**
	 * On error.
	 *
	 * @param ec the ec
	 */
	public void onError(String ec){
		Intent intent;
		switch (ec){
		case  "wrongLogin":
			intent = new Intent(getApplicationContext(),LogIn.class);
			intent.putExtra("error", getResources().getString(R.string.session_expired));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(new Intent(intent));
			break;
		case "notFound" :
			Toast.makeText(getApplicationContext(),getResources().getString(R.string.unknown_error), 
	                Toast.LENGTH_LONG).show(); 
			break;
		default:
			intent = new Intent(getApplicationContext(),LogIn.class);
			intent.putExtra("error", "Fatal error: " + ec);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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
			// finishes if it cant  get a connection to the Server
			Toast.makeText(getApplicationContext(), getResources().getString(R.string.connection_failed), 
	                Toast.LENGTH_LONG).show(); 	
			this.finish();
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
	// finishes the present activity and returns to Menue Activity
	public void disconectRetreat(){
		int id = this.id;
		boolean gender = this.gender;
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		//http://stackoverflow.com/questions/7075349/android-clear-activity-stack
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		startActivity(new Intent(intent));
		
	
	}
	/**
	 * Builts an xml Object
	 * @param object
	 * @return
	 */
	protected String buildXML(Object object) {
		Style style = new HyphenStyle();
		Format format = new Format(style);

		Serializer serializer = new Persister(format);

		StringWriter writer = new StringWriter();

		try {
			serializer.write(object, writer);
			return writer.getBuffer().toString();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in buildXML ");
			return null; // TODO Error-Handling
		}
	}
/**
 * Serializes an xml object to the provided class
 * @param xml
 * @param myClass
 * @return
 */
	@Override
    public void onBackPressed() {
            super.onBackPressed();
            this.finish();
    }
	protected Object parseXML(String xml, Class myClass) {
		Serializer serializer = new Persister();

		try {
			Object object = serializer.read(myClass, xml);
			return object;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in parseXML ");
			return null; // TODO: Error-Handling
		}
	}
}

