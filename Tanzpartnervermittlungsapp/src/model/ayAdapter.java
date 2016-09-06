package model;

import java.util.ArrayList;

import com.example.Tanzpartnervermittlung.R;

import activitys.AssignToKurs;
import activitys.EditProfile;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
/**
 * 
 * @author Simon
 *@Source: https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
 */
public class ayAdapter extends ArrayAdapter<Kurs>{
	ayAdapter ay = this;
	int id;
	public ayAdapter(Context context, ArrayList<Kurs> arrayList,int id) {
		
		super(context, R.layout.yet_searching_listitem, arrayList);
		this.id= id;}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View KursView = convertView;
		
		Kurs k = getItem(position);
		if (KursView == null) {
			KursView = LayoutInflater.from(getContext()).inflate(R.layout.yet_searching_listitem, parent, false);
			TextView day =  (TextView) KursView.findViewById(R.id.ayDayView);
			TextView time  =  (TextView) KursView.findViewById(R.id.ayKurszeitView);
			TextView date =  (TextView) KursView.findViewById(R.id.ayDateView);
			day.setText(k.getWochentag());
			time.setText(k.getUhrzeit());
			date.setText(k.getDatum());
			ToggleButton toggle = (ToggleButton) KursView.findViewById(R.id.searchtButton);
			toggle.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
					int position = (Integer) v.getTag();
	                Kurs k = getItem(position);
	                
	                k.getKursID();
	                id = id;
	             
				}
			});
	}
		return KursView;
		}
	
}
