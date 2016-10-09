package response;

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.ChatMessage;

@Root(name = "pollchatresponse")
public class PollChatResponse {
	@Element(name = "ec")
	private String ec;
	@ElementList(name ="cmessages")
	ArrayList<ChatMessage> cm;
	public PollChatResponse(){
		super();
	}
	
	public PollChatResponse(String ec, ArrayList<ChatMessage> cm) {
		super();
		this.ec = ec;
		this.cm = cm;
	}

	public String getEc() {
		return ec;
	}
	public ArrayList<ChatMessage> getCm() {
		return cm;
	}
	
	
}
