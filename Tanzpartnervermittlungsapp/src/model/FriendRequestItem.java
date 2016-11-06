package model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Contains the Information of an FriendRequest Item in the Listview of the FriendRequest Activity
 * @author Simon Stolz
 *
 */
@Root (name = "friendrequest")
public class FriendRequestItem {
	@Element (name = "idp")
	private int idp;
	@Element (name = "fn")
	private String fn;
	@Element (name = "ln")
	private String ln;
	public FriendRequestItem(){
		super();
	}
	public FriendRequestItem(int idp, String fn, String ln) {
		super();
		this.idp = idp;
		this.fn = fn;
		this.ln = ln;
	}
	public int getIdp() {
		return idp;
	}
	public String getFn() {
		return fn;
	}
	public String getLn() {
		return ln;
	}

}
