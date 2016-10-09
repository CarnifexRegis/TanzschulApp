package model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "friend")
public class Friend {
	@Element(name = "fn")
	private String fn;
	@Element(name = "ln")
	private String ln;
	@Element(name = "idp")
	private int idp;
	@Element(name = "lm", required = false)
	private String lastMessage;
	@Element(name = "pic", required = false)// for implementations of the future
	private String pic;
	@Element (name = "cid")
	private int cid;
	
	public Friend (){
		super();
	}

	public Friend(String fn, String ln, int idp, int cid ,String lm) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.idp = idp;
		this.cid = cid;
		lastMessage = lm;
	}
	public String getFn() {
		return fn;
	}
	public String getLn() {
		return ln;
	}
	public int getIdp() {
		return idp;
	}
	public String getLastMessage() {
		return lastMessage;
	}
	public String getPic() {
		return pic;
	}

	public int getCid() {
		return cid;
	}

}
