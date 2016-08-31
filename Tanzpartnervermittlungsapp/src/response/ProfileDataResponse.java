package response;

import model.ProfileData;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name =  "profiledataresponse")
public class ProfileDataResponse {
	@Element(name = "profiledata")
	ProfileData pd;
	@Element(name = "errorcode") 
	String errorCode;
	public ProfileDataResponse(){
		super();
	}
	public ProfileDataResponse(ProfileData pd, String errorCode) {
		super();
		this.pd = pd;
		this.errorCode = errorCode;
	}
	public ProfileData getPd() {
		return pd;
	}
	public String getErrorCode() {
		return errorCode;
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
