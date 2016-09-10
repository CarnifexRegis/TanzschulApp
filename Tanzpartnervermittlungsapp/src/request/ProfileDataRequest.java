package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * 
 * @author Simon Stolz
 */
@Root (name= "profiledatarequest")
public class ProfileDataRequest {

	@Element (name = "id")
	private int id;
	
	
	
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

	public int getId() {
		return id;
	}
	
	

}
