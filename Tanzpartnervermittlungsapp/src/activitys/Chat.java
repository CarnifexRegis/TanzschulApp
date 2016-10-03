package activitys;

import java.util.ArrayList;

import task.GetFriendsTask;
import adapter.ChatAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.Tanzpartnervermittlung.R;

import model.ChatMessage;

public class Chat extends ConnectedActivity {
	private int lm = 0;
	private boolean gender;
	private Chat c = this;
	private int id = -1;
	private ChatAdapter cAdapter;
	
	ArrayList<ChatMessage> cm = new ArrayList<ChatMessage>();
	protected void onCreate(Bundle savedInstanceState) {
		// gets the passed on data from mainActivity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getInt("ID", -1);
			gender = extras.getBoolean("gender");
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends);
		ListView mList = (ListView) findViewById(R.id.ChatList);
		cAdapter = new ChatAdapter();
		mList.setAdapter(cAdapter);
		final EditText mInstert = (EditText) findViewById(R.id.ChatInsert);
		final Button send = (Button) findViewById(R.id.SendButton);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mInstert.getText();
				send.setClickable(false);
				// id 
				
			}
		});
		
		}
}
