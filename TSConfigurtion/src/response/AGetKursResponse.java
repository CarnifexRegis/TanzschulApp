package response;

import java.util.ArrayList;




import model.aKurs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



@Root (name = "getkursresponse")
public class AGetKursResponse {
	@Element (name = "error")
	String ec;
	@ElementList(name = "kurslist",required = false)
	ArrayList<aKurs> kl;
	
	public AGetKursResponse(){
		super();}
	public AGetKursResponse(String ec, ArrayList<aKurs> kl) {
		super();
		this.ec = ec;
		this.kl = kl;
	}
	public String getEc() {
		return ec;
	}
	public ArrayList<aKurs> getKl() {
		return kl;
	}

}
