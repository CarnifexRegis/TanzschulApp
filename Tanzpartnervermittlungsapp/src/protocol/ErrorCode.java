package protocol;

public enum ErrorCode {
ok("ok");
private String text;
ErrorCode(String text){
	this.text=text;
}
}
