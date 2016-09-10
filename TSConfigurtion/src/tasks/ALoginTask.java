package tasks;

import com.example.tsconfigurtion.Login;

import protocol.Command;
import protocol.ErrorCode;
import request.ALoginRequest;
import response.ALoginResponse;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class ALoginTask.
 */
public class ALoginTask extends BaseHttpRequestTask{

	private String name;
	private String key ;
	
	/**
	 * Instantiates a new a login task.
	 *
	 * @param login the login
	 * @param name the name
	 * @param key the key
	 */
	public ALoginTask(Login login,String name, String key) {
		super(login);
		this.name = name;
		this.key = key;
		
		
	}
	
	/**
	 * Execute.
	 */
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
	 * After recieving the gender and the id from the server they get  passed to the login Activity.
	 *
	 * @param result the result
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
