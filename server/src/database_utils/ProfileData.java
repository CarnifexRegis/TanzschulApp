package database_utils;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ProfileData.
 *
 * @author Simon Stolz
 * This class is used to send the full data of an object extracted from table User
 * See GetProfileDataTask/Response, GetForeignProfileRequest/Task , UpdateProfileTask/Request
 */
@ Root (name = "profiledata")
public class ProfileData {
	
	@Element (name = "fn")
	private String fn;
	
	@Element (name = "ln")
	private String ln;

	@Element (name = "ptext")
	private String pText;

	@Element (name = "age")
	int age;

	@Element (name = "height")
	int height;

	@Element (name = "phonenumber")
	private String phoneNumber;

	@Element (name = "gender")
	private boolean gender;

	@Element (name = "pa")
	private boolean pa;
	
	/**
	 * This constructor is used for serializing.
	 */
	public ProfileData(){
		super();
	}
	
	/**
	 * Instantiates a new profile data.
	 *
	 * @param fn first name of the User
	 * @param ln Last Name of the User
	 * @param pText The about me text in the users profile
	 * @param age The users age
	 * @param height The users height
	 * @param phoneNumber the users phone number
	 * @param gender The users gender true for female false for male
	 * @param pa Indicates if the users age is public to other users
	 */
	public ProfileData(String fn, String ln, String pText, int age, int height,
			String phoneNumber, boolean gender, boolean pa) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.pText = pText;
		this.age = age;
		this.height = height;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.pa = pa;
	}
	//public ProfileData(){
		//super();
	/**
	 * Gets the fn.
	 *
	 * @return the fn
	 */
	//}
	public String getFn() {
		return fn;
	}
	
	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getpText() {
		return pText;
	}
	
	public void setpText(String pText) {
		this.pText = pText;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isGender() {
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public boolean isPa() {
		return pa;
	}

	public void setPa(boolean pa) {
		this.pa = pa;
	}
	
}
