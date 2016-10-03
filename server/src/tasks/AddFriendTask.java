package tasks;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.AddFriendRequest;
import response.AddFriendResponse;

/**
 *  Adds a Friend and builts a response informing about the processes success
 * @author Simon Stolz
 *
 */
public class AddFriendTask extends AbstractHandler{
	public String handle(String httpBody){
		//gets the information from the request
		AddFriendRequest request = (AddFriendRequest)parseXML(httpBody,AddFriendRequest.class);
		int mid = request.getMid();
		String fidp = request.getFidp();
		Model m = Model.getInstance();
		String	ec;
		
		if(m.checkId(mid)){
			try{
			if (m.addFriend(mid, fidp)){
				ec = ErrorCode.ja.getError();
				
				}else{
				ec = ErrorCode.ae.getError();
				}
			}catch(Exception e){
				ec = ErrorCode.nf.getError();
			}
		}else{
			ec  = ErrorCode.wl.getError();
		}
		
		AddFriendResponse response = new AddFriendResponse(ec );
		return buildXML(response);
	}

}
