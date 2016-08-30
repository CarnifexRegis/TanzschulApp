package database2;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@ Root (name = "profiledata")
public class ProfileData {
	@Element (name = "fn")
	String fn;
	@Element (name = "ln")
	String ln;
	@Element (name = "ptext")
	String pText;
	@Element (name = "age")
	int age;
	@Element (name = "hight")
	int hight;
	@Element (name = "phonenumber")
	int phoneNumber;
	@Element (name = "gender")
	boolean gender;
	@Element (name = "pa")
	boolean pa;
	public ProfileData(String fn, String ln, String pText, int age, int hight,
			int phoneNumber, boolean gender, boolean pa) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.pText = pText;
		this.age = age;
		this.hight = hight;
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
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
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
