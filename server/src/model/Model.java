package model;

import java.util.ArrayList;
/**
 * @author Simon Stolz
 * Source:  
 *			Abi Quiz-App by Tim Möschel
 *	@attribute If an Task needs acces to the database it calls an instance of this class
 *
 */














import main.Main;
import database.TableManager;
import database_utils.ChatMessage;
import database_utils.Friend;
import database_utils.FriendRequestItem;
import database_utils.Kurs;
import database_utils.ProfileChart;
import database_utils.ProfileData;
import database_utils.SQL;
import database_utils.SQLKurs;
import database_utils.aKurs;

/**
 * The Class Model.
 *
 * @author Simon Stolz
 * @ Source Abi Quiz app by Tim Möschel
 * This class is used to access the sql class
 */
public class Model {
	
	private static Model instance;
	private SQL sql2;
	private TableManager sql;

/**
 * The constructor gets an instance of the SQL class, which uses JDBC to access the Server sDatabase.
 */
	
	private Model() {
		sql = new TableManager();
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//	sql = new SQL();
		System.out.println("Constructor of the Model was called");
	}
	public ArrayList <ChatMessage> PollChat(int cid , int lmid){
		return sql.pollMessages(cid, lmid);
	}
	public boolean addMessage(int cid, int id, String message){
		return sql.addMessage(cid, id, message);
	}
public ArrayList<Friend> getOpenChats(int id){
	return sql.getOpenChats(id);
}
/**
 * Static Method that calls an instance of it self if it doesn´t already exist.
 *
 * @return single instance of Model
 */
	public static Model getInstance() {
		if (instance == null)
			instance = new Model();
		System.out.println("got an Instance of the Model");
		return instance;
	}
	/**
	 * Sets all FRIRND objects having a fitting combination of id1 and my id 1 to ACCEPTED = 1
	 * @param mid my id
	 * @param fidp the foreign users idp
	 * @return true if succcessfull
	 */
	public boolean addFriend(int mid, String fidp){
		return sql.addFriend (mid, sql.getUserIDByIDP(fidp));
	}
	/**
	 * 
	 * @param idpl
	 * @param myid
	 * @return
	 */
	public boolean acceptFriendrequest(ArrayList<Integer>idpl, int myid){
		return sql.acceptRequests(idpl, myid);
	}
	/**
	 * 
	 * @param myid
	 * @return
	 */
	public ArrayList<FriendRequestItem> getFriendrequests(int myid){
		return sql.getFriendRequests(myid);
	}
	/**
	 * Calls SQL.addAdmin to add a new admin if he doesn´t yet exist
	 *
	 * @param n The admins "name"
	 * @param k The key to access the acount
	 * @param main the main
	 * @return  Returns true in case of success and false otherwise
	 */
	//@return returns the identifier of the admin if there exist an entry in admin Table that matches the input
	public boolean addAdmin(String n, String k,Main main){
		return sql.addAdmin(n, k);
	}
	/**
	 * Calls SQl.aLogIn to check if an Object in table USER with the provided Values exists and may recieve this users id

	 * @param n The  admins "name"
	 * @param k The suitable key to access admin  permissions
	 * @return Returns the id of  the column that fits name and key insert
	 * 			if there wasn´t found a match it returns -1
	 * 			if an error occurs it return -2
	 */
	public int aLogin(String n, String k){
		return sql.aLogIn(n, k);
	}
	/**
	 * Calls SQL.acheckID to check if there exists a Object in table admin with the privided values 
	 * @param id the id that needs to be searched for
	 * @return true if exists false if not
	 */
	public boolean checkAdmin(int id){
		return sql.acheckID(id);
	}
	/**
	 * Calls SQL.deleteKurs to delete a specific  Object from KURS  with the provided id and also all  Links that refer on this KURS Object
	 * 
	 * @param kid The id of the Kurs that ought to be deleted
	 * @return Returns true if the deletion was successful else returns false
	 */
	public boolean deleteKurs( int kid){
		return sql.deleteKurs(kid);
	}
	
	/**
	 * Calls SQL.getProfileCharts to get all Objects from User that fit the provide criteria
	 *
	 * @param gender the gender of the user (result Objects have the opposite gender)
	 * @param kstu 	the "level" of the dancing lesson
	 * @param age 	the age of the User ! not yet used
	 * @param day the day
	 * @return returns an Profile Chart Array<List>
	 */
	public ArrayList<ProfileChart> getCharts(boolean gender,int kstu, int age,int day) {
		int g;
		String sDay;
		switch(day){
		case 1:
			sDay = Week.MONDAY.getdNa();
			break;
		case 2:
			sDay = Week.TUESDAY.getdNa();
			break;
		case 3:
			sDay = Week.WEDNESSDAY.getdNa();
			break;
		case 4:
			sDay = Week.THURSDAY.getdNa();
			break;
		case 5:
			sDay = Week.FRIDAY.getdNa();
			break;
		case 6:
			sDay = Week.SATURDAY.getdNa();
			break;
		case 7:
			sDay = Week.NONE.getdNa();
			break;
		default:
			sDay = Week.MONDAY.getdNa();
			break;
		}
		if (gender){
			 g = 1;
		}else{
			g = 0;
		}
		
		
			
			return sql.getProfilecharts(g, kstu, 0,sDay);
		}
		
	
	/**
	 * Calls SQL.LogIn to Check if an Object in table  USER exists having the provided attributes
	 * @param em	The E-Mail of the User
	 * @param ps	The  Users Password
	 * @return returns the id of the User
	 */
	public int Login (String em ,String ps){
		return sql.LogIn(em, ps);
	}
	
