package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


/**
 * 
 * @author Simon Stolz
 * Requests information about several Kursobjects
 */
// TODO: Auto-generated Javadoc

@Root (name = "getkursrequest")

public class AGetKursRequest {

	@Element (name = "id")
	private int id;

	@Element (name = "kursstufe")
	private int ks;
	
	public  AGetKursRequest(){
		super();
	}
	
	/**
	 * Instantiates a new a get kurs request.
	 *
	 * @param id the id
	 * @param ks the ks
	 */
	public AGetKursRequest(int id, int ks) {
		super();
		this.id = id;
		this.ks = ks;
	}

	public int getId() {
		return id;
	}
	
	public int getKursStufe(){
		return ks;
	}
}
