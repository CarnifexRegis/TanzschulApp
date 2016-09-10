package database2;

//import java.sql.Date;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * The Class Kurs.
 */
@Root (name  = "kurs")
/**
 * 
 * @author Simon Stolz
 * This Class is used to transfer from the KURSTABLE to the Client
 */
public class Kurs {
	
	/** The id. */
	@Element(name  = "id")
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
	private String datum;
	
	/** The wochentag. */
	@Element (name  = "wochentag")
	private String wochentag;
	
	/** The enlisted. */
	@Element (name = "enlisted")
	private boolean enlisted;
	//Boolean "SingUpAviable" must be added later 
	/**
	 * Instantiates a new kurs.
	 */
	public Kurs(){
		super ();
	}
	
	/**
	 * Instantiates a new kurs.
	 *
	 * @param kursID id of the dancing lesson
	 * @param kursstufe level of the dancing lesson
	 * @param datum date the dancing lesson starts
	 * @param wochentag string representing the day the dancing lesson takes place (these lessons take place weekly)
	 * @param uhrzeit the time the dancing lesson starts
	 * @param enlisted indicates if the user that requests the data already is searching for that dancing lesson
	 */
	public Kurs(int kursID,int kursstufe, String datum, String wochentag, String uhrzeit,boolean enlisted) {
		super();
		this.kursstufe = kursstufe;
		this.uhrzeit = uhrzeit;
		this.datum = datum;
		this.id = kursID;
		this.wochentag=wochentag;
		this.enlisted = enlisted;
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
	public String getDatum() {
		return datum;
	}

	/**
	 * Sets the datum.
	 *
	 * @param datum the new datum
	 */
	public void setDatum(String datum) {
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
	
	/**
	 * Checks if is enlisted.
	 *
	 * @return true, if is enlisted
	 */
	public boolean isEnlisted() {
		return enlisted;
	}
	
	//private Date kursende

}
