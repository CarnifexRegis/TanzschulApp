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
	String fn;
	String ln;
	public RegisterTask(Registration r ,String fn, String ln, String eMail, String password,
			int age, boolean gender, boolean ageVisible) {
		super(r);
		this.eMail = eMail;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.ageVisible = ageVisible;
		this.fn = fn;
		this.ln = ln;
				
	}
	public void execute() {
		RegisterRequest request = new RegisterRequest(fn, ln,eMail,  password,  age,  gender,
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
			
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
		}
	}

}
