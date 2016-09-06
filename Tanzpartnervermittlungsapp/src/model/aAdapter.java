package model;

import java.util.ArrayList;

import task.UpdateLinkTask;

import com.example.Tanzpartnervermittlung.R;

import activitys.AssignToKurs;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class aAdapter extends ArrayAdapter<Kurs>{
	int id;
	AssignToKurs atk;
	public aAdapter(Context context, ArrayList<Kurs> arrayList,int id, AssignToKurs atk) {
		super(context, R.layout.yet_searching_listitem, arrayList);
		this.id= id;
		this.atk = atk;
		}
	
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
			ToggleButton delete = (ToggleButton) KursView.findViewById(R.id.ayEnlistButton);
			// test
			delete.setTag(position);
			delete.setClickable(true);
			delete.setChecked(k.isEnlisted());
			delete.setOnCheckedChangeListener( new OnCheckedChangeListener() {
		        @Override
		        public void onCheckedChanged(CompoundButton tb, boolean isChecked) {
		        	
		        	int position =  (int) tb.getTag();
		        	Kurs k = getItem(position);
		        	
		        	UpdateLinkTask ult = new UpdateLinkTask(atk, id,k.getKursId(), isChecked,position);
		        	//tb.setChecked(!isChecked);
		        	ult.execute();
		        	
		        }

				
		    }) ;
			

	}
		return KursView;
		}
}
