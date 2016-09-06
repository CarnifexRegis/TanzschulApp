package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "updatelinkrequest")
public class UpdateLinkRequest {
@Element (name = "uid")
int uid;
@Element (name= "kid" )
int kid;
@Element (name = "command")
boolean command;
public UpdateLinkRequest (){
	super();
}
public UpdateLinkRequest(int uid, int kid,boolean command) {
	super();
	this.uid = uid;
	this.kid = kid;
	this.command  = command;
}
public boolean getcommand (){
	return command;
	}
public int getUid() {
	return uid;
}
public int getKid() {
	return kid;
}

}
