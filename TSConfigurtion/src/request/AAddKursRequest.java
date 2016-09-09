package request;

import model.SQLKurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "addkursrequest" )
public class AAddKursRequest {
	@Element(name = "kurs")
	private SQLKurs kurs;
	@Element(name = "id")
	int id;
	AAddKursRequest(){
		super();
		}
	
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
