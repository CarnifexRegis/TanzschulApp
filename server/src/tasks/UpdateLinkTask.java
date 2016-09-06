package tasks;

import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;

import request.UpdateLinkRequest;
import response.UpdateLinkResponse;

public class UpdateLinkTask extends AbstractHandler {
	String ec;
	public String handle(String httpBody){
		//gets the information from the request
		UpdateLinkRequest request = (UpdateLinkRequest)parseXML(httpBody,UpdateLinkRequest.class);
		int uid = request.getUid();
		int kid = request.getKid();
		 ec = ErrorCode.ja.getError();
		 if (request.getcommand()){
			 if (!Model.getInstance().addLink(uid, kid)){
			ec = ErrorCode.ae.getError();
		}
		 }else{
			 if (!Model.getInstance().deleteLink(uid, kid)){
					ec = ErrorCode.ae.getError();
				}
		 }
		
		
		
		UpdateLinkResponse response = new UpdateLinkResponse(ec);
		return buildXML(response);
	}

}
