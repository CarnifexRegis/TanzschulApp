package response;

import org.simpleframework.xml.Element;

import database2.ProfileData;
// TODO: Auto-generated Javadoc

/**
 * The Class ForeignProfileResponse.
 *
 * @author Simon Stolz
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
	 * @param pd ProfileData object extracted from tbale USER
	 * @param ec ErrorCode know  by the client that tells him what to do next
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
