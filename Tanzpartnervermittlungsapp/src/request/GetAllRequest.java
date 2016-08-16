package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="getallrequest")
public class GetAllRequest {

	@Element(name="id")
	int id;

	public GetAllRequest(int id) {
		super();
		this.id= id;
	}

	public int getId() {
		return id;
	}

	
	
}
