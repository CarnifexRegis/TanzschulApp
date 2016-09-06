package model;

import java.util.ArrayList;

import com.example.Tanzpartnervermittlung.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class aeAdapter extends ArrayAdapter<Kurs>{
	int id;
	public aeAdapter(Context context, ArrayList<Kurs> arrayList,int id) {
		super(context, R.layout.enlist_search_listitem, arrayList);
		this.id= id;
		}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View KursView = convertView;
		
		Kurs k = getItem(position);
		if (KursView == null) {
			KursView = LayoutInflater.from(getContext()).inflate(R.layout.enlist_search_listitem, parent, false);
			TextView day =  (TextView) KursView.findViewById(R.id.aeDayView);
			TextView time  =  (TextView) KursView.findViewById(R.id.aeKurszeitView);
			TextView date =  (TextView) KursView.findViewById(R.id.aeDateView);
			day.setText(k.getWochentag());
			time.setText(k.getUhrzeit());
			date.setText(k.getDatum());
			Button delete = (Button) KursView.findViewById(R.id.aeAddButton);
			delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
					int position = (Integer) v.getTag();
	                Kurs k = getItem(position);
	                k.getKursID();
	                
	                //Delete Link Request
				}
			});
	}
		return KursView;
		}
}
