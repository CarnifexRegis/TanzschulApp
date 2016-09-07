package response;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.ProfileChart;



@Root(name = "updatechartresponse")
public class UpdateChartResponse {
	//http://www.java-examples.com/get-size-java-arraylist-and-loop-through-elements-example
	//http://stackoverflow.com/questions/762400/how-to-display-all-elements-in-an-arraylist
@ElementList (name= "pc" )
ArrayList<ProfileChart> pc;

	public UpdateChartResponse(){
		super();
	}
	public UpdateChartResponse(ArrayList<ProfileChart> pc) {
		super();
		this.pc = pc;}
	
	public ArrayList<ProfileChart> getPc() {
		return pc;
	}		
}
