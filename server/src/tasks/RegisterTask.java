package tasks;

import java.util.ArrayList;

import model.Model;
import database2.ProfileChart;
import protocol.AbstractHandler;
import request.RegisterRequest;
import request.UpdateChartRequest;
import response.UpdateChartResponse;

public class RegisterTask extends AbstractHandler {
	public String handle(String httpBody){
		//gets the information from the request
		RegisterRequest request = (RegisterRequest)parseXML(httpBody,RegisterRequest.class);
		int age = request.getAge();
		String eMail = request.geteMail();
		String password =  request.getPassword();
		boolean pAge = request.isAgeVisible();
		boolean gender = request.isGender();
		return null;
//		
//		ArrayList<ProfileChart> antwort;
//		if(id>=0){
//	antwort= Model.getInstance().getCharts(id, gender, kstu, 0);
//		}else{
//		antwort = null;}
//		if(antwort !=null){
//			System.out.println("recieved Data UpdateProfilechart Task");
//		}
//		else{System.out.println("did not rechieve any data");}
//		
//		UpdateChartResponse response = new UpdateChartResponse(antwort);
//		return buildXML(response);
		}
}
