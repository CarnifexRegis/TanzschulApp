package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "updateimageresponse")
public class UpdateImageResponse {
@Element (name = "ec")
private String ec;

public UpdateImageResponse(){
	super();
}
public UpdateImageResponse(String ec) {
	super();
	this.ec = ec;
}

public String getEc() {
	return ec;
}

}
