package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * Requests to create or delete an Link object in the database
 * @author Simon Stolz
 */
@Root (name = "updatelinkrequest")
public class UpdateLinkRequest {

@Element (name = "uid")
private int uid;

@Element (name= "kid" )
private int kid;

@Element (name = "command")
private boolean command;

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
