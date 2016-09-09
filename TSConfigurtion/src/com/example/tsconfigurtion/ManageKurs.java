package com.example.tsconfigurtion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageKurs  extends Activity {
	private int id;
	private Button addB;
	private Button amendB;


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
	@Override
	public void onBackPressed() {
	}
	
}

