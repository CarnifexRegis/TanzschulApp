package tasks;

import database2.ProfileData;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.ForeignProfileRequest;
import response.ForeignProfileResponse;

public class ForeignProfileTask extends AbstractHandler{
	String ec;
	public String handle(String httpBody){
		//gets the information from the request
		ForeignProfileRequest request = (ForeignProfileRequest)parseXML(httpBody,ForeignProfileRequest.class);
		String idp = request.geteMail();
		 
		ProfileData pd = Model.getInstance().getfProfile(idp);
		ec = ErrorCode.ja.getError();
		if (pd==null){
			pd = new ProfileData();
			ec = ErrorCode.nf.getError();
		}else{
			if(!pd.isPa()){
				pd.setAge(0);
			}
			if(pd.getpText()== null){
				pd.setpText("Nicht angegeben."); 
			}
		}
		
		ForeignProfileResponse response = new ForeignProfileResponse(pd,ec);
		return buildXML(response);
	}
}

