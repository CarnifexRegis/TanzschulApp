package task;

import protocol.Command;
import request.UpdateChartRequest;
import response.UpdateChartResponse;
import activitys.SearchForDancingpartner;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class UpdateChartTask extends BaseHttpRequestTask{
private int id;
private int kursstufe ;
public boolean gender;
private int day;

/**
 * Instantiates a new update chart task.
 *
 * @param sfdp the sfdp
 * @param id the id
 * @param kursstufe the kursstufe
 * @param gender the gender
 * @param day the day
 */
public UpdateChartTask(SearchForDancingpartner sfdp,int id, int kursstufe, boolean gender,int day) {
	super(sfdp);
	this.id = id;
	this.kursstufe = kursstufe;
	this.gender = gender;
	this.day =day;
	
}

public void execute() {
	UpdateChartRequest request = new UpdateChartRequest( id, kursstufe, gender,day);

	try {
		String xml = buildXML(request);
		super.execute(Command.updatechart, xml);
	} catch (Exception e) {
		((SearchForDancingpartner) activity).onConnectionError();
		Log.e("Task couldn´t call execute() from SuperClass",e.toString());
	}
}

/* (non-Javadoc)
 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
 */
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

		((SearchForDancingpartner) activity).chartsUpdate(response.getPc());

		// }
	} catch (Exception e) {
		((SearchForDancingpartner) activity).onConnectionError();
		Log.e("Error in post Execute", e.toString());
	}
}
}



