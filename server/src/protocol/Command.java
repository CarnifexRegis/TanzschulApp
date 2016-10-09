package protocol;
// TODO: Auto-generated Javadoc

/**
 * The Enum Command.
 *
 * @author Simon Stolz
 * this enum is used to verify the received request
 */
public enum Command {
	
	getall("getall"), 
register("register"), 
login("login"), 
updatechart("updatechart"), 
updateprofile("updateprofile"),
getprofile("getprofile"), 
foreignprofile("foreignprofile"),
getkurs("getkurs"),
updatelink("updatelink"), 
alogin("alogin"),
agetkurs("agetkurs"),
addkurs("addKurs"),
updateimage("updateimage"),
adeletekurs("adeletekurs"),
getchatmessages("getchatmessages"),
sendmessage("sendmessage"),
getchats("getchats"),
cehckforcupdate("cehckforcupdate"),
acceptfr("acceptfr"),
getfr("getfr"),
getfriends("getfriends"),
pollchat("pollchat"),
addfriend("addfriend");


	private String text;

	/**
	 * Instantiates a new command.
	 *
	 * @param text the text
	 */
	private Command(String text) {
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}

/**
 * Checks if the text parameter equals one of the text attribute of one of the enums objects .
 *
 * @param text String value that should equal one of the text attributes
 * @return returns a Command object in case of accordance
 */
	public static Command fromString(String text) {

		if (text == null) {
			return null;
		}

		for (Command c : Command.values()) {
			if (c.text.equals(text)) {
				return c;
			}
		}

		return null;

	}

}


