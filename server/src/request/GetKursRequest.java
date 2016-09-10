package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class GetKursRequest.
 *
 * @author Simon Stolz
 */
@Root (name = "getkursrequest")

public class GetKursRequest {
	
	/** The id. */
	@Element (name = "id")
	int id;
	
	/** The ks. */
	@Element (name = "kursstufe")
	int ks;
	
	/**
	 * Instantiates a new gets the kurs request.
	 */
	public  GetKursRequest(){
		super();
	}
	
	/**
	 * Instantiates a new gets the kurs request.
	 *
	 * @param id id of the user that send the request
	 * @param ks the level of the dancing lesson
	 */
	public GetKursRequest(int id, int ks) {
		super();
		this.id = id;
		this.ks = ks;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the kurs stufe.
	 *
	 * @return the kurs stufe
	 */
	public int getKursStufe(){
		return ks;
	}
}
