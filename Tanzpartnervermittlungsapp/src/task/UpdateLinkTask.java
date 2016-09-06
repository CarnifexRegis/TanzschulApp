package task;

import protocol.Command;
import protocol.ErrorCode;
import request.UpdateLinkRequest;
import response.UpdateLinkResponse;
import activitys.AssignToKurs;
import activitys.EditProfile;
import android.util.Log;
/**
 * 
 * @author Simon
 *
 */
public class UpdateLinkTask extends BaseHttpRequestTask{
int uid;
int kid;
int position ;
boolean command;// trur for add fals for delete
	/**
	 * 
	 * @param atk		The executing activity
	 * @param uid		The User id of the Link object
	 * @param kid		The Kurs id fo the Link object
	 * @param command	True for adding dedicated Link false for deleting it
	 */
	public UpdateLinkTask(AssignToKurs atk ,int uid,int  kid, boolean command, int position) {
		super(atk);
		this.kid = kid;
		this.uid = uid;
		this.command = command;
		this.position = position;
		
		// TODO Auto-generated constructor stub
	}
	public void execute() {
		UpdateLinkRequest request = new UpdateLinkRequest(uid ,kid,command);
		try {
			String xml = buildXML(request);
			super.execute(Command.updatelink, xml);
		} catch (Exception e) {
			((AssignToKurs) activity).onConnectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/connection error");
		}
	}
	@Override
	public void onPostExecute(String result) {
		try {
			UpdateLinkResponse response = (UpdateLinkResponse) parseXML(result,
					UpdateLinkResponse.class);
			
			String error =response.getEc();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
					((EditProfile) activity).onError(error);
			 }
			 else
			 {
			((AssignToKurs) activity).added(position);
			 }
			
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
			((AssignToKurs) activity).onConnectionError();
		}
	}
}
