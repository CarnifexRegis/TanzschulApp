package response;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import database2.ProfileChart;

@Root(name = "updatechartresponse")
public class UpdateChartResponse {
	@ElementList(name = "chartslist")
	ArrayList<ProfileChart> chartList;

	public UpdateChartResponse(ArrayList<ProfileChart> chartList) {
		super();
		this.chartList = chartList;
	}

	public ArrayList<ProfileChart> getChartList() {
		return chartList;
	}

	
	
}
