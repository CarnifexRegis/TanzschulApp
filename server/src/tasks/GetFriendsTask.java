package tasks;

import java.util.ArrayList;

import model.Model;
import database_utils.Friend;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.GetFriendsRequest;
import response.GetFriendsResponse;


public class GetFriendsTask  extends AbstractHandler {
	public String handle(String httpBody){
		//gets the information from the request
		GetFriendsRequest request = (GetFriendsRequest)parseXML(httpBody,GetFriendsRequest.class);
		int id = request.getId();
		Model m = Model.getInstance();
		String	ec;
		ArrayList<Friend> fl;
		if(m.checkId(id)){
			fl= m.getOpenChats(id);
			
			if (fl == null){
				fl = new ArrayList<Friend>();
				ec = ErrorCode.nf.getError();
				}else{
					ec = ErrorCode.ja.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			fl = new ArrayList<Friend>();
		}
		GetFriendsResponse response = new GetFriendsResponse(ec , fl);
		return buildXML(response);
	}
}
