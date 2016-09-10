package enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Kursstufen.
 */
public enum Kursstufen {
	
	GK1("Grundkurs 1" ,1),
	GK2("Grundkurs 2", 2),
	B("Bronze", 3),
	S("Silber", 4),
	G("Gold",5),
	GSA("Goldstar Teil A", 6),
	GSB("Goldstar Teil B", 7), 
	JC1("Jugendclub 1", 8),
	JC2("Jugendclub 2", 9);

	String KuNa;

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

	public String getKuNa() {
		return KuNa;
	}

	public int getKuNu() {
		return KuNu;
	}
	
}