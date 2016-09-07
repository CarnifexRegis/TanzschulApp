package tasks;

import java.util.ArrayList;

import database2.ProfileChart;
import model.Model;
import protocol.AbstractHandler;
import request.UpdateChartRequest;
import response.UpdateChartResponse;

public class UpdateChartTask extends AbstractHandler {
	public String handle(String httpBody){
		//gets the information from the request
		UpdateChartRequest request = (UpdateChartRequest)parseXML(httpBody,UpdateChartRequest.class);
		int id = request.getId();
		boolean gender = request.isGender();
		int  kstu = request.getKursstufe();
		int day = request.getDay();
		ArrayList<ProfileChart> antwort;
		
		
		// TODO add possibility to ad Day Filter
		
		
		antwort= Model.getInstance().getCharts(id, gender, kstu, 0,day);
		
		
		if(antwort !=null){
			System.out.println("recieved Data UpdateProfilechart Task");
		}
		
		else{System.out.println("did not rechieve any data");
		antwort = new ArrayList<ProfileChart>();
		}

		UpdateChartResponse response = new UpdateChartResponse(antwort);
		return buildXML(response);
	}
}
