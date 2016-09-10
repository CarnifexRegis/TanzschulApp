package protocol;

// TODO: Auto-generated Javadoc
/**
 * The Enum Command.
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
updatelink("updatelink");

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


