package model;

// TODO: Auto-generated Javadoc
//an attribute for an image has to be added

/**
 *@author Simon Stolz
 */
public class Kursbuchung {

	String name;

	int age;

	String kursstart; // Kursstart is a date like: day.month.year

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getKursstart() {
		return kursstart;
	}

	public void setKursstart(String kursstart) {
		this.kursstart = kursstart;
	}

	public String getKurszeit() {
		return kurszeit;
	}

	public void setKurszeit(String kurszeit) {
		this.kurszeit = kurszeit;
	}

}