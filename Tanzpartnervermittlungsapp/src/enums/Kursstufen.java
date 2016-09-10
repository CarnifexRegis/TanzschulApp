package enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Kursstufen.
 */
public enum Kursstufen {
	
	/** The gk1. */
	GK1("Grundkurs 1" ,1),
/** The gk2. */
GK2("Grundkurs 2", 2),
/** The b. */
B("Bronze", 3),
/** The s. */
S("Silber", 4),
/** The g. */
G("Gold",5),
	
	/** The gsa. */
	GSA("Goldstar Teil A", 6),
/** The gsb. */
GSB("Goldstar Teil B", 7), 
 /** The jc1. */
 JC1("Jugendclub 1", 8),
/** The jc2. */
JC2("Jugendclub 2", 9);
	
	/** The Ku na. */
	String KuNa;
	
	/** The Ku nu. */
	int KuNu;
	
	/**
	 * Instantiates a new kursstufen.
	 *
	 * @param KuNa the ku na
	 * @param KuNu the ku nu
	 */
	Kursstufen(String KuNa ,int KuNu){ //Kursnumber = KuNu Kursname = KuNa
	this.KuNu=KuNu;
	this.KuNa=KuNa;
	

}
	
	/**
	 * From int.
	 *
	 * @param ks the ks
	 * @return the kursstufen
	 */
	public static Kursstufen fromInt(int ks) {

		if (ks >10 ||ks<1) {
			return null;
		}

		for (Kursstufen k : Kursstufen.values()) {
			if (k.KuNu ==ks) {
				return k;
			}
		}

		return null;

	}
	
	/**
	 * Gets the ku na.
	 *
	 * @return the ku na
	 */
	public String getKuNa() {
		return KuNa;
	}
	
	/**
	 * Gets the ku nu.
	 *
	 * @return the ku nu
	 */
	public int getKuNu() {
		return KuNu;
	}
	
}