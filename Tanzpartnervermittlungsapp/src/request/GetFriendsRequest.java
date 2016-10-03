package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name ="getfrequest")
public class GetFriendsRequest {
	@Element (name = "id")
	private int id;
	public GetFriendsRequest(){
		super();
	}
	public GetFriendsRequest(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
