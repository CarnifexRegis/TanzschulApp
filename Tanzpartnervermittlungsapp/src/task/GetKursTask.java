package task;

import protocol.Command;
import protocol.ErrorCode;
import activitys.AssignToKurs;
import activitys.Menue;
import android.app.Activity;
import android.util.Log;
import request.GetKursRequest;
import response.GetKursResponse;

public class GetKursTask extends BaseHttpRequestTask{
	int id;
	int ks;
	public GetKursTask(AssignToKurs atk, int id, int ks) {
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
			((AssignToKurs) activity).enableRefresh();
			((AssignToKurs) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
	}

	@Override
	public void onPostExecute(String result) {
		try {
			GetKursResponse response = (GetKursResponse) parseXML(result,
					GetKursResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	((AssignToKurs) activity).enableRefresh();
			 	((AssignToKurs) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((AssignToKurs) activity).recieveData(response.getKl());
			 }
		} catch (Exception e) {
			((AssignToKurs) activity).enableRefresh();
			((AssignToKurs) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}

}
