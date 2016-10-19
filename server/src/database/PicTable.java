package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PicTable {
	private Connection c;
	public PicTable(){
		super();
	}
	/**
	 * Creates a new PIC table if it does not yet exists
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
			String sql2 = "SELECT COUNT(*) AS I FROM PIC ;";
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			rs.getInt("I");
			System.out.println("Table PIC already exists");
			if (rs != null) rs.close();
			if (stmt != null)stmt.close();
			if(c != null)c.close();
			return true;
		} catch (Exception e) {
				/**
				 * The Table pic used to safe profile pictures 
				 * ID The ID of the object in the table 
				 * IMAGE An image encoded to an base64 String 
				 * UID The user the image belongs to 
				 * UIDP The users public identifier
				 */
				Class.forName("org.sqlite.JDBC");
				stmt = c.createStatement();
				String sql = "CREATE TABLE PIC "
						+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
						+ " IMAGE TEXT NOT NULL, "
						+ " UID INTEGER NOT NULL );";

				stmt.executeUpdate(sql);
				if (stmt != null) {
					stmt.close();
				}
				c.commit();
				System.out.println("Created new instance of PIC table");
				if(c!= null)c.close();
				return true;
		}
		
		}catch(Exception e){
			System.out.println("Couldn´t create a new Instance of the PIC Table");
			System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating PIC Table ");
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
