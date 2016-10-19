package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This class is used to crate a new table USER if idt does not yet exist
 * @author Simon Stolz
 *
 */
public class UserTable {
	private Connection c;
	public UserTable(){
		super();
	}
	/**
	 * Creates a new table USER if it does not yet exists
	 * @return returns true if successful
	 */
	public boolean create(){
		try{
		c = null;
		Statement stmt;
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:serverDatabase");
		c.setAutoCommit(false);
		try {
			String sql2 = "SELECT COUNT(*) AS I FROM USER ;";
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			rs.getInt("I");
			System.out.println("Table USER already exists");
			if (rs != null)rs.close();
			if (stmt != null) stmt.close();
			if(c != null) c.close();
			return true;
			
		} catch (Exception e) {
			/**
			 * The Table USER saves personal attributes of all registered users
			 * here 
			 * ID		The private ID of the object in the table 
			 * IPD		The public ID other Users may get to know
			 * EMAIL	The users e-mail he needs it for login purposes 
			 * PASSWORD The users key used to access his account 
			 * LN		The users last name FN The users first name 
			 * GENDER	The users gender 
			 * AGE		The users age 
			 * PTEXT	Some user created about me text 
			 * PNumber	The users phone number does not need to be specified
			 * PA		Tells if the users age is public to other users
			 * height	The users height does not nedd to be specified
			 */
		
				// TODO RESET AUTO INCREMENT AFTER DEBUGGING
				Class.forName("org.sqlite.JDBC");
				stmt = c.createStatement();
				String sql = "CREATE TABLE USER"
						+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + // 0 identification Number auto
						"IDP TEXT, " + " EMAIL TEXT NOT NULL," + // 1 e-Mail !
						" PASSWORD TEXT NOT NULL," + // 2 password !
						" LN TEXT NOT NULL," + // 3 last name !
						" FN TEXT NOT NULL," + // 4 first name !
						" GENDER INTEGER NOT NULL, " + // 5 gender !
						" AGE INTEGER NOT NULL," + // 6 age !
						" PTEXT TEXT," + // 7 profile text (a possibility for the User to introduce himself)
						" PNumber TEXT ," + // 8 phone number
						" PA INTEGER NOT NULL ," + // 9 Public Age!(Boolean, always set 0=False 1=True)
						" HEIGHT INTEGER)"; // 10 height

				stmt.executeUpdate(sql);
				if (stmt != null) stmt.close();
				c.commit();
				System.out.println("Created new instance of USER table");
				if(c!=null)c.close();
				return true;
		}
		}catch(Exception e){
			System.out.println("Couldn´t create a new Instance of the USER Table");
			System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating USER Table ");
			System.exit(0);
			
			try {
				if(c!= null){
				c.close();}
			} catch (SQLException e1) {
				System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ "coudn´t close connection in UserTable");
				e1.printStackTrace();
				return false;
			}
			return false;
		}
		
	}

}
