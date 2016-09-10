package oldExampels;

import protocol.AbstractHandler;
import request.GetAllRequest;


// TODO: Auto-generated Javadoc
/**
 * The Class GetAllTask.
 */
public class GetAllTask extends AbstractHandler  {
	
	/* (non-Javadoc)
	 * @see protocol.AbstractHandler#handle(java.lang.String)
	 */
	public String handle(String httpBody)
	{
		GetAllRequest request = (GetAllRequest)parseXML(httpBody, GetAllRequest.class);
		System.out.println("Request: " + request);
		
		String antwort = "Der GetAllRequest mit der id " + request.getId() + " wurde empfangen.";
		
		GetAllResponse response = new GetAllResponse(antwort);
		
		return buildXML(response);

	}

	
	}
