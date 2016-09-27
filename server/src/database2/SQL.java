package database2;

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

// TODO: Auto-generated Javadoc
/**
 * The Class SQL.
 *
 * @author Simon Stolz
 * @sources: Abi Quiz-App by Tim Möschel
 *           http://stackoverflow.com/questions/23851158
 *           /check-if-some-string-is-in-sqlite-database
 *           http://stackoverflow.com
 *           /questions/7886462/how-to-get-row-count-using-resultset-in-java
 *           http://www.tutorialspoint.com/jdbc/jdbc-select-records.htm
 *           http://www.w3schools.com/sql/sql_update.asp
 *           http://docs.oracle.com/javase
 *           /7/docs/api/java/security/SecureRandom.html
 *           http://www.javapractices.com/topic/TopicAction.do?Id=62
 */
public class SQL {

	SecureRandom random = new SecureRandom();

	private Connection c;

	// TODO DEBUGGING

	// https://coderanch.com/t/300886/JDBC/databases/Proper-close-Connection-Statement-ResultSet
	// TODO try out that fancy shit if you have leaft over time
	/**
	 * If the one of the tables KURS , USER , LINK, ADMIN doesnt´t exist the
	 * constructor tells the connection to create them Instantiates a new sql.
	 */

	public SQL() {
		try {
			c = null;
			Statement stmt;
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:serverDatabase");
			c.setAutoCommit(false);
			System.out.println("Established connection to the Database");

			// DatabaseMetaData dbm =c.getMetaData();
			// ResultSet tables = dbm.getTables(null,null,"KURS",null);
			// Checking if the KURS Table already exists
			try {
				String sql2 = "SELECT COUNT(*) AS I FROM KURS ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table Kurs already exists");
			} catch (Exception e) {
				// Creates Table KURS
				/**
				 * The table KURS containing the data of several dancing lessons
				 * ID The ID of the object in the table KURSSTUFE the level of
				 * the dancing lesson DATUM the date the dancing lessons start
				 * WOCHENTAG The day of the week the dancing lesson takes place
				 * UHRZEIT The time the dancing lesson takes place
				 */
				try {
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE KURS "
							+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
							+ " KURSSTUFE TEXT NOT NULL, "
							+ " DATUM     DATE NOT NULL, "
							+ " WOCHENTAG TEXT NOT NULL, "
							+ " UHRZEIT   TEXT NOT NULL)";

					stmt.executeUpdate(sql);

					if (stmt != null) {
						stmt.close();
					}
					c.commit();
					System.out.println("Created new Instance of Table Kurs");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the KURS Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}

			}
			// Checking if the PIC Table already exists
			try {
				String sql2 = "SELECT COUNT(*) AS I FROM PIC ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table PIC already exists");
			} catch (Exception e) {
				try {
					// Creates Table PIC
					/**
					 * The Table pic used to safe profile pictures ID The ID of
					 * the object in the table IMAGE An image encoded to an
					 * base64 String UID The user the image belongs to UIDP The
					 * users public identifier
					 * 
					 */
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE PIC "
							+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
							+ " IMAGE TEXT NOT NULL, "
							+ " UIDP INTEGER NOT NULL, "
							+ " UID INTEGER NOT NULL );";

					stmt.executeUpdate(sql);
					if (stmt != null) {
						stmt.close();
					}
					c.commit();
					System.out.println("Created new instance of PIC table");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the PIC Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}
			}

