package task;

import java.io.ByteArrayOutputStream;

import protocol.Command;
import protocol.ErrorCode;
import request.ForeignProfileRequest;
import request.UpdateImageRequest;
import response.ProfileDataResponse;
import activitys.EditProfile;
import activitys.ShowProfile;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
//http://stackoverflow.com/questions/9224056/android-bitmap-to-base64-string
public class UpdateImageTask extends BaseHttpRequestTask {
	Bitmap bm;
	String base64;
	int id;
	protected UpdateImageTask(EditProfile ep,Bitmap bm, int id) {
		super(ep);
		this.bm = bm;
		this.id = id;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
		bm.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
		byte[] byteArray = byteArrayOutputStream .toByteArray();


		base64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		UpdateImageRequest request = new UpdateImageRequest(base64,id);

		try {
			String xml = buildXML(request);
			super.execute(Command.updateimage, xml);
		} catch (Exception e) {
			((ShowProfile) activity).onConnectionError();
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
			ProfileDataResponse response = (ProfileDataResponse) parseXML(result,ProfileDataResponse.class);
			
			String error = response.getErrorCode();
			 if(!(error.equals( ErrorCode.ja.getError())))
			 {
				((ShowProfile) activity).onError(error);
			 }
			 else
			 {	 
				 ((ShowProfile) activity).rechieveData(response.getPd());
			 }
			
		} catch (Exception e) {
			Log.e("Error in  UpdateImage", e.toString());
			((ShowProfile) activity).onConnectionError();	
		}
	}
}
