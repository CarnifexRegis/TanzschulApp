package protocol;

// TODO: Auto-generated Javadoc
/**
 * The Enum ErrorCode.
 */
public enum ErrorCode {
	
/** The ja. */
ja("ja"),/** The wl. */
wl("wrongLogin"),/** The ae. */
ae("alreadyExists"),/** The nf. */
nf("notFound");

/** The error. */
String error;

/**
 * Instantiates a new error code.
 *
 * @param error the error
 */
private ErrorCode(String error) {
	this.error = error;
	
}

/**
 * Gets the error.
 *
 * @return the error
 */
public  String getError() {
	return error;
}


/**
 * From string.
 *
 * @param error the error
 * @return the error code
 */
public static ErrorCode fromString(String error) {

	if (error == null) {
		return null;
	}

	for (ErrorCode e : ErrorCode.values()) {
		if (e.error.equals(error)) {
			return e;
		}
	}

	return null;

}

}

