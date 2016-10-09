package request;

import org.simpleframework.xml.Element;

public class PollChatRequest {
	@Element(name = "cid")
	private int cid;
	@Element(name = "id")
	private int id ;
	@Element(name = "lm")
	private int lm ;
	public PollChatRequest(){
		super();
	}
	public PollChatRequest(int cid, int id, int lm) {
		super();
		this.cid = cid;
		this.id = id;
		this.lm=lm;
	}
	public int getCid() {
		return cid;
	}
	public int getId() {
		return id;
	}
	public int getLm() {
		return lm;
	}
	
}
