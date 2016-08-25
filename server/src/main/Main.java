package main;


import model.Model;
import database2.SQL;
import server.TServer;




/**
 * 
 * @author Simon
 * @attribute The Java Application "Server get´s started from this Class wich contains an instance of TServer"
 * @Source: 
 *			https://www.eclipse.org/jetty/documentation/9.3.x/jetty-config-guide.html
 *			http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 */
public class Main {
	

//	static SQL sql;
	public static void main(String[] args) {
		Model.getInstance(); 
	//	sql = new SQL();
	//
	TServer server = new TServer();
	
		
		
		
		 
}
	}
