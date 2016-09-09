package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "adeleteresponse")
public class ADeleteResponse {
	@Element (name = "ec")
	String ec ;
	
	ADeleteResponse(){
		super();
		}

	public ADeleteResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	
		
	
}
