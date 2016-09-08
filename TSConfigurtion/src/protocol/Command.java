package protocol;

public enum Command {
	 alogin("alogin"),agetkurs("agetkurs"),addkurs("addKurs");

	private String text;

	private Command(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}

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


