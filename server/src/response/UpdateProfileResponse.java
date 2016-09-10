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
 * @param ec ErrorCode know  by the client that tells him what to do next
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
