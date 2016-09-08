package response;

import model.ProfileData;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;



@Root(name =  "profiledataresponse")
public class ProfileDataResponse {
	@Element(name = "profiledata",required = false)
	ProfileData pd;
	@Element(name = "ec") 
	String ec;
	public ProfileDataResponse(){
		super();
	}
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
