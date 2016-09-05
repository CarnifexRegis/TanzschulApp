package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "foreignprofilerequest")
public class ForeignProfileRequest {
	@Element(name = "email" )
	String eMail;
	public ForeignProfileRequest(){
		super();
	}
	public ForeignProfileRequest(String eMail) {
		super();
		this.eMail = eMail;
	}

	public String geteMail() {
		return eMail;
	}
	
}
