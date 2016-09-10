package response;

import java.util.ArrayList;

import model.Kurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



// TODO: Auto-generated Javadoc
/**
 * The Class GetKursResponse.
 */
@Root (name = "getkursresponse")
public class GetKursResponse {
	
	/** The ec. */
	@Element (name = "error")
	String ec;
	
	/** The kl. */
	@ElementList(name = "kurslist",required = false)
	ArrayList<Kurs> kl;
	
	/**
	 * Instantiates a new gets the kurs response.
	 */
	public GetKursResponse(){
		super();}
	
	/**
	 * Instantiates a new gets the kurs response.
	 *
	 * @param ec the ec
	 * @param kl the kl
	 */
	public GetKursResponse(String ec, ArrayList<Kurs> kl) {
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
	public ArrayList<Kurs> getKl() {
		return kl;
	}

}
