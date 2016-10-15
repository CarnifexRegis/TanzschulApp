package activitys;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Serializer;

import task.PollChatTask;
import task.SendMessageTask;
import adapter.ChatAdapter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
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
import model.MessagesContainer;
/**
 * This Acticvity is used to communicate with other Users
 * @author Simon Stolz
 *
 */
//http://stackoverflow.com/questions/5452394/best-way-to-perform-an-action-periodically-while-an-app-is-running-handler
public class Chat extends ConnectedActivity {
	private boolean gender;
	private Chat c = this;
	private int id ;
	private int cid;
	private int fidp ;
	private ChatAdapter cAdapter;
	private Thread thread;
	private int sleepTime = 10000;
	private String fname;
	private int lm;
	private ArrayList<ChatMessage> cm = new ArrayList<ChatMessage>();
	private Button send;
	private SharedPreferences prefs;
	private String test;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		// gets the passed on data from mainActivity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			id = extras.getInt("ID", -1);
			cid = extras.getInt("cid", -1);
			fidp = extras.getInt("idp", -1);
			gender = extras.getBoolean("gender");
			fname = extras.getString("fname");
		}
		prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String pref = prefs.getString("cm"+cid,null);
		MessagesContainer mc = null;
		if(pref != null){
		 mc =((MessagesContainer) parseXML(pref, MessagesContainer.class));}
		if (mc != null){
			ChatMessage[] ca = mc.getCm();
			for(int i = 0; i <ca.length;i++){
				cm.add(ca[i]);
			}
		}
		test = prefs.getString("cm"+cid,null);
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
				mInstert.setText("");
				smt.execute();
			}
		});
		
		 if (cm.size()>0){
	            lm =  cm.get(cm.size()-1).getMid();}
	             else{
	            	lm = 0;
	             }
	             PollChatTask pct = new PollChatTask(c, id, cid, lm);
	             pct.execute();
		}
	public void addNewMessages(ArrayList<ChatMessage> cm) {
		this.cm.addAll(cm);
		cAdapter.notifyDataSetChanged();
		poll(sleepTime);
	}
	public void poll(int i){
		new CountDownTimer(i, 1000) {

		     public void onTick(long millisUntilFinished) {
		        
		     }

		     public void onFinish() {
		    	 if (c.cm.size()>0){
			            lm =  c.cm.get(c.cm.size()-1).getMid();}
			             else{
			            	lm = 0;
			             }
			             PollChatTask pct = new PollChatTask(c, id, cid, lm);
			 			pct.execute();
		     }
		  }.start();
	}
	/**
	 * is called if an message was successfully send
	 */
	public void successful() {
		enableButton();
		Toast.makeText(this, "Nachricht versendet", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
			this.finish();
			
		}
	public void enableButton(){
		send.setClickable(true);
	}
	@Override
	public void onPause() {
		super.onPause();
		Editor editor = prefs.edit();
		try{
			for(int i = 0; i<cm.size();i++){
				ChatMessage[] ca= new ChatMessage[cm.size()];
				ca[i] = cm.get(i);
			}
			editor.putString("cm"+cid,buildXML(cm.toArray())) ;
			}catch (Exception e){
				e.printStackTrace();}
			editor.commit();
	}
	}
	

