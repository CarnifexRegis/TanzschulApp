package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class UpdateProfileResponse.
 */
@Root (name = "updateprofileresponse")
public class UpdateProfileResponse {

/** The ec. */
@Element (name = "ec")
String ec;

/**
 * Instantiates a new update profile response.
 */
public UpdateProfileResponse(){
	super ();
}

/**
 * Instantiates a new update profile response.
 *
 * @param ec the ec
 */
public UpdateProfileResponse(String ec) {
	super();
	this.ec = ec;
}

/**
 * Gets the error code.
 *
 * @return the error code
 */
public String getErrorCode() {
	return ec;
}

}
