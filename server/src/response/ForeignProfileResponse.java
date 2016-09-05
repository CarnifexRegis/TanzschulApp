package response;

import org.simpleframework.xml.Element;

import database2.ProfileData;

public class ForeignProfileResponse {
	@Element(name = "profiledata")
	ProfileData pd;
	@Element(name = "errorcode") 
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
