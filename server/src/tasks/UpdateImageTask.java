package tasks;

import java.util.ArrayList;
import java.util.Base64;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import model.Model;
import database2.ProfileChart;
import protocol.AbstractHandler;
import protocol.ErrorCode;
import request.UpdateChartRequest;
import request.UpdateImageRequest;
import response.UpdateChartResponse;

public class UpdateImageTask extends AbstractHandler{
	public String handle(String httpBody){
		//gets the information from the request
		UpdateImageRequest request = (UpdateImageRequest)parseXML(httpBody,UpdateImageRequest.class);
		int id = request.getId();
		String base64 = request.getBase64();
		ArrayList<ProfileChart> antwort;
		String ec;
		byte[] decoded = Base64.getDecoder().decode(base64);
		Bitmap bitmap = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
		// TODO add possibility to ad Day Filter
		
		 Model m = Model.getInstance();
		 if(m.checkId(id)){
			 antwort= m.
			 	if(antwort == null){
			 		antwort = new ArrayList<ProfileChart>();
			 		ec  = ErrorCode.nf.getError();
			 	}else{
			 		ec = ErrorCode.ja.getError();
			 	}
		 	}else{
		 		ec = ErrorCode.wl.getError();
		 		antwort = new ArrayList<ProfileChart>();
		 		}
		UpdateChartResponse response = new UpdateChartResponse(antwort,ec);
		return buildXML(response);
	}
}
