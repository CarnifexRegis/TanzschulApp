package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root (name = "updateprofileresponse")
public class UpdateProfileResponse {
@Element (name = "ec")
String ec;

public UpdateProfileResponse(){
	super ();
}
public UpdateProfileResponse(String ec) {
	super();
	this.ec = ec;
}

public String getErrorCode() {
	return ec;
}

}
