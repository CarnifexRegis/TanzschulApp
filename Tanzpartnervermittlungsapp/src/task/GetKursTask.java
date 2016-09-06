package task;

import protocol.Command;

import activitys.AssignToKurs;
import activitys.Menue;
import android.app.Activity;
import android.util.Log;
import request.GetKursRequest;

public class GetKursTask extends BaseHttpRequestTask{
	int id;
	int ks;
	protected GetKursTask(AssignToKurs atk, int id, int ks) {
		super(atk);
		this.id=id;
		this.ks =ks;
		
	}

	public void execute() {
		GetKursRequest request = new GetKursRequest(id,ks);

		try {
			String xml = buildXML(request);
			super.execute(Command.getkurs, xml);
		} catch (Exception e) {
		Log.e("Request", e.toString());
		e.printStackTrace();
	}
	}

	@Override
	public void onPostExecute(String result) {
		try {
			GetAllResponse response = (GetAllResponse) parseXML(result,
					GetAllResponse.class);
//			
//			// if(!(response.getEc() == ErrorCode.ok))
//			// {
//			//
//			// }
//			// else
//			// {
//			// Antwort erfolgreich erhalten
//
			((Menue) activity).testAusgabe(response.getText());
//			// }
		} catch (Exception e) {
			Log.e("test", e.toString());
		}
	}

}
