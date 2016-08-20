package response;

import java.util.ArrayList;

import model.ProfileChart;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



@Root(name = "updatechartresponse")
public class UpdateChartResponse {
	//http://www.java-examples.com/get-size-java-arraylist-and-loop-through-elements-example
	//http://stackoverflow.com/questions/762400/how-to-display-all-elements-in-an-arraylist
	@ElementArray (name= "fn" )
String[] fn;
	@ElementArray (name= "ln" )
String[] ln;
	@ElementArray(name= "age" )
String[] age; 
	@ElementArray(name= "uhr" )
String[] uhr; 
	@ElementArray(name= "date" )
String[] date;
	public UpdateChartResponse(){}
	public UpdateChartResponse(ArrayList<ProfileChart> chartList) {
		super();
		ArrayList<ProfileChart>chartListTemp = chartList;
		int i = chartListTemp.size();
		fn = new String [i];
		ln = new String [i];
		age = new String [i];
		uhr = new String [i];
		date = new String [i];
	//	for(ProfileChart item :chartListTemp){
	//		}
		for (int c = 0; c<i; c++ ){
			ProfileChart temp = chartListTemp.get(c);
			fn[c] = temp.getFn();
			ln[c] = temp.getLn();
			age[c] = temp.getAge();
			uhr[c] = temp.getUhr();
			date[c] = temp.getdate();
		}
	}

	public ArrayList<ProfileChart> getChartList() {
		ArrayList<ProfileChart> chartList= new ArrayList<ProfileChart>();
		int l = fn.length;
		for(int i = 0; i< l;i++){
			chartList.add(new ProfileChart(fn[i],ln[i],age[i],uhr[i],date[i]));
			
		}
		return chartList;
	}

	
	
}
