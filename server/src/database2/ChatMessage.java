package database2;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 * 
 * @author Simon Stolz
 * An Instance of this object contains the data of one chat message 
 */
@Root(name = "chatmessage")
public class ChatMessage {
	@Element(name= "text")
	private String Text;
	@Element (name = "mid")
	private int mid;
	@Element (name = "sender")
	private int senderId;
	
	public String getText() {
		return Text;
	}
	public int getMid() {
		return mid;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setMid(int mid){
		this.mid =mid;
	}
	
	/**
	 * 
	 * @param time the time the message was recieved by the server
	 * @param text the actual message
	 * @param mid the messages id
	 * @param senderId the senders idp
	 */
	public ChatMessage(){
		super();
	}
	public ChatMessage(String text, int mid, int senderId) {
		super();
		Text = text;
		this.mid = mid;
		this.senderId = senderId;
		
	}
	
	
}
