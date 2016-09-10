package com.example.tsconfigurtion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// TODO: Auto-generated Javadoc
/**
 * The Class ManageKurs.
 */
public class ManageKurs  extends Activity {
	
	/** The id. */
	private int id;
	
	/** The add B. */
	private Button addB;
	
	/** The amend B. */
	private Button amendB;


	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_kurs);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
		id = extras.getInt("id");
		}
		
		amendB = (Button) findViewById(R.id.mAmendButton);
		
		addB = (Button) findViewById(R.id.mAddKursButton);
		amendB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),AmendKurs.class);
				intent.putExtra("id", id);
				startActivity(new Intent(intent));
				
			}
		});
		addB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),AddKurs.class);
				intent.putExtra("id", id);
				startActivity(new Intent(intent));
				
			}
		});
		 
		
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
	}
	
}

