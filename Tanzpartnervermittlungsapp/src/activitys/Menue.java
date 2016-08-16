package activitys;

import request.GetAllRequest;
import task.GetAllTask;

import com.example.Tanzpartnervermittlung.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//SQL für Fortgeschritttene join..on group by Roman Create Table, insert,update 
//Php my table
/**
 * 
 * @author Simon
 *
 */
public class Menue extends Activity {

	int ID;
	boolean gender;

	@Override
	/**
	 * 
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menue);

		// datasource = new UserDAO(this);
		// datasource.open();
		// updateArray();

		final Button tpFinden = (Button) findViewById(R.id.TpFinden);

	//	final Menue menue = this;

		tpFinden.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

		//		GetAllTask getAllTask = new GetAllTask(menue, 1234);
		//		getAllTask.execute();
				Intent intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
				intent.getBooleanExtra("gender", gender);
				intent.getIntExtra("ID", ID);
				 startActivity(new Intent(intent));
			}
		});
		final Button myProfile = (Button) findViewById(R.id.Profil);
		myProfile.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(),
						EditProfile.class));
			}
		});
		// Temporary to test Login
		final Button tempLogin = (Button) findViewById(R.id.Sozial);
		tempLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// startActivity(new
				// Intent(getApplicationContext(),LogIn.class));
			}
		});
	}

	public void testAusgabe(String text) {
		TextView testView = (TextView) findViewById(R.id.test1);
		testView.setText(text);
	}

}
