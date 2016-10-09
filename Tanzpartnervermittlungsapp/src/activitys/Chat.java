package activitys;

import java.util.ArrayList;

import task.PollChatTask;
import task.SendMessageTask;
import adapter.ChatAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Tanzpartnervermittlung.R;

import model.ChatMessage;

public class Chat extends ConnectedActivity {
	private int lm = 0;
	private boolean gender;
	private Chat c = this;
	private int id ;
	private int cid;
	private int fidp ;
	private ChatAdapter cAdapter;
	private Thread thread;
	private int sleepTime = 10000;
	private String fname;
	private ArrayList<ChatMessage> cm = new ArrayList<ChatMessage>();
	protected void onCreate(Bundle savedInstanceState) {
		// gets the passed on data from mainActivity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getInt("ID", -1);
			cid = extras.getInt("cid", -1);
			fidp = extras.getInt("idp", -1);
			gender = extras.getBoolean("gender");
			fname = extras.getString("fname");
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		TextView nv = (TextView) findViewById(R.id.ChatName);
		nv.setText(fname);
		ListView mList = (ListView) findViewById(R.id.ChatList);
		cAdapter = new ChatAdapter(this,cm,fidp);
		mList.setAdapter(cAdapter);
		//http://stackoverflow.com/questions/1921514/how-to-run-a-runnable-thread-in-android
		thread = new Thread() {
		    @Override
		    public void run() {
		        try {
		             sleep(sleepTime);
		             if (cm.size()>0){
		            lm =  cm.get(cm.size()-1).getMid();}
		             else{
		            	lm = -1;
		             }
		             PollChatTask pct = new  PollChatTask(c, id, cid,lm);
		            pct.execute();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		};
		thread.start();
		final EditText mInstert = (EditText) findViewById(R.id.ChatInsert);
		final Button send = (Button) findViewById(R.id.SendButton);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mInstert.getText();
				send.setClickable(false);
				SendMessageTask smt =  new SendMessageTask(c,id,mInstert.getText().toString(),cid);
				smt.execute();
				thread.interrupt();
				
			}
		});
		

		}
	public void addNewMessages(ArrayList<ChatMessage> cm) {
		this.cm.addAll(cm);
		cAdapter.notifyDataSetChanged();
		thread.run();
	}
	
	public void successful() {
		Toast.makeText(this, "Nachricht versendet", Toast.LENGTH_SHORT).show();
		if(!thread.isAlive()){
			thread.run();
		}
	}
	@Override
	protected void onPause() {
		super.onPause();
		thread.interrupt();
	}
	}

