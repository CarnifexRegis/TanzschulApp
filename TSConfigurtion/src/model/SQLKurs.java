package model;

import java.sql.Date;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class SQLKurs.
 *
 * @author Simon Stolz
 */
public class SQLKurs {
	
		

		/** The id. */
		@Root (name  = "sqlkurs")
		
			@Element(name  = "id",required = false)
			private int id;
			
			/** The kursstufe. */
			@Element (name  = "kursstufe")
			private int kursstufe;
			
			/** The uhrzeit. */
			@Element (name = "uhrzeit")
			private String uhrzeit;
			
			/** The datum. */
			//private Date datum; // User Kurs DAO needs a String datum has to put in like : Day(int).Month(int).Year(int)
			@Element (name = "datum")
			private Date datum;
			
			/** The wochentag. */
			@Element (name  = "wochentag")
			private String wochentag;
			//Boolean "SingUpAviable" must be added later 
			
			
			
//			public SQLKurs(){
//				super();
//			}

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

			/**
			 * Gets the kurs id.
			 *
			 * @return the kurs id
			 */
			public int getKursId() {
				return id;
			}
			
			/**
			 * Sets the kurs ID.
			 *
			 * @param kursID the new kurs ID
			 */
			public void setKursID(int kursID) {
				this.id = kursID;
			}

			/**
			 * Gets the kursstufe.
			 *
			 * @return the kursstufe
			 */
			public int getKursstufe() {
				return kursstufe;
			}

			/**
			 * Sets the kursstufe.
			 *
			 * @param kursstufe the new kursstufe
			 */
			public void setKursstufe(int kursstufe) {
				this.kursstufe = kursstufe;
			}

			/**
			 * Gets the uhrzeit.
			 *
			 * @return the uhrzeit
			 */
			public String getUhrzeit() {
				return uhrzeit;
			}

			/**
			 * Sets the uhrzeit.
			 *
			 * @param uhrzeit the new uhrzeit
			 */
			public void setUhrzeit(String uhrzeit) {
				this.uhrzeit = uhrzeit;
			}

			/**
			 * Gets the datum.
			 *
			 * @return the datum
			 */
			public Date getDatum() {
				return datum;
			}

			/**
			 * Sets the datum.
			 *
			 * @param datum the new datum
			 */
			public void setDatum(Date datum) {
				this.datum = datum;
			}

			/**
			 * Gets the wochentag.
			 *
			 * @return the wochentag
			 */
			public String getWochentag() {
				return wochentag;
			}

			/**
			 * Sets the wochentag.
			 *
			 * @param wochentag the new wochentag
			 */
			public void setWochentag(String wochentag) {
				this.wochentag = wochentag;
			}
			
			
		

		}
	

