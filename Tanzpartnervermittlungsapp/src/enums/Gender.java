package enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Gender.
 */
public enum Gender {

/** The n. */
n("none"),
/** The m. */
m("male"),
/** The fm. */
fm("female");

/**
 * Gets the gender.
 *
 * @return the gender
 */
public String getGender() {
	return gender;
}

/** The gender. */
String gender;

/**
 * Instantiates a new gender.
 *
 * @param gender the gender
 */
private Gender(String gender) {
	this.gender = gender;
}

/**
 * Gets the enum.
 *
 * @param s the s
 * @return the enum
 */
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
