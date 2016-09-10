package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class ADeleteRequest.
 */
@Root(name = "adeleterequest")
public class ADeleteRequest {
	
	/** The aid. */
	@Element(name = "aid")
	int aid;
	
	/** The kid. */
	@Element (name = "kid")
	int kid;
	 
 	/**
 	 * Instantiates a new a delete request.
 	 */
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

	/**
	 * Gets the aid.
	 *
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}
	
	/**
	 * Gets the kid.
	 *
	 * @return the kid
	 */
	public int getKid() {
		return kid;
	}
	 
	

}
