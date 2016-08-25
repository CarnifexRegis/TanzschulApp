package protocol;

public enum ErrorCode {
	
ja("ja"),wl("wrongLogin"),ae("alreadyExists"),nf("notFound");

String error;

private ErrorCode(String error) {
	this.error = error;
}

}

