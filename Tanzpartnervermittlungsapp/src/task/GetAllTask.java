package task;
/**
 * @author Simon Stolz, Martin Pabst
 * Sources:	http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 *			Abi Quiz-App by Tim Möschel
 */
import protocol.Command;
import response.GetAllResponse;
import activitys.Menue;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public class GetAllTask extends BaseHttpRequestTask {
	private int userID;

	/**
	 * Instantiates a new gets the all task.
	 *
	 * @param menue the menue
	 * @param userID the user ID
	 */
	public GetAllTask(Menue menue, int userID) {
		super(menue);
		this.userID = userID;
	}
	
	public void execute() {
	//	GetAllRequest request = new GetAllRequest(userID);

		try {
			String xml = null;
			super.execute(Command.getall, xml);
		} catch (Exception e) {
		Log.e("Request", e.toString());
		e.printStackTrace();
	}
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	public void onPostExecute(String result) {
		try {
			GetAllResponse response = (GetAllResponse) parseXML(result,
					GetAllResponse.class);
//			
//			// if(!(response.getEc() == ErrorCode.ok))
//			// {
//			//
//			// }
//			// else
//			// {
//			// Antwort erfolgreich erhalten
//
			((Menue) activity).testAusgabe(response.getText());
//			// }
		} catch (Exception e) {
			Log.e("test", e.toString());
		}
	}
}
