package task;

import model.ProfileData;
import protocol.Command;
import protocol.ErrorCode;
import request.LoginRequest;
import request.ProfileDataRequest;
import response.LoginResponse;
import response.ProfileDataResponse;
import response.RegisterResponse;
import activitys.EditProfile;
import activitys.LogIn;
import activitys.Registration;
import activitys.ShowProfile;
import android.util.Log;

public class ProfileDataTask  extends BaseHttpRequestTask{

	int id;
	public ProfileDataTask(EditProfile ep,int id) {
		super(ep);
		this.id = id;
	}
	
	public void execute() {
		ProfileDataRequest request = new ProfileDataRequest(id);

		try {
			String xml = buildXML(request);
			super.execute(Command.getprofile, xml);
		} catch (Exception e) {
			((EditProfile) activity).ConnectionError();
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
					((EditProfile) activity).onError(error);
			 }
			 else
			 {
				 ProfileData pd = response.getPd();
				 ((EditProfile) activity).rechieveData(pd);
			 }
			
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
			((EditProfile) activity).ConnectionError();
		}
	}

}
