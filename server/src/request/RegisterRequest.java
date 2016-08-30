package request;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "registerrequest")
public class RegisterRequest {
@Element (name = "firstname")
String fn;
@Element (name = "lastname")
String ln;
@Element(name = "email")
String eMail;
@Element(name = "password")
String password;
@Element(name = "age")
int age;
@Element(name ="gender" )
boolean gender;
@Element (name ="agevisible" )
boolean ageVisible;

public RegisterRequest(){
	super();
}



public RegisterRequest(String fn, String ln, String eMail, String password,
		int age, boolean gender, boolean ageVisible) {
	super();
	this.fn = fn;
	this.ln = ln;
	this.eMail = eMail;
	this.password = password;
	this.age = age;
	this.gender = gender;
	this.ageVisible = ageVisible;
}



public String getFn() {
	return fn;
}

public String getLn() {
	return ln;
}
public String geteMail() {
	return eMail;
}
public String getPassword() {
	return password;
}
public int getAge() {
	return age;
}
public boolean isGender() {
	return gender;
}
public boolean isAgeVisible() {
	return ageVisible;
}

}
