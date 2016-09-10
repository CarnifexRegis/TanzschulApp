package tasks;

import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.ALoginRequest;

import response.ALoginResponse;


// TODO: Auto-generated Javadoc
/**
 * The Class ALoginTask.
 */
public class ALoginTask extends AbstractHandler{
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody){
		//gets the information from the request
		ALoginRequest request = (ALoginRequest)parseXML(httpBody,ALoginRequest.class);
		String key = request.getKey();
		String name = request.getname();
		Model m = Model.getInstance();
		String ec;
		int  id = m.aLogin(name, key);
		
		if (id >= 0){
			ec = ErrorCode.ja.getError();
		}else{
			if(id == -1){
				
				ec = ErrorCode.wl.getError();
			}else{
				
				ec = ErrorCode.nf.getError();
			}
		}
		
		
		
		ALoginResponse response = new ALoginResponse(id,ec);
		return buildXML(response);
	}
	}

