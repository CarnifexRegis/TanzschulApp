package request;


import model.SQLKurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


// TODO: Auto-generated Javadoc

/**
 * The Class AAddKursRequest.
 *
 * @author Simon Stolz
 */
@Root (name = "addkursrequest" )
public class AAddKursRequest {

	@Element(name = "kurs")
	private SQLKurs kurs;

	@Element(name = "id")
	private int id;
	
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

	public SQLKurs getKurs() {
		return kurs;
	}

	public int getId() {
		return id;
	}
	
}
