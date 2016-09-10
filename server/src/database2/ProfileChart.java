package database2;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class ProfileChart.
 */
@Root(name = "profilechart")
/**
 * This class is used to deliver data to the client see  GetProfilChartsTask/Response
 * 
 * @author Simon Stolz
 *
 */
public class ProfileChart {
	
	/** The fn. */
	@Element (name= "fn" )
String fn;
	
	/** The ln. */
	@Element (name= "ln" )
String ln;
	
	/** The age. */
	@Element(name= "age" )
String age; 
	
	/** The uhr. */
	@Element(name= "uhr" )
String uhr; 
	
	/** The date. */
	@Element(name= "date" )
String date;
	
	/** The idp. */
	@Element(name= "idp" )
String idp;
	
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

/**
 * Gets the fn.
 *
 * @return the fn
 */
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
 * Gets the age.
 *
 * @return the age
 */
public String getAge() {
	return age;
}

/**
 * Sets the age.
 *
 * @param age the new age
 */
public void setAge(String age) {
	this.age = age;
}

/**
 * Gets the uhr.
 *
 * @return the uhr
 */
public String getUhr() {
	return uhr;
}

/**
 * Sets the uhr.
 *
 * @param uhr the new uhr
 */
public void setUhr(String uhr) {
	this.uhr = uhr;
}

/**
 * Gets the date.
 *
 * @return the date
 */
public String getdate() {
	return date;
}

/**
 * Sets the date.
 *
 * @param date the new date
 */
public void setdate(String date) {
	this.date = date;
}

/**
 * Gets the idp.
 *
 * @return the idp
 */
public String getIdp() {
	return idp;
}

/**
 * Sets the idp.
 *
 * @param idp the new idp
 */
public void setIdp(String idp) {
	this.idp = idp;
}

}
