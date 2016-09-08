package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "loginresponse")
public class LoginResponse {
	@Element(name = "id",required = false)
	int id;
	@Element (name = "gender",required = false)
	int gender;
	@Element (name = "ec",required = false)
	String ec;
	public LoginResponse(int id, int gender,String ec) {
		super();
		this.id = id;
		this.gender = gender;
		this.ec = ec;
	}
	public int getId() {
		return id;
	}
	public int getGender() {
		return gender;
	}
	public String getEc() {
		return ec;
	}

	
}
