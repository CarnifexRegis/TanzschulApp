package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "addkursresponse")
public class AAddKursResponse {
	@Element (name = "ec")
	private String ec;
	public AAddKursResponse(){
		super();
	}
	public AAddKursResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	

}
