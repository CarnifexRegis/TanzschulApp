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
	
	/** The name. */
	@Element (name = "name")
	String name;
	
	/** The key. */
	@Element (name = "key")
	String key;
	
	/**
	 * Instantiates a new a login request.
	 */
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

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getname() {
		return name;
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
