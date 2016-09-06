package tasks;

import java.util.ArrayList;

import database2.Kurs;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.GetKursRequest;
import response.GetKursResponse;

public class GetKursTask extends AbstractHandler {
	public String handle(String httpBody){
		//gets the information from the request
		GetKursRequest request = (GetKursRequest)parseXML(httpBody,GetKursRequest.class);
		int id = request.getId();
		int ks = request.getKursStufe();
		Model m = Model.getInstance();
		ArrayList<Kurs> kl= m.getKurs(id,ks);
		String	ec = ErrorCode.ja.getError();
		if (kl == null){
			kl = new ArrayList<Kurs>();
			 ec = ErrorCode.wl.getError();
		}
		
		GetKursResponse response = new GetKursResponse(ec , kl);
		return buildXML(response);
	}
}
