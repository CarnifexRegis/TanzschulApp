package task;

import protocol.Command;
import protocol.ErrorCode;
import request.UpdateLinkRequest;
import response.UpdateLinkResponse;
import activitys.AssignToKurs;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
// TODO: Auto-generated Javadoc

/**
 * The Class UpdateLinkTask.
 *
 * @author Simon
 */
public class UpdateLinkTask extends BaseHttpRequestTask{
	private int uid;
	private int kid;
	private int position ;
	private View tb;

boolean command;// trur for add fals for delete
	
	/**
	 * Instantiates a new update link task.
	 *
	 * @param atk 	The executing activity
	 * @param uid 	The User id of the Link object
	 * @param kid 	The Kurs id fo the Link object
	 * @param command True for adding dedicated Link false for deleting it
	 * @param position the position
	 * @param tb the tb
	 */
	public UpdateLinkTask(AssignToKurs atk ,int uid,int  kid, boolean command, int position,View tb) {
		super(atk);
		this.kid = kid;
		this.uid = uid;
		this.command = command;
		this.position = position;
		this.tb = tb;
		
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		UpdateLinkRequest request = new UpdateLinkRequest(uid ,kid,command);
		try {
			
			String xml = buildXML(request);
			super.execute(Command.updatelink, xml);
		} catch (Exception e) {
			((AssignToKurs) activity).onConnectionError();
			 tb.setClickable(true);
//			 tb.setEnabled(true);
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
			UpdateLinkResponse response = (UpdateLinkResponse) parseXML(result,
					UpdateLinkResponse.class);
			
			String error =response.getEc();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
					((AssignToKurs) activity).onError(error);
					((CompoundButton) tb).setChecked(!command);
			 }
			 else
			 {	
				 
				 ((CompoundButton) tb).setChecked(command);
				 
				 if (command ){
					 ((AssignToKurs) activity).added(position);
	
				 }else{
				 	((AssignToKurs) activity).deleted(position);}
				 }
		 tb.setClickable(true);
//			 tb.setEnabled(true);
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
			 tb.setClickable(true);
//			 tb.setEnabled(true);
			((AssignToKurs) activity).onConnectionError();
		}
	}
}
