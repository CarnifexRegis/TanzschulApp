package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ADeleteResponse.
 *
 * @author Simon Stolz
 */
@Root (name = "adeleteresponse")
public class ADeleteResponse {
	
	@Element (name = "ec")
	String ec ;
	
	ADeleteResponse(){
		super();
		}

/**
 * Instantiates a new a delete response.
 *
 * @param ec ErrorCode know  by the client that tells him what to do next
 */
	public ADeleteResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	
		
	
}
