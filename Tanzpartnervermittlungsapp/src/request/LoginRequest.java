package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class LoginRequest.
 *
 * @author Simon Stolz
 */
@Root(name = "loginrequest")
public class LoginRequest {

	@Element (name = "email")
	private String eMail;

	@Element (name = "key")
	private String key;

	public LoginRequest(){
		super();
	}
	
	/**
	 * Instantiates a new login request.
	 *
	 * @param eMail the eMail of the requesting user
	 * @param key the key to access his private id
	 */
	public LoginRequest(String eMail, String key) {
		super();
		this.eMail = eMail;
		this.key = key;
	}

	public String geteMail() {
		return eMail;
	}

	public String getKey() {
		return key;
	}
	
}
