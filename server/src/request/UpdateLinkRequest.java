package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateLinkRequest.
 */
@Root (name = "updatelinkrequest")
public class UpdateLinkRequest {

/** The uid. */
@Element (name = "uid")
int uid;

/** The kid. */
@Element (name= "kid" )
int kid;

/** The command. */
@Element (name = "command")
boolean command;

/**
 * Instantiates a new update link request.
 */
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

/**
 * Gets the command.
 *
 * @return the command
 */
public boolean getcommand (){
	return command;
	}

/**
 * Gets the uid.
 *
 * @return the uid
 */
public int getUid() {
	return uid;
}

/**
 * Gets the kid.
 *
 * @return the kid
 */
public int getKid() {
	return kid;
}

}
