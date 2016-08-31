package futurerequest;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "updateprofilerequest")
public class UpdateProfileRequest {
	@Element (name = "id")
	private int id;
	@Element (name = "pn")
	private int pn;
	@Element (name = "hight")
	private int hight;
	@Element (name = "age")
	private int age;
	@Element (name = "ptext")
	private String pText;
	@Element (name = "pa")
	private boolean pa;
	public UpdateProfileRequest(){
		super();
	}
	
	public UpdateProfileRequest(int id, int pn, int hight,int age,
			String pText, boolean pa) {
		super();
		this.id = id;
		this.pn = pn;
		this.hight = hight;
		this.age= age;
		this.pText = pText;
		this.pa = pa;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public int getPn() {
		return pn;
	}
	public int getHight() {
		return hight;
	}
	public String getpText() {
		return pText;
	}
	public boolean isPa() {
		return pa;
	}


}
