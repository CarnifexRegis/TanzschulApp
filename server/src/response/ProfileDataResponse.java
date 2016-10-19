package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import database_utils.ProfileData;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileDataResponse.
 * @author Simon Stolz
 */
@Root(name =  "profiledataresponse")
public class ProfileDataResponse {

	@Element(name = "profiledata",required = false)
	 private ProfileData pd;

	@Element(name = "ec") 
	 private String ec;
	
	/**
	 * Instantiates a new profile data response.
	 */
	public ProfileDataResponse(){
		super();
	}
	
	/**
	 * Instantiates a new profile data response.
	 *
	 * @param pd ProfileData object extracted from table KURS
	 * @param ec ErrorCode know  by the client that tells him what to do next
	 */
	public ProfileDataResponse(ProfileData pd, String ec) {
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
	
//	String fn;
//	String ln;
//	boolean gender;
//	boolean pa;
//	int age;
//	int phoneNumber;
//	String pText;
//	int hight;
	
	
	
	

}
