package request;

import org.simpleframework.xml.Element;

public class PollChatRequest {
	@Element(name = "cid")
	private int cid;
	@Element(name = "id")
	private int id ;
	public PollChatRequest(){
		super();
	}
	public PollChatRequest(int cid, int id) {
		super();
		this.cid = cid;
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public int getId() {
		return id;
	}
}
