package searchutils;

import java.util.ArrayList;

import model.ProfileChart;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Tanzpartnervermittlung.R;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class Adapter extends ArrayAdapter<ProfileChart> {
	
	/**
	 * Instantiates a new adapter.
	 *
	 * @param context the context
	 * @param arrayList the array list
	 */
	public Adapter(Context context, ArrayList<ProfileChart> arrayList) {
		super(context, R.layout.list_item_chart, arrayList);}
	
	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
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
	    TextView tvViewOfAge = (TextView) ProfileChartView.findViewById(R.id.ViewOfAge);
        TextView tvViewOfKursstart = (TextView) ProfileChartView.findViewById(R.id.ViewOfKursstart);
        TextView tvViewOfKurszeit = (TextView) ProfileChartView.findViewById(R.id.ViewOfKurszeit);
       
        Log.d("derp", "tvname = " + tvname);
 
		tvname.setText(profileChart.getFn() + " "+ profileChart.getLn());
		tvViewOfAge.setText(profileChart.getAge());
	    tvViewOfKursstart.setText(""+profileChart.getUhr());
	    tvViewOfKurszeit.setText(""+profileChart.getdate());
	    
	    // How to change ImageViews Resource : myImageView.setImageResource(mynewImageDrawable)
	    // http://stackoverflow.com/questions/10726519/how-to-get-the-source-of-imageview-in-order-to-change-it 
			
	       }
		return ProfileChartView;	
	}
	}
