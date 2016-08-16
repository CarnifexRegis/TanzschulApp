package server;

import org.eclipse.jetty.server.Server;

import tasks.DefaultTask;

public class TServer {
	public TServer(){
		 
		/**
		 * Instanziert einen Jetty-Webserver, der später auf Port 8080 horchen soll
		 */
		 Server server = new Server(8080);
 
		 	/**
		 	 * Bei jedem Request wird vom Webserver die handle-Methode der Handler-Klasse MyHandler aufgerufen. 
		 	 */
		    server.setHandler(new THandler());
		    System.out.println(server.getURI());
 
		    try {
		    	/**
		    	 * Starten des Webservers
		    	 */
				server.start();
				server.join();	
					
			} catch (Exception e) {
 
				e.printStackTrace();
			}
	}
 
}

