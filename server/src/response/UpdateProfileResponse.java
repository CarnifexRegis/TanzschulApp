package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root (name = "updateprofileresponse")
public class UpdateProfileResponse {
@Element (name = "errorcode")
String errorCode;

public UpdateProfileResponse(){
	super ();
}
public UpdateProfileResponse(String errorCode) {
	super();
	this.errorCode = errorCode;
}

public String getErrorCode() {
	return errorCode;
}

}
