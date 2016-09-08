package tasks;

import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;

import request.UpdateLinkRequest;
import response.UpdateLinkResponse;
//ec Update
public class UpdateLinkTask extends AbstractHandler {
	String ec;
	public String handle(String httpBody){
		//gets the information from the request
		UpdateLinkRequest request = (UpdateLinkRequest)parseXML(httpBody,UpdateLinkRequest.class);
		
		int uid = request.getUid();
		int kid = request.getKid();
		Model m = Model.getInstance();
		 if (m.checkId(uid)){
			 ec = ErrorCode.ja.getError();
			 if (request.getcommand()){
				 if (!m.addLink(uid, kid)){
					 ec = ErrorCode.ae.getError();
				 }
			 }else{
				 if (!m.deleteLink(uid, kid)){
					ec = ErrorCode.ae.getError();
				 }
			 }
		 }else{
			 ec = ErrorCode.wl.getError();
		 }
		
		
		UpdateLinkResponse response = new UpdateLinkResponse(ec);
		return buildXML(response);
	}

}
