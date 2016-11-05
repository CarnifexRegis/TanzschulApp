package task;

import protocol.Command;
import protocol.ErrorCode;
import request.LoginRequest;
import response.LoginResponse;
import activitys.LogIn;
import android.util.Log;
/**
 * This Task sends an LoginRequest
 * @author Simon Stolz
 */
public class LoginTask extends BaseHttpRequestTask{
	private String eMail;
	private String key ;
	
	/**
	 * Instantiates a new login task.
	 *
	 * @param login the login
	 * @param eMail the e mail
	 * @param key the key
	 */
	public LoginTask(LogIn login,String eMail, String key) {
		super(login);
		this.eMail = eMail;
		this.key = key;
		
		
	}
	
	public void execute() {
		LoginRequest request = new LoginRequest(eMail, key);

		try {
			String xml = buildXML(request);
			super.execute(Command.login, xml);
		} catch (Exception e) {
			((LogIn) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
		}
	}
	
	/**
	 * After recieving the gender and the id from the server they get  passed to the login Activity.
	 *
	 * @param result the result
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			LoginResponse response = (LoginResponse) parseXML(result,
					LoginResponse.class);
			String ec = response.getEc();
			 if(!(ec.equals(ErrorCode.ja.getError())))
			 {
				 ((LogIn) activity).onError(ec);
			 }
			 else
			 {
				 int intGender = response.getGender();
				 boolean gender; 
					if (intGender==1){
						gender = true;
					}else
						if(intGender==0){
							gender = false;
						}
						else{
							gender = false;
						// TODO error handling
						}
					((LogIn) activity).getLoginValues(response.getId(),gender);
			 }
			
			
		} catch (Exception e) {
			((LogIn) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
			
		}
	}

}
