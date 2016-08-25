package protocol;

public enum ErrorCode {
	
ja("ja","Korrekt!"),wl("wrongLogin","Falsche E-MAil oder Kennwort."),ae("alreadyExists","Diese E-Mail existiert bereits in unserer Datenbank."),nf("notFound","Der Nutzer konnte nicht gefunden werden.");

String error;
String output;

private ErrorCode(String error,String output) {
	this.error = error;
	this.output =  output;
}

public String getError() {
	return error;
}
public String getOutput() {
	return output;
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

