package response;

import java.util.ArrayList;







import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.aKurs;

// TODO: Auto-generated Javadoc
/**
 * The Class AGetKursResponse.
 *
 * @author Simon Stolz
 */

@Root (name = "getkursresponse")
public class AGetKursResponse {

	@Element (name = "error")
	String ec;
	
	@ElementList(name = "kurslist",required = false)
	ArrayList<aKurs> kl;

	public AGetKursResponse(){
		super();}
	
	/**
	 * Instantiates a new a get kurs response.
	 *
	 * @param ec ErrorCode know  by the client that tells him what to do next
	 * @param kl List of Kurs objects extracted from the database
	 */
	public AGetKursResponse(String ec, ArrayList<aKurs> kl) {
		super();
		this.ec = ec;
		this.kl = kl;
	}

	public String getEc() {
		return ec;
	}

	public ArrayList<aKurs> getKl() {
		return kl;
	}

}
