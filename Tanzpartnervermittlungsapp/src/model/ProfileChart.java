package model;

public class ProfileChart {
String fn;
String ln;
String age;
String uhr;
String date;

public ProfileChart(String fn, String ln,int age, String uhr, String date) {
	this.fn = fn;
	this.ln = ln;
	if(age>=0){
	this.age = age + "";
	}else{
		this.age="/";
	}
	this.uhr = uhr;
	this.date = date;
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
public String getAge() {
	return age;
}
public void setAge(String em) {
	this.age = age;
}
public String getUhr() {
	return uhr;
}
public void setUhr(String uhr) {
	this.uhr = uhr;
}
public String getdate() {
	return date;
}
public void setdate(String date) {
	this.date = date;
}

}
