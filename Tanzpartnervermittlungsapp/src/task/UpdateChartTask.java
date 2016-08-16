package task;

import protocol.Command;
import request.UpdateChartRequest;
import response.GetAllResponse;
import response.UpdateChartResponse;
import activitys.Menue;
import activitys.SearchForDancingpartner;
import android.util.Log;

public class UpdateChartTask extends BaseHttpRequestTask{
private int id;
private int kursstufe ;
public boolean gender;
public UpdateChartTask(SearchForDancingpartner sfdp,int id, int kursstufe, boolean gender) {
	super(sfdp);
	this.id = id;
	this.kursstufe = kursstufe;
	this.gender = gender;
	
}
public void execute() {
	UpdateChartRequest request = new UpdateChartRequest( id, kursstufe, gender);

	try {
		String xml = buildXML(request);
		super.execute(Command.updatechart, xml);
	} catch (Exception e) {
		// FIXME Errorhandling
	}
}
@Override
public void onPostExecute(String result) {
	try {
		UpdateChartResponse response = (UpdateChartResponse) parseXML(result,
				UpdateChartResponse.class);
		
		// if(!(response.getEc() == ErrorCode.ok))
		// {
		//
		// }
		// else
		// {
		// Antwort erfolgreich erhalten

		((SearchForDancingpartner) activity).chartsUpdate(response.getChartList());

		// }
	} catch (Exception e) {
		Log.e("test", e.toString());
	}
}
}



