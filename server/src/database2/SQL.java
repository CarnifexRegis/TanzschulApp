package database2;
import java.awt.List;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;
/**
 * 
 * @author Simon
 *Sources: 
 *			Abi Quiz-App by Tim M�schel
 *			http://stackoverflow.com/questions/23851158/check-if-some-string-is-in-sqlite-database
 *			http://stackoverflow.com/questions/7886462/how-to-get-row-count-using-resultset-in-java
 *			http://www.tutorialspoint.com/jdbc/jdbc-select-records.htm
 *			http://www.w3schools.com/sql/sql_update.asp		
 */
public class SQL {
	
private Connection c;
//https://coderanch.com/t/300886/JDBC/databases/Proper-close-Connection-Statement-ResultSet
// TODO try out that fancy shit if you have leaft over time
/**
 * 
 */
	public SQL(){
		try
		{
			//Create Database
			c= null;
			Statement stmt = null;
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:serverDatabase");
			
			c.setAutoCommit(false);
			
			//creating Table KURS
			
			//DatabaseMetaData dbm =c.getMetaData();
			//ResultSet tables = dbm.getTables(null,null,"KURS",null);
			try{
				//TODO buggy
				String sql2 = "SELECT COUNT(*) AS I FROM KURS ;";
				//String sql = "SELECT COUNT(*) AS PS FROM USER WHERE EMAIL = 'hallo' AND PASSWORD = 'geheim' ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				int i = rs.getInt("I");
				
			}catch(Exception e){
				try{
					Class.forName("org.sqlite.JDBC");
					stmt = c.createStatement();
					String sql = "CREATE TABLE KURS "+
							"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
							" KURSSTUFE TEXT NOT NULL, " +
							" DATUM     DATE NOT NULL, " +
							" WOCHENTAG TEXT NOT NULL, " +
							" UHRZEIT   TEXT NOT NULL)";
		
					stmt.executeUpdate(sql);
					
					c.commit();
					
					if(stmt != null){
						stmt.close();}
					System.out.println("New KURS Instance");
				}catch(Exception e1){
					System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
			        System.exit(0);
				}
			
			}
			// creating Table USER
			//	7.8.16 combined USER with Profileddata due reasons of simplicity
		//	dbm =c.getMetaData();	
			//tables = dbm.getTables(null,null,"USER",null);
			try{
				//TODO buggy
				String sql2 = "SELECT COUNT(*) AS I FROM USER ;";
				//String sql = "SELECT COUNT(*) AS PS FROM USER WHERE EMAIL = 'hallo' AND PASSWORD = 'geheim' ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				int i = rs.getInt("I");
				
			}catch(Exception e){	
				try{
				Class.forName("org.sqlite.JDBC");
				stmt = c.createStatement();
				String sql= "CREATE TABLE USER" +
							"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + //0 identification Number   auto
							" EMAIL TEXT NOT NULL," +					//1 e-Mail					!
							" PASSWORD TEXT NOT NULL," +				//2 password				!
							" LN TEXT NOT NULL,"+						//3 last name				!
							" FN TEXT NOT NULL,"+						//4 first name				!
							" GENDER INTEGER NOT NULL, "+				//5 gender					!
							" AGE INTEGER NOT NULL,"+					//6 age						!
							" PTEXT TEXT,"+								//7 profile text			 (a possibility for the User to introduce him self)
							" PNumber INTEGER ,"+						//8 phone number
							" PA INTEGER NOT NULL ,"+			//9 Public Age				!(Boolean, always set 0=False  1=True
							" HIGHT INTEGER)";							//10 hight
				
				stmt.executeUpdate(sql);
				if(stmt != null){
				c.commit();
					stmt.close();
				}
				System.out.println("New USER Instance");	
				}catch(Exception e1){
					System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
			        System.exit(0);
				}
			}
				// creating link Table
				// 7.8.16
				//dbm = c.getMetaData();
				//tables = dbm.getTables(null, null, "LINK", null);
			try{
				//TODO buggy
				String sql2 = "SELECT COUNT(*) AS I FROM LINK ;";
				//String sql = "SELECT COUNT(*) AS PS FROM USER WHERE EMAIL = 'hallo' AND PASSWORD = 'geheim' ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql2);
				int i = rs.getInt("I");
				
			}catch(Exception e){
				
					try{
					Class.forName("org.sqlite.JDBC");
						stmt= c.createStatement();
						String sql = "CREATE TABLE LINK" +
									 "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+ // some Guys on Stackoverflow said you better have a primary key so i got me one....
									 " UID INTEGER NOT NULL,"+
									 " KID INTEGER NOT NULL)";
								 
					stmt.executeUpdate(sql);
					c.commit();
					if(stmt != null){
						stmt.close();
						}	
					
						System.out.println("New LINK Instance");
						}catch(Exception e1){
							System.err.println( e1.getClass().getName() + ": " + e1.getMessage() );
					        System.exit(0);
						}
								}
			//Tests
		//	eMailExists("hi");
		//	addUser("Huan@huan.de","geheim","a","Wurst",0,8,0);
		//	addUser("df@huan.de","geheim","b","Wurst",1,8,0);
		//	addUser("mfmn@huan.de","geheim","c","Wurst",0,8,1);
			addUser("hallo","geheim","Hans","d",1,8,0);
		//	addUser("jzt@huan.de","geheim","e","Wurst",0,8,1);
		//	addUser("Hjzg@huan.de","geheim","f","Wurst",0,8,0);
		//	addUser("zjg@huan.de","geheim","g","Wurst",0,8,1);
			getAllUserData();
			
			//addKurs(1,"25.03.2016","Donnerstag","15:25");
			//addKurs(2,"25.03.2016","Donnerstag","15:25");
		//	readKurs();
		//	addLink(1, 1);
		//	addLink(2,1);
		//	addLink(3,1);
		//	addLink(4,1);
		//	addLink(5,1);
		//	addLink(6,1);
		//	addLink(7,2);
		//	addLink(1,2);
			//eMailExists("Huan@huan.de");
		//	readLinks();
		//	myKurs(1);
		//	getProfilecharts(1, 1,87);
		//	getProfilecharts(1, 1,50);
		//	LogIn("hallo","geheim");
			getProfileData(1);
						}catch(Exception e){
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				        System.exit(0);	}
			}
	//methods
	// sources: http://stackoverflow.com/questions/23851158/check-if-some-string-is-in-sqlite-database
	/**
	 * 
	 * @param em
	 * @return
	 */
	public boolean eMailExists(String em){
		Statement stmt = null;
		try{
			stmt = c.createStatement();
			String sql = " SELECT COUNT(*) AS COUNT FROM USER WHERE EMAIL = '" + em + "';";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				int count = rs.getInt("count");
				if (rs != null)rs.close();
				if(stmt!= null)stmt.close();
				if(count == 0){
				//	System.out.println("nope");
					return false;
					}
				else
					{
					
					System.out.println("The requested E-Mail already exists in our database");
					return true;
					}
				}	
			}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
			}
		return true;
		}
	/**
	 * 
	 * @param em
	 * @param ps
	 * @param ln
	 * @param fn
	 * @param g
	 * @param age
	 * @return
	 */
	public int addUser(String em, String ps,String ln,  String fn, int g,int age,int pa){
		int i;
		Statement stmt;
		try{
			String sql2 = "SELECT COUNT(EMAIL) AS I FROM USER"
					+ " WHERE USER.EMAIL= '"+ em + "' ;";
		
			 stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql2);
			i = rs.getInt("I");
		//if(rs!=null){rs.close();}
		if(i==0){
		
			String sql = "INSERT INTO USER(EMAIL,PASSWORD,LN,FN,GENDER,AGE,PA)"+ 
					  	 "VALUES(?,?,?,?,?,?,?);";						// new Version similar to the dedicated source
			PreparedStatement p = c.prepareStatement (sql);
			p.setString(1,em);
			p.setString(2, ps);
			p.setString(3,ln);
			p.setString(4,fn);
			p.setInt(5, g);
			p.setInt(6,age);
			p.setInt(7,pa);
			p.executeUpdate();
			c.commit();
			if(p!=null)p.close();
			System.out.println(getUserIDByEMAIL(em));
			return getUserIDByEMAIL(em);// returns the id after success
			
			}
		else{
			return -1;//email already exists
		}
		}
		catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	        return -2;// Sql Error
	        
			}
		
		
		
	}
	public int getUserIDByEMAIL(String em){
		Statement stmt = null;
		try{
			stmt = c.createStatement();
			String sql = "SELECT ID FROM USER WHERE EMAIL = '" + em + "';";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				int id = rs.getInt("id");
				if (rs != null)rs.close();
				if(stmt!= null)stmt.close();
				return id;
				}
			else
				{
				if (rs != null)rs.close();
				if(stmt!= null)stmt.close();
				return -1;
				}
			}
		catch (Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
			}
		return -1;
		}
	/**
	 * 
	 * @return
	 */
	public ArrayList<UserData> getAllUserData(){
		//this Method grabs the user data of all listed users
		//sources I used : http://stackoverflow.com/questions/7886462/how-to-get-row-count-using-resultset-in-java
		//					http://www.tutorialspoint.com/jdbc/jdbc-select-records.htm
		//TODO
		Statement stmt= null;
		ArrayList<UserData> dataList = new ArrayList<UserData>();
		// Change to get full Userdata later on
		try {
			String sql = "SELECT EMAIL,LN,FN,GENDER,AGE,PA FROM USER";
			stmt = c.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String eMail = rs.getString("EMAIL");
				String ln = rs.getString("LN");
				String fn = rs.getString("FN");
				int g = rs.getInt("GENDER");
				int age = rs.getInt("AGE");
				int pa =  rs.getInt("PA");
				System.out.println(" "+eMail+" "+ln+ " "+fn+ " "+ g +" " +age+ " " + pa);
			dataList.add(new UserData(eMail, fn, ln, g, pa, age));
			}
			if (rs != null)rs.close();
			if(stmt!= null)stmt.close();
			
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
			e.printStackTrace();
		}
		
		return dataList;
	}
	
	/**
	 * 
	 * @param kursstufe		
	 * @param datum			
	 * @param wochentag		
	 * @param uhrzeit		
	 */
	public void addKurs(int kursstufe, String datum, String wochentag,String uhrzeit)  {

		PreparedStatement p;
		try {
			p = c.prepareStatement("INSERT INTO KURS (KURSSTUFE, DATUM, WOCHENTAG, UHRZEIT)"
									+ "  VALUES (?, ?, ?, ?);");
			p.setInt(1, kursstufe);
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			Date parsed = format.parse(datum);
            java.sql.Date sqldate = new java.sql.Date(parsed.getTime());
            p.setDate(2, sqldate);
            p.setString(3, wochentag);
            p.setString(4, uhrzeit);
            p.executeUpdate();
           // p.addBatch();
           // c.setAutoCommit(false);
           // p.executeBatch();
           // c.setAutoCommit(true);
           //ResultSet rs = prep.getGeneratedKeys();
            //if (rs.next()) {
            //	return (int) rs.getLong(1);
            //}
            //
            //rs.close();
            c.commit();
           if(p!=null) p.close();
		} catch (SQLException | ParseException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
			e.printStackTrace();
				}
	}
	/**
	 * Creates a Connection between the KURS and USER table
	 * @param uid	ID of The User	that shall be connected
	 * @param kid	ID of the Kurs	that shall be connected
	 */
	public void addLink(int uid, int kid){
		PreparedStatement p ;
		try{
			String sql = "INSERT INTO LINK (UID, KID) VALUES(?,?);";
			p= c.prepareStatement(sql); 
			p.setInt(1, uid);
			p.setInt(2, kid);
			p.executeUpdate();
			c.commit();
			if(p!=null)p.close();
			
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
			e.printStackTrace();
		}	
	
	}
	/**
	 * 
	 * @param uid		
	 * @return
	 */
	public ArrayList<Integer> myKurs(int uid){
		Statement stmt;
		ArrayList<Integer> kursList = new ArrayList<Integer>();
		//TODO also Extract UHRZEIT DATUM  KURSSTUFE
		try{
			//System.out.println(""+uid);
			stmt = c.createStatement();
			String sql = "SELECT KURS.ID AS ID FROM KURS JOIN LINK  ON LINK.KID = KURS.ID"
					+ " JOIN USER ON LINK.UID = USER.ID "
					+ "WHERE LINK.UID ='"+ uid +"' ;" ;
			//TODO further testing althoug  method passed the first Tests 
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				int id = rs.getInt("ID");
				System.out.println("Listed Kurs :"+id);
				kursList.add(id);
			}
		
			if (rs != null)rs.close();
			if(stmt!= null)stmt.close();
			
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
			e.printStackTrace();
		}
		return kursList;
	}
	
	public void restorePassword (){}
	
	
	public void fullProfiledata(){}
	/**
	 * 
	 * @param gender	The gender of the requesting User
	 * @param kstu		The required dancing lesson "level"
	 * @param myage		The age of the requesting user (not used but may be in the Future)
	 * @return
	 */
	public ArrayList<ProfileChart> getProfilecharts(int gender, int kstu,int myage){
		//TODO age
		Statement stmt;
		ArrayList<ProfileChart>  pc = new ArrayList<ProfileChart>();
		try{
			String sql = "SELECT USER.FN, USER.LN, USER.AGE, KURS.UHRZEIT,USER.EMAIL, KURS.DATUM "
						+ "FROM KURS "
						+ "JOIN LINK  ON LINK.KID = KURS.ID"
						+ " JOIN USER ON LINK.UID = USER.ID "
						+ "WHERE GENDER != "+gender 
						+ " AND KURSSTUFE = "+ kstu;
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String fn = rs.getString("FN");
				String ln =rs.getString("LN");
				int age = rs.getInt("AGE");
				String uhr = rs.getString("UHRZEIT");
				String date = "" +rs.getDate("DATUM");
				String eMail = rs.getString("EMAIL");
				
				System.out.println(fn);
				System.out.println(ln);
				System.out.println(age);
				System.out.println(uhr);
				System.out.println(date);
				pc.add(new ProfileChart(fn,ln,age,uhr,date,eMail));
			}
			if(stmt!= null)stmt.close();
			if(rs!= null) stmt.close();
		}catch(Exception e){
		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
		e.printStackTrace();
		}
		return pc;
	}
	/**
	 * With this Method the User can modify the saved Data about himself.
	 * @param ptext		Some Text the user writes about himself
	 * @param pnumber	The users Phone Number
	 * @param pa		This parameter indicates if the users Age shall be public
	 * @param hight		The users hight
	 * @param id		The id of the users account used to verify himself
	 */
	public void updateProfile(String ptext, int pnumber, int pa, int hight, int id ){
		//Source  http://www.w3schools.com/sql/sql_update.asp
		PreparedStatement p;
		try{
			String sql = "UPDATE USER SET PTEXT = ? , PNUMBER = ? , PA = ?, HIGHT = ? WHERE ID = ?;";
			p = c.prepareStatement(sql);
			p.setString(1, ptext);
			p.setInt(2, pnumber);
			p.setInt(3, pa);
			p.setInt(4,hight);
			p.setInt(5,id);
			c.commit();
			if (p != null)p.close();		
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
			e.printStackTrace();
		}	
	}
