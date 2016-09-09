package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "getkursrequest")

public class AGetKursRequest {
	@Element (name = "id")
	int id;
	@Element (name = "kursstufe")
	int ks;
	public  AGetKursRequest(){
		super();
	}
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
