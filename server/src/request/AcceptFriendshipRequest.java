package request;

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "accceptfriendshiprequest")
/**
 * Requests to accept aLind of friendrequests
 * @author Simon Stolz
 *
 */
public class AcceptFriendshipRequest {
	@Element (name = "id")
	private int id;
	@ElementList(name = "idplist")
	ArrayList<Integer> idpl;
	public AcceptFriendshipRequest(){
		super();
	}
	public AcceptFriendshipRequest(int id, ArrayList<Integer> idpl) {
		super();
		this.id = id;
		this.idpl = idpl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Integer> getIdpl() {
		return idpl;
	}
	public void setIdpl(ArrayList<Integer> idpl) {
		this.idpl = idpl;
	}
	
}
