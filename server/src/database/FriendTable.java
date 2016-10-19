package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendTable {
	Connection c;
	public boolean create(){
		try{
			c = null;
			Statement stmt;
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:serverDatabase");
			c.setAutoCommit(false);
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
				c.close();
				System.out.println("Table FRIEND already exists");
				return true;
			} catch (Exception e) {
				
				/**
				 * Creates the table FRIEND
				 */
				
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
					System.out.println("Created new instance of the FRIEND table");
					c.close();
					return true;
			}
			}catch(Exception e){
				System.out.println("Couldn´t create a new Instance of the FRIEND Table");
				System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ " creating FRIEND Table ");
				System.exit(0);
				
				try {
					if(c!= null){
					c.close();}
				} catch (SQLException e1) {
					System.err.println(e.getClass().getName() + ": "+ e.getMessage()+ "coudn´t close connection in  FriendTable");
					e1.printStackTrace();
					return false;
				}
				return false;
			}
	}
}
