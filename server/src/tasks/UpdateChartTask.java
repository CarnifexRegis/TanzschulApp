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
		ArrayList<ProfileChart> antwort= Model.getInstance().getCharts(id, gender, kstu, 0);
		if(antwort !=null){
			System.out.println("recieved Data");
		}
		else{System.out.println("derp");}
		UpdateChartResponse response = new UpdateChartResponse(antwort);
		return buildXML(response);
	}
}
