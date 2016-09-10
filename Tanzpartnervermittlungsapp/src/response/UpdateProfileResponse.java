package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class UpdateProfileResponse.
 */
@Root (name = "updateprofileresponse")
public class UpdateProfileResponse {

@Element (name = "ec")
String ec;

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

public String getErrorCode() {
	return ec;
}

}
