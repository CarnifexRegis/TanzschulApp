package response;

import java.util.ArrayList;

import model.Kurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
@Root (name = "getkursresponse")
public class GetKursResponse {

	@Element (name = "error")
	String ec;
	
	@ElementList(name = "kurslist",required = false)
	ArrayList<Kurs> kl;

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

	public String getEc() {
		return ec;
	}

	public ArrayList<Kurs> getKl() {
		return kl;
	}

}
