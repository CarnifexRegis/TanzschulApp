package response;

import java.util.ArrayList;

import model.Kurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root (name = "getkursresponse")
public class GetKursResponse {
	@Element (name = "error")
	String ec;
	@ElementList(name = "kurslist")
	ArrayList<Kurs> kl;
	public GetKursResponse(){
		super();}
	public GetKursResponse(String ec, ArrayList<Kurs> kl) {
		super();
		this.ec = ec;
		this.kl = kl;
	}
	public String getEc() {
		return ec;
	}
	public ArrayList<Kurs> getKl() {
		return kl;
	}

}
