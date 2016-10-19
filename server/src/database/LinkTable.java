package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This Class is for Creating a LINK Table if it doesn´t exist.
 * @author Simon Stolz
 *
 */
public class LinkTable {
	private Connection c;
	public LinkTable(){
		super();
	}
	/**
	 * Creates a new AdminTable if it does not yet exists
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
			// TODO buggy
			String sql2 = "SELECT COUNT(*) AS I FROM LINK ;";
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			rs.getInt("I");
			if (rs != null)rs.close();
			if (stmt != null)stmt.close();
			System.out.println("Table LINK already exists");
			if(c!= null)c.close();
			return true;
		} catch (Exception e) {

		
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
				if (stmt != null) stmt.close();
				System.out.println("Created new instance of LINK table");
				if(c!= null)c.close();
				return true;
		}
		}catch(Exception e){
			System.out.println("Couldn´t create a new Instance of the LINK Table");
			System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating LINK Table ");
			System.exit(0);
			
			try {
				if(c!= null){
				c.close();}
			} catch (SQLException e1) {
				System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ "coudn´t close connection in LinkTable");
				e1.printStackTrace();
				return false;
			}
			return false;
		}
		
	}
}
