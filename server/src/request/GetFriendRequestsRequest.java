package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "getfrrequest")
/**
 * Requests a list of all pending friendrequests submitted to the requesting user
 * @author Simon Stolz
 *
 */
public class GetFriendRequestsRequest {
	@Element(name = "myid")
	private int id;

	public GetFriendRequestsRequest(){
		super();
	}
	public GetFriendRequestsRequest(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	

}
