package protocol;

public enum ErrorCode {
	
ja("ja"),wl("wrongLogin"),ae("alreadyExists"),nf("notFound");

String error;

private ErrorCode(String error) {
	this.error = error;
	
}

public String getError() {
	return error;
}


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

