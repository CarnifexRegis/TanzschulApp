package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
/**
 * 
 * @author Simon Stolz
 * Sources: http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 * @attribute This is my Server Class it contains Jetty server that is hosted on  192.168.1.104
 */
public class TServer {
	/**
	 * 
	 */
	public TServer(){
			
		 
		/**
		 * Instanziert einen Jetty-Webserver, der später auf Port 8080 horchen soll
		 */
		 Server server = new Server();
		 
		

	        // HTTP connector
	        ServerConnector http = new ServerConnector(server);
	         http.setHost("192.168.1.105");
	        
	       // http.setHost("localhost");
	        http.setPort(8080);
	        http.setIdleTimeout(30000);

	        // Set the connector
	        server.addConnector(http);

	   
	       
	    
		 	/**
		 	 * Bei jedem Request wird vom Webserver die handle-Methode der Handler-Klasse MyHandler aufgerufen. 
		 	 * For every incoming Request the handle-method of the THandler Class gets called.
		 	 */
		    server.setHandler(new THandler());
		    System.out.println(server.getURI());
 
		    try {
		    	/**
		    	 * Starten des Webservers
		    	 * This starts the Server
		    	 */
				server.start();;
				server.join();;	
					
			} catch (Exception e) {
 
				e.printStackTrace();
			}
	}
 
}

