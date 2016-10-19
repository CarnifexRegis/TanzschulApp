package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This Class is for creating an ADMIN Table if it does not yet exist
 * @author Simon Stolz
 *
 */
public class AdminTable {
	private Connection c;
	public AdminTable(){
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
			c.close();
			return true;
		} catch (Exception e) {
			
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
				c.close();
				return true;
		}
		}catch(Exception e){
			System.out.println("Couldn´t create a new Instance of the ADMIN Table");
			System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating ADMIN Table ");
			System.exit(0);
			
			try {
				if(c!= null){
				c.close();}
			} catch (SQLException e1) {
				System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ "coudn´t close connection in AdminTable");
				e1.printStackTrace();
				return false;
			}
			return false;
		}
		
	}
}
