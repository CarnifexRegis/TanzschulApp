package activitys;

import java.util.ArrayList;
import task.AcceptFriendshipTask;
import task.GetFriendRequestsTask;
import com.example.Tanzpartnervermittlung.R;
import model.FriendRequestItem;
import adapter.FriendRequestAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FriendRequest extends ConnectedActivity {
	private FriendRequestAdapter frAdapter;
	private ArrayList<FriendRequestItem> fritems;
	private int id;
	private final FriendRequest fr = this;
	private ArrayList<Integer> idpl= new ArrayList<Integer>();
	private Button send;

	protected void onCreate(Bundle savedInstanceState) {
		// gets the passed on data from mainActivity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getInt("ID", -1);

		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friend_requests);
		send = (Button) findViewById(R.id.frButton);
		fritems =  new ArrayList<FriendRequestItem>();
		frAdapter = new  FriendRequestAdapter(this,fritems,fr );
		final ListView requestView = (ListView) findViewById(R.id.FRequestsListView);
		requestView.setAdapter(frAdapter);	
		GetFriendRequestsTask gfrt = new GetFriendRequestsTask(fr, id);
		gfrt.execute();
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AcceptFriendshipTask aft = new AcceptFriendshipTask(fr,id ,idpl);
				aft.execute();
			}
		});
	}
	public void addToList(int idp){
		idpl.add(idp);
	}
	public void removeFromList(Integer idp){
		if(!idpl.remove(idp)){
			Toast.makeText(this, "Die gewünschte Freundschaftsanfrage konnte nicht abgewählt werden um Fehler zu vermeiden starten sie die App neu.", Toast.LENGTH_LONG).show();
		}
	}
	
	public void recieveRequests(ArrayList<FriendRequestItem> frl) {
		frAdapter.clear();
		frAdapter.addAll(frl);
		frAdapter.notifyDataSetChanged();
		idpl.clear();
		Toast.makeText(this, "Neue Freundschaftsanfragen vom Server empfangen.", Toast.LENGTH_LONG).show();
		
	}
	public void accptedSuccessful() {
		Toast.makeText(this, "Freundschaftsanfragen erfolgreich angenommen", Toast.LENGTH_LONG).show();
		GetFriendRequestsTask gfrt = new GetFriendRequestsTask(fr, id);
		gfrt.execute();
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
