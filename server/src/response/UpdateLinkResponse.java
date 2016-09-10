package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateLinkResponse.
 */
@Root (name  ="updatelinkresponse")
public class UpdateLinkResponse {
	
	/** The ec. */
	@Element (name = "ec")
	String ec;

	/**
	 * Instantiates a new update link response.
	 */
	public UpdateLinkResponse(){
		super();
	}
	
	/**
	 * Instantiates a new update link response.
	 *
	 * @param ec the ErrorCode know  by the client that tells him what to do next
	 */
	public UpdateLinkResponse(String ec) {
		super();
		this.ec = ec;
	}


	/**
	 * Gets the ec.
	 *
	 * @return the ec
	 */
	public String getEc() {
		return ec;
	}
	

}
