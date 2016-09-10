package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class AAddKursResponse.
 */
@Root (name = "addkursresponse")
public class AAddKursResponse {
	
	/** The ec. */
	@Element (name = "ec")
	private String ec;
	
	/**
	 * Instantiates a new a add kurs response.
	 */
	public AAddKursResponse(){
		super();
	}
	
	/**
	 * Instantiates a new a add kurs response.
	 *
	 * @param ec the ec
	 */
	public AAddKursResponse(String ec) {
		super();
		this.ec = ec;
	}

	/**
	 * Gets the ec.
	 *
	 * @return the ec
	 */
	public String getEc() {
		return ec;
	}
	

}
