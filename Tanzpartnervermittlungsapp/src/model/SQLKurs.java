package model;

import java.sql.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 * This class represents an Obect that is contained in the KURS table.
 * When the Hander revieves  an AAddKursRequest he revieves an Object of this class(without the id )
 * The id is still there  in case there might be any databases in the future client
 */
public class SQLKurs {
	
		@Root (name  = "sqlkurs")
		
			@Element(name  = "id",required = false)
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
			
			/**
			 * Instantiates a new SQL kurs.
			 */
			public SQLKurs(){
				super();
			}

			/**
			 * Instantiates a new SQL kurs.
			 *
			 * @param id the id
			 * @param kursstufe the kursstufe
			 * @param uhrzeit the uhrzeit
			 * @param datum the datum
			 * @param wochentag the wochentag
			 */
			public SQLKurs(int id, int kursstufe, String uhrzeit, Date datum,
					String wochentag) {
				super();
				this.id = id;
				this.kursstufe = kursstufe;
				this.uhrzeit = uhrzeit;
				this.datum = datum;
				this.wochentag = wochentag;
			}
			
			/**
			 * Instantiates a new SQL kurs.
			 *
			 * @param kursstufe the kursstufe
			 * @param uhrzeit the uhrzeit
			 * @param datum the datum
			 * @param wochentag the wochentag
			 */
			public SQLKurs( int kursstufe, String uhrzeit, Date datum,
					String wochentag) {
				super();
				
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
	