//	public Login logIn(){}
	/**
	 * 
	 * @param em	the email you want to log in with
	 * @param ps	the fitting password
	 * @return 		returns the User ID according to the Login E-Mail
	 */
		public 	int LogIn(String em, String ps){ // id check
			Statement stmt;
			
			int i;
			try{
				//TODO buggy
				String sql = "SELECT COUNT(ID) AS I FROM USER"
							+ " WHERE USER.EMAIL='"+ em + "' AND PASSWORD = '"+ps+"' ;";
				//String sql = "SELECT COUNT(*) AS PS FROM USER WHERE EMAIL = 'hallo' AND PASSWORD = 'geheim' ;";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				 i = rs.getInt("I");
				if(rs!=null)rs.close();
				if( i == 1){
					int id;
					try{
						 stmt = c.createStatement();
						String sql2 = "SELECT ID FROM USER WHERE EMAIL = '" + em + "' ;";
						ResultSet rs2 = stmt.executeQuery(sql2);
						id = rs2.getInt("ID");
						if(stmt!=null)stmt.close();
						if(rs!=null)rs.close();
						System.out.println(id);
						return id;
					}catch(Exception e){
						System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				        System.exit(0);
						e.printStackTrace();
					}
				}else{
					if(i<1){
						System.out.println("Wrong Password");
					}else{
						System.out.println("Some Error occured loging in");
					}
				}
				}
			catch(Exception e){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
				e.printStackTrace();
				}
					return -1;
			}
