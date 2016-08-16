package tasks;

import protocol.AbstractHandler;
import request.GetAllRequest;
import response.GetAllResponse;


public class GetAllTask extends AbstractHandler  {
	
	public String handle(String httpBody)
	{
		GetAllRequest request = (GetAllRequest)parseXML(httpBody, GetAllRequest.class);
		System.out.println("Request: " + request);
		
		String antwort = "Der GetAllRequest mit der id " + request.getId() + " wurde empfangen.";
		
		GetAllResponse response = new GetAllResponse(antwort);
		
		return buildXML(response);

	}

	
	}
