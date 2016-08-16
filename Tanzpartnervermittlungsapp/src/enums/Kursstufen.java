package enums;

public enum Kursstufen {
	GK1("Grundkurs 1" ,1),GK2("Grundkurs 2", 2),B("Bronze", 3),S("Silber", 4),G("Gold",5),
	GSA("Goldstar A", 6),GSB("Goldstar B", 7),GSAB("Goldstar(beide)",8), JC("Jugendclub", 9);
	
	String KuNa;
	int KuNu;
	Kursstufen(String KuNa ,int KuNu){ //Kursnumber = KuNu Kursname = KuNa
	this.KuNu=KuNu;
	this.KuNa=KuNa;
}
}