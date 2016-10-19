package database_utils;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ProfileChart.
 * @author Simon Stolz
 */
@Root(name = "profilechart")
/**
 * This class is used to deliver data to the client see  GetProfilChartsTask/Response
 * 
 * @author Simon Stolz
 *
 */
public class ProfileChart {

	@Element (name= "fn" )
	private String fn;

	@Element (name= "ln" )
	private String ln;

	@Element(name= "age" )
	private String age; 

	@Element(name= "uhr" )
	private String uhr; 

	@Element(name= "date" )
	private String date;

	@Element(name= "idp" )
	private String idp;
	
	/**
	 * used for serializing.
	 */
	public ProfileChart(){
		super();
	}
	
	/**
	 * Instantiates a new profile chart.
	 *
	 * @param fn first name of the User
	 * @param ln last Name of the User
	 * @param age users age
	 * @param uhr the time the dancing lesson starts
	 * @param date the date the first dancing lesson takes place
	 * @param idp the public identifier of an object extracted from the USER table
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
 * @param fn first name of the User
 * @param ln last Name of the User
 * @param age users age
 * @param uhr the time the dancing lesson starts
 * @param date the date the first dancing lesson takes place
 * @param idp the public identifier of an object extracted from the USER table
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
