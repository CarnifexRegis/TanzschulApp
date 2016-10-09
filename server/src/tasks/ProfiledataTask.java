package tasks;
import model.Model;
import database2.ProfileData;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.ProfileDataRequest;
import response.ProfileDataResponse;


/**
 * @author Simon Stolz
 * The Class ProfiledataTask.
 */
public class ProfiledataTask extends AbstractHandler {

	public String handle(String httpBody){
		//gets the information from the request
		ProfileDataRequest request = (ProfileDataRequest)parseXML(httpBody,ProfileDataRequest.class);
		int id = request.getId();
		
		ProfileData pd;
		String ec;
		Model m = Model.getInstance();
		if(m.checkId(id)){
			pd= m.getProfileData(id);
			if(pd == null){
				pd = new ProfileData();
				ec = ErrorCode.nf.getError();
			}else{
				ec = ErrorCode.ja.getError();
				if(pd.getpText()== null){
					pd.setpText("Nicht Eingetragen");
					}
				if(pd.getPhoneNumber()== null){
					pd.setPhoneNumber("Nicht Eingetragen");
					}
			}
		}else{
			pd = new ProfileData();
			ec = ErrorCode.wl.getError();
		}
		
		ProfileDataResponse response = new ProfileDataResponse(pd, ec);
		return buildXML(response);
	}

}
