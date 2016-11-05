package database;

import java.io.StringWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;

import database_utils.ChatMessage;
import database_utils.Friend;
import database_utils.FriendRequestItem;
import database_utils.Kurs;
import database_utils.Messages;
import database_utils.ProfileChart;
import database_utils.ProfileData;
import database_utils.aKurs;



/**
 * 
 * @author Simon Stolz
 * This class simply  conatains the Table Classes it´s constructor is called when a new Instance of the Server is created
 * @sources: Abi Quiz-App by Tim Möschel
 *           http://stackoverflow.com/questions/23851158 /check-if-some-string-is-in-sqlite-database
 *           http://stackoverflow.com/questions/7886462/how-to-get-row-count-using-resultset-in-java
 *           http://www.tutorialspoint.com/jdbc/jdbc-select-records.htm
 *           http://www.w3schools.com/sql/sql_update.asp
 *           http://docs.oracle.com/javase/7/docs/api/java/security/SecureRandom.html
 *           http://www.javapractices.com/topic/TopicAction.do?Id=62
 */
public class TableManager {
	 private AdminTable admin = new AdminTable();
	 private UserTable user = new UserTable();
	 private KursTable kurs = new KursTable();
	 private LinkTable link = new LinkTable();
	 private PicTable pic = new PicTable();
	 private FriendTable friend = new FriendTable();
	 private ChatTable chat = new ChatTable();
	 Connection c;
	 SecureRandom random = new SecureRandom();
	 public TableManager(){
		 if(admin.create()&&chat.create()&&friend.create()&&kurs.create()&&pic.create()&&user.create()&&link.create()){
				try {
				c = null;
				c = DriverManager.getConnection("jdbc:sqlite:serverDatabase");
				c.setAutoCommit(false);
				System.out.println("The TableManager established a new Connection to the Database");
				Class.forName("org.sqlite.JDBC");
				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ "establishing Connection in Table Manager");
					System.exit(0);
				}
				
		 }else{
			 System.out.println("Table Manager did no`t try to establis a connetion to the database due an error while creating new tables.");
		 }
	 }
	
	 
	 /**
	  * InsertM
	  */
	 /**
		 * Adds adds a new link between a user and dancing lesson
		 *
		 * @param uid the users id
		 * @param kid the lessons id
		 * @return true, if successful
		 */
		public boolean addLink(int uid, int kid) {
			// TODO NOT READY check debug
			int i = 0;
			ResultSet rs;

			PreparedStatement p;
			try {
				String sql2 = "SELECT COUNT (*) AS I FROM LINK WHERE UID = ? AND KID =  ?;";
				p = c.prepareStatement(sql2);
				p.setInt(1, uid);
				p.setInt(2, kid);
				rs = p.executeQuery();
				i = rs.getInt("I");
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
				e.printStackTrace();
				return false;
			}
			if (i < 1) {
				try {
					String sql = "INSERT INTO LINK (UID, KID) VALUES(?,?);";
					p = c.prepareStatement(sql);
					p.setInt(1, uid);
					p.setInt(2, kid);
					p.executeUpdate();

					if (p != null)
						p.close();
					c.commit();
					return true;
				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": "
							+ e.getMessage()+ " in addLink");
					System.exit(0); 
					e.printStackTrace();
					return false;

				}
			}
			return false;
		}

	 /**
		 * Adds a new column to the Kurs table .
		 * 
		 * @param kursstufelevel of the dancing lessons 
		 * @param datum java.sql.Date("yyyy-MM-dd")
		 * @param wochentag String for the Day {@link <Week>}
		 * @param uhrzeit the time the lesson takes place
		 * @return Returns true if no exception is thrown otherwise returns false
		 */
		public boolean addKurs(int kursstufe, java.sql.Date datum,
				String wochentag, String uhrzeit) {

			PreparedStatement p;
			try {
				p = c.prepareStatement("INSERT INTO KURS (KURSSTUFE, DATUM, WOCHENTAG, UHRZEIT)"
						+ "  VALUES (?, ?, ?, ?);");
				p.setInt(1, kursstufe);
				p.setDate(2, datum);
				p.setString(3, wochentag);
				p.setString(4, uhrzeit);
				p.executeUpdate();
				if (p != null)
					{p.close();}
				c.commit();
				return true;
				// ParseException e
			} catch (SQLException e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in addKurs");
				System.exit(0);
				e.printStackTrace();
				return false;
			}
		}
	 /**
		 * Adds an new user to the USER table.
		 *
		 * @param eMail the users e-mail
		 * @param ps the users key
		 * @param ln the users last name
		 * @param fn the users first name
		 * @param g the users gender
		 * @param age the users age
		 * @param pa indicates if the users age is public to other users
		 * @return returns the new users id
		 */
		public int addUser(String eMail, String ps, String ln, String fn, int g,
				int age, int pa) {
			String idp;
			// int id;
			if (!eMailExists(eMail)) {
				try {

					// http://docs.oracle.com/javase/7/docs/api/java/security/SecureRandom.html
					// http://www.javapractices.com/topic/TopicAction.do?Id=62
					idp = random.nextInt(10000000) + "";
					// id = random.nextInt(10000000);

					while (!aviableIDP(idp)) {
						idp = random.nextInt(10000000) + "";
					}
					// TODO deactivated for easier debugging
					// while(!aviableID(id)){
					// id = random.nextInt(10000000);
					// }

					idp = random.nextInt(10000000) + "";
					// TODO deactivated for easier debugging
					// id = random.nextInt(10000000);

					// TODO ADD ID AFTER DEBUGGING
					String sql = "INSERT INTO USER(IDP, EMAIL,PASSWORD,LN,FN,GENDER,AGE,PA)"
							+ "VALUES(?,?,?,?,?,?,?,?);"; 
					PreparedStatement p = c.prepareStatement(sql);
					// TODO Deactivated for Debugging
					// p.setInt(1,id);
					// p.setString(2,idp);
					// p.setString(3,em);
					// p.setString(4, ps);
					// p.setString(5,ln);
					// p.setString(6,fn);
					// p.setInt(7, g);
					// p.setInt(8,age);
					// p.setInt(9,pa);
					// p.executeUpdate();

					p.setString(1, idp);
					p.setString(2, eMail);
					p.setString(3, ps);
					p.setString(4, ln);
					p.setString(5, fn);
					p.setInt(6, g);
					p.setInt(7, age);
					p.setInt(8, pa);
					p.executeUpdate();

					if (p != null)
						p.close();
					c.commit();
					System.out.println("Added User with ID : "
							+ getUserIDByIDP(idp));
					return getUserIDByIDP(idp);// returns the id after success

				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": "
							+ e.getMessage()+ " in addUser" );
					System.exit(0);
					return -2;// Sql Error

				}
			} else {
				System.out.println("Didn´t add User E-Mail yet exists");
				return -1;
			}
		}
	 /**
		 * Adds a new admin Object
		 *
		 * @param n the admins "name"
		 * @param k  the key to access the addmin permissions
		 * @return returns the id of the created Admin
		 * @attribute This mehtod adds a new user and returns the generated if from
		 *            his column
		 */
		public boolean addAdmin(String n, String k) {
			Statement stmt;
			try {
				stmt = c.createStatement();
				String sql2 = " SELECT COUNT(*) AS COUNT FROM ADMIN WHERE NAME = '"
						+ n + "';";
				ResultSet rs = stmt.executeQuery(sql2);
				int count = rs.getInt("COUNT");
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (count == 0) {
					int id;
					PreparedStatement p;
					try {
						// http://docs.oracle.com/javase/7/docs/api/java/security/SecureRandom.html
						// http://www.javapractices.com/topic/TopicAction.do?Id=62
						id = random.nextInt(10000000); // taking the chanches for
														// duplicate id ^^
						String sql = "INSERT INTO ADMIN (ID, NAME,KEY)"
								+ "VALUES(?,?,?);"; // new Version similar to the
													// dedicated source
						p = c.prepareStatement(sql);

						p.setInt(1, id);
						p.setString(2, n);
						p.setString(3, k);
						p.executeUpdate();
						if (p != null)
							p.close();
						c.commit();
						System.out.println("added Admin ");

						return true;
					} catch (Exception e) {
						System.err.println(e.getClass().getName() + ": "
								+ e.getMessage()+ " in addAdmin");
						System.exit(0);
						return false;

					}
				} else {
					System.out
							.println("The requested admin already exists in our database");

				}

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
		}
	 
	 /**
		 * Adds a new Friend object to the FRIEND table  that connects the requesting User to another one
		 * @param id1 the requesting users id
		 * @param id2 other users id
		 * @return returns true if successful
		 */
		public boolean addFriend(int id1, int id2) {
			// TODO not fully tested
			Statement stmt;
			try {
				stmt = c.createStatement();
				String sql2 = " SELECT COUNT(*) AS COUNT FROM FRIEND WHERE ID1 = '"
						+ id1 + "' AND ID2 = '" + id2 + "' ;";
				String sql3 = " SELECT COUNT(*) AS COUNT FROM FRIEND WHERE ID1 = '"
						+ id2 + "' AND ID2 = '" + id1 + "' ;";
				ResultSet rs = stmt.executeQuery(sql2);
				int count;
				int count1 = rs.getInt("COUNT");
				if (rs != null)rs.close();
				if (stmt != null)stmt.close();
				stmt = c.createStatement();
				rs = stmt.executeQuery(sql3);
				int count2 = rs.getInt("COUNT");
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				
				count  = count1 + count2;
				if (count == 0) {
					PreparedStatement p;
					try {
						String sql = "INSERT INTO FRIEND (ID1, ID2,CID,ACCEPTED)"
								+ "VALUES(?,?,?,?);"; 
						p = c.prepareStatement(sql);
						p.setInt(1, id1);
						p.setInt(2, id2);
						p.setInt(3, -1);

						p.setInt(4, 0);
						p.executeUpdate();
						if (p != null)
							p.close();
						c.commit();
						System.out.println("added Connection from "+id1+ "to "+id2);
						return true;
					} catch (Exception e) {
						
						System.err.println(e.getClass().getName() + ": "
								+ e.getMessage());
						System.exit(0);
						System.out.println("Couldn´t connect from "+id1+ "to "+id2 );
						return false;
					}
					
				} else {
					System.out.println("The requested connection between "+ id1+ "and " +id2+ "already exists");
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		/**
		 * Source: http://stackoverflow.com/questions/12882874/how-can-i-get-the-autoincremented-id-when-i-insert-a-record-in-a-table-via-jdbct
		 * Adds a new Chat between two Users (refers to a friend object)
		 * 
		 * @return Returns the id of the created chat
		 */
		public int addChat(int id1, int id2) {
			
		PreparedStatement p;
		Statement stmt;
			try {
				stmt = c.createStatement();
				String sql1 = " SELECT COUNT(*) AS C FROM CHAT WHERE IDP1 = '"
						+ getUserIDPByID(id1) + "' AND IDP2 = '" + getUserIDPByID(id2) + "' ;";
				ResultSet rs1 = stmt.executeQuery(sql1);
				int count = rs1.getInt("C");
					if (rs1 != null)
						rs1.close();
					if (stmt != null)
						stmt.close();
					if (count == 0) {
						Messages m = new Messages();
						String sql2 = "INSERT INTO CHAT (IDP1, IDP2,MESSAGES)"
								+ "VALUES(?,?,?);"; 
						p = c.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
						p.setInt(1, getUserIDPByID(id1));
						p.setInt(2, getUserIDPByID(id2));
						p.setString(3,buildXML(m));
						p.executeUpdate();
					    ResultSet rs2 = p.getGeneratedKeys();
					    	System.out.println("added Chat between "+id1+ "and "+id2);
					    	int newCid = rs2.getInt(1); 
							if(rs2 != null){
								rs2.close();
							}
							if (p!= null){
								p.close();
							}
						c.commit();
						return newCid;	
				}else{
					stmt = c.createStatement();
					String sql3 = " SELECT ID  FROM CHAT WHERE IDP1 = '"
							+ getUserIDPByID(id1) + "' AND IDP2 = '" + getUserIDPByID(id2) + "' ;";
					ResultSet rs2 = stmt.executeQuery(sql3);
					
					int cid = rs2.getInt("ID");
						if (rs2 != null)
							rs2.close();
						if (stmt != null)
							stmt.close();
						System.out.println("Chat between "+id1+ " and "+id2+ "already exists" );
						return cid;
				}
				}catch (Exception e) {
					System.err.println(e.getClass().getName() + ": "
							+ e.getMessage()+" in addChat" );
					System.exit(0);
					System.out.println("Couldn´t create Chat between "+id1+ "to "+id2 );
					return -2;
				}
		}
	 /**
	  * UpdateM
	  */
		/**
		 * With this method the User can modify the saved data about himself.
		 * @param id 		the id of the users account used to verify himself
		 * @param pn 		the phone number
		 * @param height 	the users height
		 * @param age		 the users age
		 * @param pText		 the users about me text
		 * @param pa 		this parameter indicates if the users age is public to other users
		 * @return true, if successful
		 */
		// int id, int pn, int height,int age,String pText, boolean pa
		// String ptext, int pnumber, int pa, int height, int id, int age
		public boolean updateProfile(int id, String pn, int height, int age,
				String pText, int pa) {
			// Source http://www.w3schools.com/sql/sql_update.asp
			PreparedStatement p;
			try {
				String sql = "UPDATE USER SET PTEXT = ? , PNUMBER = ? , PA = ?, HEIGHT = ?,AGE = ? WHERE ID = ?;";
				p = c.prepareStatement(sql);
				p.setString(1, pText);
				p.setString(2, pn);
				p.setInt(3, pa);
				p.setInt(4, height);
				p.setInt(5, age);
				p.setInt(6, id);
				p.executeUpdate();

				if (p != null)
					p.close();
				c.commit();
				return true;
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in updateProfile");
				System.exit(0);
				e.printStackTrace();
				return false;
			}
		}
		/**
		 * Adds a new message to an chat object
		 * @param cid the chats id
		 * @param myid the sending users id
		 * @param message the sent message
		 * @return if successful
		 */
		public boolean addMessage(int cid, int myid, String message) {
			Statement stmt;
			
			try{
				String sql = "SELECT MESSAGES FROM CHAT WHERE ID = " +cid+ "; ";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				Messages m;
				if(rs.next()){
				 m =(Messages) parseXML(rs.getString("MESSAGES"),Messages.class );
				m.addMessage(message, getUserIDPByID(myid));}
				else{
					return false;
					}
				if(rs!= null ){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				
				stmt = c.createStatement();
				String sql2 = "UPDATE CHAT SET MESSAGES = '" +buildXML(m)+ "' WHERE ID = "+cid+" ;";
				stmt.executeUpdate(sql2);
				c.commit();
				if(stmt != null){
					stmt.close();
				}
				return true;
			}catch(Exception e){
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage()+" in addMessage");
				System.exit(0);
				return false;
			}
		}
		/**
		 * This Methods sets the status of an friend request to accepted and creates a new chat object for the friend object
		 * @param id1
		 * @param myid
		 * @return
		 */
		public boolean acceptRequests(ArrayList<Integer> idp1, int myid){
			PreparedStatement p;
			try{
				String sql = "UPDATE FRIEND SET ACCEPTED = 1, CID = ? WHERE ID1 = ? AND ID2 = ?";
				p = c.prepareStatement(sql);
				
				
				for(int i = 0; i <idp1.size(); i ++){
					p.setInt(1, addChat(getUserIDByIDP(idp1.get(i)+""),myid ));
					p.setInt(2, getUserIDByIDP(idp1.get(i)+""));
					p.setInt(3, myid);
					p.addBatch();
				}
				p.executeBatch();
				if(p != null){
					p.close();
				}
				c.commit();
				return true;
			}catch(Exception e){
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage()+" in acceptRequests");
				System.exit(0);
				return false;
			}
		}
	 
	 /**
	  * SelectM
	  */
		/**
		 * Gets data from KURS table specified by dancing lesson level and user id see AssingToKurs Activity
		 *
		 * @param kstu  the level of the dancing lesson
		 * @param uid  the users id used to see if any links exists between him and any KURS object
		 * @return the data of teh Kur object
		 */
		public ArrayList<Kurs> getKurs(int kstu, int uid) {
			Statement stmt;

			ArrayList<Kurs> kurs = new ArrayList<Kurs>();
			// SELECT KURS.ID,KURS.DATUM,KURS.KURSSTUFE,KURS.UHRZEIT,KURS.WOCHENTAG
			// ,COUNT (USER.ID)AS C FROM KURS LEFT JOIN LINK ON KURS.ID = LINK.KID
			// LEFT JOIN USER ON LINK.UID = USER.ID AND USER.ID = '"+uid+"' WHERE
			// KURSSTUFE = '"+ks+"' GROUP BY KURS.ID ORDER BY KURSSTUFE ASC,DATUM
			// DESC
			try {
				stmt = c.createStatement();
				String sql = " SELECT KURS.ID,KURS.DATUM,KURS.KURSSTUFE,KURS.UHRZEIT,KURS.WOCHENTAG ,COUNT (USER.ID)AS C FROM KURS"
						+ " LEFT JOIN LINK ON KURS.ID = LINK.KID "
						+ "LEFT JOIN USER ON LINK.UID = USER.ID AND USER.ID = '"
						+ uid
						+ "' WHERE KURSSTUFE = '"
						+ kstu
						+ "' GROUP BY KURS.ID ORDER BY KURSSTUFE ASC,DATUM DESC   ;";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int kid = rs.getInt("ID");
					int cl = rs.getInt("kursstufe");
					String uhr = rs.getString("UHRZEIT");
					String date = "" + rs.getDate("DATUM");
					String day = rs.getString("WOCHENTAG");
					boolean enlisted;
					if (rs.getInt("C") > 0) {
						enlisted = true;
					} else {
						enlisted = false;
					}
					System.out.println(kid + "");
					kurs.add(new Kurs(kid, cl, date, day, uhr, enlisted));
				}
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				return kurs;
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in getKurs");
				System.exit(0);
				e.printStackTrace();
				return null;
			}

		}
		/**
		 * Gets the profile data of an specific user
		 *
		 * @param id  the users id
		 * @return the users profile data
		 */
		public ProfileData getProfileData(int id) {
			// TODO might be buggy if i use thios in edit profile activity cause age
			Statement stmt;
			ProfileData pd;
			try {
				String sql = "SELECT LN,FN,GENDER,AGE,PA,PTEXT, PNumber, HEIGHT FROM USER WHERE ID = '"
						+ id + "';";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				// String eMail = rs.getString("EMAIL");
				String ln = rs.getString("LN");
				String fn = rs.getString("FN");
				String pText = rs.getString("PTEXT");
				// in case someone did not proceed to the editProfile Activity
				if (pText == null || !(pText.length() > 0)) {
					pText = "Nicht angegeben.";
				}
				int height = rs.getInt("HEIGHT");
				// in case someone did not proceed to the editProfile Activity
				String phoneNumber = rs.getString("PNumber");
				if (phoneNumber == null || !(phoneNumber.length() > 0)) {
					phoneNumber = "Nicht angegeben.";
				}
				int g = rs.getInt("GENDER");
				int age = rs.getInt("AGE");
				int pa = rs.getInt("PA");
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				boolean gender;
				boolean pAge;
				if (pa == 1) {
					pAge = true;
				} else {
					pAge = false;
				}
				if (g == 1) {
					gender = true;
				} else {
					gender = false;
				}
				// System.out.println(" "+eMail+" "+ln+ " "+fn+ " "+ g +" " +age+
				// " " + pa);

				pd = new ProfileData(fn, ln, pText, age, height, phoneNumber,
						gender, pAge);

			} catch (SQLException e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in getProfileData");
				System.exit(0);
				e.printStackTrace();
				return null;
			}
			return pd;
		}
		/**
		 * Recieves the ID and reads out the Gender according to the id.
		 * 
		 * @param id  ID of the user
		 * @return Returns the Gender of the User as int three Values are possible :
		 *         1 for female, 0 for male and -1 in case of an Error
		 */
		public int getGender(int id) {
			Statement stmt;
			int gender;
			try {
				// Creates a new Satement
				stmt = c.createStatement();
				// Creates a new String that will be executed as SQL Statement /
				// Query
				String sql = "SELECT GENDER FROM USER WHERE ID = '" + id + "' ;";
				// The Query gets executed and its result is saved in an ResultSet
				// Object
				ResultSet rs = stmt.executeQuery(sql);
				// Reads out the int Value of the extracted Integer "GENDER" from
				// the ResultSet
				gender = rs.getInt("GENDER");

				System.out.println("Extracted Gender = " + gender);
				// returns the extracted int value "gender"
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				return gender;
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in getGender");
				System.exit(0);
				e.printStackTrace();
				return -1;
			}
			// in case of an Error it returns -1

		}
		/**
		 * checks if the provided id exists in the admin table
		 *
		 * @param id the admins id
		 * @return true, if successful
		 */
		public boolean acheckID(int id) { // Login returns the user id
			Statement stmt;
			int i;

			try {

				String sql = "SELECT COUNT (ID) AS COUNT FROM ADMIN WHERE ID = '"
						+ id + "';";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				i = rs.getInt("COUNT");
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				if (i == 1) {
					return true;
				} else {
					if (i == 0) {
						System.out.println("Wrong ID");
						return false;
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage() +" in acheckID");
				System.exit(0);
				e.printStackTrace();
				System.out.println("Something went wrong at checkID(id)");

			}
			return false;
		}
		/**
		 * Checks if this id exists in the Database
		 *
		 * @param id the users id
		 * @return returns true if it exists.
		 * @attribute Checks if an User with this ID exists
		 */
		public boolean checkID(int id) { // Login returns the user id
			Statement stmt;
			int i;

			try {

				String sql = "SELECT COUNT (ID) AS COUNT FROM USER WHERE ID = '"
						+ id + "';";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				i = rs.getInt("COUNT");
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				if (i == 1) {
					return true;
				} else {
					if (i == 0) {
						System.out.println("Wrong ID");
						return false;
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in checkID");
				System.exit(0);
				e.printStackTrace();
				System.out.println("Something went wrong at checkID(id)");

			}
			return false;
		}
		/**
		 * This method is executed to gain a users id in exchange for email and password
		 *
		 * @param em the email you want to log in with
		 * @param ps the fitting password
		 * @return returns the User ID according to the Login E-Mail
		 */
		public int LogIn(String em, String ps) { // id check
			PreparedStatement p;

			int i;
			try {
				// TODO buggy
				String sql = "SELECT COUNT(ID) AS I FROM USER"
						+ " WHERE USER.EMAIL=? AND PASSWORD = ? ;";
				// String sql =
				// "SELECT COUNT(*) AS PS FROM USER WHERE EMAIL = 'hallo' AND PASSWORD = 'geheim' ;";
				p = c.prepareStatement(sql);
				p.setString(1, em);
				p.setString(2, ps);
				ResultSet rs = p.executeQuery();

				i = rs.getInt("I");
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (i == 1) {
					int id;
					try {

						String sql2 = "SELECT ID FROM USER WHERE EMAIL = ? ;";
						p = c.prepareStatement(sql2);
						p.setString(1, em);
						ResultSet rs2 = p.executeQuery();
						id = rs2.getInt("ID");

						System.out.println(id);

						if (rs != null)
							rs.close();
						if (p != null)
							p.close();
						return id;
					} catch (Exception e) {

						System.err.println(e.getClass().getName() + ": "
								+ e.getMessage());
						System.exit(0);
						e.printStackTrace();
						return -2;
					}
				} else {
					if (i < 1) {
						System.out.println("Wrong Password");
					} else {
						System.out.println("Some Error occured loging in");
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage() + " in LogIn" );
				System.exit(0);
				e.printStackTrace();
				return -2;
			}
			return -1;
		}

		/**
		 * Gets data from KURS and USER table and puts it into profile chart objects
		 *
		 * @param gender The gender of the requesting User
		 * @param kstu The required dancing lesson "level"
		 * @param myage The age of the requesting user (not used but may be in the Future)
		 * @param day the day the lesson usually takes place
		 * @return returns a ArrayList of  ProfileChar objects
		 */
		public ArrayList<ProfileChart> getProfilecharts(int gender, int kstu,
				int myage, String day) {
			// TODO age,day
			Statement stmt;
			// int notgender ;

			ArrayList<ProfileChart> pc = new ArrayList<ProfileChart>();
			try {
				String sql = "SELECT USER.FN,USER.IDP, USER.LN, USER.AGE, KURS.UHRZEIT,USER.IDP, KURS.DATUM FROM KURS INNER JOIN LINK  ON LINK.KID = KURS.ID INNER JOIN USER ON LINK.UID = USER.ID WHERE USER.GENDER != '"
						+ gender
						+ "' AND KURSSTUFE = '"
						+ kstu
						+ "'AND WOCHENTAG = " + day + " ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					String fn = rs.getString("FN");
					String ln = rs.getString("LN");
					int age = rs.getInt("AGE");
					String uhr = rs.getString("UHRZEIT");
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String date = df.format(rs.getDate("DATUM"));
					String eMail = rs.getString("IDP");

					System.out.println(fn + " " + ln);
					pc.add(new ProfileChart(fn, ln, age, uhr, date, eMail));
				}
				if (stmt != null)
					stmt.close();
				if (rs != null)
					stmt.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in getProfilecharts");
				System.exit(0);
				e.printStackTrace();
			}
			return pc;
		}
		/**
		 * The login for admins
		 *
		 * @param n the admins name
		 * @param k the admins key
		 * @return if ther is a match returns the admins id else returns -1 in case
		 *         of an exception it returns -2
		 */
		public int aLogIn(String n, String k) { // id check
			int i;
			try {
				// TODO buggy
				String sql = "SELECT COUNT(ID) AS I FROM ADMIN WHERE NAME = ? AND KEY = ? ;";
				// String sql =
				// "SELECT COUNT(*) AS PS FROM USER WHERE EMAIL = 'hallo' AND PASSWORD = 'geheim' ;";
				PreparedStatement p = c.prepareStatement(sql);
				p.setString(1, n);
				p.setString(2, k);
				ResultSet rs = p.executeQuery();

				i = rs.getInt("I");
				if (rs != null)
					rs.close();
				if (p != null)
					p.close();
				if (i == 1) {
					int id;
					try {

						String sql2 = "SELECT ID FROM ADMIN WHERE NAME = ? ;";
						p = c.prepareStatement(sql2);
						p.setString(1, n);
						ResultSet rs2 = p.executeQuery();
						id = rs2.getInt("ID");

						System.out.println(id);

						if (rs != null)
							rs.close();
						if (p != null)
							p.close();
						return id;
					} catch (Exception e) {

						System.err.println(e.getClass().getName() + ": "
								+ e.getMessage()+ " in aLogIn" );
						System.exit(0);
						e.printStackTrace();
						return -2;
					}
				} else {
					if (i < 1) {
						System.out.println("Wrong Password");
					} else {
						System.out.println("Some Error occured loging in");
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
				e.printStackTrace();
				return -2;
			}
			return -1;
		}
		/**
		 * Gets all the courses and the number of searching people
		 *
		 * @param kstu
		 *            the level of the dancing lesson
		 * @return returns a List of Kurs objects
		 * @attribute This method exutes a SELECT statement getting
		 */
		public ArrayList<aKurs> getaKurs(int kstu) {
			Statement stmt;

			ArrayList<aKurs> kurs = new ArrayList<aKurs>();
			try {
				stmt = c.createStatement();
				String sql = " SELECT KURS.ID,KURS.DATUM,KURS.KURSSTUFE,KURS.UHRZEIT,KURS.WOCHENTAG ,COUNT (USER.ID)AS C FROM KURS"
						+ " LEFT JOIN LINK ON KURS.ID = LINK.KID "
						+ "LEFT JOIN USER ON LINK.UID = USER.ID WHERE KURSSTUFE = '"
						+ kstu
						+ "' GROUP BY KURS.ID ORDER BY KURSSTUFE ASC,DATUM DESC   ;";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int kid = rs.getInt("ID");
					int cl = rs.getInt("kursstufe");
					String uhr = rs.getString("UHRZEIT");
					String date = "" + rs.getDate("DATUM");
					String day = rs.getString("WOCHENTAG");
					int enlisted = rs.getInt("C");
					System.out.println(kid + "");
					kurs.add(new aKurs(kid, cl, date, day, uhr, enlisted));
				}
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				return kurs;
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+" in getaKurs");
				System.exit(0);
				e.printStackTrace();
				return null;
			}

		}
		
		/**
		 * Provides all missing messages of an specific chat
		 * @param cid
		 * @param lmid
		 * @return missing messages
		 */
		public ArrayList<ChatMessage> pollMessages(int cid, int lmid){
			Statement stmt;
			try{
				String sql = "SELECT MESSAGES FROM CHAT WHERE ID = "+cid+";";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()){
				Messages m = (Messages) parseXML(rs.getString("MESSAGES"),Messages.class);
				return m.getMissingMessages(lmid);
				}
				if(rs != null){
					rs.close();
				}if(stmt != null){
					stmt.close();
				}
				return  null;
			}catch(Exception e){
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage()+ " in pollMessages" );
				System.exit(0);
			}
			return null;
		}
		/**
		 * Selects reads all your freinds also pending ones
		 * @param myid
		 * @return a List of Friend Objects
		 */
		public ArrayList<Friend> getOpenChats(int myid) {
			Statement stmt;
			//http://stackoverflow.com/questions/5901791/is-having-an-or-in-an-inner-join-condition-a-bad-idea
			ArrayList<Friend> fl = new ArrayList<Friend>();
			try{
				String sql = "SELECT USER.FN, USER.LN, USER.IDP, CID, ACCEPTED FROM FRIEND LEFT JOIN USER ON USER.ID = ID2 WHERE FRIEND.ID1 = "+myid+" UNION"
						+ " SELECT USER.FN, USER.LN, USER.IDP, CID, ACCEPTED FROM FRIEND LEFT JOIN USER ON USER.ID = ID1 WHERE FRIEND.ID2 = "+myid+" ;";
				stmt = c.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql);
				String lm = null; // it´s calls last message so u can in future add the last messages for accepted friends
				while(rs.next()){
					if(rs.getInt("ACCEPTED")== 0){
						lm = "Freundschaft Ausstehend";
					}else{
						lm = "Hier klicken";
					}
					fl.add(new Friend(rs.getString("USER.FN"),rs.getString("USER.LN"),rs.getInt("USER.IDP"), rs.getInt("CID"),lm));
					System.out.println("Fn: "+rs.getString("USER.FN")+ " Ln: "+rs.getString("USER.LN")+" IDP: "+rs.getInt("USER.IDP")+ " CID: "+ rs.getInt("CID")+ " lm: "+ lm );
				}
				if(rs != null){rs.close();}
				if(stmt != null){stmt.close();}
				return fl;
			}catch(Exception e){
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage()+" in getOpenChats");
				System.exit(0);
				return null;
			}
		}
		/**
		 * Reads out all pending friend requests for one user
		 * @param myid the requesting users idp
		 * @return an FriendRequestItem ArrayList containing information about each pending request
		 */
		public ArrayList<FriendRequestItem> getFriendRequests(int myid) {
			Statement stmt;
			ArrayList<FriendRequestItem> fri = new ArrayList<FriendRequestItem>();
			try{
				stmt = c.createStatement();
				String sql = "SELECT USER.FN, USER.LN , USER.IDP FROM FRIEND LEFT JOIN USER  ON FRIEND.ID1 = USER.ID WHERE ACCEPTED = 0 AND ID2 = " + myid+" ;";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					fri.add(new FriendRequestItem(rs.getInt("IDP"),rs.getString("FN"),rs.getString("LN")));
					System.out.println(rs.getInt("IDP"));
				}
				if(rs!= null){
					rs.close();
				}
				if(stmt!= null){
					stmt.close();
				}
			}catch(Exception e){ 
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage()+" in getFriendRequests");
				System.exit(0);
				return null;
			}
			return fri;
		}
		/**
		 * DeleteM
		 * 
		 */
		/**
		 * deletes an specific link between a Kurs and an User object
		 * @param uid the users id
		 * @param kid the lessons id
		 * @return true, if successful
		 */
		public boolean deleteLink(int uid, int kid) {
			PreparedStatement p;
			try {
				String sql = "DELETE FROM LINK WHERE UID = ? AND KID = ?;";
				p = c.prepareStatement(sql);
				p.setInt(1, uid);
				p.setInt(2, kid);
				p.executeUpdate();
				c.commit();
				if (p != null) {
					p.close();
				}
				return true;

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage() + "in deleteLink");
				System.exit(0);
				e.printStackTrace();
				return false;
			}

		}
		/**
		 * Deletes an Kurs object(dancing lesson) and all references on it
		 * @param kid the id of the lesson
		 * @return true, if successful
		 */
		public boolean deleteKurs(int kid) {
			PreparedStatement p;
			try {
				String sql = "DELETE FROM Kurs WHERE ID =  ?;";
				p = c.prepareStatement(sql);
				p.setInt(1, kid);
				p.executeUpdate();
				c.commit();
				if (p != null) {
					p.close();
				}
				String sql2 = "DELETE FROM LINK WHERE KID = ?;";
				p = c.prepareStatement(sql2);
				p.setInt(1, kid);
				p.executeUpdate();
				return true;

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in deleteKurs");
				System.exit(0);
				e.printStackTrace();
				return false;
			}
		}

	 /**
	  * UtilityM
	  */
		/**
		 * Gets the user ID by IDP.
		 *
		 * @param idp
		 *            The public identifer of the user that is searched for
		 * @return returns the private User id having the suplied idp
		 */
		public int getUserIDByIDP(String idp) {
			Statement stmt = null;
			try {
				stmt = c.createStatement();
				// String sql = "SELECT ID FROM USER WHERE EMAIL = '" + em + "';";
				String sql = "SELECT ID FROM USER WHERE IDP = '" + idp + "';";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					int id = rs.getInt("id");
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					return id;
				} else {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					return -1;
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in getUserIDByIDP");
				System.exit(0);
			}
			return -1;
		}

		public int getUserIDPByID(int id) {
			// TODO not yet fully tested
			Statement stmt = null;
			try {
				stmt = c.createStatement();
				// String sql = "SELECT ID FROM USER WHERE EMAIL = '" + em + "';";
				String sql = "SELECT IDP FROM USER WHERE ID = '" + id + "';";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					int idp = rs.getInt("idp");
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					return idp;
				} else {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					return -1;
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in getUserIDPByID");
				System.exit(0);
			}
			return -1;
		}
		/**
		 * Checks if the provided idp value already exists in the database
		 *
		 * @param idp
		 *            the provieded public identifer
		 * @return true, if successful
		 */
		public boolean aviableIDP(String idp) {
			Statement stmt = null;
			try {
				stmt = c.createStatement();
				String sql = " SELECT COUNT(*) AS COUNT FROM USER WHERE IDP = '"
						+ idp + "';";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					int count = rs.getInt("count");
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (count == 0) {
						System.out.println("nope");
						return true;
					} else {

						System.out
								.println("The requested IDP already exists in our database");
						return false;
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage() +" in aviableIDP");
				System.exit(0);
			}
			return false;
		}
		/**
		 * checks if an id is aviable
		 *
		 * @param id
		 *            the provided id(auto generated in addUser)
		 * @return true, if successful
		 */

		public boolean aviableID(int id) {
			Statement stmt = null;
			try {
				stmt = c.createStatement();
				String sql = " SELECT COUNT(*) AS COUNT FROM USER WHERE ID = '"
						+ id + "';";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					int count = rs.getInt("count");
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (count == 0) {
						System.out.println("nope");
						return true;
					} else {

						System.out
								.println("The requested E-Mail already exists in our database");
						return false;
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+" in aviableID");
				System.exit(0);
			}
			return false;
		}

		// sources:
		// http://stackoverflow.com/questions/23851158/check-if-some-string-is-in-sqlite-database
		/**
		 * Checks if an entry with that e-mail value exists
		 *
		 * @param em the provided e-mail
		 * @return true, if this e-mail exists in the database
		 */
		public boolean eMailExists(String em) {
			Statement stmt = null;
			try {
				stmt = c.createStatement();
				String sql = " SELECT COUNT(*) AS COUNT FROM USER WHERE EMAIL = '"
						+ em + "';";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					int count = rs.getInt("count");
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (count == 0) {
						System.out.println("nope");
						return false;
					} else {

						// System.out.println("The requested E-Mail already exists in our database");
						return true;
					}
				}
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in eMailExists");
				System.exit(0);
			}
			return true;
		}
		protected String buildXML(Object object) {
			Style style = new HyphenStyle();
			Format format = new Format(style);

			Serializer serializer = new Persister(format);

			StringWriter writer = new StringWriter();

			try {
				serializer.write(object, writer);
				return writer.getBuffer().toString();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in buildXML ");
				return null; // TODO Error-Handling
			}
		}

		protected Object parseXML(String xml, Class myClass) {
			Serializer serializer = new Persister();

			try {
				Object object = serializer.read(myClass, xml);
				return object;
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage()+ " in parseXML ");
				return null; // TODO: Error-Handling
			}
		}
		 public void closeDatabaseConnection() {
				try {
					
					if(c!= null)c.close();
				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": " + e.getMessage() + " in closeDatabaseConnection ");
					System.exit(0);
				}
			}
}
