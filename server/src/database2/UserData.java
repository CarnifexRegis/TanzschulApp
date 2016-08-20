package database2;

public class UserData {
String eMail;
String fn;
String ln;
boolean gender; // true is female false is male; 0=False  1=True -> fm =1 m = 0
boolean publicAge;
int age;
public UserData(){
	super();
}
public UserData(String eMail,String fn, String ln, int g,int pa,int age){
	this.eMail= eMail;
	this.fn = fn;
	this.ln = ln;
	if (g ==0){
		
		gender= false; // der Nuter ist Männlich
		
	}
	else{
		if(g == 1){
			gender = true; // der Nutzer ist Weiblich
		}else{
			System.out.println("Some error occured calculating your gender :D");
		}
	}
	this.age = age;
	
	if (pa ==0){
		
		publicAge = false; // the Users Age is not public
		
	}
	else{
		if(pa == 1){
			publicAge = true; // the Users Age is Public
		}else{
			System.out.println("Something went wrong calculating your age policy");
		}
	}
}
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
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
public boolean isGender() {
	return gender;
}
public void setGender(boolean gender) {
	this.gender = gender;
}
public boolean isPublicAge() {
	return publicAge;
}
public void setPublicAge(boolean publicAge) {
	this.publicAge = publicAge;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
