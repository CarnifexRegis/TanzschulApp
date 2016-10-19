package tasks;

import java.util.ArrayList;

import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.PollChatRequest;
import response.PollChatResponse;
import database_utils.ChatMessage;

public class PollChatTask extends AbstractHandler{
	public String handle(String httpBody){
		//gets the information from the request
		PollChatRequest request = (PollChatRequest)parseXML(httpBody,PollChatRequest.class);
		int id = request.getId();
		Model m = Model.getInstance();
		String	ec;
		ArrayList<ChatMessage> ml;
		if(m.checkId(id)){
			ml=  m.PollChat(request.getCid(), request.getLm());
			
			if (ml == null){
				ml = new ArrayList<ChatMessage>();
				ec = ErrorCode.nf.getError();
				}else{
					ec = ErrorCode.ja.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			ml = new ArrayList<ChatMessage>();
		}
		PollChatResponse response = new PollChatResponse(ec , ml);
		return buildXML(response);
	}
}
