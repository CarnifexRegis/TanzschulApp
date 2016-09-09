package tasks;


import com.example.tsconfigurtion.AmendKurs;

import protocol.Command;
import protocol.ErrorCode;
import android.util.Log;
import request.AGetKursRequest;
import response.AGetKursResponse;

public class AGetKursTask extends BaseHttpRequestTask{
	int id;
	int ks;
	boolean mature;
	public AGetKursTask(AmendKurs amk, int id, int ks, boolean mature) {
		super(amk);
		this.id=id;
		this.ks =ks;
		this.mature = mature;
		
		
	}

	public void execute() {
		AGetKursRequest request = new AGetKursRequest(id,ks,mature);

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
			AGetKursResponse response = (AGetKursResponse) parseXML(result,
					AGetKursResponse.class);
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
