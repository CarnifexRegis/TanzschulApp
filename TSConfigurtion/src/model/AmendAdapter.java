package model;

import java.util.ArrayList;





import com.example.tsconfigurtion.AmendKurs;
import com.example.tsconfigurtion.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
// TODO: Auto-generated Javadoc

/**
 * @author Simon Stolz
 * @Sources: http://stackoverflow.com/questions/21053979/listview-duplicates-android
 * 			model.adapter
 * 			http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
 */
public class AmendAdapter extends ArrayAdapter<aKurs>{
	private Context context;
	private AmendKurs atk;
	
	/**
	 * Instantiates a new amend adapter.
	 *
	 * @param context the context
	 * @param arrayList the array list
	 * @param atk the atk
	 */
	public AmendAdapter(Context context, ArrayList<aKurs> arrayList, AmendKurs atk) {
		super(context, R.layout.kurs_item, arrayList);
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
            LayoutInflater inflater = ((AmendKurs) context).getLayoutInflater();
            row = inflater.inflate(R.layout.kurs_item, parent, false);
            //Make sure the textview exists in this xml
     } else {
            row = convertView;
     }
		aKurs k = getItem(position);
		
			
			TextView day =  (TextView) row.findViewById(R.id.KursWochentagView);
			TextView time  =  (TextView) row.findViewById(R.id.KursZeitView);
			TextView date =  (TextView) row.findViewById(R.id.KursDatumView);
			TextView level =  (TextView) row.findViewById(R.id.KursstufeView);
			TextView interested =  (TextView) row.findViewById(R.id.KursSuchendeView);
			
			day.setText(k.getWochentag());
			time.setText(k.getUhrzeit());
			date.setText(k.getDatum());
			
			level.setText(Kursstufen.fromInt(k.getKursstufe()).getKuNa());
			date.setText(k.getDatum());
			interested.setText(k.getEnlisted()+" User");
			Button delete = (Button) row.findViewById(R.id.KursDeleteButton);
			
			//http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/view/List14.html
			delete.setTag(position);
			delete.setClickable(true);
			delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int position =  (int) v.getTag();
					aKurs k = getItem(position);
					atk.requestDelete(position, k.getKursId());
				}
			});	return row;
		}
}
//			delete.setOnCheckedChangeListener( new OnCheckedChangeListener() {
//		        @Override
//		        public void onCheckedChanged(CompoundButton tb, boolean isChecked) {
//		        	
//		        	int position =  (int) tb.getTag();
//		        	aKurs k = getItem(position);
//		        	
//		        	UpdateLinkTask ult = new UpdateLinkTask(atk, id,k.getaKursId(), isChecked,position,tb);
//		        	tb.setClickable(false);
//		        	tb.setEnabled(false);
//		        	tb.setChecked(!isChecked);
//		        	
//		        	ult.execute();
//		        	
//		        }

				
		   // }) ;
			

	
	
