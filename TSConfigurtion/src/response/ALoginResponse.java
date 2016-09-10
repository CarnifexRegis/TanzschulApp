package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ALoginResponse.
 *
 * @author Simon Stolz
 */
@Root (name = "aloginresponse")
public class ALoginResponse {

	@Element(name = "id",required = false)
	private int id;

	@Element (name = "ec")
	private String ec;

	public ALoginResponse(){
		super ();
	}
	
	/**
	 * Instantiates a new a login response.
	 *
	 * @param id id of the requesting user
	 * @param ec ErrorCode know  by the client that tells him what to do next
	 */
	public ALoginResponse(int id,String ec) {
		super();
		this.id = id;
		
		this.ec = ec;
	}

	public int getId() {
		return id;
	}

	public String getEc() {
		return ec;
	}

	
}
