package task;

import protocol.Command;
import protocol.ErrorCode;
import request.AddFriendRequest;
import response.AddFriendResponse;
import activitys.ShowProfile;
import android.util.Log;

public class AddFriendTask extends BaseHttpRequestTask{
	private int mid;
	private String fidp;
	public AddFriendTask (ShowProfile sp, int mid,String fidp ) {
		super(sp);
		this.mid=mid;
		this.fidp =fidp;
	}

	public void execute() {
		AddFriendRequest request = new AddFriendRequest(mid, fidp);

		try {
			String xml = buildXML(request);
			super.execute(Command.addfriend, xml);
		} catch (Exception e) {
			((ShowProfile) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
	}

	@Override
	public void onPostExecute(String result) {
		try {
			AddFriendResponse response = (AddFriendResponse) parseXML(result,
					AddFriendResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	
			 	((ShowProfile) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((ShowProfile) activity).requestSended();
			 }
		} catch (Exception e) {
			
			((ShowProfile) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}
}
