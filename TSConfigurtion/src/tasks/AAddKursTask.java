package tasks;

import model.SQLKurs;
import protocol.Command;
import protocol.ErrorCode;
import request.AAddKursRequest;
import response.AAddKursResponse;
import android.util.Log;

import com.example.tsconfigurtion.AddKurs;
// TODO: Auto-generated Javadoc

/**
 * The Class AAddKursTask.
 *
 * @author Simon Stolz
 * @attribute This Handler builts an Request to add a new Kurs object to the servers database
 * 				if it reaches the server it recieves  an error String response
 */
public class AAddKursTask extends BaseHttpRequestTask {
	
	/** The id. */
	private int id;
	
	/** The kurs. */
	private SQLKurs kurs;
	
	
	/**
	 * Instantiates a new a add kurs task.
	 *
	 * @param ak the ak
	 * @param id the id
	 * @param kurs the kurs
	 */
	public AAddKursTask(AddKurs ak, int id, SQLKurs kurs) {
		super(ak);
		this.id = id;
		this.kurs = kurs;
	}
	
	/**
	 * Execute.
	 */
	public void execute() {
		AAddKursRequest request = new AAddKursRequest(kurs, id);

		try {
			String xml = buildXML(request);
			super.execute(Command.addkurs, xml);
		} catch (Exception e) {
			((AddKurs) activity).enableAddButton();
			((AddKurs) activity).onConnectionError();
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
			AAddKursResponse response = (AAddKursResponse) parseXML(result,
					AAddKursResponse.class);
			String ec = response.getEc();
			 if(!(ec.equals(ErrorCode.ja.getError())))
			 {
				 ((AddKurs) activity).enableAddButton();
				 ((AddKurs) activity).onError(ec);
			 }
			 else
			 {
				
					((AddKurs) activity).onAddSucces();
			 }
			
			
		} catch (Exception e) {
			((AddKurs) activity).enableAddButton();
			((AddKurs) activity).onConnectionError();
			Log.e("Error in  AAddKursTask", e.toString());
			
		}
	}
}
