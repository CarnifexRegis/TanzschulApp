package response;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="getallresponse")
public class GetAllResponse {
	
	@Element
	private String message;

	public GetAllResponse() {
		
	}

	public GetAllResponse(String message) {
		super();
		this.message = message;
	}

	public String getText() {
		return message;
	}

}
