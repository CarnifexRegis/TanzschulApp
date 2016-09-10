package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Model;
import server.TServer;
// TODO: Auto-generated Javadoc
/**
 * This is the Main calls it contain a JFrame by which the server can be controlled and configurated. 
 * Functions : 
 * Starting the Server 
 * Stopping the Server
 * Adding an Entry to Admin table 
 * displaying errors in an ErrorView
 * @author Simon Stolz
 * 
 * @Source  
 *			https://www.eclipse.org/jetty/documentation/9.3.x/jetty-config-guide.html
 *			http://www.pabst-software.de/doku.php?id=programmieren:java:android:httpclient:start
 *			http://stackoverflow.com/questions/14981435/how-do-i-stop-jetty
 *			http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
 *			http://stackoverflow.com/questions/3195666/how-to-place-a-jbutton-at-a-desired-location-in-a-jframe-using-java
 *			http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
 *			Everything that hast todo with threads: http://www.vogella.com/tutorials/JavaConcurrency/article.html#threads-in-java
 *			http://stackoverflow.com/questions/10961714/how-to-properly-stop-the-thread-in-java
 *			http://stackoverflow.com/questions/13662618/how-to-add-text-to-jframe
 *			http://stackoverflow.com/questions/9612096/i-want-to-make-a-text-field-editable-only-when-a-check-box-is-selected-in-netbea
 */

public class Main  {
	
	/** Declaration of the Objects that are needed for  the JFrame. */
		private static JFrame frame = new JFrame("Server Control");
		
		/** The my panel. */
		private JPanel myPanel ;
		
		/** The btn start server. */
		private JButton btnStartServer ;
		
		/** The btn stop server. */
		private JButton btnStopServer ;
		
		/** The btn add admin. */
		private JButton btnAddAdmin ;
		
		/** The s thread. */
		private Thread sThread = null;
		
		/** The server. */
		private TServer server ;
		
		/** The host text. */
		private final JTextField hostText;
		
		/** The a N text. */
		private final JTextField aNText;
		
		/** The a K text. */
		private final JTextField aKText;
		
		/** The error text. */
		private final JTextField errorText;
		
		/** The admin name. */
		private final JTextField adminName;
		
		/** The admin key 1. */
		private final JTextField adminKey1;
		
		/** The admin key 2. */
		private final JTextField adminKey2;
		
		/** The main. */
		private Main main = this;
		
		/** The Constant host. */
		static final  String host = "192.168.1.10X";
		
		
		
