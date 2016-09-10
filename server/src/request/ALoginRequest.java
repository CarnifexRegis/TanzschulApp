package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc


/**
 * The Class ALoginRequest.
 *
 * @author Simon Stolz
 */
@Root(name = "aloginrequest")
public class ALoginRequest {

	@Element (name = "name")
	private String name;

	@Element (name = "key")
	private String key;

	public ALoginRequest(){
		super();
	}
	
	/**
	 * Instantiates a new a login request.
	 *
	 * @param name admin name
	 * @param key admin key
	 */
	public ALoginRequest(String name, String key) {
		super();
		this.name = name;
		this.key = key;
	}

	public String getname() {
		return name;
	}

	public String getKey() {
		return key;
	}
	
}