			// Checking if the FRIEND Table already exists
			try {
				String sql2 = "SELECT COUNT(*) AS I FROM FRIEND ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table FRIEND already exists");
			} catch (Exception e) {
				// Creates table admin
				/**
				 * The Links ID
				 * 
				 */
				try {
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE FRIEND "
							+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
							+ " ID1 INTEGER NOT NULL,"
							+ " ID2 INTEGER NOT NULL,"
							+ " ACCEPTED INTEGER NOT NULL,"
							+ " CID INTEGER NOT NULL );";

					stmt.executeUpdate(sql);
					if (stmt != null) {
						stmt.close();
					}
					c.commit();
					System.out.println("Created new instance of FRIEND table");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the FRIEND Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}
			}
			// Checking if the ADMIN Table already exists
			try {
				String sql2 = "SELECT COUNT(*) AS I FROM ADMIN ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table ADMIN already exists");
			} catch (Exception e) {
				try {
					// Creates Table ADMIN
					/**
					 * The Table ADMIN used to provide special User that can
					 * modify the database e.g. kurs TABLE ID The ID of the
					 * object in the table NAME The admins Name KEY The admins
					 * KEY needed to access his privilege permissions
					 */
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE ADMIN "
							+ "(ID INTEGER PRIMARY KEY , "
							+ " NAME TEXT NOT NULL, "
							+ " KEY    TEXT NOT NULL)";
					stmt.executeUpdate(sql);
					if (stmt != null) {
						stmt.close();
					}
					c.commit();
					System.out.println("Created new instance of ADMIN table");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the ADMIN Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}
			}
			// Checks if table USER already exists
			try {
				String sql2 = "SELECT COUNT(*) AS I FROM USER ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table USER already exists");
			} catch (Exception e) {
				/**
				 * The Table User each User has to register his data is saved
				 * here ID The private ID of the object in the table IPD The
				 * public ID other Users may get to know EMAIL The users e-mail
				 * he needs it for login purposes PASSWORD The users key used to
				 * access his account LN The users last name FN The users first
				 * name GENDER The users gender AGE The users age PTEXT Some
				 * user created about me text PNumber The users phone number
				 * does not need to be specified PA Tells if the users age is
				 * public to other users height The users height does not nedd
				 * to be specified
				 */
				try {
					// Creates new table USER
					// TODO RESET AUTO INCREMENT AFTER DEBUGGING
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE USER"
							+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + // 0
																			// identification
																			// Number
																			// auto
							"IDP TEXT, " + " EMAIL TEXT NOT NULL," + // 1 e-Mail
																		// !
							" PASSWORD TEXT NOT NULL," + // 2 password !
							" LN TEXT NOT NULL," + // 3 last name !
							" FN TEXT NOT NULL," + // 4 first name !
							" GENDER INTEGER NOT NULL, " + // 5 gender !
							" AGE INTEGER NOT NULL," + // 6 age !
							" PTEXT TEXT," + // 7 profile text (a possibility
												// for the User to introduce him
												// self)
							" PNumber TEXT ," + // 8 phone number
							" PA INTEGER NOT NULL ," + // 9 Public Age
														// !(Boolean, always set
														// 0=False 1=True
							" HEIGHT INTEGER)"; // 10 height

					stmt.executeUpdate(sql);
					if (stmt != null) {
						stmt.close();
					}
					c.commit();
					System.out.println("Created new instance of USER table");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the USER Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}
			}
			// Checks if table USER already exists
			try {
				// TODO buggy
				String sql2 = "SELECT COUNT(*) AS I FROM LINK ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table LINK already exists");
			} catch (Exception e) {

				try {
					/**
					 * The table LINK links the USER and KURS table UID The
					 * users id KID The lessons id
					 */
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE LINK"
							+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
							+ " UID INTEGER NOT NULL,"
							+ " KID INTEGER NOT NULL)";

					stmt.executeUpdate(sql);
					c.commit();
					if (stmt != null) {
						stmt.close();
					}

					System.out.println("Created new instance of LINK table");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the LINK Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}

			}

			try {
				String sql2 = "SELECT COUNT(*) AS I FROM CHAT ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				rs.getInt("I");
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				System.out.println("Table LINK already exists");
			} catch (Exception e) {

				try {
					/**
					 * The table LINK links the USER and KURS table UID The
					 * users id KID The lessons id
					 */
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE CHAT"
							+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
							+ " IDP1 INTEGER NOT NULL,"
							+ " IDP2 INTEGER NOT NULL,"
							+ " CHAT TEXT NOT NULL)";

					stmt.executeUpdate(sql);
					c.commit();
					if (stmt != null) {
						stmt.close();
					}

					System.out.println("Created new instance of Chat table");
				} catch (Exception e1) {
					System.out
							.println("Couldn´t create a new Instance of the C Table");
					System.err.println(e1.getClass().getName() + ": "
							+ e1.getMessage());
					System.exit(0);
				}
			}
			// Tests
			// eMailExists("hi");
			addUser("ich@also.de", "geheim1", "Stronk", "Vitaly", 0, 8, 0);
			addUser("naja@hier.de", "geheim2", "Hanse", "Hanna", 1, 8, 0);
			addUser("alles@jetzt.de", "geheim3", "Dicke", "Berta", 1, 8, 1);
			addUser("hallo", "geheim", "von Richthofen", "Manfred", 0, 8, 0);
			addUser("wann@geht.de", "geheim5", "Sturm", "Edric", 0, 8, 1);
			addUser("hier@jetzt.de", "geheim6", "Baratheon", "Stannis", 0, 8, 0);
			addUser("nun@hier.de", "geheim8", "Tagaryen", "Denaerys", 1, 8, 1);
			addUser("die@Steppe.de", "geheim9", "Khal", "Drogo", 0, 8, 1);
			addUser("jma@pampam.de", "geheim10", "Lang", "Lang", 0, 8, 1);
			addUser("Needle@Nadel.de", "geheim11", "Stark", "Arya", 1, 8, 1);
			addUser("faceless@men.de", "geheim12", "Nobody", "Noone", 0, 8, 1);
			addUser("a@girl.de", "geheim13", "Nobody", "Noone", 1, 8, 1);
			addUser("syrio@forell.de", "geheim14", "Forell", "Syrio", 0, 8, 1);
			addUser("sansa@Stark.de", "geheim14", "Stark", "Sansa", 1, 8, 1);
			addUser("meera@reet.de", "geheim14", "Reet", "Meera", 1, 8, 1);
			addUser("youknow@nothing.de", "geheim14", "Freeborn", "Ygritte", 1,
					8, 1);
			addUser("fortheNighttisfull@terrors.de", "geheim14", "Redwoman",
					"Melisandre", 1, 8, 1);
			addUser("war@ftw.de", "geheim14", "Sand", "Obara", 1, 8, 1);
			addUser("Freedom@dorne.de", "geheim14", "Sand", "Nymeria", 1, 8, 1);
			addUser("KillingForFreedom@dorne.de", "geheim14", "Sand", "Tyene",
					1, 8, 1);
			addUser("iaminnocent@kingslanding.de", "geheim14", "Lannister",
					"Cersei", 1, 8, 1);

			addLink(1, 3);
			addLink(2, 3);
			addLink(3, 3);
			addLink(4, 3);
			addLink(5, 3);
			addLink(6, 3);
			addLink(7, 3);
			addLink(8, 3);
			addLink(9, 3);
			addLink(10, 3);
			addLink(11, 3);
			addLink(12, 3);
			addLink(13, 3);
			addLink(14, 3);
			addLink(15, 3);
			addLink(16, 3);
			addLink(17, 3);
			addLink(18, 3);
			addLink(19, 3);
			addLink(20, 3);
			addLink(21, 3);

			// getAllUserData();
			// kein goldstar b im quartal
			// addKurs(3,"25.03.2016","Donnerstag","15:25");
			// addKurs(4,"25.03.2016","Donnerstag","16:25");
			// addKurs(6,"26.03.2016","Freitag","16:35");
			// addKurs(1,"26.03.2016","Freitag","13:25");
			// addKurs(2,"26.03.2016","Freitag","14:35");
			// addKurs(3,"26.03.2016","Freitag","15:35");
			// addKurs(4,"26.03.2016","Freitag","16:35");
			// addKurs(5,"26.03.2016","Freitag","17:35");
			// addKurs(1,"24.03.2016","Mittwoch","13:25");
			// addKurs(2,"24.03.2016","Mittwoch","14:25");

			addLink(1, 1);
			addLink(2, 1);
			addLink(3, 1);
			addLink(4, 1);
			addLink(5, 1);
			addLink(6, 1);
			addLink(7, 1);
			addLink(8, 1);
			addLink(9, 1);
			addLink(10, 1);
			addLink(11, 1);
			addLink(12, 1);
			addLink(13, 1);
			addLink(10, 2);
			addLink(10, 3);
			addLink(10, 4);
			addLink(10, 5);
			addLink(10, 6);
			addLink(10, 7);
			addLink(10, 8);
			addLink(10, 9);
			addLink(10, 10);
			addAdmin("d", "d");
			getProfilecharts(1, 3, 87, null);
			addFriend(1, 1, false);

		} catch (Exception e3) {
			System.out
					.println("Couldn´t establish a connection to the database");
			System.err
					.println(e3.getClass().getName() + ": " + e3.getMessage());
			System.exit(0);
		}
	}

	// methods
	/**
	 * Adds a new Friend link from the requesting User to another User
	 * 
	 * @return true if successful
	 */
	public boolean addFriend(int myid, int id2, boolean accepted) {
		// TODO not tested implement add Chat
		Statement stmt;
		int a = 0;
		try {
			stmt = c.createStatement();
			String sql2 = " SELECT COUNT(*) AS COUNT FROM FRIEND WHERE ID1 = '"
					+ myid + "' AND ID2 = '" + id2 + "' ;";
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
					String sql = "INSERT INTO FRIEND (ID1, ID2,CID,ACCEPTED)"
							+ "VALUES(?,?,?,?);"; // new Version similar to the
												// dedicated source
					p = c.prepareStatement(sql);
					p.setInt(1, myid);
					p.setInt(2, id2);
					p.setInt(3, addChat(myid, id2));
				
					if (accepted) {
						a = 1;
					}
					p.setInt(4, a);
					p.executeUpdate();
					if (p != null)
						p.close();
					c.commit();
					System.out.println("added Connection from "+myid+ "to "+id2);
					setAccepted(a,myid, id2);
					return true;
				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": "
							+ e.getMessage());
					System.exit(0);
					System.out.println("Couldn´t connect from "+myid+ "to "+id2 );
					return false;
					
				}
				
			} else {
				System.out.println("The requested connection between "+ myid+ "and " +id2+ "already exists");

			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * sets the ACCEPTED attribute of an Friend column to the accept parameters value
	 * @param accept Tells if the User accepted the friendrequest
	 * @param myid	the requesting user
	 * @param uid2 the other user
	 */
	public void setAccepted(int accept,int myid,int uid2){
		//TODO Debug
		PreparedStatement p;
		try {
			String sql = "UPDATE FRIEND SET ACCEPTED = ?  WHERE ID1 = ? AND ID2 = ? ;";
			p = c.prepareStatement(sql);
			p.setInt(1,accept);
			p.setInt(2, uid2);
			p.setInt(3, myid);
			p.executeUpdate();

			if (p != null)
				p.close();
			c.commit();
			System.out.println("Accepted status set to "+accept+ "for Link from "+uid2+" to "+myid);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			System.out.println("Couldn´t change accepted status");
		}
	}

	/**
	 * Adds a new Chat between two Users
	 * 
	 * @return
	 */
	public int addChat(int id1, int id2) {

		return 1;

	}

	/**
		 * 
		 */
	public void getFriendRequests() {

	}

	public void getChatFromFriend(int uid, int u2id) {
	}

	public void getChat(int cid) {
	}

	public void addMessage(int cid, int uid, String Message) {
	}

	public boolean amendPic(int id) {
		return false;

	}

	// sources:
	// http://stackoverflow.com/questions/23851158/check-if-some-string-is-in-sqlite-database
	/**
	 * Checks if an entry with that e-mail value exists
	 *
	 * @param em
	 *            the privided e-mail
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return true;
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return false;
	}

	/**
	 * Adds the admin.
	 *
	 * @param n
	 *            the admins "name"
	 * @param k
	 *            the key to access the addmin permissions
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
							+ e.getMessage());
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
	 * Gets the a kurs.
	 *
	 * @param kstu
	 *            the level of the dancing lesson
	 * @return returns a List of Kurs objects
	 * @attribute This method exutes a SELECT statement getting
	 */
	public ArrayList<aKurs> getaKurs(int kstu) {
		Statement stmt;

		ArrayList<aKurs> kurs = new ArrayList<aKurs>();
		// SELECT KURS.ID,KURS.DATUM,KURS.KURSSTUFE,KURS.UHRZEIT,KURS.WOCHENTAG
		// ,COUNT (USER.ID)AS C FROM KURS LEFT JOIN LINK ON KURS.ID = LINK.KID
		// LEFT JOIN USER ON LINK.UID = USER.ID AND USER.ID = '"+uid+"' WHERE
		// KURSSTUFE = '"+ks+"' GROUP BY KURS.ID ORDER BY KURSSTUFE ASC,DATUM
		// DESC
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * The login for admins
	 *
	 * @param n
	 *            the admins name
	 * @param k
	 *            the admins key
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return -2;
		}
		return -1;
	}

	/**
	 * Check if the provided idp value already exists in the database
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return false;
	}

	/**
	 * Adds an new user to the USER table.
	 *
	 * @param eMail
	 *            the users e-mail
	 * @param ps
	 *            the users key
	 * @param ln
	 *            the users last name
	 * @param fn
	 *            the users first name
	 * @param g
	 *            the users gender
	 * @param age
	 *            the users age
	 * @param pa
	 *            indicates if the users age is public to other users
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
						+ "VALUES(?,?,?,?,?,?,?,?);"; // new Version similar to
														// the dedicated source
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
						+ e.getMessage());
				System.exit(0);
				return -2;// Sql Error

			}
		} else {
			System.out.println("Didn´t add User E-Mail yet exists");
			return -1;
		}
	}

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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return -1;
	}

	public int getUserIDPByID(String id) {
		// TODO not yet tested
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return -1;
	}

	/**
	 * Adds a new column to the Kurs table .
	 * 
	 * @param kursstufe
	 *            level of the dancing lessons see {@link
	 *            [<enums>.]<Kursstufen>}
	 * @param datum
	 *            java.sql.Date("yyyy-MM-dd")
	 * @param wochentag
	 *            String for the Day {@link <Week>}
	 * @param uhrzeit
	 *            the time the lesson takes place
	 * @return Returns true if no exception is thrown otherwise returns false
	 */
	public boolean addKurs(int kursstufe, java.sql.Date datum,
			String wochentag, String uhrzeit) {

		PreparedStatement p;
		try {
			p = c.prepareStatement("INSERT INTO KURS (KURSSTUFE, DATUM, WOCHENTAG, UHRZEIT)"
					+ "  VALUES (?, ?, ?, ?);");
			p.setInt(1, kursstufe);
			// SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			// Date parsed = format.parse(datum);
			// java.sql.Date sqldate = new java.sql.Date(parsed.getTime());
			p.setDate(2, datum);
			p.setString(3, wochentag);
			p.setString(4, uhrzeit);
			p.executeUpdate();
			// p.addBatch();
			// c.setAutoCommit(false);
			// p.executeBatch();
			// c.setAutoCommit(true);
			// ResultSet rs = prep.getGeneratedKeys();
			// if (rs.next()) {
			// return (int) rs.getLong(1);
			// }
			//
			// rs.close();

			if (p != null)
				p.close();
			c.commit();
			return true;
			// ParseException e
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Deletes all Connections between the KURS and USER table.
	 */
	// TODO not used
	public void deleteAllLink() {
		Statement stmt;
		try {
			String sql = "DELETE FROM LINK;";
			stmt = c.createStatement();
			stmt.executeUpdate(sql);
			c.commit();
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an Kurs object(dancing lesson) and all references on it
	 *
	 * @param kid
	 *            the id of the lesson
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * deletes an specific link
	 *
	 * @param uid
	 *            the users id
	 * @param kid
	 *            the lessons id
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Adds adds a new link betwen a user and dancing lesson
	 *
	 * @param uid
	 *            the users id
	 * @param kid
	 *            the lessons id
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
						+ e.getMessage());
				System.exit(0);
				e.printStackTrace();
				return false;

			}
		}
		return false;
	}

	/**
	 * Restore password.
	 */
	public void restorePassword() {
	}

	// TODO not used

	/**
	 * Full profiledata.
	 */
	public void fullProfiledata() {
	}

	// TODO not used

	/**
	 * Gets data from KURS and USER table and puts it into profile chart objects
	 *
	 * @param gender
	 *            The gender of the requesting User
	 * @param kstu
	 *            The required dancing lesson "level"
	 * @param myage
	 *            The age of the requesting user (not used but may be in the
	 *            Future)
	 * @param day
	 *            the day
	 * @return the profilecharts
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
		}
		return pc;
	}

	/**
	 * With this Method the User can modify the saved Data about himself.
	 *
	 * @param id
	 *            The id of the users account used to verify himself
	 * @param pn
	 *            the phone number
	 * @param height
	 *            The users height
	 * @param age
	 *            the users age
	 * @param pText
	 *            the users about me text
	 * @param pa
	 *            This parameter indicates if the users Age shall be public
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return false;
		}
	}

	// public Login logIn(){}
	/**
	 * Thsi method is called by the client to log in
	 *
	 * @param em
	 *            the email you want to log in with
	 * @param ps
	 *            the fitting password
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return -2;
		}
		return -1;
	}

	/**
	 * Checks if this id exists in the Database
	 *
	 * @param id
	 *            the users id
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			System.out.println("Something went wrong at checkID(id)");

		}
		return false;
	}

	/**
	 * checks if ht eproviede id exists in the admin table
	 *
	 * @param id
	 *            the admins id
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			System.out.println("Something went wrong at checkID(id)");

		}
		return false;
	}

	/**
	 * Recieves the ID and reads out the Gender according to the id.
	 * 
	 * @param id
	 *            ID of the user
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return -1;
		}
		// in case of an Error it returns -1

	}

	/**
	 * Gets the profile data o an specific user
	 *
	 * @param id
	 *            the users id
	 * @return the user sprofile data
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return null;
		}
		return pd;
	}

	// /**
	// * Reads out all links don´t know why
	// *
	// */
	// public void readLinks(){
	// Statement stmt ;
	// try{
	// stmt = c.createStatement();
	// String sql = "SELECT * FROM LINK;";
	// ResultSet rs = stmt.executeQuery(sql);
	// while(rs.next()){
	// System.out.println("Link ID: " + rs.getInt("ID")+
	// "Kurs ID: " +rs.getInt("KID")+
	// "User ID: "+rs.getInt("UID"));
	// }
	// if(stmt!= null)stmt.close();
	// if(rs!= null)rs.close();
	// }catch(Exception e){
	// System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	// System.exit(0);
	// e.printStackTrace();
	// }
	// }

	/**
	 * Gets data from KURS table
	 *
	 * @param kstu
	 *            the level of the dancing lesson
	 * @param uid
	 *            the users id used to see if any links exists between him and
	 *            any KURS object
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
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			e.printStackTrace();
			return null;
		}

	}

	// public boolean aAddKurs(SQLKurs kurs) {
	// TODO outdated
	// PreparedStatement p;
	// try{
	// String sql = String sql = "INSERT INTO K (ID, NAME,KEY)"+
	// "VALUES(?,?,?);";
	// p = c.prepareStatement(sql);
	// p.executeUpdate();
	// c.commit();
	// if(p != null){
	// p.close();
	// }
	// return true;
	// }
	// catch(Exception e){
	// System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	// System.exit(0);
	// e.printStackTrace();}
	// return false;
	// }
	private String buildXML(Object object) {
		Style style = new HyphenStyle();
		Format format = new Format(style);

		Serializer serializer = new Persister(format);

		StringWriter writer = new StringWriter();

		try {
			serializer.write(object, writer);
			return writer.getBuffer().toString();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null; // TODO Error-Handling
		}
	}

	private Object parseXML(String xml, Class myClass) {
		Serializer serializer = new Persister();

		try {
			Object object = serializer.read(myClass, xml);
			return object;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null; // TODO: Error-Handling
		}
	}

	public void closeDatabaseConnection() {
		try {
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