	  /**
  	 * Instantiates a new main.
  	 */
  	public Main() {
			/**
			 *  Instantiation of a new JPanel
			 */
			 myPanel = new JPanel();
			/**
			 *  Button Instantiation
			 */
			 btnStartServer = new JButton("Start Server");
			 btnStopServer = new JButton("Stop Server");
			 btnAddAdmin = new JButton("Admin hinzufügen");
			 server = new TServer();
	        /**
	         * Set bounds of the Buttons and J Pannel
	         */
			btnStartServer.setBounds(0, 0, 200, 30);
			btnStopServer.setBounds(210, 0, 200, 30);
			btnAddAdmin.setBounds(200, 600, 200, 30);
			myPanel.setBounds(800, 800, 200, 100);

	        
			
			/**
			 * //http://stackoverflow.com/questions/9612096/i-want-to-make-a-text-field-editable-only-when-a-check-box-is-selected-in-netbea
			 * Instantiation and configuration of the TexFields
			 */
			hostText = new JTextField(10);
			hostText.setEnabled(true);
			hostText.setText(host);
			aNText = new JTextField(20);
			aNText.setEnabled(false);
			aNText.setText("Neues Adminpseudonym eintragen");
			adminName = new JTextField(10);
			adminName.setEnabled(true);
			aKText = new JTextField(20);	
			aKText.setEnabled(false);
			aKText.setText("Kennwort eintragen und bestätigen");
			adminKey1= new JTextField(16);
			adminKey1.setEnabled(true);
			adminKey2= new JTextField(16);
			adminKey2.setEnabled(true);
			errorText =   new JTextField(30);
			errorText.setEnabled(false);
			errorText.setText("Fehlerausgabe");
			
			/**
			 *Addition of the Buttons to the JPanel
			 */
			myPanel.add(errorText);
	       myPanel.add(btnStartServer);
	       myPanel.add(btnStopServer);
	     
			 
			/** 
			 * Addition of the TextFields to the JPanel
			 */
	       myPanel.add(hostText);
	       myPanel.add(aNText);
	       myPanel.add(adminName);
	       myPanel.add(aKText);
	       myPanel.add(adminKey1);
	       myPanel.add(adminKey2);
	        myPanel.add(btnAddAdmin);
	       
	       
	      /**
	       * Addition of the JPanel to the JFrame
	       */
	        frame.add(myPanel);
	        
	        
	        //http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
	        /**
	         * When this action Listerner is triggered the Main class tries to start the server 
	         * if it fails an error will be displayed in the errorView 
	         */
	        btnStartServer.addActionListener(new ActionListener()
	        {
	          public void actionPerformed(ActionEvent e)
	          {
	            errorText.setText("");
	        	  //http://www.vogella.com/tutorials/JavaConcurrency/article.html#threads-in-java
	        	 //http://stackoverflow.com/questions/13538668/stop-thread-and-again-start-giving-illegalthreadstateexception-in-blackberry
	        	 Runnable runServer  = new Runnable() {
	        		 
					@Override
					public void run() {
						/**
						 * When this method throws an exception the error View displays it 
						 * an possible Bug would be  that the server would stops without throwing an exception wich should jsut occur if the . stop() method is caled on  teh server
						 */
						errorText.setText(server.startServer(hostText.getText()));
						
					}
				};
	        	  if(sThread== null){
	        	  sThread = new Thread(runServer);
	        	  sThread.setName("ServerThread");
	        	  sThread.start();
	        	  JOptionPane.showMessageDialog(null, "Server initialized!","Server Started", JOptionPane.WARNING_MESSAGE);
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
	        /**
	         * When this action Listerner is triggered the Main class tries to stop the server 
	         * if it fails the error will be displayed in the errorView 
	         */
	        btnStopServer.addActionListener(new ActionListener()
	        {
	        	/**
	        	 * o
	        	 */
	          public void actionPerformed(ActionEvent e)
	          {
	        	  //http://www.vogella.com/tutorials/JavaConcurrency/article.html#threads-in-java
	        	 // http://stackoverflow.com/questions/10961714/how-to-properly-stop-the-thread-in-java
	        	  errorText.setText("");
	        	  try{
	        		 // sThread.interrupt();
	        		  if(!(sThread == null)){
	        			 if(sThread.isAlive()){
	        				 server.stopServer();
		        			  sThread.join();
		        			  JOptionPane.showMessageDialog(null, "Server sucessfully stopped by User","Server Stopped", JOptionPane.WARNING_MESSAGE);
	        			 }else{
	        				 JOptionPane.showMessageDialog(null, "Server has already been stopped","Server Stopped", JOptionPane.WARNING_MESSAGE);
	        			 }
	        		 
	        		  
	        		  }else{
	        			  JOptionPane.showMessageDialog(null, "Server has already been stopped","Server Stopped", JOptionPane.WARNING_MESSAGE);
	        			  
	        		  }
	        	  }catch(Exception ex){
	        		  ex.printStackTrace();
	        		
	        	  }
    
	          }
	        });
	        /**
	         * When this action Listerner is triggered the Main class tries to stop the server 
	         * if it fails the error will be displayed in the errorView 
	         */
	        btnAddAdmin.addActionListener(new ActionListener() {
	        	 
				@Override
				public void actionPerformed(ActionEvent e) {
					 errorText.setText("");
					String key1 = adminKey1.getText();
					String name = adminName.getText();
					if(name.length()>0&&key1.length()>0){
					if(key1.equals(adminKey2.getText())) {
						if(Model.getInstance().addAdmin(name, key1,main)){
							errorText.setText("Admin erfolgreich hinzugefügt");
						}else{
							errorText.setText("Es ist ein Fehler aufgetreten ein Admin unter diesem Pseudonym ist möglicherweise schon bekannt");
						}
					}else{
						errorText.setText("Die beiden Kennwörter stimmen nicht überein");
					}
					}else{
						errorText.setText("In mindestens eins der Felder wurde nichts eingetragen");
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
	 

	/**
  	 * The main method.
  	 *
  	 * @param args the arguments
  	 */
  	public static void main(String[] args) {
		new Main();
		Model.getInstance(); 	 
}
	}
