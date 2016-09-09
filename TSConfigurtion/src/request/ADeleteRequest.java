package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "adeleterequest")
public class ADeleteRequest {
	@Element(name = "uid")
	int uid;
	@Element (name = "kid")
	int kid;
	 ADeleteRequest(){
		 super();
	 }
	 
	public ADeleteRequest(int uid, int kid) {
		super();
		this.uid = uid;
		this.kid = kid;
	}

	public int getUid() {
		return uid;
	}
	public int getKid() {
		return kid;
	}
	 
	

}
