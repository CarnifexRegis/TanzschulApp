package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllRequest.
 */
@Root(name="getallrequest")
public class GetAllRequest {

	/** The id. */
	@Element(name="id")
	int id;

	/**
	 * Instantiates a new gets the all request.
	 *
	 * @param id the id
	 */
	public GetAllRequest(int id) {
		super();
		this.id= id;
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
