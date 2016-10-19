package tasks;

import java.util.ArrayList;

import database_utils.FriendRequestItem;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.GetFriendRequestsRequest;
import response.GetFriendRequestsResponse;

public class GetFriendRequestsTask extends AbstractHandler{
	public String handle(String httpBody){
		//gets the information from the request
		GetFriendRequestsRequest request = (GetFriendRequestsRequest)parseXML(httpBody,GetFriendRequestsRequest.class);
		int id = request.getId();
		
		Model m = Model.getInstance();
		String	ec;
		ArrayList<FriendRequestItem> fri;
		if(m.checkId(id)){
			 fri = m.getFriendrequests(id);
			if (fri != null){
				ec = ErrorCode.ja.getError();
				
				}else{
				ec = ErrorCode.nf.getError();
				fri = new ArrayList<FriendRequestItem>();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			fri = new ArrayList<FriendRequestItem>();
		}
		GetFriendRequestsResponse response = new GetFriendRequestsResponse(fri, ec);
		return buildXML(response);
	}
}
