package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterResponse.
 */
@Root(name = "registerresponse")
public class RegisterResponse {

/** The ec. */
@Element(name = "ec")
String ec;

/** The id. */
@Element(name = "id",required = false)
int id;

/**
 * Instantiates a new register response.
 */
public RegisterResponse(){
	super ();
}

/**
 * Instantiates a new register response.
 *
 * @param ec the ec
 * @param id the id
 */
public RegisterResponse(String ec, int id) {
	super();
	this.ec = ec;
	this.id = id;
}

/**
 * Gets the error.
 *
 * @return the error
 */
public String getError() {
	return ec;
}

/**
 * Gets the id.
 *
 * @return the id
 */
public int getId() {
	return id;
}

}
