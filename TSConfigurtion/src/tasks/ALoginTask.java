package tasks;

import com.example.tsconfigurtion.Login;

import protocol.Command;
import protocol.ErrorCode;
import request.ALoginRequest;
import response.ALoginResponse;
import android.util.Log;

public class ALoginTask extends BaseHttpRequestTask{

	private String name;
	private String key ;
	public ALoginTask(Login login,String name, String key) {
		super(login);
		this.name = name;
		this.key = key;
		
		
	}
	public void execute() {
		ALoginRequest request = new ALoginRequest(name, key);

		try {
			String xml = buildXML(request);
			super.execute(Command.alogin, xml);
		} catch (Exception e) {
			((Login) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
		}
	}
	/**
	 * After recieving the gender and the id from the server they get  passed to the login Activity
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			ALoginResponse response = (ALoginResponse) parseXML(result,
					ALoginResponse.class);
			String ec = response.getEc();
			 if(!(ec.equals(ErrorCode.ja.getError())))
			 {
				 ((Login) activity).onError(ec);
			 }
			 else
			 {
				
					((Login) activity).getLoginValues(response.getId());
			 }
			
			
		} catch (Exception e) {
			((Login) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
			
		}
	}

}
