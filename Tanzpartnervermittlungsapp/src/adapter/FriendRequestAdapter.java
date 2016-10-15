package adapter;

import java.util.ArrayList;

import model.FriendRequestItem;
import model.Kurs;
import task.UpdateLinkTask;
import activitys.AssignToKurs;
import activitys.FriendRequest;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.Tanzpartnervermittlung.R;

/**
 * Organizes the display of the users friend requests
 * @author Simon Stolz
 *
 */
//TODO not ready
public class FriendRequestAdapter extends ArrayAdapter<FriendRequestItem> {
	
		private Context context;
		private FriendRequest fr;
	
		/**
		 * Instantiates a new a adapter.
		 *
		 * @param context the context
		 * @param arrayList the array list
		 * @param atk the atk
		 */
		public FriendRequestAdapter(Context context, ArrayList<FriendRequestItem> arrayList,FriendRequest fr) {
			super(context, R.layout.yet_searching_listitem, arrayList);
			
			this.fr = fr;
			this.context= context;
			}
		

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//http://stackoverflow.com/questions/21053979/listview-duplicates-android
			View row = null;
			if (convertView == null) {
	            LayoutInflater inflater = ((FriendRequest) context).getLayoutInflater();
	            row = inflater.inflate(R.layout.friend_request_item, parent, false);
	     } else {
	            row = convertView;
	     }
			FriendRequestItem fri = getItem(position);
			
				
				CheckBox name =  (CheckBox) row.findViewById(R.id.FriendRequestCheck);
				
				name.setText(fri.getFn()+" "+fri.getLn());
				//http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
				name.setTag(position);
				name.setClickable(true);
				name.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						if(isChecked){
							((FriendRequest) fr).addToList(getItem((int) buttonView.getTag()).getIdp());
						
						}else{
							((FriendRequest) fr).removeFromList(getItem((int) buttonView.getTag()).getIdp());
						}
						
					}
				});
				
				
				return row;
			}
	}

