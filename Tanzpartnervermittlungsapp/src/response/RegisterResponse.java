package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "registerresponse")
public class RegisterResponse {
@Element(name = "ec")
String ec;
@Element(name = "id",required = false)
int id;

public RegisterResponse(){
	super ();
}
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
