package tasks;

import database2.ProfileData;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.ForeignProfileRequest;
import response.ForeignProfileResponse;
// TODO: Auto-generated Javadoc

/**
 * @author Simon Stolz
 * The Class ForeignProfileTask.
 */
// sec update
public class ForeignProfileTask extends AbstractHandler{
	
	/** The ec. */
	String ec;
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody){
		//gets the information from the request
		ForeignProfileRequest request = (ForeignProfileRequest)parseXML(httpBody,ForeignProfileRequest.class);
		String idp = request.getIdp();
		int id = request.getId();
		 ProfileData pd;
		Model m = Model.getInstance();
		 if(m.checkId(id)){
			 
			 pd = m.getfProfile(idp);
			 if (pd==null){
				 	pd = new ProfileData();
				 	ec = ErrorCode.nf.getError();
			 }else{
				 ec = ErrorCode.ja.getError();
				 	if(!pd.isPa()){
				 		pd.setAge(0);
				 	}
				 	if(pd.getpText()== null){
				 		pd.setpText("Nicht angegeben."); 
				 	}
			 	}
		 }else{
			 pd = new ProfileData();
			 ec = ErrorCode.wl.getError();
		 }
		ForeignProfileResponse response = new ForeignProfileResponse(pd,ec);
		return buildXML(response);
	}
}

