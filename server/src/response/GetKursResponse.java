package response;

import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.Kurs;

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
	 * @param ec ErrorCode know  by the client that tells him what to do next
	 * @param kl List of Kurs Object extracted from table KURS
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
