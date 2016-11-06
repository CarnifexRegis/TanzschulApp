package model;

import java.util.ArrayList;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root(name = "cmc")
// doesn´t work
/**
 *
 * is Used to be able to built xml for  the cm object in Chat class
 * @author Simon Stolz
 *
 */
public class MessagesContainer {
	@ElementArray(name = "cmlist")
	ChatMessage [] cm;
	public MessagesContainer(){
		super();
	}
	public MessagesContainer(ArrayList<ChatMessage> cm) {
		super();
		if(cm != null){
			if(cm.size()>0){
		this.cm= new ChatMessage [cm.size()-1];
		for(int i = 0; i<cm.size();i++){
			this.cm[i] = cm.get(i);
		}
		
			}
			}
	}

	public ChatMessage [] getCm() {
		return cm;
	}

}
