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
	 */
	public LoginResponse(){
		super ();
	}
	
	/**
	 * Instantiates a new login response.
	 *
	 * @param id the id
	 * @param gender the gender
	 * @param ec the ec
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
