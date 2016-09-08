package tasks;

import protocol.Command;
import protocol.ErrorCode;
import request.aDeleteRequest;
import response.aDeleteResponse;
import android.util.Log;
import android.view.View;

import com.example.tsconfigurtion.AmendKurs;

public class aDeleteTask extends BaseHttpRequestTask{
int kid;
int uid;
int position;
View v;
	public aDeleteTask(AmendKurs amk,int kid, int uid,int position,View v) {
		super(amk);
		this.kid = kid;
		this.uid = uid;
		this.position = position;
		this.v = v;
	}

	public void execute() {
		aDeleteRequest request = new aDeleteRequest(uid, kid);

		try {
			String xml = buildXML(request);
			super.execute(Command.agetkurs, xml);
		} catch (Exception e) {
			v.setClickable(true);
			((AmendKurs) activity).onConnectionError();
			Log.e("Request", e.toString());
			e.printStackTrace();
		
	}
}
	

	@Override
	public void onPostExecute(String result) {
		try {
			aDeleteResponse response = (aDeleteResponse) parseXML(result,
					aDeleteResponse.class);
			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
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
