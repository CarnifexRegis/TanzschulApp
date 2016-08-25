package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * 
 * @author Simon Stolz
 *
 */
@Root(name = "loginrequest")
public class LoginRequest {
	@Element (name = "email")
	String eMail;
	@Element (name = "key")
	String key;
	public LoginRequest(){
		super();
	}
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
