package request;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import database2.SQLKurs;
// TODO: Auto-generated Javadoc

/**
 * The Class AAddKursRequest.
 *
 * @author Simon Stolz
 */
@Root (name = "addkursrequest" )
public class AAddKursRequest {
	
	/** The kurs. */
	@Element(name = "kurs")
	private SQLKurs kurs;
	
	/** The id. */
	@Element(name = "id")
	int id;
	
	/**
	 * Instantiates a new a add kurs request.
	 */
	AAddKursRequest(){
		super();
		}
	
	/**
	 * Instantiates a new a add kurs request.
	 *
	 * @param kurs SQLKurs
	 * @param id id of the requesting admin
	 */
	public AAddKursRequest(SQLKurs kurs, int id) {
		super();
		this.kurs = kurs;
		this.id = id;
	}

	/**
	 * Gets the kurs.
	 *
	 * @return the kurs
	 */
	public SQLKurs getKurs() {
		return kurs;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
