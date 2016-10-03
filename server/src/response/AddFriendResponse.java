package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "addfriendresponse")
public class AddFriendResponse {
	@Element (name = "ec")
	String ec;
	public AddFriendResponse(){
		super();
	}
	public AddFriendResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	
}
