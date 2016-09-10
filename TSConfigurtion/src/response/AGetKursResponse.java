package response;

import java.util.ArrayList;




import model.aKurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



// TODO: Auto-generated Javadoc
/**
 * The Class AGetKursResponse.
 */
@Root (name = "getkursresponse")
public class AGetKursResponse {
	
	/** The ec. */
	@Element (name = "error")
	String ec;
	
	/** The kl. */
	@ElementList(name = "kurslist",required = false)
	ArrayList<aKurs> kl;
	
	/**
	 * Instantiates a new a get kurs response.
	 */
	public AGetKursResponse(){
		super();}
	
	/**
	 * Instantiates a new a get kurs response.
	 *
	 * @param ec the ec
	 * @param kl the kl
	 */
	public AGetKursResponse(String ec, ArrayList<aKurs> kl) {
		super();
		this.ec = ec;
		this.kl = kl;
	}
	
	/**
	 * Gets the ec.
	 *
	 * @return the ec
	 */
	public String getEc() {
		return ec;
	}
	
	/**
	 * Gets the kl.
	 *
	 * @return the kl
	 */
	public ArrayList<aKurs> getKl() {
		return kl;
	}

}
