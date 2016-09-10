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
	
	
	@Element(name  = "id")
	private int id;
	
	@Element (name  = "kursstufe")
	private int kursstufe;
	
	@Element (name = "uhrzeit")
	private String uhrzeit;
	
	//private Date datum; // User Kurs DAO needs a String datum has to put in like : Day(int).Month(int).Year(int)
	@Element (name = "datum")
	private String datum;
	
	@Element (name  = "wochentag")
	private String wochentag;
	
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

	public boolean isEnlisted() {
		return enlisted;
	}
	
	//private Date kursende

}
