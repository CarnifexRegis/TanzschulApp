package activitys;

import java.util.ArrayList;

import task.GetFriendsTask;
import model.Friend;
import adapter.FriendsAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
		fView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	
            	if((int) view.getTag()==1){
            		
            	
                //http://stackoverflow.com/questions/9208827/how-to-extract-the-text-from-the-selected-item-on-the-listview
                Intent intent = new Intent(getApplicationContext(),Chat.class);
				intent.putExtra("ID", f.id);
				intent.putExtra("gender", f.gender);
				int cid = fAdapter.getItem(position).getCid();
				intent.putExtra("cid", cid); 
				intent.putExtra("idp", fAdapter.getItem(position).getIdp()); 
				intent.putExtra("fname",fAdapter.getItem(position).getFn()+" "+fAdapter.getItem(position).getLn() ); 
				 startActivity(new Intent(intent));
				 }else{
					 Toast.makeText(f,"Der Nutzer hat ihre Freundschaftsanfrage nochnicht akzeptiert", Toast.LENGTH_SHORT).show();
				 }
            }
        });
		}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
//		Intent intent = new Intent(getApplicationContext(),Menue.class);
//		intent.putExtra("ID", id);
//		intent.putExtra("gender", gender);
//			 startActivity(new Intent(intent));
			 this.finish();
	}
	/**
	 * Updates the ListLiew when new data was recieved
	 * @param flist
	 */
	public void recieveFriends(ArrayList<Friend> flist) {
		fList.clear();
		fList.addAll(flist);
		fAdapter.notifyDataSetChanged();
		if(flist.size() ==0){
			Toast.makeText(this,"Keine BEstehenden Freundschaften oder Anfragen mit anderen Usern", Toast.LENGTH_LONG).show();
		}else{
		Toast.makeText(this,"Neue Datensätze vom Server empfangen", Toast.LENGTH_LONG).show();}
	}
	public void setClickable(boolean c){

	}
}
