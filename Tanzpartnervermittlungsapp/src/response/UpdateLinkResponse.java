package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name  ="updatelinkresponse")
public class UpdateLinkResponse {
	@Element (name = "error")
	String ec;

	public UpdateLinkResponse(){
		super();
	}
	public UpdateLinkResponse(String ec) {
		super();
		this.ec = ec;
	}


	public String getEc() {
		return ec;
	}
	

}
