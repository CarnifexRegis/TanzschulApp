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

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class ProfileDataTask  extends BaseHttpRequestTask{
	private int id;
	
	/**
	 * Instantiates a new profile data task.
	 *
	 * @param ep the ep
	 * @param id the id
	 */
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
			((EditProfile) activity).onConnectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/exceuting command");
		}
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
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
			((EditProfile) activity).onConnectionError();
		}
	}

}
