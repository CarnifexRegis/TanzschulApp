package response;

import java.util.ArrayList;

import model.ProfileChart;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
@Root(name = "updatechartresponse")
public class UpdateChartResponse {
	//http://www.java-examples.com/get-size-java-arraylist-and-loop-through-elements-example
	//http://stackoverflow.com/questions/762400/how-to-display-all-elements-in-an-arraylist
@ElementList (name= "pc", required = false )
private ArrayList<ProfileChart> pc;

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
