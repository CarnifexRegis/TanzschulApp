package response;

import model.ProfileData;

import org.simpleframework.xml.Element;



public class ForeignProfileResponse {
	@Element(name = "profiledata",required = false)
	ProfileData pd;
	@Element(name = "ec") 
	String ec;
	public ForeignProfileResponse(){
		super();
	}
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
