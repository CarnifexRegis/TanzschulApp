package model;

import java.sql.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

public class SQLKurs {
	
		

		@Root (name  = "sqlkurs")
		
			@Element(name  = "id")
			private int id;
			@Element (name  = "kursstufe")
			private int kursstufe;
			@Element (name = "uhrzeit")
			private String uhrzeit;
			//private Date datum; // User Kurs DAO needs a String datum has to put in like : Day(int).Month(int).Year(int)
			@Element (name = "datum")
			private Date datum;
			@Element (name  = "wochentag")
			private String wochentag;
			//Boolean "SingUpAviable" must be added later 
			
			
			
//			public SQLKurs(){
//				super();
//			}

			public SQLKurs(int id, int kursstufe, String uhrzeit, Date datum,
					String wochentag) {
				super();
				this.id = id;
				this.kursstufe = kursstufe;
				this.uhrzeit = uhrzeit;
				this.datum = datum;
				this.wochentag = wochentag;
			}

			public int getKursId() {
				return id;
			}
			
			public void setKursID(int kursID) {
				this.id = kursID;
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

			public Date getDatum() {
				return datum;
			}

			public void setDatum(Date datum) {
				this.datum = datum;
			}

			public String getWochentag() {
				return wochentag;
			}

			public void setWochentag(String wochentag) {
				this.wochentag = wochentag;
			}
			
			
		

		}
	

