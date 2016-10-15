package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * Requests a new Message to be added to a chat between two users
 * @author Simon Stolz
 *
 */
@Root(name = "sendmessagerequest")
public class SendMessageRequest {
	@Element(name = "id")
	private int id;
	@Element(name = "message")
	private String message;
	@Element (name = "cid")
	private int cid;
	public SendMessageRequest(){
		super();
	}
	public SendMessageRequest(int id, String message, int cid) {
		super();
		this.id = id;
		this.message = message;
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public int getCid() {
		return cid;
	}
	
	
}
