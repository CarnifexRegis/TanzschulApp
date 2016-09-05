package model;

import java.util.ArrayList;
/**
 * @author Simon Stolz
 * Source:  
 *			Abi Quiz-App by Tim Möschel
 *	@attribute If an Task needs acces to the database it calls an instance of this class
 *
 */






import database2.Kurs;
import database2.ProfileChart;
import database2.ProfileData;
import database2.SQL;

public class Model {
	private static Model instance;
	private SQL sql;
/**
 * The constructor gets an instance of the SQL class, which uses JDBC to access the Server sDatabase
 */
	private Model() {
		sql = new SQL();
		System.out.println("Constructor of the Model was called");
	}
/**
 * Static Method that calls an instance of it self if it doesn´t already exist
 */
	public static Model getInstance() {
		if (instance == null)
			instance = new Model();
		System.out.println("got an Instance of the Model");
		return instance;
	}
	/**
	 * 
	 * @param id		the id of the user
	 * @param gender	the gender of the user
	 * @param kstu		the "level" of the dancing lesson
	 * @param age		the age of the User
	 * @return returns an Profile Chart Array<List>
	 */
	public ArrayList<ProfileChart> getCharts(int id,boolean gender,int kstu, int age,String day) {
		int g;
		if (gender){
			 g = 1;
		}else{
			g = 0;
		}
		
		if (sql.checkID(id)) {
			
			return sql.getProfilecharts(g, kstu, 0,day);
		}
		else {
			return null ;
			}
	}
	/**
	 * @attribute This method recieves your E-Mail and password and passes it on to SQL.LogIn
	 * E-Mail and password and returns your id if it´s correct
	 * @param em	The E-Mail of the User
	 * @param ps	The  Users Password
	 * @return returns the id of the User
	 */
	public int Login (String em ,String ps){
		return sql.LogIn(em, ps);
	}
	/**
	 * This method is called to extract the Gender of an specific user 
	 * @param id	The id of the user
	 * @return 
	 * @return		Returns the Gender of the User as int three Values are possible : 1 for female, 0 for male and -1 in case of an Error
	 */
	public ProfileData getProfileData(int id){
		if(sql.checkID(id)){
		return sql.getProfileData(id);
		}
		return null;
	}
	public boolean UpdateProfile(int id, String pn, int height,int age,String pText, boolean pa){
		int intPa;
		if(pa){
			intPa = 1;
		}else{
			intPa= 0;
		}
		return sql.updateProfile(id, pn, height, age, pText, intPa);
	
		
	}
	public ArrayList<Kurs> readKurs(int id){
		if(sql.checkID(id)){
		return sql.readKurs();
		}
		return null;
	}
	public Boolean addLink(int id, int kid){
		if(sql.checkID(id)){
			sql.addLink(id, kid);
		}
		return true;
		
	}
	public int getGender(int id){
		return sql.getGender(id);
	}
	public int register(String em,String ps, String ln, String fn, int g,int age, int pa ){
		return sql.addUser(em, ps, ln, fn, g, age, pa);
	}
	public ProfileData getfProfile(String eMail) {
	return sql.getProfileData(sql.getUserIDByEMAIL(eMail));
	}
}
