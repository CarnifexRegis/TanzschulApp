package tasks;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.SendMessageRequest;
import response.SendMessageResponse;

public class SendMessageTask extends AbstractHandler{
	public String handle(String httpBody){
		//gets the information from the request
		SendMessageRequest request = (SendMessageRequest)parseXML(httpBody,SendMessageRequest.class);
		int id = request.getId();
		Model m = Model.getInstance();
		String	ec;
		
		if(m.checkId(id)){
			if(m.addMessage(request.getCid(), request.getId(), request.getMessage())){
				ec = ErrorCode.ja.getError();
			}else{
				ec = ErrorCode.nf.getError();
			}	
	}else{
		ec = ErrorCode.nf.getError();
	}
		SendMessageResponse response = new SendMessageResponse(ec);
		return buildXML(response);
		}
	
}
	


