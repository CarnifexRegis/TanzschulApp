package task;

import protocol.Command;
import protocol.ErrorCode;
import activitys.EditProfile;
import activitys.Menue;
import activitys.Registration;
import android.app.Activity;
import android.util.Log;
import request.RegisterRequest;
import request.UpdateProfileRequest;
import response.RegisterResponse;
import response.UpdateProfileResponse;


// TODO: Auto-generated Javadoc
/**
 * The Class UpdateProfileTask.
 */
public class UpdateProfileTask extends  BaseHttpRequestTask {
	
	/** The id. */
	private int id;
	
	/** The pn. */
	private String pn;
	
	/** The height. */
	private int height;
	
	/** The age. */
	private int age ;
	
	/** The p text. */
	private String pText;
	
	/** The pa. */
	private boolean pa;
	
	/**
	 * Instantiates a new update profile task.
	 *
	 * @param ep the ep
	 * @param id the id
	 * @param pn the pn
	 * @param height the height
	 * @param age the age
	 * @param pText the text
	 * @param pa the pa
	 */
	public UpdateProfileTask(EditProfile ep, int id, String pn, int height,
			int age, String pText, boolean pa) {
		super(ep);
		this.id = id;
		this.pn = pn;
		
		this.height = height;
		this.age = age;
		
		this.pText = pText;
		this.pa = pa;
	}
	
	/**
	 * Execute.
	 */
	public void execute() {
		UpdateProfileRequest request = new UpdateProfileRequest(id,pn,height,age,pText,pa);
		try {
			String xml = buildXML(request);
			super.execute(Command.updateprofile, xml);
		} catch (Exception e) {
			//((Registration) activity).connectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/connection error");
		}
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			UpdateProfileResponse response = (UpdateProfileResponse) parseXML(result,
					UpdateProfileResponse.class);
			
			String error =response.getErrorCode();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
					((EditProfile) activity).onError(error);
			 }
			 else
			 {
			((EditProfile) activity).updateSucessful();
			 }
			
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
			
		}
	}

	
}
