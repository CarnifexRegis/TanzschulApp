package tasks;

import java.util.ArrayList;

import model.Model;
import database_utils.ProfileChart;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.UpdateImageRequest;
import response.UpdateChartResponse;

public class UpdateImageTask extends AbstractHandler{
	// TODO Work in Progress
	public String handle(String httpBody){
		//gets the information from the request
		UpdateImageRequest request = (UpdateImageRequest)parseXML(httpBody,UpdateImageRequest.class);
		int id = request.getId();
		String base64 = request.getBase64();
		ArrayList<ProfileChart> antwort;
		String ec;
		// TODO add possibility to ad Day Filter
		
		 Model m = Model.getInstance();
		 if(m.checkId(id)){
			 antwort= null;
			 	if(antwort == null){
			 		antwort = new ArrayList<ProfileChart>();
			 		ec  = ErrorCode.nf.getError();
			 	}else{
			 		ec = ErrorCode.ja.getError();
			 	}
		 	}else{
		 		ec = ErrorCode.wl.getError();
		 		antwort = new ArrayList<ProfileChart>();
		 		}
		UpdateChartResponse response = new UpdateChartResponse(antwort,ec);
		return buildXML(response);
	}
}
