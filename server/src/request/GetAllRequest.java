package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * not important will be deleted in beta ^^.
 *
 * @author Simon Stolz, Martin Pabst
 * Sources: http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 * 			Abi Quiz-App by Tim Möschel
 */
@Root(name="getallrequest")
public class GetAllRequest {

	@Element(name="id")
	int id;

//	public GetAllRequest(int id) {
//		super();
//		this.id= id;
//	}

public int getId() {
		return id;
	}

	
	
}
