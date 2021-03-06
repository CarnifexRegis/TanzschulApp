package activitys;

import model.ConnectedActivity;
import model.ProfileData;
import task.AddFriendTask;
import task.ForeignProfileTask;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Tanzpartnervermittlung.R;

/**
 * In this Activity you can spectate the profile of an foreign User
 *
 * @author Simon Stolz
 * @ Source: http://stackoverflow.com/questions/19253786/how-to-copy-text-to-clip-board-in-android
 */
public class ShowProfile extends ConnectedActivity {
	private int id;
	private boolean gender;
	private String idp;
	private ShowProfile sp = this;
	private TextView nameView;
	private TextView ageText;
	private TextView ageView;
	private TextView heightView;
	private TextView aboutMeView;
	private TextView pnView;
	 private ClipData myClip;
	 private ProfileData pd = new ProfileData();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       setContentView(R.layout.show_profile);
	       Bundle extras = getIntent().getExtras();
			if(extras != null){
			id = extras.getInt("ID");
			gender = extras.getBoolean("gender");
			idp = extras.getString("idp");
			}
			
			nameView = (TextView) findViewById(R.id.spnView);
			
			ageText = (TextView) findViewById(R.id.spAgeText);
			ageView = (TextView) findViewById(R.id.spAgeView);
			heightView = (TextView) findViewById(R.id.spHeightView);
			aboutMeView = (TextView) findViewById(R.id.spAboutMeView);
			pnView = (TextView) findViewById(R.id.spPhoneView);
			
	       final Button addToContactsButton = (Button) findViewById(R.id.spAddToContactsButton);
	       addToContactsButton.setOnClickListener(new View.OnClickListener() {
	            @Override
				public void onClick(View v) {
	            	addAsContactConfirmed(sp,pd);
	            }
	        });	
	       final Button FriendRequestButton = (Button) findViewById(R.id.spAddFriendButton);
	       FriendRequestButton.setOnClickListener(new View.OnClickListener() {
	            @Override
				public void onClick(View v) {
	            	AddFriendTask aft = new AddFriendTask(sp, id, idp);
	            	aft.execute();
	            }
	        });	
	   
	       final Button ZwischenablageButton = (Button) findViewById(R.id.spZwischenablageButton);
	    		   ZwischenablageButton.setOnClickListener(new View.OnClickListener() {
	            @Override
				public void onClick(View v) {
	            	if(pnView.getText().toString().equals(getString(R.string.missing_value))){
	            		Toast.makeText(getApplicationContext(),getString(R.string.missing_value), 
	        	                Toast.LENGTH_SHORT).show(); 
	            	}
	            	else{
	            	String text = pnView.getText().toString();
	            	ClipboardManager myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
	                myClip = ClipData.newPlainText("text", text);
	                myClipboard.setPrimaryClip(myClip);
	                Toast.makeText(getApplicationContext(), "In Zwischenablage.", 
	                Toast.LENGTH_SHORT).show(); 
	            	}}
	        });	  
	   ForeignProfileTask fpt =new ForeignProfileTask(sp, idp, id);
			fpt.execute();
			}
	
	@Override
	public void onError(String ec) {
		Intent intent;
		switch (ec){
		case  "wrongLogin":
			intent = new Intent(getApplicationContext(),LogIn.class);
			intent.putExtra("error", getResources().getString(R.string.session_expired));
			startActivity(new Intent(intent));
			break;
		case "notFound" :
			intent = new Intent(getApplicationContext(),SearchForDancingpartner.class);
			intent.putExtra("ID", id);
			intent.putExtra("gender", gender);
			intent.putExtra("error", "Fatal error: "+ec);
			startActivity(new Intent(intent));
			break;
		case "alreadyExists" :
			Toast.makeText(this,"Es besteht bereits eine Anfrage", Toast.LENGTH_LONG).show();
			break;
		default:
			intent = new Intent(getApplicationContext(),LogIn.class);
			intent.putExtra("error", "Fatal error: " + ec);
			startActivity(new Intent(intent));
			break;
		}
	}


	/**
	 * Rechieve data.
	 *
	 * @param pd the pd
	 */
	public void rechieveData(ProfileData pd) {
		this.pd = pd;
		if(pd.isPa()){
		ageView.setVisibility(View.VISIBLE);
		ageText.setVisibility(View.VISIBLE);
		 ageView.setText(pd.getAge()+"");
		 }else{
			//ageView.setText(R.string.missing_value);
			ageView.setVisibility(View.INVISIBLE);
			ageText.setVisibility(View.INVISIBLE);
			Toast.makeText(this, "Der Nutzer hat sich dazu entschieden sein Alter privat zu halten",Toast.LENGTH_LONG).show();
		 }
		 heightView.setText(pd.getHeight()+"");
		 aboutMeView.setText(pd.getpText());
		 pnView.setText(pd.getPhoneNumber()+"");
		 nameView.setText(pd.getFn()+" "+pd.getLn());
	}
	
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		this.finish();
	}
	
	/**
	 * Adds the as contact confirmed.
	 *
	 * @param context the context
	 * @param pd the pd
	 */
	//http://stackoverflow.com/questions/14278587/insert-a-new-contact-intent
	public static void addAsContactConfirmed(final Context context, final ProfileData pd) {

	    Intent intent = new Intent(Intent.ACTION_INSERT);
	    intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

	    intent.putExtra(ContactsContract.Intents.Insert.NAME, pd.getFn()+" "+pd.getLn());
	    intent.putExtra(ContactsContract.Intents.Insert.PHONE, pd.getPhoneNumber());
	    //intent.putExtra(ContactsContract.Intents.Insert.EMAIL, person.email);

	    context.startActivity(intent);

	}

	public void requestSended() {
		Toast.makeText(this, "Freundschaftsanfrage erfolgreich versendet", Toast.LENGTH_LONG).show();
		
	}

}
	

