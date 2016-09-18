package activitys;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import model.ProfileData;
import task.ProfileDataTask;
import task.UpdateProfileTask;
import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Tanzpartnervermittlung.R;

import database.Picture;
import database.TsDataSource;



// TODO: Auto-generated Javadoc
// Added: 13.06.2016
//Last Modofied:14.6.2016 
/**
 * @author Simon Stolz
 * Source : http://codetheory.in/android-pick-select-image-from-gallery-with-intents/
 * http://stackoverflow.com/questions/25490928/androidselect-image-from-gallery-then-crop-that-and-show-in-an-imageview
 */
// Add Listeners for 2 Radio Groups and one Button Mabe do the first request
public class EditProfile extends ConnectedActivity {
	private TsDataSource dataSource;

//	ProfileDataForServer data;
	private static final int REQUEST_EXTERNAL_STORAGE = 1;
	private static String[] PERMISSIONS_STORAGE = {
	        Manifest.permission.READ_EXTERNAL_STORAGE,
	        Manifest.permission.WRITE_EXTERNAL_STORAGE
	};
	private EditText pnInsert;
	private EditText pTextInsert;
	private EditText ageInsert;
	private EditText heightInsert;
	private TextView nView;
	private CheckBox paCheck;
	private static final String LOG_TAG = "EditProfile";
	private EditProfile edp = this;
	private int id;
	private String pn;
	private int height;
	private int age;
	private String pText;
	private boolean pa;
	private boolean gender;
	private ImageView pic;
	private static final int PICK_FROM_GALLERY = 2;
	//private static final  Random generator = new Random();
	private SharedPreferences prefs;
	private int count;
//	private EditProfile ep;
	private Picture myPicture;
	Bitmap myBitmap = null;
	static final String appDirectoryName = "TanzschulVermittlung";
	static final File imageRoot = new File(Environment.getExternalStoragePublicDirectory(
	        Environment.DIRECTORY_PICTURES), appDirectoryName);

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle 
			savedInstanceState) {
		 Bundle extras = getIntent().getExtras();
			if(extras != null){
				id = extras.getInt("ID");
			}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);
		 prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		 count = prefs.getInt("count", 0);
		 pnInsert = (EditText) findViewById(R.id.pNumberInsert);
		 pTextInsert = (EditText) findViewById(R.id.aboutMeInsert);
		 ageInsert = (EditText) findViewById(R.id.ageInsert);
		 heightInsert = (EditText) findViewById(R.id.heightInsert);
		 nView = (TextView) findViewById(R.id.epNameView);
		 pic = (ImageView) findViewById(R.id.editProfileImage);
		
		 paCheck = (CheckBox) findViewById(R.id.checkBox1);
		 
	ProfileDataTask pdTask = new ProfileDataTask(edp,id);
    	pdTask.execute();
    	
    //	dataSource.close();
        Log.d(LOG_TAG, "Die Datenquelle wird geöffnet.");
        
      //  Picture picture = dataSource.createPicture("bla", "bla", 1000);
   
       getInternalPic();
     

       
		// This Button reads the Users inserted information and saves it in a ProfileDataForServer Object 
		final Button ready = (Button) findViewById(R.id.fertigButton);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {
            // TODO nach dem ersten Request das für alle übernehmen
            	if(pnInsert.getText().toString().length()>0){
            	pn = pnInsert.getText().toString();
            	}else{
            		pn = getString(R.string.missing_value);  
            	}
            	if(ageInsert.getText().toString().length()>0){
            		age = Integer.valueOf(ageInsert.getText().toString());
            		}else{
            			age = 0;}
            	if(heightInsert.getText().toString().length()>0){
            		height = Integer.valueOf(heightInsert.getText().toString());}
            			else{height  = 0;}
            	if(!pTextInsert.getText().toString().equals(getString(R.string.about_me))
            			&&!pTextInsert.getText().toString().equals(getString(R.string.missing_value))
            			&&pTextInsert.getText().toString().length()>0)
            		{
            		pText =  pTextInsert.getText().toString();}
            	else{
            		pText =getString(R.string.missing_value); 
            		}
            	pa = paCheck.isChecked();
            	UpdateProfileTask upTask = new UpdateProfileTask(edp,id,pn,height,age,pText,pa);
            	upTask.execute();
            }
        });
		pic.setOnClickListener(new OnClickListener() {
			/**
			 *  http://codetheory.in/android-pick-select-image-from-gallery-with-intents/
			 */
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				// Show only images, no videos or anything else
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				// Always show the chooser (if there are multiple options available)
				 intent.putExtra("crop", "true");
		            intent.putExtra("aspectX", 300);
		            intent.putExtra("aspectY", 300);
		        
		            try {
		            	intent.putExtra("return-data", true);
		            	startActivityForResult(Intent.createChooser(intent,"Complete action using"),     PICK_FROM_GALLERY);

		            	            } catch (ActivityNotFoundException e) {
		            	            }
				
			}
		});
	    }
	
	/**
	 * Rechieve data.
	 *
	 * @param pd the pd
	 */
	public void rechieveData(ProfileData pd) {
		
		if(pd.getPhoneNumber().length()>0){
			pnInsert.setText( pd.getPhoneNumber());
		}
		pTextInsert.setText(pd.getpText());
		nView.setText(pd.getFn()+" "+pd.getLn());
		
		gender = pd.isGender();
		paCheck.setChecked(pd.isPa());
		pnInsert.setText(pd.getPhoneNumber()+"");
		pTextInsert.setText(pd.getpText());
		ageInsert.setText(pd.getAge()+"");
		heightInsert.setText(pd.getHeight()+"");
				}
	
	public Bitmap getInternalPic(){
    	 dataSource = new TsDataSource(this);
     	dataSource.open();
     	try{
     	myPicture =dataSource.getMyPic();
     	myBitmap  = BitmapFactory.decodeFile(myPicture.getClientSource());
     	}catch(Exception e){
     		Toast.makeText(this, "Es exestiert noch kein Bild in der Datenbank",Toast.LENGTH_LONG).show();
     	}
     	
     	if(myBitmap != null){
     	pic.setImageBitmap(myBitmap);
     	}
     	return myBitmap;
     	}
	/**
	 * Update sucessful.
	 */
	public void updateSucessful() {
		Intent intent = new Intent(getApplicationContext(),Menue.class);
		intent.putExtra("ID", id);
		intent.putExtra("gender", gender);
		startActivity(new Intent(intent));
	}
	
	/* (non-Javadoc)
	 * @see activitys.ConnectedActivity#onConnectionError()
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    
	  //  http://stackoverflow.com/questions/25490928/androidselect-image-from-gallery-then-crop-that-and-show-in-an-imageview
	    if (requestCode == PICK_FROM_GALLERY) {
	    	if(data != null){
	        Bundle extras2 = data.getExtras();
	        if (extras2 != null) {
	            Bitmap photo = extras2.getParcelable("data");
	            pic.setImageBitmap(photo);
	            dataSource = new TsDataSource(this);
	            saveStorage(photo);
	           // saveToInternalStorage(photo);
	            //dataSource.	amendPic(saveToInternalStorage(photo),null, -1);
	            Log.d(LOG_TAG, "Die Datenquelle wird geschlossen.");
	       //     dataSource.close();


	        }}
	    }
	}
	
	
	@Override // must be overrided see TODO
	public void onConnectionError() {
		
			//TODO Error Handling 
			//this activity has to switch back to the activity that called it
			if(!isOnline(this)){
				
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.check_connection), 
		                Toast.LENGTH_SHORT).show(); 
			
			}else{
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.connection_failed), 
		                Toast.LENGTH_SHORT).show(); 
				
			}	
	}
	  
	  //http://www.geeks.gallery/saving-image/
//	  private String saveImage(Bitmap finalBitmap) {
//          
//	        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
//	        System.out.println(root +" Root value in saveImage Function");
//	        File myDir = new File(root + "/contact_images"); 
//	        if (!myDir.exists()) {
//	            myDir.mkdirs();
//	        }
//
//	        Random generator = new Random();
//	        int n = 10000;
//	        n = generator.nextInt(n);
//	       
//	       String  iname = "Image-" + count + ".jpg";
//	       count = count++;
//	        File file = new File(myDir, iname);
//
//	        if (file.exists())
//
//	            file.delete();
//
//	        try {
//
//	            FileOutputStream out = new FileOutputStream(file);
//	            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
//	            out.flush();
//	            out.close();
//	        }
//	        catch (Exception e) {
//	            e.printStackTrace();
//	        }
//
//	 
//
//	        // Tell the media scanner about the new file so that it is
//
//	        // immediately available to the user.
//
//	        MediaScannerConnection.scanFile(this, new String[] { file.toString() }, null,
//
//	                new MediaScannerConnection.OnScanCompletedListener() {
//	        	@Override
//	                    public void onScanCompleted(String path, Uri uri) {
//
//	                        Log.i("ExternalStorage", "Scanned " + path + ":");
//
//	                        Log.i("ExternalStorage", "-> uri=" + uri);
//
//	                    }
//	        });
//	        File[] files = myDir.listFiles();
//	        int numberOfImages=files.length;
//	        System.out.println("Total images in Folder "+numberOfImages);
//	        return  Environment.getExternalStorageDirectory()+ "/Pictures/contact_images/"+iname;
//	  }
	  private String saveStorage(Bitmap bitmapImage){
		  verifyStoragePermissions(this);
		  ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		  bitmapImage.compress(Bitmap.CompressFormat.PNG, 40, bytes);

		  //you can create a new file name "test.BMP" in sdcard folder.
		  File f = new File(Environment.getExternalStorageDirectory()
		                          + File.separator + "profile+"+count+".bmp");
		  count ++;
		  try {
			f.createNewFile();
			FileOutputStream fo = new FileOutputStream(f);
			fo.write(bytes.toByteArray());

		// remember close de FileOutput
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//write the bytes in file
		
		  return f.getAbsolutePath();
	  }
	  private String saveToInternalStorage(Bitmap bitmapImage){
		  //http://stackoverflow.com/questions/17674634/saving-and-reading-bitmaps-images-from-internal-memory-in-android
		 // http://stackoverflow.com/questions/20523658/how-to-create-application-specific-folder-in-android-gallery
	         // path to /data/data/yourapp/app_data/imageDir
	      //  File directory = cw.getDir("PROFILE_PICS", Context.MODE_PRIVATE);
	        // Create imageDir
		  verifyStoragePermissions(this);
		  imageRoot.mkdirs();
	        File mypath=new File(imageRoot,"profile_"+ count +".jpg");
	      //  scanPhoto(mypath.toString());	
	        count ++;
	        FileOutputStream  fos = null;
	        try {
	        	mypath.createNewFile();          
	        	 fos = new FileOutputStream(mypath);
	            
	       // Use the compress method on the BitMap object to write image to the OutputStream
	            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
	            fos.close();
	        } catch (Exception e) {
	        	Toast.makeText(this, "Couldn´t write Picture.", Toast.LENGTH_LONG).show();
	              e.printStackTrace();
	        } 
	         
	        return mypath.getAbsolutePath();
	    }
	  @Override
	  public void onPause(){
		  super.onPause();
		  Editor editor = prefs.edit();
	      editor.putInt("count",count);
	      editor.commit();
		 // dataSource.close();
	  }
	  public static void verifyStoragePermissions(Activity activity) {
		 // http://stackoverflow.com/questions/8854359/exception-open-failed-eacces-permission-denied-on-android
		    // Check if we have write permission
		    int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

		    if (permission != PackageManager.PERMISSION_GRANTED) {
		        // We don't have permission so prompt the user
		        ActivityCompat.requestPermissions(
		                activity,
		                PERMISSIONS_STORAGE,
		                REQUEST_EXTERNAL_STORAGE
		        );
		    }
		}
	  
	 }

