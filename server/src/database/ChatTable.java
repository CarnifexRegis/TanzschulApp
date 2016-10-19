package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChatTable {
	private Connection c;
	public ChatTable(){
		super();
	}
	/**
	 * Creates a new CHAT table if it does not yet exist.
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
			c.close();
			System.out.println("Table CHAT already exists");
			return true;
		} catch (Exception e) {
			/**
			 * This table contains chat messages
			 */
				Class.forName("org.sqlite.JDBC");
				stmt = c.createStatement();
				String sql = "CREATE TABLE CHAT"
						+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ " IDP1 INTEGER NOT NULL,"
						+ " IDP2 INTEGER NOT NULL,"
						+ " MESSAGES TEXT NOT NULL)";

				stmt.executeUpdate(sql);
				c.commit();
				if (stmt != null) {
					stmt.close();
				}
				c.close();
				System.out.println("Created a new instance of the CHAT table");
				return true;
		}
		}catch(Exception e){
			System.out.println("Couldn´t create a new Instance of the CHAT Table");
			System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating CHAT Table ");
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

