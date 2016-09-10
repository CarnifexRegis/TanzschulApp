package protocol;

// TODO: Auto-generated Javadoc
/**
 * The Enum ErrorCode.
 */
public enum ErrorCode {
	
ja("ja"),
wl("wrongLogin"),
ae("alreadyExists"),
nf("notFound");

String error;

/**
 * Instantiates a new error code.
 *
 * @param error the error
 */
private ErrorCode(String error) {
	this.error = error;
	
}

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

