package tasks;

import java.util.ArrayList;

import protocol.AbstractHandler;
import model.Model;
import request.LoginRequest;
import response.LoginResponse;
import database2.ProfileChart;

public class LoginTask extends AbstractHandler {
	public String handle(String httpBody){
		//gets the information from the request
		LoginRequest request = (LoginRequest)parseXML(httpBody,LoginRequest.class);
		String key = request.getKey();
		String eMail = request.geteMail();
		Model m = Model.getInstance();
		int  id = m.Login(eMail, key);
		int gender = m.getGender(id);
		if(id >= 0 && gender == 1 || gender == 0 ){
			System.out.println("recieved Data UpdateProfilechart Task");
		}
		else{System.out.println("did not rechieve any data");}
		
		LoginResponse response = new LoginResponse(id, gender);
		return buildXML(response);
	}
}
