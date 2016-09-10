package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginResponse.
 */
@Root (name = "loginresponse")
public class LoginResponse {
	
	/** The id. */
	@Element(name = "id",required = false)
	int id;
	
	/** The gender. */
	@Element (name = "gender",required = false)
	int gender;
	
	/** The ec. */
	@Element (name = "ec",required = false)
	String ec;
	
	/**
	 * Instantiates a new login response.
	 *
	 * @param id the users id
	 * @param gender the users gender
	 * @param ec the ErrorCode know  by the client that tells him what to do next
	 */
	public LoginResponse(int id, int gender,String ec) {
		super();
		this.id = id;
		this.gender = gender;
		this.ec = ec;
	}
	
	public int getId() {
		return id;
	}
	
	public int getGender() {
		return gender;
	}

	public String getEc() {
		return ec;
	}

	
}
