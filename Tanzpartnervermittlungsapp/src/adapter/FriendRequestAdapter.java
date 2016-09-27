package adapter;

import java.util.ArrayList;

import model.FriendRequestItem;
import model.Kurs;
import task.UpdateLinkTask;
import activitys.AssignToKurs;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.Tanzpartnervermittlung.R;

/**
 * Organizes the display of your friend requests
 * @author Simon Stolz
 *
 */
public class FriendRequestAdapter extends ArrayAdapter<FriendRequestItem> {
	
		private int id;
		private Context context;
		private AssignToKurs atk;
		
		/**
		 * Instantiates a new a adapter.
		 *
		 * @param context the context
		 * @param arrayList the array list
		 * @param id the id
		 * @param atk the atk
		 */
		public FriendRequestAdapter(Context context, ArrayList<FriendRequestItem> arrayList,int id, AssignToKurs atk) {
			super(context, R.layout.yet_searching_listitem, arrayList);
			this.id= id;
			this.atk = atk;
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
	            row = inflater.inflate(R.layout.yet_searching_listitem, parent, false);
	            //Make sure the textview exists in this xml
	     } else {
	            row = convertView;
	     }
			Kurs k = getItem(position);
			
				
				TextView day =  (TextView) row.findViewById(R.id.ayDayView);
				TextView time  =  (TextView) row.findViewById(R.id.ayKurszeitView);
				TextView date =  (TextView) row.findViewById(R.id.ayDateView);
				day.setText(k.getWochentag());
				time.setText(k.getUhrzeit());
				date.setText(k.getDatum());
				ToggleButton delete = (ToggleButton) row.findViewById(R.id.ayEnlistButton);
				
				//http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
				delete.setTag(position);
				delete.setClickable(true);
				delete.setChecked(k.isEnlisted());
				
				delete.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						int position =  (int) v.getTag();
						Kurs k = getItem(position);
						
						UpdateLinkTask ult = new UpdateLinkTask(atk, id,k.getKursId(),((CompoundButton) v).isChecked(),position,v);
						v.setClickable(false);
			        	
			        	((CompoundButton) v).setChecked(!((CompoundButton) v).isChecked());
			        	
			        	ult.execute();
					}
				});	return row;
			}
	}
}
