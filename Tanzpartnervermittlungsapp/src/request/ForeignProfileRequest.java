package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ForeignProfileRequest.
 *
 * @author Simon Stolz
 */
@Root(name = "foreignprofilerequest")
public class ForeignProfileRequest {
	

	@Element(name = "idp" )
	private String idp;

	@Element (name = "id")
	private int id;
	
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

	public String getIdp() {
		return idp;
	}
	
	public int getId() {
		return id;
	}
	
}
