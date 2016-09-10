package response;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllResponse.
 */
@Root(name="getallresponse")
public class GetAllResponse {
	
	/** The message. */
	@Element(name = "message")
	private String message;

	public GetAllResponse() {
		super ();
	}

	public GetAllResponse(String message) {
		super();
		this.message = message;
	}

	public String getText() {
		return message;
	}

}
