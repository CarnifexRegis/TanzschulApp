package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "registerresponse")
public class RegisterResponse {
@Element
String error;
@Element
int id;

public RegisterResponse(){}
public RegisterResponse(String error, int id) {
	super();
	this.error = error;
	this.id = id;
}
public String getError() {
	return error;
}
public int getId() {
	return id;
}

}
