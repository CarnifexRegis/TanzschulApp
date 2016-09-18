package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * Requests information about several kursobjects
 *
 * @author Simon Stolz
 */
@Root (name = "getkursrequest")

public class GetKursRequest {

	@Element (name = "id")
	private int id;

	@Element (name = "kursstufe")
	private int ks;

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

	public int getId() {
		return id;
	}

	public int getKursStufe(){
		return ks;
	}
}
