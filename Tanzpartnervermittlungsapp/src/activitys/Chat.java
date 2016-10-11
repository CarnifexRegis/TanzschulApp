package activitys;

import java.util.ArrayList;

import task.PollChatTask;
import task.SendMessageTask;
import adapter.ChatAdapter;
import android.os.AsyncTask;
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
import model.Message;
/**
 * This Acticvity is used to communicate with other Users
 * @author Simon
 *
 */
public class Chat extends ConnectedActivity {
	private boolean gender;
	private Chat c = this;
	private int id ;
	private int cid;
	private int fidp ;
	private ChatAdapter cAdapter;
	private Thread thread;
	private int sleepTime = 3000;
	private String fname;
	private int lm;
	private ArrayList<ChatMessage> cm = new ArrayList<ChatMessage>();
	private Button send;
	
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
		
		final EditText mInstert = (EditText) findViewById(R.id.ChatInsert);
		send = (Button) findViewById(R.id.SendButton);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mInstert.getText();
				send.setClickable(false);
				SendMessageTask smt =  new SendMessageTask(c,id,mInstert.getText().toString(),cid);
				smt.execute();
				stopPollThread();
				
				
			}
		});
		createPollThread(sleepTime);
		startPollThread();
		}
	public void addNewMessages(ArrayList<ChatMessage> cm) {
		this.cm.addAll(cm);
		cAdapter.notifyDataSetChanged();
			startPollThread();
		
	}
	/**
	 * is called if an message was successfully send
	 */
	public void successful() {
		send.setClickable(true);
		Toast.makeText(this, "Nachricht versendet", Toast.LENGTH_SHORT).show();
		if(thread.isInterrupted()){
			startPollThread();
		}
		
		
	}
	public void startPollThread(){
		thread.run();
	}
	
	public void stopPollThread(){
		if(thread.isAlive()&&!thread.isInterrupted()){
			thread.interrupt();
		}
	}
	
	public void createPollThread(int pollrate){
		sleepTime = pollrate;
		thread = new Thread() {
		    @Override
		    public void run() {
		        try {
		             sleep(sleepTime);
		             if (cm.size()>0){
		            lm =  cm.get(cm.size()-1).getMid();}
		             else{
		            	lm = 0;
		             }
		             PollThread pt = new PollThread();
		             pt.execute(1);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		};
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
			thread.interrupt();
			this.finish();
			
		}
	private  class PollThread extends AsyncTask<Integer, Void, Void>{

		@Override
		protected Void doInBackground(Integer... params) {
			PollChatTask pct = new PollChatTask(c, id, cid, lm);
			pct.execute();
			return null;
		
		}

	}
	}
	

