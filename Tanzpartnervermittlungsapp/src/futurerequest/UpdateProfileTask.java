package futurerequest;

import protocol.Command;
import protocol.ErrorCode;
import activitys.EditProfile;
import activitys.Menue;
import activitys.Registration;
import android.app.Activity;
import android.util.Log;
import request.RegisterRequest;
import response.RegisterResponse;
import task.BaseHttpRequestTask;


public class UpdateProfileTask extends  BaseHttpRequestTask {
	private int id;
	private int pn;
	private int hight;
	private int age ;
	private String pText;
	private boolean pa;
	public UpdateProfileTask(EditProfile ep, int id, int pn, int hight,
			int age, String pText, boolean pa) {
		super(ep);
		this.id = id;
		this.pn = pn;
		this.hight = hight;
		this.age = age;
		this.pText = pText;
		this.pa = pa;
	}
	public void execute() {
		UpdateProfileRequest request = new UpdateProfileRequest(id,pn,hight,age,pText,pa);
		try {
			String xml = buildXML(request);
			super.execute(Command.updateprofile, xml);
		} catch (Exception e) {
			//((Registration) activity).connectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/connection error");
		}
	}
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
