package server;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import protocol.Command;
import tasks.GetAllTask;




public class THandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		baseRequest.setHandled(true);

		Command command = Command.fromString(request.getParameter("do"));
		String body = getHttpBody(request);

		String antwort = "<h1>Fehler!<h1>";
		
		
		if (command != null) {
			
			switch (command) {
			case getall:
				GetAllTask getalltask = new GetAllTask();
				System.out.println("Body: " + body);
				antwort = getalltask.handle(body);
				break;
			case register:
				// RegisterTask registertask = new RegisterTask();
				//antwort = getalltask.handle(body);
				break;
			case login:
				//LoginTask logintask = new LoginTask();
				//antwort = logintask.handle(body);
				break;
			case updatechart:
				//UpdateChartTask ucharttask = new UpdateChartTask();
				//antwort = ucharttask.handle(body);
				break;
			case updateprofile:
				//UpdateProfileTask uprofiletask = new UpdateProfileTask();
				//antwort = uprofiletask.handle(body);
				break;
			case getprofile:
				//GetProfileTask gprofiletask = new UpdateProfileZask();
			//	antwort = uprofiletask.handle(body);
				break;
			default:

				

			}

		}
		response.getWriter().println(antwort);

	}

	private String getHttpBody(HttpServletRequest request) {

		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = null;

		try {
			// InputStream inputStream = request.getInputStream();
			// inputStream.available();
			// if (inputStream != null) {
			bufferedReader = request.getReader(); // new BufferedReader(new
													// InputStreamReader(inputStream));
			char[] charBuffer = new char[128];
			int bytesRead;
			while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
				sb.append(charBuffer, 0, bytesRead);
			}
			// } else {
			// sb.append("");
			// }

		} catch (IOException ex) {
			return ""; // TODO Error-Handling!
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					return ""; // TODO Error-Handling!
				}
			}
		}

		return sb.toString();
	}

}
