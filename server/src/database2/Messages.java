package database2;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "messages")
public class Messages {
	@ElementList
	ArrayList<ChatMessage> cm = new ArrayList<ChatMessage>();

	public Messages() {
		super();
	}
	public void addMessage(String message,int senderIdp){
			cm.add( new ChatMessage(message, cm.size(),  senderIdp));
			System.out.println("Added Message with id: "+ (cm.size()-1));
	}
	public ArrayList<ChatMessage> getMissingMessages(int mid){
		ArrayList<ChatMessage> missingM = new   ArrayList<ChatMessage>();
	
	for(int i= mid+1;i<cm.size();i++){
		missingM.add(cm.get(i));
		System.out.println("Updating message with id: "+ cm.get(i).getMid());
		}
	
		return missingM;
	}
	public ArrayList<ChatMessage> getCm() {
		return cm;
	}
	
}
