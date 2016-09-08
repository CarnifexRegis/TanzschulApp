package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "foreignprofilerequest")
public class ForeignProfileRequest {
	@Element(name = "email" )
	String eMail;
	@Element (name = "id")
	int id;
	public ForeignProfileRequest(){
		super();
	}
	public ForeignProfileRequest(String eMail, int id) {
		super();
		this.eMail = eMail;
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}
	public int getId() {
		return id;
	}
	
}
