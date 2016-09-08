package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Model;
import server.TServer;
/**
 * 
 * @author Simon
 * @attribute The Java Application "Server get´s started from this Class wich contains an instance of TServer"
 * @Source: 
 *			https://www.eclipse.org/jetty/documentation/9.3.x/jetty-config-guide.html
 *			http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 *			http://stackoverflow.com/questions/14981435/how-do-i-stop-jetty
 *			http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
 *			http://stackoverflow.com/questions/3195666/how-to-place-a-jbutton-at-a-desired-location-in-a-jframe-using-java
 *			http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
 *			Everything that hast todo with threads: http://www.vogella.com/tutorials/JavaConcurrency/article.html#threads-in-java
 *			http://stackoverflow.com/questions/10961714/how-to-properly-stop-the-thread-in-java
 *			http://stackoverflow.com/questions/13662618/how-to-add-text-to-jframe
 */

public class Main  {
		static JFrame frame = new JFrame("Server Control");
		JPanel myPanel ;
		JButton btnStartServer ;
		JButton btnStopServer ;
		Thread sThread = null;
		TServer server ;
		
		
		
		/** @attribute The constructor of the main class creates a Jlabel 
		 * which can be used to start and stop the server and also add new admin logins
		 * 
		 */
	  public Main() {
			//Model.getInstance(); 
			 myPanel = new JPanel();
			 btnStartServer = new JButton("Start Server");
			 btnStopServer = new JButton("Stop Server");
			 server = new TServer();
	        /**
	         * Set bounds of the Buttons and J Pannel
	         */
			btnStartServer.setBounds(0, 400, 200, 30);
			btnStopServer.setBounds(210, 400, 200, 30);
			myPanel.setBounds(800, 800, 200, 100);

	        // Adding to JFrame
	       myPanel.add(btnStartServer);
	       myPanel.add(btnStopServer);
	        frame.add(myPanel);
	        
	        //http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
	        /**
	         * on action performed this class starts the server
	         */
	        btnStartServer.addActionListener(new ActionListener()
	        {
	          public void actionPerformed(ActionEvent e)
	          {
	            
	        	  //http://www.vogella.com/tutorials/JavaConcurrency/article.html#threads-in-java
	        	 //http://stackoverflow.com/questions/13538668/stop-thread-and-again-start-giving-illegalthreadstateexception-in-blackberry
	        	 Runnable runServer  = new Runnable() {
					
					@Override
					public void run() {
						server.startServer();
						
					}
				};
	        	  if(sThread== null){
	        	  sThread = new Thread(runServer);
	        	  sThread.setName("ServerThread");
	        	  sThread.start();
	        	  JOptionPane.showMessageDialog(null, "The Server was sucessfully initialized!","Server Started", JOptionPane.WARNING_MESSAGE);
	        	 }else{
	        		if(!sThread.isAlive()){
	        			sThread = new Thread(runServer);
	  	        	  	sThread.setName("ServerThread");
	  	        	  	sThread.start();
	   	        	  	JOptionPane.showMessageDialog(null, "Server running again","Server Started", JOptionPane.WARNING_MESSAGE);
	   	        	  	
	   	        	  	 }else{
	   	        	  	JOptionPane.showMessageDialog(null, "Server already runnging","Server Started", JOptionPane.WARNING_MESSAGE);
	   	        	  		 
	   	        	  	 }
	        	 }

	          }
	        });
	        btnStopServer.addActionListener(new ActionListener()
	        {
	          public void actionPerformed(ActionEvent e)
	          {
	        	  //http://www.vogella.com/tutorials/JavaConcurrency/article.html#threads-in-java
	        	 // http://stackoverflow.com/questions/10961714/how-to-properly-stop-the-thread-in-java
	        	  try{
	        		 // sThread.interrupt();
	        		  if(!(sThread == null)){
	        			 
	        			  server.stopServer();
	        			  sThread.join();
	        		 
	        		  JOptionPane.showMessageDialog(null, "Server sucessfully stopped by User","Server Stopped", JOptionPane.WARNING_MESSAGE);
	        		  
	        		  }else{
	        			  JOptionPane.showMessageDialog(null, "Server has already been stopped","Server Stopped", JOptionPane.WARNING_MESSAGE);
	        			  
	        		  }
	        	  }catch(Exception ex){
	        		  ex.printStackTrace();
	        		
	        	  }
    
	          }
	        });
	        // JFrame properties
	        frame.setSize(400, 400);
	        frame.setBackground(Color.BLACK);
	       
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	  //http://stackoverflow.com/questions/10161149/android-like-toast-in-swing
	 

	public static void main(String[] args) {
		new Main();
		Model.getInstance(); 	 
}
	}
