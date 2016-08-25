package task;



import protocol.Command;
import protocol.ErrorCode;
import request.RegisterRequest;
import response.LoginResponse;
import response.RegisterResponse;
import activitys.LogIn;
import activitys.Registration;
import android.util.Log;


public class RegisterTask  extends BaseHttpRequestTask{
	
	String eMail;
	String password;
	int age;
	boolean gender;
	boolean ageVisible;
	public RegisterTask(Registration r , String eMail, String password,
			int age, boolean gender, boolean ageVisible) {
		super(r);
		this.eMail = eMail;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.ageVisible = ageVisible;
	}
	public void execute() {
		RegisterRequest request = new RegisterRequest(eMail,  password,  age,  gender,
				 ageVisible);

		try {
			String xml = buildXML(request);
			super.execute(Command.register, xml);
		} catch (Exception e) {
			((Registration) activity).connectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/exceuting command");
		}
	}
	@Override
	public void onPostExecute(String result) {
		try {
			RegisterResponse response = (RegisterResponse) parseXML(result,
					RegisterResponse.class);
			
			String error =response.getError();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
					((Registration) activity).onError(error);
			 }
			 else
			 {
			
			int id = response.getId();
			
			
			((Registration) activity).getLoginValues(response.getId());
			 }
			// }
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
		}
	}

}
