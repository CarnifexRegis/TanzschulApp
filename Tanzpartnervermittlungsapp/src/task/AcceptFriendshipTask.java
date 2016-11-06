package task;

import java.util.ArrayList;

import protocol.Command;
import protocol.ErrorCode;
import request.AcceptFriendshipRequest;
import response.AcceptFriendshipResponse;
import activitys.FriendRequest;
import android.util.Log;
 /**
  * Requests several friendships to be accepted
  * @author Simon Stolz
  *
  */
public class AcceptFriendshipTask extends BaseHttpRequestTask{
	private int id;
	private ArrayList<Integer> idpl;
	public AcceptFriendshipTask(FriendRequest fr, int id,ArrayList<Integer> idpl ) {
		super(fr);
		this.id=id;
		this.idpl =idpl;
	}

	public void execute() {
		AcceptFriendshipRequest request = new AcceptFriendshipRequest(id, idpl);

		try {
			String xml = buildXML(request);
			super.execute(Command.acceptfr, xml);
		} catch (Exception e) {
			
			((FriendRequest) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			AcceptFriendshipResponse response = (AcceptFriendshipResponse) parseXML(result,
					AcceptFriendshipResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	
			 	((FriendRequest) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((FriendRequest) activity).accptedSuccessful();
			 }
		} catch (Exception e) {
			
			((FriendRequest) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}
}
