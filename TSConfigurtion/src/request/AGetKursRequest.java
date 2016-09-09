package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "getkursrequest")

public class AGetKursRequest {
	@Element (name = "id")
	int id;
	@Element (name = "kursstufe")
	int ks;
//	@Element (name = "mature")
//	boolean mature;
	
	public  AGetKursRequest(){
		super();
	}
	public AGetKursRequest(int id, int ks) {
		super();
		this.id = id;
		this.ks = ks;
//		this.mature = mature;
		
	}
	public AGetKursRequest(int id, int ks, boolean mature) {
		super();
		this.id = id;
		this.ks = ks;
//		this.mature = mature;
		
	}

	public int getId() {
		return id;
	}
	public int getKursStufe(){
		return ks;
	}
	
}
