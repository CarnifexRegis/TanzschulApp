package response;

import java.util.ArrayList;

import model.ProfileChart;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;





// TODO: Auto-generated Javadoc
/**
 * The Class UpdateChartResponse.
 */
@Root(name = "updatechartresponse")
public class UpdateChartResponse {
	//http://www.java-examples.com/get-size-java-arraylist-and-loop-through-elements-example
	/** The pc. */
	//http://stackoverflow.com/questions/762400/how-to-display-all-elements-in-an-arraylist
@ElementList (name= "pc", required = false )
ArrayList<ProfileChart> pc;

/** The ec. */
@Element (name = "ec")
String ec;

	/**
	 * Instantiates a new update chart response.
	 */
	public UpdateChartResponse(){
		super();
	}
	
	/**
	 * Instantiates a new update chart response.
	 *
	 * @param pc the pc
	 * @param ec the ec
	 */
	public UpdateChartResponse(ArrayList<ProfileChart> pc,String ec ) {
		super();
		this.pc = pc;
		this.ec = ec;
	}
	
	/**
	 * Gets the pc.
	 *
	 * @return the pc
	 */
	public ArrayList<ProfileChart> getPc() {
		return pc;
	}
	
	/**
	 * Gets the ec.
	 *
	 * @return the ec
	 */
	public String getEc() {
		return ec;
	}	
	
}
