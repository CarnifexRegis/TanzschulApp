package response;

import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.ProfileChart;



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
private String ec;

	public UpdateChartResponse(){
		super();
	}
	
	/**
	 * Instantiates a new update chart response.
	 *
	 * @param pc ProfileChart extracted from USER table
	 * @param ec ErrorCode know  by the client that tells him what to do next
	 */
	public UpdateChartResponse(ArrayList<ProfileChart> pc,String ec ) {
		super();
		this.pc = pc;
		this.ec = ec;
	}

	public ArrayList<ProfileChart> getPc() {
		return pc;
	}

	public String getEc() {
		return ec;
	}	
	
}
