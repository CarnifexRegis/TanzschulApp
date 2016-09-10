package model;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ProfileChart.
 */
@Root(name = "profilechart")
public class ProfileChart {

	@Element (name= "fn" )
String fn;

	@Element (name= "ln" )
String ln;

	@Element(name= "age" )
String age; 

	@Element(name= "uhr" )
String uhr; 

	@Element(name= "date" )
String date;

	@Element(name= "idp" )
String idp;

	public ProfileChart(){
		super();
	}

/**
 * Instantiates a new profile chart.
 *
 * @param fn the fn
 * @param ln the ln
 * @param age the age
 * @param uhr the uhr
 * @param date the date
 * @param idp the idp
 */
public ProfileChart(String fn, String ln, String age, String uhr,String date, String idp) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.age = age;
		this.uhr = uhr;
		this.date = date;
		this.idp = idp;
	}

/**
 * Instantiates a new profile chart.
 *
 * @param fn the fn
 * @param ln the ln
 * @param age the age
 * @param uhr the uhr
 * @param date the date
 * @param idp the idp
 */
public ProfileChart(String fn, String ln,int age, String uhr, String date,String idp) {
	this.fn = fn;
	this.ln = ln;
	if(age>=0){
	this.age = age + "";
	}else{
		this.age="/";
	}
	this.uhr = uhr;
	this.date = date;
	this.idp= idp;
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

public void setAge(String age) {
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

public String getIdp() {
	return idp;
}

public void setIdp(String idp) {
	this.idp = idp;
}

}
