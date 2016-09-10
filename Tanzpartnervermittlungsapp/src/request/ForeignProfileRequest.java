package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class ForeignProfileRequest.
 */
@Root(name = "foreignprofilerequest")
public class ForeignProfileRequest {
	
	/** The idp. */
	@Element(name = "idp" )
	String idp;
	
	/** The id. */
	@Element (name = "id")
	int id;
	
	/**
	 * Instantiates a new foreign profile request.
	 */
	public ForeignProfileRequest(){
		super();
	}
	
	/**
	 * Instantiates a new foreign profile request.
	 *
	 * @param idp the public id of the requested users data
	 * @param id the private id of the requesting User
	 */
	public ForeignProfileRequest(String idp, int id) {
		super();
		this.idp = idp;
		this.id = id;
	}

	/**
	 * Gets the idp.
	 *
	 * @return the idp
	 */
	public String getIdp() {
		return idp;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