	/**
	 * Calls SQL.getProfileData to get  attributes from the the Obj	ect in table USER with an id equals the provided id (just the User himself knows his actual id)
	 *
	 * @param id the id
	 * @return Returns an ProfileData object if successful else returns null.
	 */
	public ProfileData getProfileData(int id){
		
		return sql.getProfileData(id);
			
	}
	
	/**
	 * Calls SQL.updateProfile to Update in the provided values in the USER Column that has an id equals the provided id (just the User himself knows his actual id)
	 *
	 * @param id The identifier of an user object in user table.
	 * @param pn Attribute representing the phone number of the user.
	 * @param height Attribute representing the height of the user.
	 * @param age Attribute representing the Users Age.
	 * @param pText Attribute representing the Users about me text.
	 * @param pa Tells if the users Age is set public.
	 * @return true, if successful
	 */
	public boolean UpdateProfile(int id, String pn, int height,int age,String pText, boolean pa){
		int intPa;
		if(pa){
			intPa = 1;
		}else{
			intPa= 0;
		}
		return sql.updateProfile(id, pn, height, age, pText, intPa);
	/**
	 * Calls SQL.checkID to check if an column in table USEr having the dedicate id value in column ID exists 
	 *  @param id The identifier of an user object in user table.
	 *  @return if an fitting column was found returns the ID column    of the column 
	 */
	}
	
	/**
	 * Checks if the id exists for any user in the db
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean checkId (int id){
		return sql.checkID(id);
	}
	
	/**
	 * Calls an ArrayList of Data extracted from objects of the KURS table that fit the provided KURSSTUFE.
	 *
	 * @param ks The level of the dancing  lesson
	 * @return returns an ArrayList of Kurs Object containing extracted data from the data base
	 */
	public ArrayList<aKurs> getaKurs(int ks){
		return sql.getaKurs(ks);
	}
	
	/**
	 * Calls SQL.addLink to extract all objects from table KURS having the provided  KURSSTUFE value  and see if ther exist a link between the extracted object and the user that calls this method using an http request
	 *
	 * @param id The Identifer of the USER
	 * @param ks The provied value that has to equal the Value in column KURSSTUFE
	 * @return the kurs
	 */
	public ArrayList<Kurs> getKurs(int id,int ks){
		return sql.getKurs(ks,id);
	}
	
	/**
	 * Calls SQL.addLink to create a new object in Link table with the provided values
	 *
	 * @param uid Value for the UID column
	 * @param kid Value for the KID column
	 * @return the boolean
	 */
	public Boolean addLink(int uid, int kid){
		
			return sql.addLink(uid, kid);	
	}
	
	/**
	 * Calls SQL.deleteLink to delete the Link WHERE UID = uid AND KID = kid
	 *
	 * @param uid The Id of the User
	 * @param kid The id of th eKrus object he wants to delete
	 * @return the boolean
	 */
	public Boolean deleteLink(int uid, int kid){
		
			return sql.deleteLink(uid, kid);
		
	
		
	}
	
	/**
	 * This method is called to extract the Gender of an specific user .
	 *
	 * @param id The id of the user
	 * @return 	Returns the Gender of the User as int three Values are possible : 1 for female, 0 for male and -1 in case of an Error
	 */
	public int getGender(int id){
		return sql.getGender(id);
	}
	
	/**
	 * Register.
	 *
	 * @param em the em
	 * @param ps the ps
	 * @param ln the ln
	 * @param fn the fn
	 * @param g the g
	 * @param age the age
	 * @param pa the pa
	 * @return the int
	 */
	public int register(String em,String ps, String ln, String fn, int g,int age, int pa ){
		return sql.addUser(em, ps, ln, fn, g, age, pa);
	}
	
	/**
	 * Requests the ProfileData from an  specific user object in Table user specified by the provided value .
	 *
	 * @param idp public identifier of the user
	 * @return returns UserData object if successful else returns null
	 */
	public ProfileData getfProfile(String idp) {
	return sql.getProfileData(sql.getUserIDByIDP(idp));
	}
	
	/**
	 * Tells the sql class to add a new column in table Kurs.
	 *
	 * @param kurs  the data that shall be added the parameter id is not required
	 * @return returns true if the request was executed sucessful otherwise returns false
	 */
	public boolean aAddKurs(SQLKurs kurs) {
	
		return sql.addKurs(kurs.getKursstufe(),kurs.getDatum(),kurs.getUhrzeit(), kurs.getWochentag());
		
	}
		
	
}
