package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "sendmessageresponse")
public class SendMessageResponse {
	@Element(name =  "ec")
	private String ec;
	public SendMessageResponse(){
		super();
	}
	public SendMessageResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	
}
