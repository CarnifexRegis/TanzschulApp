package tasks;

import java.util.ArrayList;

import database_utils.ProfileChart;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.UpdateChartRequest;
import response.UpdateChartResponse;
// TODO: Auto-generated Javadoc

/**
 * @author Simon Stolz
 * The Class UpdateChartTask.
 */
// sc update 
public class UpdateChartTask extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody){
		//gets the information from the request
		UpdateChartRequest request = (UpdateChartRequest)parseXML(httpBody,UpdateChartRequest.class);
		int id = request.getId();
		boolean gender = request.isGender();
		int  kstu = request.getKursstufe();
		int day = request.getDay();
		ArrayList<ProfileChart> antwort;
		String ec;
		
		// TODO add possibility to ad Day Filter
		
		 Model m = Model.getInstance();
		 if(m.checkId(id)){
			 antwort= m.getCharts( gender, kstu, 0,day);
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
