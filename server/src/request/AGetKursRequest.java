package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class AGetKursRequest.
 */
@Root (name = "getkursrequest")

public class AGetKursRequest {
	
	/** The id. */
	@Element (name = "id")
	int id;
	
	/** The ks. */
	@Element (name = "kursstufe")
	int ks;
	
	/**
	 * Instantiates a new a get kurs request.
	 */
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
