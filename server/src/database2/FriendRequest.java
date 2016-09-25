package database2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * The Information the users can access about an friend request
 * @author Simon Stolz
 *
 */
@Root(name = "friendrequest")
public class FriendRequest {
	@Element(name = "pid")
	private int pid;
	@Element (name = "n")
	private String name;
	public int getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
	public FriendRequest(){
		super();
	}
	/**
	 * 
	 * @param pid the public id of the requesting user
	 * @param name the requesting users name
	 */
	public FriendRequest(int pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}

}
