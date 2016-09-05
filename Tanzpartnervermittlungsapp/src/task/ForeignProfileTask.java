package task;

import model.ProfileData;
import protocol.Command;
import protocol.ErrorCode;
import request.ForeignProfileRequest;
import request.ProfileDataRequest;
import response.ProfileDataResponse;
import activitys.EditProfile;
import activitys.ShowProfile;
import android.util.Log;

public class ForeignProfileTask extends BaseHttpRequestTask {
	String eMail;
	public ForeignProfileTask (ShowProfile sp,String eMail) {
		super(sp);
		this.eMail = eMail;
	}
	
	public void execute() {
		ForeignProfileRequest request = new ForeignProfileRequest(eMail);

		try {
			String xml = buildXML(request);
			super.execute(Command.foreignprofile, xml);
		} catch (Exception e) {
			((ShowProfile) activity).connectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/exceuting command");
		}
	}
	@Override
	public void onPostExecute(String result) {
		try {
			ProfileDataResponse response = (ProfileDataResponse) parseXML(result,
					ProfileDataResponse.class);
			
			String error = response.getErrorCode();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
					((ShowProfile) activity).onError(error);
			 }
			 else
			 {
			
			ProfileData pd = response.getPd();
			
			
			
			((ShowProfile) activity).rechieveData(pd);
			 }
			
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
			((ShowProfile) activity).connectionError();
		}
	}
}
