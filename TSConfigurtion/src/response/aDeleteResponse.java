package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "adeleteresponse")
public class aDeleteResponse {
	@Element (name = "ec")
	String ec ;
	
	aDeleteResponse(){
		super();
		}

	public aDeleteResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	
		
	
}
