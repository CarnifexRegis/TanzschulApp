package tasks;

import java.util.ArrayList;

import model.Model;
import database2.aKurs;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.AGetKursRequest;
import response.AGetKursResponse;

public class AGetKursTask extends AbstractHandler{

	public String handle(String httpBody){
		//gets the information from the request
		AGetKursRequest request = (AGetKursRequest)parseXML(httpBody,AGetKursRequest.class);
		int id = request.getId();
		int ks = request.getKursStufe();
		Model m = Model.getInstance();
		String	ec;
		ArrayList<aKurs> kl;
		if(m.checkAdmin(id)){
			kl= m.getaKurs(ks);
			
			if (kl == null){
				kl = new ArrayList<aKurs>();
				ec = ErrorCode.nf.getError();
				}else{
					ec = ErrorCode.ja.getError();
				}
		}else{
			ec  = ErrorCode.wl.getError();
			kl = new ArrayList<aKurs>();
		}
		AGetKursResponse response = new AGetKursResponse(ec , kl);
		return buildXML(response);
	}

}
