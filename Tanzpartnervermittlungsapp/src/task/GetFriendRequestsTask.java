package task;

import protocol.Command;
import protocol.ErrorCode;
import request.GetFriendRequestsRequest;
import request.GetKursRequest;
import response.GetFriendRequestsResponse;
import response.GetKursResponse;
import activitys.AssignToKurs;
import activitys.FriendRequest;
import android.util.Log;

public class GetFriendRequestsTask extends BaseHttpRequestTask{
	private int id;
	
	/**
	 * Gets all Friend requests
	 *
	 * @param fr instance of an activity
	 * @param id the users  id
	 */
	public GetFriendRequestsTask(FriendRequest fr, int id) {
		super(fr);
		this.id=id;
	}

	public void execute() {
		GetFriendRequestsRequest request = new GetFriendRequestsRequest(id);

		try {
			String xml = buildXML(request);
			super.execute(Command.getfr, xml);
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
			GetFriendRequestsResponse response = (GetFriendRequestsResponse) parseXML(result,
					GetFriendRequestsResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	
			 	((FriendRequest) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((FriendRequest) activity).recieveRequests(response.getFrl());
			 }
		} catch (Exception e) {
			
			((FriendRequest) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}
}
