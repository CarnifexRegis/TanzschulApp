package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * 
 * @author Simon Stolz
 *
 */
@Root(name = "aloginrequest")
public class ALoginRequest {
	@Element (name = "name")
	String name;
	@Element (name = "key")
	String key;
	public ALoginRequest(){
		super();
	}
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
