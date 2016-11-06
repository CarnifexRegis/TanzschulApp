package model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 *The profiledata of an USer used in ShowProfile and EditProfile
 * @author Simon Stolz
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
	private int age;

	@Element (name = "height")
	private int height;

	@Element (name = "phonenumber")
	private String phoneNumber;

	@Element (name = "gender")
	private boolean gender;

	@Element (name = "pa")
	private boolean pa;

	public ProfileData(){
		super();
	}
	
	/**
	 * Instantiates a new profile data.
	 *
	 * @param fn the fn
	 * @param ln the ln
	 * @param pText the text
	 * @param age the age
	 * @param height the height
	 * @param phoneNumber the phone number
	 * @param gender the gender
	 * @param pa the pa
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
