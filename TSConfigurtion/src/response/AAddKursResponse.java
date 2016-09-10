package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 *
 * @author Simon Stolz
 */
@Root (name = "addkursresponse")
public class AAddKursResponse {

	@Element (name = "ec")
	private String ec;

	public AAddKursResponse(){
		super();
	}
	
	/**
	 * Instantiates a new a add kurs response.
	 *
	 * @param ec ErrorCode know  by the client that tells him what to do next
	 */
	public AAddKursResponse(String ec) {
		super();
		this.ec = ec;
	}

	public String getEc() {
		return ec;
	}
	

}
