package database2;

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
	
	/** The fn. */
	@Element (name = "fn")
	String fn;
	
	/** The ln. */
	@Element (name = "ln")
	String ln;
	
	/** The p text. */
	@Element (name = "ptext")
	String pText;
	
	/** The age. */
	@Element (name = "age")
	int age;
	
	/** The height. */
	@Element (name = "height")
	int height;
	
	/** The phone number. */
	@Element (name = "phonenumber")
	String phoneNumber;
	
	/** The gender. */
	@Element (name = "gender")
	boolean gender;
	
	/** The pa. */
	@Element (name = "pa")
	boolean pa;
	
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
	
	/**
	 * Sets the fn.
	 *
	 * @param fn the new fn
	 */
	public void setFn(String fn) {
		this.fn = fn;
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
	 * Sets the ln.
	 *
	 * @param ln the new ln
	 */
	public void setLn(String ln) {
		this.ln = ln;
	}
	
	/**
	 * Gets the p text.
	 *
	 * @return the p text
	 */
	public String getpText() {
		return pText;
	}
	
	/**
	 * Sets the p text.
	 *
	 * @param pText the new p text
	 */
	public void setpText(String pText) {
		this.pText = pText;
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
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	/**
	 * Checks if is pa.
	 *
	 * @return true, if is pa
	 */
	public boolean isPa() {
		return pa;
	}
	
	/**
	 * Sets the pa.
	 *
	 * @param pa the new pa
	 */
	public void setPa(boolean pa) {
		this.pa = pa;
	}
	
}
