package adapter;

import java.util.ArrayList;

import model.ChatMessage;
import model.FriendRequestItem;
import activitys.Chat;
import activitys.FriendRequest;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.Tanzpartnervermittlung.R;

/**
 * Organizes the display of your chat messages
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
			TextView message =  (TextView) row.findViewById(R.id.ChatMessage);
			message.setText(cm.getText()); 
			if (idp == cm.getSenderId()){
				message.setGravity(Gravity.START);
			}
			return row;
		}
}
