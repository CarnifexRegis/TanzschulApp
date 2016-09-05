package tasks;
import model.Model;
import database2.ProfileData;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.ProfileDataRequest;
import response.ProfileDataResponse;

public class ProfiledataTask extends AbstractHandler {

	public String handle(String httpBody){
		//gets the information from the request
		ProfileDataRequest request = (ProfileDataRequest)parseXML(httpBody,ProfileDataRequest.class);
		int id = request.getId();
		
		ProfileData pd;
		String error = ErrorCode.ja.getError();
		pd= Model.getInstance().getProfileData(id);
	if(pd == null){
		error = ErrorCode.wl.getError();
	}
	if(pd.getpText()== null){
		pd.setpText("jklenedhdsuzhfsdhfdsfh9sdhfsdd9fhfd");
	}
	if(pd.getPhoneNumber()== null){
		pd.setPhoneNumber("Nicht Eingetragen");
	}
		
		
		ProfileDataResponse response = new ProfileDataResponse(pd, error);
		return buildXML(response);
	}

}
