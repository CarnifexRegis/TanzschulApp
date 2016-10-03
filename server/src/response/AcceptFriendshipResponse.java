package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "accepfriendshipresponse")
public class AcceptFriendshipResponse {
	@Element(name = "ec")
	private String ec;

	public AcceptFriendshipResponse(){
		super();
	}
	public AcceptFriendshipResponse(String ec) {
		super();
		this.ec = ec;
	}


	public String getEc() {
		return ec;
	}

	

}
