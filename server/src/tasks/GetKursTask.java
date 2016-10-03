package tasks;

import java.util.ArrayList;

import database2.Kurs;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.GetKursRequest;
import response.GetKursResponse;
/**
 * @author Simon Stolz
 * The Class GetKursTask.
 */
public class GetKursTask extends AbstractHandler {
	
	public String handle(String httpBody){
		//gets the information from the request
		GetKursRequest request = (GetKursRequest)parseXML(httpBody,GetKursRequest.class);
		int id = request.getId();
		int ks = request.getKursStufe();
		Model m = Model.getInstance();
		String	ec;
		ArrayList<Kurs> kl;
		if(m.checkId(id)){
			kl= m.getKurs(id,ks);
			
			if (kl == null){
				kl = new ArrayList<Kurs>();
				ec = ErrorCode.nf.getError();
				}else{
					ec = ErrorCode.ja.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			kl = new ArrayList<Kurs>();
		}
		GetKursResponse response = new GetKursResponse(ec , kl);
		return buildXML(response);
	}
}
