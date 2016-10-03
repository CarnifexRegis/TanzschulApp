package task;

import protocol.Command;
import protocol.ErrorCode;
import request.GetFriendsRequest;
import response.GetFriendsResponse;
import activitys.Friends;
import android.util.Log;
/**
 * Gets the List of all Friends (also pending ones)
 * @author Simon Stolz
 *
 */
public class GetFriendsTask extends BaseHttpRequestTask{
private int id;
	
	/**
	 * 
	 * @param f
	 * @param id
	 */
	public GetFriendsTask(Friends f, int id) {
		super(f);
		this.id=id;
	}

	public void execute() {
		GetFriendsRequest request = new GetFriendsRequest(id);

		try {
			String xml = buildXML(request);
			super.execute(Command.getfriends, xml);
		} catch (Exception e) {
			
			((Friends) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
	}
	@Override
	public void onPostExecute(String result) {
		try {
			GetFriendsResponse response = (GetFriendsResponse) parseXML(result,
					GetFriendsResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	
			 	((Friends) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((Friends) activity).recieveFriends(response.getFlist());
			 }
		} catch (Exception e) {
			
			((Friends) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}
}
