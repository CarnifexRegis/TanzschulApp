package tasks;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.UpdateProfileRequest;
import response.UpdateProfileResponse;
// TODO: Auto-generated Javadoc

/**
 * @author Simon Stolz
 * The Class UpdateProfileTask.
 */
// ec update
public class UpdateProfileTask extends AbstractHandler {
	
		/* (non-Javadoc)
		 * @see protocol.AbstractHandler#handle(java.lang.String)
		 */
		public String handle(String httpBody){
			//gets the information from the request
			UpdateProfileRequest request = (UpdateProfileRequest)parseXML(httpBody,UpdateProfileRequest.class);
			int id = request.getId();
			String pn = request.getPn();
			int height = request.getHeight();
			int age = request.getAge();
			String pText = request.getpText();
			boolean pa = request.isPa();
			
			boolean succes;
			String ec;
			Model m = Model.getInstance();
			if (m.checkId(id)){
				succes= m.UpdateProfile(id, pn, height, age, pText, pa);
		
				if(succes){
					ec = ErrorCode.ja.getError();
					System.out.println("Updated Profiledata");
				}else{
					ec = ErrorCode.nf.getError();
					System.out.println("Update failed");}
			}else{
				ec = ErrorCode.wl.getError();
			}
			
			UpdateProfileResponse response = new UpdateProfileResponse(ec);
			return buildXML(response);
		}
	}
