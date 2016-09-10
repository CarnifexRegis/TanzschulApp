package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
@Root(name = "adeleterequest")
public class ADeleteRequest {

	@Element(name = "aid")
	int aid;

	@Element (name = "kid")
	int kid;

 	ADeleteRequest(){
		 super();
	 }
	 
 	/**
 	 * Instantiates a new a delete request.
 	 *
 	 * @param aid identifer of the Admin
 	 * @param kid id of the object in table KURS that must be deleted
 	 */
	public ADeleteRequest(int aid, int kid) {
		super();
		this.aid = aid;
		this.kid = kid;
	}

	public int getAid() {
		return aid;
	}
	
	public int getKid() {
		return kid;
	}
	 
	

}
