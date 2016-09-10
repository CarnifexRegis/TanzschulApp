package task;

import protocol.Command;
import protocol.ErrorCode;
import request.ForeignProfileRequest;
import response.ProfileDataResponse;
import activitys.ShowProfile;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class ForeignProfileTask extends BaseHttpRequestTask {
	private String eMail;
	private int id;
	
	/**
	 * Instantiates a new foreign profile task.
	 *
	 * @param sp the sp
	 * @param eMail the e mail
	 * @param id the id
	 */
	public ForeignProfileTask (ShowProfile sp,String eMail, int id) {
		super(sp);
		this.eMail = eMail;
		this.id = id;
	}
	
	public void execute() {
		ForeignProfileRequest request = new ForeignProfileRequest(eMail, id);

		try {
			String xml = buildXML(request);
			super.execute(Command.foreignprofile, xml);
		} catch (Exception e) {
			((ShowProfile) activity).onConnectionError();
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
			ProfileDataResponse response = (ProfileDataResponse) parseXML(result,ProfileDataResponse.class);
			
			String error = response.getErrorCode();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
				((ShowProfile) activity).onError(error);
			 }
			 else
			 {	 
				 ((ShowProfile) activity).rechieveData(response.getPd());
			 }
			
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
			((ShowProfile) activity).onConnectionError();	
		}
	}

}
