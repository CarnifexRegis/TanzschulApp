package task;

import protocol.Command;
import request.LoginRequest;
import response.LoginResponse;
import activitys.LogIn;
import android.util.Log;

public class LoginTask extends BaseHttpRequestTask{

	private String eMail;
	private String key ;
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
			((LogIn) activity).connectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/exceuting command");
		}
	}
	/**
	 * After recieving the gender and the id from the server they get  passed to the login Activity
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			LoginResponse response = (LoginResponse) parseXML(result,
					LoginResponse.class);
			
			// if(!(response.getEc() == ErrorCode.ok))
			// {
			//
			// }
			// else
			// {
			// Antwort erfolgreich erhalten
			int intGender = response.getGender();
			boolean gender; 
			if (intGender==1){
				gender = true;
			}else
				if(intGender== 0){
					gender = false;
				}else{
					gender = false;
					System.out.println("Your Gender was not properly recieved from the server and set male as default");
				}
			((LogIn) activity).getLoginValues(response.getId(),gender);

			// }
		} catch (Exception e) {
			Log.e("Error in  LoginTask", e.toString());
		}
	}

}
