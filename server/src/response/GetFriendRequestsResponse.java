package response;

import java.util.ArrayList;




import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.FriendRequestItem;

@Root(name = "getfrresponse")
public class GetFriendRequestsResponse {
	@ElementList(name = "frl")
	ArrayList<FriendRequestItem> frl;
	@Element (name = "ec")
	String ec;
	public GetFriendRequestsResponse(){
		super();
	}
	public GetFriendRequestsResponse(ArrayList<FriendRequestItem> frl, String ec) {
		super();
		this.frl = frl;
		this.ec = ec;
	}
	public ArrayList<FriendRequestItem> getFrl() {
		return frl;
	}
	public String getEc() {
		return ec;
	}
	
}
