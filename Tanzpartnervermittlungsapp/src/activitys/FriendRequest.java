package activitys;

import java.util.ArrayList;

import com.example.Tanzpartnervermittlung.R;

import model.FriendRequestItem;
import model.ProfileChart;
import adapter.Adapter;
import adapter.FriendRequestAdapter;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class FriendRequest extends ConnectedActivity {
	private FriendRequestAdapter frAdapter;
	private ArrayList<FriendRequestItem> fritems;
	private int id;
	private final FriendRequest fr = this;

	protected void onCreate(Bundle savedInstanceState) {
		// gets the passed on data from mainActivity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getInt("ID", -1);

		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_requests);
		fritems =  new ArrayList<FriendRequestItem>();
		frAdapter = new  FriendRequestAdapter(this,fritems,id );
		final ListView ProfileChartView = (ListView) findViewById(R.id.userListView);
		ProfileChartView.setAdapter(frAdapter);	
	}
}
