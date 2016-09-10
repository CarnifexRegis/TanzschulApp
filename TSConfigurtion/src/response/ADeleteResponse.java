package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class ADeleteResponse.
 */
@Root (name = "adeleteresponse")
public class ADeleteResponse {
	
	/** The ec. */
	@Element (name = "ec")
	String ec ;
	
	/**
	 * Instantiates a new a delete response.
	 */
	ADeleteResponse(){
		super();
		}

	/**
	 * Instantiates a new a delete response.
	 *
	 * @param ec the ec
	 */
	public ADeleteResponse(String ec) {
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
