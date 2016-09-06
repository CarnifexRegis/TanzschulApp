package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "getkursrequest")
class GetKursRequest {
	@Element (name = "id")
	int id;
	@Element (name = "kursstufe")
	int ks;
	public  GetKursRequest(){
		super();
	}
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
