package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * 
 * @author Simon Stolz
 *
 */
@Root(name = "registerresponse")
public class RegisterResponse {

@Element(name = "ec")
String ec;

@Element(name = "id",required = false)
int id;

public RegisterResponse(){}

/**
 * Instantiates a new register response.
 *
 * @param ec ErrorCode know  by the client that tells him what to do next
 * @param id users id
 */
public RegisterResponse(String ec, int id) {
	super();
	this.ec = ec;
	this.id = id;
}

public String getError() {
	return ec;
}

public int getId() {
	return id;
}

}
