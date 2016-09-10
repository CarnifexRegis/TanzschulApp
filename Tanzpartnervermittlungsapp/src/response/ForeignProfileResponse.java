package response;

import model.ProfileData;

import org.simpleframework.xml.Element;


// TODO: Auto-generated Javadoc

/**
 * The Class ForeignProfileResponse.
 *
 * @author Simon Stolz
 */
public class ForeignProfileResponse {

	@Element(name = "profiledata",required = false)
	ProfileData pd;

	@Element(name = "ec") 
	String ec;

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
	
	public ProfileData getPd() {
		return pd;
	}

	public String getErrorCode() {
		return ec;
	}
}
