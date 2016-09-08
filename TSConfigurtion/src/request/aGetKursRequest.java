package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "getkursrequest")

public class aGetKursRequest {
	@Element (name = "id")
	int id;
	@Element (name = "kursstufe")
	int ks;
	public  aGetKursRequest(){
		super();
	}
	public aGetKursRequest(int id, int ks) {
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
