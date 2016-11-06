package adapter;

import java.util.ArrayList;
import model.ProfileChart;
import activitys.SearchForDancingpartner;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.Tanzpartnervermittlung.R;

/**
 * This Adapter is used to display other users PrfoileCharts
 *@author Simon Stolz
 * @Sources:http://stackoverflow.com/questions/8486511/how-to-set-on-click-listener-on-the-custom-list-view-in-android 				http://stackoverflow.com/questions/10726519/how-to-get-the-source-of-imageview-in-order-to-change-it 
 * 				http://stackoverflow.com/questions/21053979/listview-duplicates-android
 */
public class SearchAdapter extends ArrayAdapter<ProfileChart> {
	private Context context;
	
	/**
	 * Instantiates a new adapter.
	 *
	 * @param context the context
	 * @param arrayList the array list
	 */
	public SearchAdapter(Context context, ArrayList<ProfileChart> arrayList) {
		super(context, R.layout.list_item_chart, arrayList);
	this.context= context;	
	}
	
	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	// http://stackoverflow.com/questions/21053979/listview-duplicates-android
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		if (convertView == null) {
			
            LayoutInflater inflater = ((SearchForDancingpartner) context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_item_chart, parent, false);
     } else {
            row = convertView;
     }
		
		ProfileChart profileChart = getItem(position);
//		if (row == null) {
//			row = LayoutInflater.from(getContext()).inflate(R.layout.list_item_chart, parent, false);
			
	/*Instanziierung der Views 
	 * */
		//ImageView ivProfilePic = (ImageView) row.findViewById(R.id.pictureView);	
		TextView tvname = (TextView) row.findViewById(R.id.nameView);
		//TextView tvAge = (TextView) row.findViewById(R.id.ageView);
	    TextView tvViewOfAge = (TextView) row.findViewById(R.id.ViewOfAge);
	    //TextView Tvkursstart = (TextView) row.findViewById(R.id.kursstartView);
        TextView tvViewOfKursstart = (TextView) row.findViewById(R.id.ViewOfKursstart);
        //TextView tvKurszeit = (TextView) row.findViewById(R.id.kurszeitView);
        TextView tvViewOfKurszeit = (TextView) row.findViewById(R.id.ViewOfKurszeit);
       
        Log.d("derp", "tvname = " + tvname);
   //  String eMail =   profileChart.geteMail();

		tvname.setText(profileChart.getFn() + " "+ profileChart.getLn());
		tvViewOfAge.setText(profileChart.getAge());
	    tvViewOfKursstart.setText(""+profileChart.getdate());
	    tvViewOfKurszeit.setText(""+profileChart.getUhr());
	    
	    // How to change ImageViews Resource : myImageView.setImageResource(mynewImageDrawable)
	    // http://stackoverflow.com/questions/10726519/how-to-get-the-source-of-imageview-in-order-to-change-it 
			return row;	
	       }
		
	
	
	}
