package model;
/**
 * 
 */
import java.util.ArrayList;

import com.example.Tanzpartnervermittlung.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 
 * @author Simon Stolz, MartinPabst
 * @Sources:http://stackoverflow.com/questions/8486511/how-to-set-on-click-listener-on-the-custom-list-view-in-android
 *				http://stackoverflow.com/questions/10726519/how-to-get-the-source-of-imageview-in-order-to-change-it 
 */
public class Adapter extends ArrayAdapter<ProfileChart> {
	
	public Adapter(Context context, ArrayList<ProfileChart> arrayList) {
		super(context, R.layout.list_item_chart, arrayList);}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View ProfileChartView = convertView;
		
		ProfileChart profileChart = getItem(position);
		if (ProfileChartView == null) {
			ProfileChartView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_chart, parent, false);
			
	/*Instanziierung der Views 
	 * */
		ImageView ivProfilePic = (ImageView) ProfileChartView.findViewById(R.id.pictureView);	
		TextView tvname = (TextView) ProfileChartView.findViewById(R.id.nameView);
		TextView tvAge = (TextView) ProfileChartView.findViewById(R.id.ageView);
	    TextView tvViewOfAge = (TextView) ProfileChartView.findViewById(R.id.ViewOfAge);
	    TextView Tvkursstart = (TextView) ProfileChartView.findViewById(R.id.kursstartView);
        TextView tvViewOfKursstart = (TextView) ProfileChartView.findViewById(R.id.ViewOfKursstart);
        TextView tvKurszeit = (TextView) ProfileChartView.findViewById(R.id.kurszeitView);
        TextView tvViewOfKurszeit = (TextView) ProfileChartView.findViewById(R.id.ViewOfKurszeit);
       
        Log.d("derp", "tvname = " + tvname);
   //  String eMail =   profileChart.geteMail();

		tvname.setText(profileChart.getFn() + " "+ profileChart.getLn());
		tvViewOfAge.setText(profileChart.getAge());
	    tvViewOfKursstart.setText(""+profileChart.getdate());
	    tvViewOfKurszeit.setText(""+profileChart.getUhr());
	    
	    // How to change ImageViews Resource : myImageView.setImageResource(mynewImageDrawable)
	    // http://stackoverflow.com/questions/10726519/how-to-get-the-source-of-imageview-in-order-to-change-it 
			
	       }
		return ProfileChartView;	
	}
	
	}
