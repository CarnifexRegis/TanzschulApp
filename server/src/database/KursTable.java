package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KursTable {
	private Connection c;
	public KursTable(){
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
			c.close();
			return true;
		} catch (Exception e) {
			/**
			 * The table KURS containing the data of several dancing lessons
			 * ID			The ID of the object in the table
			 * KURSSTUFE	The level of the dancing lesson
			 * DATUM 		The date the dancing lessons start
			 * WOCHENTAG 	The day of the week the dancing lesson takes place
			 * UHRZEIT		The time the dancing lesson takes place
			 */
			
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
				System.out.println("Created new Instance of KURS table");
				c.close();
				return true;
		}
		}catch(Exception e){
			System.out.println("Couldn´t create a new Instance of the KURS Table");
			System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating KURS Table ");
			System.exit(0);
			
			try {
				if(c!= null){
				c.close();}
			} catch (SQLException e1) {
				System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ "coudn´t close connection in KursTable");
				e1.printStackTrace();
				return false;
			}
			return false;
		}
		
	}
}
