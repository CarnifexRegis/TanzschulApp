package tasks;

import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.ADeleteRequest;
import response.ADeleteResponse;


// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 * The Class ADeleteTask.
 */
public class ADeleteTask extends AbstractHandler{
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody){
		//gets the information from the request
		ADeleteRequest request = (ADeleteRequest)parseXML(httpBody,ADeleteRequest.class);
		int uid = request.getAid();
		int kid = request.getKid();
		Model m = Model.getInstance();
		String	ec;
		
		if(m.checkAdmin(uid)){
			
			
			if (m.deleteKurs(kid)){
				ec = ErrorCode.ja.getError();
				
				}else{
				ec = ErrorCode.nf.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			
		}
		ADeleteResponse response = new ADeleteResponse(ec );
		return buildXML(response);
	}


}
