package model;

// TODO: Auto-generated Javadoc
//an attribute for an image has to be added

/**
 * The Class Kursbuchung.
 */
public class Kursbuchung {
	
	/** The name. */
	String name;
	
	/** The age. */
	int age;
	
	/** The kursstart. */
	String kursstart; // Kursstart is a date like: day.month.year
	
	/** The kurszeit. */
	String kurszeit;  // Kurszeit is a point of time like: hours(in 24 h):minutes

	/**
	 * Instantiates a new kursbuchung.
	 *
	 * @param n the n
	 * @param a the a
	 * @param kS the k S
	 * @param kZ the k Z
	 */
	public Kursbuchung(String n, int a,String kS, String kZ) {
		super();
		name=n;
		age=a;
		kursstart=kS;
		kurszeit=kZ;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the kursstart.
	 *
	 * @return the kursstart
	 */
	public String getKursstart() {
		return kursstart;
	}

	/**
	 * Sets the kursstart.
	 *
	 * @param kursstart the new kursstart
	 */
	public void setKursstart(String kursstart) {
		this.kursstart = kursstart;
	}

	/**
	 * Gets the kurszeit.
	 *
	 * @return the kurszeit
	 */
	public String getKurszeit() {
		return kurszeit;
	}

	/**
	 * Sets the kurszeit.
	 *
	 * @param kurszeit the new kurszeit
	 */
	public void setKurszeit(String kurszeit) {
		this.kurszeit = kurszeit;
	}

}