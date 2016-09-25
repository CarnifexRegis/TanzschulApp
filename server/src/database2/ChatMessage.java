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
	@Element(name = "time")
	private String time;
	@Element(name= "text")
	private String Text;
	@Element (name = "mid")
	private int mid;
	@Element (name = "sender")
	private boolean sender;
	@Element (name = "friend")
	private boolean friend;
	public boolean isFriend() {
		return friend;
	}
	public String getTime() {
		return time;
	}
	public String getText() {
		return Text;
	}
	public int getMid() {
		return mid;
	}
	public boolean isSender() {
		return sender;
	}
	
	/**
	 * 
	 * @param time the time the message was recieved by the server
	 * @param text the actual message
	 * @param mid the messages id
	 * @param sender tells if u send the message yourself
	 * @param friend tells if the user accepted your friendrequest yet
	 */
	public ChatMessage(String time, String text, int mid, boolean sender,boolean friend) {
		super();
		this.time = time;
		Text = text;
		this.mid = mid;
		this.sender = sender;
		this.friend = friend;
	}
	
	
}
