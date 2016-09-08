package model;

public class Admin {
	private String username;
	private String key;
	private String eMail;
	
	Admin (String username, String key, String  eMail){
		
		this.username = username;
		this.key = key;
		this.eMail = eMail;
	}
	
	public boolean checkLogin(String username, String key){
		if(this.username.equals(username)&& this.key.equals(key)){
			return true;
		}
		return false;
	}

}
