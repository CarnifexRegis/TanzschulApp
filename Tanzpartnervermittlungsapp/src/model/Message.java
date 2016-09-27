package model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "message")
public class Message {
	@Element (name = "id")
private int id;
	@Element (name ="sender" )
private boolean sender;
	@Element (name = "txt")
private String txt;
	@Element (name = "time")
private String time;// in case u want to  add this feature in the Future
	
	public Message(){
		super();
	}
	public Message(int id, boolean sender, String txt) {
		super();
		this.id = id;
		this.sender = sender;
		this.txt = txt;
	}
	public int getId() {
		return id;
	}
	public boolean isSender() {
		return sender;
	}
	public String getTxt() {
		return txt;
	}
	public String getTime() {
		return time;
	}

	
}
