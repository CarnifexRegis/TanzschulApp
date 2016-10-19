package tasks;

import database_utils.SQLKurs;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.AAddKursRequest;
import response.AAddKursResponse;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 * Returns an Error String encoded to xml
 */
public class AAddKursTask extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody){
		//gets the information from the request
		AAddKursRequest request = (AAddKursRequest)parseXML(httpBody,AAddKursRequest.class);
		int uid = request.getId();
		SQLKurs kurs  = request.getKurs();
		String	ec;
		Model m = Model.getInstance();
		if(m.checkAdmin(uid)){
			
			
			if (m.aAddKurs(kurs)){
				ec = ErrorCode.ja.getError();
				
				}else{
				ec = ErrorCode.nf.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			
		}
		AAddKursResponse response = new AAddKursResponse(ec );
		return buildXML(response);
	}
}
