package task;

import protocol.Command;
import protocol.ErrorCode;
import request.RegisterRequest;
import request.SendMessageRequest;
import response.RegisterResponse;
import response.SendMessageResponse;
import activitys.Chat;
import activitys.Registration;
import android.util.Log;

public class SendMessageTask extends BaseHttpRequestTask{
	String message;
	int id;
	int cid;
	

	public SendMessageTask(Chat c, int id ,String message,int cid ) {
		super(c);
		this.message = message;
		this.id = id;
		this.cid =cid;
		
	}
	public void execute() {
		SendMessageRequest request = new SendMessageRequest(id, message, cid);

		try {
			String xml = buildXML(request);
			super.execute(Command.sendmessage, xml);
		} catch (Exception e) {
			((Chat) activity).onConnectionError();
			System.out.println("An error occured bulding the xml/exceuting command");
		}
	}
	@Override
	public void onPostExecute(String result) {
		try {
			SendMessageResponse response = (SendMessageResponse) parseXML(result,
					SendMessageResponse.class);
			
			String error =response.getEc();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
					((Chat) activity).onError(error);
			 }
			 else
			 {
				 ((Chat) activity).successful();
			 }
			
		} catch (Exception e) {
			((Chat) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
		}
	}
}
