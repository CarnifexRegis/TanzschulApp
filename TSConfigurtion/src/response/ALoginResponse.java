package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class ALoginResponse.
 */
@Root (name = "aloginresponse")
public class ALoginResponse {
	
	/** The id. */
	@Element(name = "id",required = false)
	int id;
	
	/** The ec. */
	@Element (name = "ec")
	String ec;
	
	/**
	 * Instantiates a new a login response.
	 */
	public ALoginResponse(){
		super ();
	}
	
	/**
	 * Instantiates a new a login response.
	 *
	 * @param id the id
	 * @param ec the ec
	 */
	public ALoginResponse(int id,String ec) {
		super();
		this.id = id;
		
		this.ec = ec;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
