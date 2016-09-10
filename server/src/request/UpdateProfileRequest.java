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

	@Element (name = "id")
	private int id;

	@Element (name = "pn")
	private String pn;

	@Element (name = "height")
	private int height;

	@Element (name = "age")
	private int age;

	@Element (name = "ptext")
	private String pText;

	@Element (name = "pa")
	private boolean pa;

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

	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getPn() {
		return pn;
	}

	public int getHeight() {
		return height;
	}

	public String getpText() {
		return pText;
	}

	public boolean isPa() {
		return pa;
	}
}