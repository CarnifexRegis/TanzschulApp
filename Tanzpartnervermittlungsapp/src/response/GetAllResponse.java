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

	/**
	 * Instantiates a new gets the all response.
	 */
	public GetAllResponse() {
		super ();
	}

	/**
	 * Instantiates a new gets the all response.
	 *
	 * @param message the message
	 */
	public GetAllResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return message;
	}

}
