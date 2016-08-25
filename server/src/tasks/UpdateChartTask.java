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
		ArrayList<ProfileChart> antwort;
		if(id>=0){
		antwort= Model.getInstance().getCharts(id, gender, kstu, 0);
		}else{
		antwort = null;}
		if(antwort !=null){
			System.out.println("recieved Data UpdateProfilechart Task");
		}
		else{System.out.println("did not rechieve any data");}
		
		UpdateChartResponse response = new UpdateChartResponse(antwort);
		return buildXML(response);
	}
}
