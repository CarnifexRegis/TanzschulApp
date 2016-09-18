package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Requests to update a users image
 * @author Simon Stolz
 *
 */
@Root (name = "updateimagerequest")
public class UpdateImageRequest {
@Element (name = "base64")
	private String base64;
@Element (name = "id")
	private int id;
public UpdateImageRequest(){
	super();
}
public UpdateImageRequest(String base64, int id) {
	super();
	this.base64 = base64;
	this.id = id;
}
public String getBase64() {
	return base64;
}
public int getId() {
	return id;
}

}
