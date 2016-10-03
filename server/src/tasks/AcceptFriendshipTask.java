package tasks;

import java.util.ArrayList;

import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.AcceptFriendshipRequest;
import response.AcceptFriendshipResponse;
/**
 * This class sets the Attribute in several friendrequest as accepted and builts a response that tells if it was successful
 * @author Simon Stolz
 *
 */
public class AcceptFriendshipTask extends AbstractHandler{
	public String handle(String httpBody){
		//gets the information from the request
		AcceptFriendshipRequest request = (AcceptFriendshipRequest)parseXML(httpBody,AcceptFriendshipRequest.class);
		int id = request.getId();
		ArrayList<Integer> idpl = request.getIdpl();
		Model m = Model.getInstance();
		String	ec;
		
		if(m.checkId(id)){
			if (m.acceptFriendrequest( idpl, id)){
				ec = ErrorCode.ja.getError();
				
				}else{
				ec = ErrorCode.nf.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			
		}
		AcceptFriendshipResponse response = new AcceptFriendshipResponse(ec );
		return buildXML(response);
	}
}
