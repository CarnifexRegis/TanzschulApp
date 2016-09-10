package task;



import protocol.Command;
import protocol.ErrorCode;
import request.RegisterRequest;
import response.LoginResponse;
import response.RegisterResponse;
import activitys.LogIn;
import activitys.Registration;
import android.util.Log;


// TODO: Auto-generated Javadoc
/**
 * The Class RegisterTask.
 */
public class RegisterTask  extends BaseHttpRequestTask{
	
	private String eMail;
	private String password;
	private int age;
	private boolean gender;
	private boolean ageVisible;
	private String fn;
	private String ln;
	
	/**
	 * Instantiates a new register task.
	 *
	 * @param r the r
	 * @param fn the fn
	 * @param ln the ln
	 * @param eMail the e mail
	 * @param password the password
	 * @param age the age
	 * @param gender the gender
	 * @param ageVisible the age visible
	 */
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
	
	/**
	 * Execute.
	 */
	public void execute() {
		RegisterRequest request = new RegisterRequest(fn, ln,eMail,  password,  age,  gender,
				 ageVisible);

		try {
			String xml = buildXML(request);
			super.execute(Command.register, xml);
		} catch (Exception e) {
			((Registration) activity).onConnectionError();
			// FIXME Errorhandling
			System.out.println("An error occured bulding the xml/exceuting command");
		}
	}
	
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
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
				 ((Registration) activity).getLoginValues(response.getId());
			 }
			
		} catch (Exception e) {
			((Registration) activity).onConnectionError();
			Log.e("Error in  LoginTask", e.toString());
		}
	}

}