/**
 * @attribute 	Checks if an User with this ID exists
 * @param  		The Users ID
 * @return		returns true if it exists.
 */
		public  boolean checkID(int id){ // Login returns the user id
			Statement stmt;
			int i;
			
			try{
				
				String sql ="SELECT COUNT (ID) AS COUNT FROM USER WHERE ID = '"+ id+ "';";
				stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				i = rs.getInt("COUNT");
				if(i== 1){
					return true;
				}else{
					if(i ==0){
						System.out.println("Wrong ID");
						return false;
					}
				}
			}catch(Exception e ){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
				e.printStackTrace();
				System.out.println("Something went wrong at checkID(id)");
			
			}
			return false;
		}
		/**
		 * Recieves the ID and reads out the Gender according to the id.
		 * @param id	ID of the User
		 * @return		Returns the Gender of the User as int three Values are possible :
		 * 				1 for female, 0 for male and -1 in case of an Error
		 */
		public int getGender(int id){
			Statement stmt; 
			int gender;
			try{
				//Creates a new Satement
				stmt = c.createStatement();
				//Creates a new String that will be executed as SQL Statement / Query
				String sql = "SELECT GENDER FROM USER WHERE ID = '" +id + "' ;";
				//The Query gets executed and its result is saved in an ResultSet Object
				ResultSet rs = stmt.executeQuery(sql);
				//Reads out the int Value of the extracted Integer "GENDER" from the ResultSet
				gender = rs.getInt("GENDER");
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
				System.out.println("Extracted Gender = "+gender);
				// returns the extracted int value "gender"
				return gender;
			}catch(Exception e){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
				e.printStackTrace();
				
			}
			// in case of an Error it returns -1
				return -1;
			
		}
		public ProfileData getProfileData(int id){
			
			Statement stmt= null;
			ProfileData pd = null;
			try {
				String sql = "SELECT EMAIL,LN,FN,GENDER,AGE,PA,PTEXT, PNumber, HIGHT FROM USER WHERE ID = '"+id+"';";
				stmt = c.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql);
				
				//	String eMail = rs.getString("EMAIL");
					String ln = rs.getString("LN");
					String fn = rs.getString("FN");
					String pText = rs.getString("PTEXT");
					int hight = rs.getInt("HIGHT");
					int phoneNumber = rs.getInt("PNumber");
					
					int g = rs.getInt("GENDER");
					int age = rs.getInt("AGE");
					int pa =  rs.getInt("PA");
					boolean gender;
					boolean pAge;
					if (pa ==1){
						pAge = true;
					}else {
						pAge = false;
					}
					if (g ==1){
						gender = true;
					}else {
						gender = false;
					}
					//System.out.println(" "+eMail+" "+ln+ " "+fn+ " "+ g +" " +age+ " " + pa);
				pd =   new ProfileData(fn, ln, pText, age, hight, phoneNumber, gender, pAge);
				
				if (rs != null)rs.close();
				if(stmt!= null)stmt.close();
				
			} catch (SQLException e) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
				e.printStackTrace();
				return null;
			}
			return pd;
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//Tim 	
//	private String buildXML(Object object)
//	{
//		Style style = new HyphenStyle();
//		Format format = new Format(style);
//		
//		Serializer serializer = new Persister(format);
//		
//		StringWriter writer = new StringWriter();
//		
//		try
//		{
//			serializer.write(object, writer);
//			return writer.getBuffer().toString();
//		}
//		catch(Exception e)
//		{
//			return null; //TODO Error-Handling
//		}
//	}
//	
//	private Object parseXML(String xml, Class myClass)
//	{
//		Serializer serializer = new Persister();
//		
//		try
//		{
//			Object object = serializer.read(myClass, xml);
//			return object;
//		}
//		catch(Exception e)
//		{
//			return null; //TODO: Error-Handling
//		}
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Test methods
		public void readLinks(){
			Statement stmt ;
			try{
				stmt = c.createStatement();
				String sql = "SELECT * FROM LINK;";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					System.out.println("Link ID: " + rs.getInt("ID")+
							"Kurs ID: " +rs.getInt("KID")+
							"User ID: "+rs.getInt("UID"));
				}
				if(stmt!= null)stmt.close();
				if(rs!= null)rs.close();
			}catch(Exception e){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
				e.printStackTrace();
			}
		}
		public void readKurs(){
			Statement stmt;
			try{
				stmt=c.createStatement();
				String sql = " SELECT ID FROM KURS;";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					System.out.println(rs.getString("ID"));
				}
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
			}catch(Exception e){
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
				e.printStackTrace();
			}
			
		}
}


				
				
						
		

