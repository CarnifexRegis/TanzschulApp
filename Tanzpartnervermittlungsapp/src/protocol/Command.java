package protocol;

// TODO: Auto-generated Javadoc
/**
 * sources : Abiquiz App by Tim M�schel
 * @author Simon Stolz
 * The Enum Command.
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
updateimage("updateimage"),
getchatmessages("getchatmessages"),
sendmessage("sendmessage"),
getchats("getchats"),
cehckforcupdate("cehckforcupdate"),
acceptfr("acceptfr"),
getfr("getfr"),
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
	 * From string.
	 *
	 * @param text the text
	 * @return the command
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


