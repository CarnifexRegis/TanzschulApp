package tasks;


import com.example.tsconfigurtion.AmendKurs;

import protocol.Command;
import protocol.ErrorCode;
import android.util.Log;
import request.aGetKursRequest;
import response.aGetKursResponse;

public class aGetKursTask extends BaseHttpRequestTask{
	int id;
	int ks;
	public aGetKursTask(AmendKurs amk, int id, int ks) {
		super(amk);
		this.id=id;
		this.ks =ks;
		
	}

	public void execute() {
		aGetKursRequest request = new aGetKursRequest(id,ks);

		try {
			String xml = buildXML(request);
			super.execute(Command.agetkurs, xml);
		} catch (Exception e) {
			((AmendKurs) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
	}

	@Override
	public void onPostExecute(String result) {
		try {
			aGetKursResponse response = (aGetKursResponse) parseXML(result,
					aGetKursResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	((AmendKurs) activity).onError(ec);
			 }
			 else
			 {
				 ((AmendKurs) activity).recieveData(response.getKl());
			 }
		} catch (Exception e) {
			((AmendKurs) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}

}
