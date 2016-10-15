package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Requests to add a new friend request between two specific users
 * @author Simon Stolz
 *
 */
@Root(name = "addfriendrequest")
public class AddFriendRequest {
	@Element(name = "myid")
	private int mid;
	@Element(name = "foreignidp")
	private String fidp;
	
	public AddFriendRequest(){
		super();
	}
	public AddFriendRequest(int mid, String fidp) {
		super();
		this.mid = mid;
		this.fidp = fidp;
	}
	public int getMid() {
		return mid;
	}
	public String getFidp() {
		return fidp;
	}
	
}
