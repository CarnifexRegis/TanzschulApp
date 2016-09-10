package protocol;
// TODO: Auto-generated Javadoc

/**
 * The Enum Command.
 *
 * @author Simon Stolz
 * this enum is used to verify the received request
 */
public enum Command {
	
	/** The getall. */
	getall("getall"), 
 /** The register. */
 register("register"), 
 /** The login. */
 login("login"), 
 /** The updatechart. */
 updatechart("updatechart"), 
 /** The updateprofile. */
 updateprofile("updateprofile"),
/** The getprofile. */
getprofile("getprofile"), 
 /** The foreignprofile. */
 foreignprofile("foreignprofile"),
/** The getkurs. */
getkurs("getkurs"),
/** The updatelink. */
updatelink("updatelink"), 
 /** The alogin. */
 alogin("alogin"),
/** The agetkurs. */
agetkurs("agetkurs"),
/** The addkurs. */
addkurs("addKurs"),
/** The adeletekurs. */
adeletekurs("adeletekurs");

	/** The text. */
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


