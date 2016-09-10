package tasks;

import protocol.AbstractHandler;
import protocol.ErrorCode;
import model.Model;
import request.LoginRequest;
import response.LoginResponse;
// TODO: Auto-generated Javadoc

/**
 * The Class LoginTask.
 */
//sec update
public class LoginTask extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	// TODO add errorCode
	public String handle(String httpBody){
		//gets the information from the request
		LoginRequest request = (LoginRequest)parseXML(httpBody,LoginRequest.class);
		String key = request.getKey();
		String eMail = request.geteMail();
		Model m = Model.getInstance();
		String ec;
		int  id = m.Login(eMail, key);
		int gender ;
		if (id >= 0){
			gender = m.getGender(id);
			try{
				if( gender == 1 || gender == 0 ){
					ec = ErrorCode.ja.getError();
				}else{
					ec = ErrorCode.nf.getError();
				}
			}catch(Exception ex){
				gender = 0;
				ec = ErrorCode.nf.getError();
				ex.printStackTrace();
			}
		}else{
			if(id == -1){
				gender = 0;
				ec = ErrorCode.wl.getError();
			}else{
				gender = 0;
				ec = ErrorCode.nf.getError();
			}
		}
		
		
		
		LoginResponse response = new LoginResponse(id, gender,ec);
		return buildXML(response);
	}
}
