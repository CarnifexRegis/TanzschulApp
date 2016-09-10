package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ProfileDataRequest.
 *
 * @author Simon Stolz
 */
@Root (name= "profiledatarequest")
public class ProfileDataRequest {
	
	/** The id. */
	@Element (name = "id")
	int id;
	
	
	
	/**
	 * Instantiates a new profile data request.
	 */
	public ProfileDataRequest() {
		super();	
	}

	/**
	 * Instantiates a new profile data request.
	 *
	 * @param id  id of the User
	 */
	public ProfileDataRequest(int id) {
		super();
		this.id = id;
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	

}
