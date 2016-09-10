package request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
// TODO: Auto-generated Javadoc

/**
 * The Class UpdateProfileRequest.
 *
 * @author Simon Stolz
 */
@Root (name = "updateprofilerequest")
public class UpdateProfileRequest {
	
	/** The id. */
	@Element (name = "id")
	private int id;
	
	/** The pn. */
	@Element (name = "pn")
	private String pn;
	
	/** The height. */
	@Element (name = "height")
	private int height;
	
	/** The age. */
	@Element (name = "age")
	private int age;
	
	/** The p text. */
	@Element (name = "ptext")
	private String pText;
	
	/** The pa. */
	@Element (name = "pa")
	private boolean pa;
	
	/**
	 * Instantiates a new update profile request.
	 */
	public UpdateProfileRequest(){
		super();
	}
	// TODO use profile data class
	/**
	 * Instantiates a new update profile request.
	 *
	 * @param id users id
	 * @param pn users phone number
	 * @param height users height
	 * @param age users age
	 * @param pText users about me text
	 * @param pa tells if the users age is public
	 */
	public UpdateProfileRequest(int id, String pn, int height,int age,
			String pText, boolean pa) {
		super();
		this.id = id;
		this.pn = pn;
		this.height = height;
		this.age= age;
		this.pText = pText;
		this.pa = pa;
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
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Gets the pn.
	 *
	 * @return the pn
	 */
	public String getPn() {
		return pn;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Gets the p text.
	 *
	 * @return the p text
	 */
	public String getpText() {
		return pText;
	}
	
	/**
	 * Checks if is pa.
	 *
	 * @return true, if is pa
	 */
	public boolean isPa() {
		return pa;
	}


}
