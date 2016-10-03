package response;

import java.util.ArrayList;

import model.Friend;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "getfresponse")
public class GetFriendsResponse {
	@Element (name = "ec")
	String ec;
	@ElementList(name= "friendlist" )
	ArrayList<Friend> flist;
	
	public GetFriendsResponse(){
		super();
	}
	public GetFriendsResponse(String ec, ArrayList<Friend> flist) {
		super();
		this.ec = ec;
		this.flist = flist;
	}
	public String getEc() {
		return ec;
	}
	public ArrayList<Friend> getFlist() {
		return flist;
	}
	
}
