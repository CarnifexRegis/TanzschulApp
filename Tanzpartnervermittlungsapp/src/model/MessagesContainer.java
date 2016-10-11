package model;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "cmc")
/**
 * is Used to be able to built xml for  the cm object in Chat class
 * @author Simon
 *
 */
public class MessagesContainer {
	@ElementList
	ArrayList<ChatMessage> cm ;
	public MessagesContainer(){
		super();
	}
	public MessagesContainer(ArrayList<ChatMessage> cm) {
		super();
		this.cm = cm;
	}

	public ArrayList<ChatMessage> getCm() {
		return cm;
	}

}
