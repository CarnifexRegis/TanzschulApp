package request;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class UpdateChartRequest.
 */
@Root(name = "updatechartrequest")
//gender needed
public class UpdateChartRequest {
	
	/** The id. */
	@Element(name = "id")
	int id;
	
	/** The kursstufe. */
	@Element(name ="kursstufe")
	int kursstufe;
	
	/** The gender. */
	@Element(name = "gender")
	boolean gender;
	
	/** The day. */
	@Element (name = "day")
	int day;
	
	/**
	 * Instantiates a new update chart request.
	 */
	public UpdateChartRequest(){
		super();
	}
	
	/**
	 * Instantiates a new update chart request.
	 *
	 * @param id the users id
	 * @param kursstufe the lesson level he is interested in
	 * @param gender the gender of the user
	 * @param day the day he is interested in
	 */
	public UpdateChartRequest(int id, int kursstufe, boolean gender, int day) {
		super();
		this.id = id;
		this.kursstufe = kursstufe;
		this.gender = gender;
		this.day = day;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Checks if is gender.
	 *
	 * @return true, if is gender
	 */
	public boolean isGender() {
		return gender;
	}
	
	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	
}
