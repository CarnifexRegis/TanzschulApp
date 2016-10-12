package task;

import protocol.Command;
import protocol.ErrorCode;
import request.PollChatRequest;
import response.PollChatResponse;
import activitys.Chat;
import android.util.Log;

public class PollChatTask extends BaseHttpRequestTask{
	int id;
	int cid;
	int lm;

	public PollChatTask(Chat chat,int id, int cid, int lm) {
		super(chat);
		this.id = id;
		this.cid=cid;
		this.lm =lm;
	}
	
	public void execute() {
		PollChatRequest request = new PollChatRequest(cid,id,lm);
		try {
			String xml = buildXML(request);
			super.execute(Command.pollchat, xml);
		} catch (Exception e) {
			((Chat) activity).enableButton();
			((Chat) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
		}
	}
	
	@Override
	public void onPostExecute(String result) {
		try {
			PollChatResponse response = (PollChatResponse) parseXML(result,
					PollChatResponse.class);

			String ec = response.getEc();
		 if(!(ec.equals( ErrorCode.ja.getError())))
			 {
			 	
			 	((Chat) activity).onError(ec);
			 	((Chat) activity).enableButton();
			 }
			 else
			 {
				 ((Chat) activity).addNewMessages(response.getCm());
			 }
			
			
		} catch (Exception e) {
			((Chat) activity).enableButton();
			((Chat) activity).onConnectionError();
			Log.e("Error in  PollChatTask", e.toString());
			
		}
	}
}
