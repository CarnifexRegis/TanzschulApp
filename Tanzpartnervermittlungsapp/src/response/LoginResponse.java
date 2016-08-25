package response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "loginresponse")
public class LoginResponse {
	@Element(name = "id")
	int id;
	@Element (name = "gender")
	int gender;
	public LoginResponse() {
		super();
	}
	public LoginResponse(int id, int gender) {
		super();
		this.id = id;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public int getGender() {
		return gender;
	}

	
}
