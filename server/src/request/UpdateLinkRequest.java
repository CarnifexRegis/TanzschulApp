package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
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

/**
 * Instantiates a new update link request.
 *
 * @param uid users id
 * @param kid id of a object in table KURS
 * @param command true for adding a link false for deleting it
 */
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
