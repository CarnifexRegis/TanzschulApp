package enums;

public enum Gender {
n("none"),m("male"),fm("female");
public String getGender() {
	return gender;
}

String gender;

private Gender(String gender) {
	this.gender = gender;
}
public Gender getEnum(String s){
	//https://examples.javacodegeeks.com/java-basics/switch-statement/java-switch-case-example/
	switch (s){
	case "male":
		return m;
	case "female":
		return fm;
	default:
		return n;
}
	}

}
