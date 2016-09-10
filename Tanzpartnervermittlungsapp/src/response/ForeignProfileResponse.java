package response;

import model.ProfileData;

import org.simpleframework.xml.Element;



// TODO: Auto-generated Javadoc
/**
 * The Class ForeignProfileResponse.
 */
public class ForeignProfileResponse {
	
	/** The pd. */
	@Element(name = "profiledata",required = false)
	ProfileData pd;
	
	/** The ec. */
	@Element(name = "ec") 
	String ec;
	
	/**
	 * Instantiates a new foreign profile response.
	 */
	public ForeignProfileResponse(){
		super();
	}
	
	/**
	 * Instantiates a new foreign profile response.
	 *
	 * @param pd the pd
	 * @param ec the ec
	 */
	public ForeignProfileResponse(ProfileData pd, String ec) {
		super();
		this.pd = pd;
		this.ec = ec;
	}
	
	/**
	 * Gets the pd.
	 *
	 * @return the pd
	 */
	public ProfileData getPd() {
		return pd;
	}
	
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return ec;
	}
}
