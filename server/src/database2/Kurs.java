package database2;

import java.sql.Date;



public class Kurs {
	
	
	private int ID;
	private int kursstufe;
	private String uhrzeit;
	//private Date datum; // User Kurs DAO needs a String datum has to put in like : Day(int).Month(int).Year(int)
	private String datum;
	private String wochentag;
	//Boolean "SingUpAviable" must be added later 
	
	
	public Kurs(int kursID,int kursstufe, String datum, String wochentag, String uhrzeit) {
		super();
		this.kursstufe = kursstufe;
		this.uhrzeit = uhrzeit;
		this.datum = datum;
		this.ID = kursID;
	}
	
	public Kurs() {}

	public int getKursID() {
		return ID;
	}

	public void setKursID(int kursID) {
		this.ID = kursID;
	}

	public int getKursstufe() {
		return kursstufe;
	}

	public void setKursstufe(int kursstufe) {
		this.kursstufe = kursstufe;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getWochentag() {
		return wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}
	
	//private Date kursende

}
