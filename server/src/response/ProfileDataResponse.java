package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import database2.ProfileData;

@Root(name =  "profiledataresponse")
public class ProfileDataResponse {
	@Element(name = "profiledata")
	ProfileData pd;
	@Element(name = "errorcode") 
	String ErrorCode;
	public ProfileDataResponse(){
		super();
	}
	public ProfileDataResponse(ProfileData pd, String errorCode) {
		super();
		this.pd = pd;
		ErrorCode = errorCode;
	}
	public ProfileData getPd() {
		return pd;
	}
	public String getErrorCode() {
		return ErrorCode;
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
