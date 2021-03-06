package adapter;

import java.util.ArrayList;

import model.ChatMessage;
import activitys.Chat;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.Tanzpartnervermittlung.R;
/**
 * Organizes the display of the chat messages in Chat Activity
 * @author Simon Stolz
 *
 */
public class ChatAdapter extends ArrayAdapter<ChatMessage>{
	private Context context;
	private int idp;
	
	/**
	 * This Adapter manages the rows in the the list view  in the Chat activity
	 *
	 * @param context the context
	 * @param arrayList the array list
	 * @param atk the atk
	 */
	public ChatAdapter(Context context, ArrayList<ChatMessage> arrayList, int idp) {
		super(context, R.layout.chat_item, arrayList);
		this.context= context;
		this.idp = idp;
		
		}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		if (convertView == null) {
            LayoutInflater inflater = ((Chat) context).getLayoutInflater();
            row = inflater.inflate(R.layout.chat_item, parent, false);
     } else {
            row = convertView;
     }
		ChatMessage cm = getItem(position);
		
			
			TextView m1 =  (TextView) row.findViewById(R.id.ForeignMessage);
			TextView m2 =  (TextView) row.findViewById(R.id.MyMessage);
			if (idp == cm.getSenderId()){
				m2.setText(cm.getText());
				m2.setVisibility(View.VISIBLE);
				m1.setVisibility(View.GONE);
			}else{
				m1.setText(cm.getText());
				m1.setVisibility(View.VISIBLE);
				m2.setVisibility(View.GONE);
				
			}
			
			return row;
		}
}
