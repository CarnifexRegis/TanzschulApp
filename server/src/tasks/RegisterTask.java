package tasks;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.RegisterRequest;
import response.RegisterResponse;
// TODO: Auto-generated Javadoc

/**
 * @author Simon Stolz
 * The Class RegisterTask.
 */
//sc update n ot required
public class RegisterTask extends AbstractHandler {
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody){
		//gets the information from the request
		RegisterRequest request = (RegisterRequest)parseXML(httpBody,RegisterRequest.class);
		String fn = request.getFn();
		String ln = request.getLn();
		int age = request.getAge();
		String eMail = request.geteMail();
		String password =  request.getPassword();
		boolean pAge = request.isAgeVisible();
		boolean gender = request.isGender();
		int g;
		int pa;
		if(pAge){
			pa = 1;
		}else{
			pa = 0;
		}
		if(gender){
			 g = 1;
		}else{
			 g = 0;
		}
		String ec = null;
		int id = Model.getInstance().register(eMail, password, ln, fn, g, age, pa);
		if (id>0 ){
			ec = ErrorCode.ja.getError();
		}else{
			switch (id){
			case -1:
				ec = ErrorCode.ae.getError();
			break;
			case -2:
				ec = ErrorCode.nf.getError();
			break;
			
			
			}
		}
		
		RegisterResponse response = new RegisterResponse(ec,id);
		return buildXML(response);

		}
}
