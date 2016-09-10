package protocol;

// TODO: Auto-generated Javadoc
/**
 * The Enum Command.
 */
public enum Command {
	 
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


