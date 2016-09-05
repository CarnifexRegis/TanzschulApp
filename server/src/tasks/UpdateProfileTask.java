package tasks;
import model.Model;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.UpdateProfileRequest;
import response.UpdateProfileResponse;
public class UpdateProfileTask extends AbstractHandler {
	
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
			succes= Model.getInstance().UpdateProfile(id, pn, height, age, pText, pa);
		
			if(succes){
			ec = ErrorCode.ja.getError();
			System.out.println("Updated Profiledata");
			}else{
				ec = ErrorCode.nf.getError();
				System.out.println("Update failed");}
			
			UpdateProfileResponse response = new UpdateProfileResponse(ec);
			return buildXML(response);
		}
	}
