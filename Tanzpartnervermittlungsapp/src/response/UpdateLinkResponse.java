package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
@Root (name  ="updatelinkresponse")
public class UpdateLinkResponse {

	@Element (name = "ec")
	private String ec;

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

	public String getEc() {
		return ec;
	}
	

}
