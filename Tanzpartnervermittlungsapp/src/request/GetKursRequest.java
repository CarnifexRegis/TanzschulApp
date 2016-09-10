package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class GetKursRequest.
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
	 * @param id the id
	 * @param ks the ks
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
