package tasks;

import protocol.Command;
import protocol.ErrorCode;
import request.ADeleteRequest;
import response.ADeleteResponse;
import android.util.Log;
import android.view.View;

import com.example.tsconfigurtion.AmendKurs;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class ADeleteTask extends BaseHttpRequestTask{
int kid;
int uid;
int position;
View v;
	
	/**
	 * Instantiates a new a delete task.
	 *
	 * @param amk the amk
	 * @param kid the kid
	 * @param uid the uid
	 * @param position the position
	 * @param v the v
	 */
	public ADeleteTask(AmendKurs amk,int kid, int uid,int position,View v) {
		super(amk);
		this.kid = kid;
		this.uid = uid;
		this.position = position;
		this.v = v;
	}

	public void execute() {
		ADeleteRequest request = new ADeleteRequest(uid, kid);

		try {
			String xml = buildXML(request);
			super.execute(Command.adeletekurs, xml);
		} catch (Exception e) {
			v.setClickable(true);
			((AmendKurs) activity).onConnectionError();
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
			ADeleteResponse response = (ADeleteResponse) parseXML(result,
					ADeleteResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	v.setClickable(true);
			 	((AmendKurs) activity).onError(ec);
			 	
			 }
			 else
			 {
				 ((AmendKurs) activity).deleteItem(position);
			 }
		} catch (Exception e) {
			v.setClickable(true);
			((AmendKurs) activity).onConnectionError();
			Log.e("test", e.toString());
		}
	}



}
