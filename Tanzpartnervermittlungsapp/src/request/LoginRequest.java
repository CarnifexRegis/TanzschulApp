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
	
	/** The e mail. */
	@Element (name = "email")
	String eMail;
	
	/** The key. */
	@Element (name = "key")
	String key;
	
	/**
	 * Instantiates a new login request.
	 */
	public LoginRequest(){
		super();
	}
	
	/**
	 * Instantiates a new login request.
	 *
	 * @param eMail the e mail
	 * @param key the key
	 */
	public LoginRequest(String eMail, String key) {
		super();
		this.eMail = eMail;
		this.key = key;
	}

	/**
	 * Gets the e mail.
	 *
	 * @return the e mail
	 */
	public String geteMail() {
		return eMail;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
}
