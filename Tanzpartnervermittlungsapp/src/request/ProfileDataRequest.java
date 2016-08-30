package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name= "profiledatarequest")
public class ProfileDataRequest {
	@Element (name = "id")
	int id;
	
	
	
	public ProfileDataRequest() {
		super();	
	}

	public ProfileDataRequest(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}
	
	

}
