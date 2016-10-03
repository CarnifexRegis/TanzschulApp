package adapter;

import java.util.ArrayList;

import model.Friend;
import model.FriendRequestItem;
import activitys.FriendRequest;
import activitys.Friends;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.Tanzpartnervermittlung.R;

/**
 * Organizes the display of your friend items
 * @author Simon Stolz
 *
 */
public class FriendsAdapter extends ArrayAdapter<Friend> {
	
	private Context context;
	private Friends f;

	/**
	 * Instantiates a new a adapter.
	 *
	 * @param context the context
	 * @param arrayList the array list
	 * @param atk the atk
	 */
	public FriendsAdapter(Context context, ArrayList<Friend> arrayList,Friends f) {
		super(context, R.layout.friends_item, arrayList);
		
		this.f = f;
		this.context= context;
		}
	
	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//http://stackoverflow.com/questions/21053979/listview-duplicates-android
		View row = null;
		if (convertView == null) {
            LayoutInflater inflater = ((Friends) context).getLayoutInflater();
            row = inflater.inflate(R.layout.friends_item, parent, false);
            //Make sure the textview exists in this xml
     } else {
            row = convertView;
     }
		Friend fItem = getItem(position);
		
			
			TextView name =  (TextView) row.findViewById(R.id.FNameView);
			TextView message = (TextView) row.findViewById(R.id.FMessageView);
			if(fItem.getLastMessage().equals("Freundschaft Ausstehend")){
				row.setClickable(false);
			}
			message.setText(fItem.getLastMessage());
			name.setText(fItem.getFn()+" "+fItem.getLn());
			//http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
			name.setTag(position);
			name.setClickable(true);
			
			
			
			return row;
		}
}
