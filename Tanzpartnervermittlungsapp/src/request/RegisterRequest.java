package request;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class RegisterRequest.
 */
@Root(name = "registerrequest")
public class RegisterRequest {

/** The fn. */
@Element (name = "firstname")
String fn;

/** The ln. */
@Element (name = "lastname")
String ln;

/** The e mail. */
@Element(name = "email")
String eMail;

/** The password. */
@Element(name = "password")
String password;

/** The age. */
@Element(name = "age")
int age;

/** The gender. */
@Element(name ="gender" )
boolean gender;

/** The age visible. */
@Element (name ="agevisible" )
boolean ageVisible;

/**
 * Instantiates a new register request.
 */
public RegisterRequest(){
	super();
}



/**
 * Instantiates a new register request.
 *
 * @param fn the fn
 * @param ln the ln
 * @param eMail the e mail
 * @param password the password
 * @param age the age
 * @param gender the gender
 * @param ageVisible the age visible
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



/**
 * Gets the fn.
 *
 * @return the fn
 */
public String getFn() {
	return fn;
}

/**
 * Gets the ln.
 *
 * @return the ln
 */
public String getLn() {
	return ln;
}

/**
 * Gets the e mail.
 *
 * @return the e mail
 */
public String geteMail() {
	return eMail;
}

/**
 * Gets the password.
 *
 * @return the password
 */
public String getPassword() {
	return password;
}

/**
 * Gets the age.
 *
 * @return the age
 */
public int getAge() {
	return age;
}

/**
 * Checks if is gender.
 *
 * @return true, if is gender
 */
public boolean isGender() {
	return gender;
}

/**
 * Checks if is age visible.
 *
 * @return true, if is age visible
 */
public boolean isAgeVisible() {
	return ageVisible;
}

}
