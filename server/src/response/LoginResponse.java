package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginResponse.
 * @author Simon Stolz
 */
@Root (name = "loginresponse")
public class LoginResponse {

	@Element(name = "id",required = false)
	 private int id;
	@Element (name = "gender",required = false)
	 private int gender;
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
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public int getGender() {
		return gender;
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
