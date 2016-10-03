package activitys;

import java.util.ArrayList;

import task.GetFriendsTask;
import model.Friend;
import adapter.FriendsAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Tanzpartnervermittlung.R;

public class Friends extends ConnectedActivity {
	private int id;
	boolean gender;
	private Friends f = this;
	private ArrayList<Friend> fList = new ArrayList<Friend>();
	private FriendsAdapter fAdapter ;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// gets the passed on data from mainActivity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getInt("ID", -1);
			gender = extras.getBoolean("gender");
		}
		GetFriendsTask gft = new GetFriendsTask(f, id);
		gft.execute();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends);
		final ListView fView = (ListView) findViewById(R.id.ContactsListView);
		fAdapter = new FriendsAdapter(this,fList,f);
		fView.setAdapter(fAdapter);
		}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
			 startActivity(new Intent(intent));
	}
	public void recieveFriends(ArrayList<Friend> flist) {
		
		fList.clear();
		fList.addAll(flist);
		fAdapter.notifyDataSetChanged();
		if(flist.size() ==0){
			Toast.makeText(this,"Keine BEstehenden Freundschaften oder Anfragen mit anderen Usern", Toast.LENGTH_LONG).show();
		}else{
		Toast.makeText(this,"Neue Datensätze vom Server empfangen", Toast.LENGTH_LONG).show();}
	}
}
