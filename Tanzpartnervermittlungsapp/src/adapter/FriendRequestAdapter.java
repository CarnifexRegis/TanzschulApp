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
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.Tanzpartnervermittlung.R;

/**
 * Organizes the display of your friend requests
 * @author Simon Stolz
 *
 */
//TODO not ready
public class FriendRequestAdapter extends ArrayAdapter<FriendRequestItem> {
	
		private int id;
		private Context context;
	
		/**
		 * Instantiates a new a adapter.
		 *
		 * @param context the context
		 * @param arrayList the array list
		 * @param id the id
		 * @param atk the atk
		 */
		public FriendRequestAdapter(Context context, ArrayList<FriendRequestItem> arrayList,int id) {
			super(context, R.layout.yet_searching_listitem, arrayList);
			this.id= id;
	
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
	            LayoutInflater inflater = ((AssignToKurs) context).getLayoutInflater();
	            row = inflater.inflate(R.layout.friend_request_item, parent, false);
	            //Make sure the textview exists in this xml
	     } else {
	            row = convertView;
	     }
			FriendRequestItem fri = getItem(position);
			
				
				TextView name =  (TextView) row.findViewById(R.id.FrNameView);
				Button accept = (Button) row.findViewById(R.id.FrAcceptButton);
				Button deny = (Button) row.findViewById(R.id.FrDenyButton);
				
				//http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
				accept.setTag(position);
				accept.setClickable(true);
				accept.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO stop both buttons from being clickable whe on Click gets executed
						int position =  (int) v.getTag();
						FriendRequestItem fr = getItem(position);
						//UpdateLinkTask ult = new UpdateLinkTask(context, id,fri.getIdp(),false,position,v);
						v.setClickable(false);
			        	
			        	((CompoundButton) v).setChecked(!((CompoundButton) v).isChecked());
			        //	ult.execute();
						
					}
				});
				
				deny.setTag(position);
				deny.setClickable(true);
				deny.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						int position =  (int) v.getTag();
						FriendRequestItem fr = getItem(position);
						
						//UpdateLinkTask ult = new UpdateLinkTask(fr, id,fr.getIdp(),false,position,v);
						v.setClickable(false);
			        	
			        	((CompoundButton) v).setChecked(!((CompoundButton) v).isChecked());
			        	
			        //	ult.execute();
					}
				});
				return row;
			}
	}

