package task;

import protocol.Command;
import protocol.ErrorCode;
import activitys.AssignToKurs;
import activitys.Menue;
import android.app.Activity;
import android.util.Log;
import request.GetKursRequest;
import response.GetKursResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class GetKursTask.
 */
public class GetKursTask extends BaseHttpRequestTask{
	
	/** The id. */
	int id;
	
	/** The ks. */
	int ks;
	
	/**
	 * Instantiates a new gets the kurs task.
	 *
	 * @param atk the atk
	 * @param id the id
	 * @param ks the ks
	 */
	public GetKursTask(AssignToKurs atk, int id, int ks) {
		super(atk);
		this.id=id;
		this.ks =ks;
		
	}

	/**
	 * Execute.
	 */
	public void execute() {
		GetKursRequest request = new GetKursRequest(id,ks);

		try {
			String xml = buildXML(request);
			super.execute(Command.getkurs, xml);
		} catch (Exception e) {
			
			((AssignToKurs) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			GetKursResponse response = (GetKursResponse) parseXML(result,
					GetKursResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	
			 	((AssignToKurs) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((AssignToKurs) activity).recieveData(response.getKl());
			 }
		} catch (Exception e) {
			
			((AssignToKurs) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}

}
