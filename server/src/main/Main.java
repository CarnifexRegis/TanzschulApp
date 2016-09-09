package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import android.content.SharedPreferences.Editor;
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
 *			http://stackoverflow.com/questions/9612096/i-want-to-make-a-text-field-editable-only-when-a-check-box-is-selected-in-netbea
 */

public class Main  {
		private static JFrame frame = new JFrame("Server Control");
		private JPanel myPanel ;
		private JButton btnStartServer ;
		private JButton btnStopServer ;
		private JButton btnAddAdmin ;
		private Thread sThread = null;
		private TServer server ;
		static final  String host = "192.168.1.10X";
		private final JTextField hostText;
		private final JTextField aNText;
		private final JTextField aKText;
		private final JTextField errorText;
		
		private final JTextField adminName;
		private final JTextField adminKey1;
		private final JTextField adminKey2;
		private Main main = this;
		
		
		
		/** @attribute The constructor of the main class creates a Jlabel 
		 * which can be used to start and stop the server and also add new admin logins
		 * 
		 */
	  public Main() {
			//Model.getInstance(); 
			 myPanel = new JPanel();
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

	        
			//http://stackoverflow.com/questions/9612096/i-want-to-make-a-text-field-editable-only-when-a-check-box-is-selected-in-netbea
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
			// Adding to JFrame 
			myPanel.add(errorText);
	       myPanel.add(btnStartServer);
	       myPanel.add(btnStopServer);
	      
	       myPanel.add(hostText);
	       myPanel.add(aNText);
	       myPanel.add(adminName);
	       myPanel.add(aKText);
	       myPanel.add(adminKey1);
	       myPanel.add(adminKey2);
	        myPanel.add(btnAddAdmin);
	       
	       
	      
	        frame.add(myPanel);
	        
	        
	        //http://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
	        /**
	         * on action performed this class starts the server
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
	 

	public static void main(String[] args) {
		new Main();
		Model.getInstance(); 	 
}
	}
