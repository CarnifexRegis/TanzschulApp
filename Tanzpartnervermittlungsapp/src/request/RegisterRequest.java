package request;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
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
// TODO use Profile Data instead

/**
 * Instantiates a new register request.
 *
 * @param fn first name of the user
 * @param ln last name of the user
 * @param eMail e-mail of the user
 * @param password key of the  user
 * @param age age of the user
 * @param gender gender of the user true for female false for male
 * @param ageVisible state s if the age of the user is public
 */

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
