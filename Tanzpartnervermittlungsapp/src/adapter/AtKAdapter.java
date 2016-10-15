package adapter;

import java.util.ArrayList;

import model.Kurs;
import task.UpdateLinkTask;
import activitys.AssignToKurs;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
// TODO: Auto-generated Javadoc


import com.example.Tanzpartnervermittlung.R;

/**
 * An Adapter for the ListView in AssingToKurs class
 *
 * @author Simon Stolz
 * @Sources: http://stackoverflow.com/questions/21053979/listview-duplicates-android
 * 			model.adapter
 * 			http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
 */
public class AtKAdapter extends ArrayAdapter<Kurs>{
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
	public AtKAdapter(Context context, ArrayList<Kurs> arrayList,int id, AssignToKurs atk) {
		super(context, R.layout.yet_searching_listitem, arrayList);
		this.id= id;
		this.atk = atk;
		this.context= context;
		}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//http://stackoverflow.com/questions/21053979/listview-duplicates-android
		View row = null;
		if (convertView == null) {
            LayoutInflater inflater = ((AssignToKurs) context).getLayoutInflater();
            row = inflater.inflate(R.layout.yet_searching_listitem, parent, false);
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