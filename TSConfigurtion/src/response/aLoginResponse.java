package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "aloginresponse")
public class aLoginResponse {
	@Element(name = "id",required = false)
	int id;
	
	@Element (name = "ec",required = false)
	String ec;
	public aLoginResponse(){
		super ();
	}
	public aLoginResponse(int id,String ec) {
		super();
		this.id = id;
		
		this.ec = ec;
	}
	public int getId() {
		return id;
	}
	
	public String getEc() {
		return ec;
	}

	
}
